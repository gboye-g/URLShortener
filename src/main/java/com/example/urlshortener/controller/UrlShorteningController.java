package com.example.urlshortener.controller;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.model.UrlDto;
import com.example.urlshortener.model.UrlErrorResponseDto;
import com.example.urlshortener.model.UrlResponseDto;
import com.example.urlshortener.repository.UrlRepository;
import com.example.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UrlShorteningController {
    @Autowired
    private UrlService urlService;
    private UrlRepository urlRepository;

    @PostMapping("/generated")
    public ResponseEntity<?> generateShortUrl(@RequestBody UrlDto urlDto){
        Url urlToRet = urlService.generateShortUrl(urlDto);

        return getResponseEntity(urlToRet);
    }

    @PostMapping("/search/result")
    public ResponseEntity<?> searchRecordsByShortUrl(@RequestBody UrlDto urlDto){
        Url urlToRet = urlService.searchRecordsByShortUrl(urlDto);

        return getResponseEntity(urlToRet);
    }

    private ResponseEntity<?> getResponseEntity(Url urlToRet) {
        if(urlToRet != null){
            UrlResponseDto urlResponseDto = new UrlResponseDto();
            urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
            urlResponseDto.setShortUrl(urlToRet.getShortUrl());
            urlResponseDto.setShortUrlLength(urlToRet.getShortUrlLength());

            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("There was an error processing your request. Please try again");

        return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        if(StringUtils.isEmpty(shortUrl))
        {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("Invalid Url");
            urlErrorResponseDto.setStatus("404");

            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
        }

        Url urlToRet = urlService.getEncodedUrl(shortUrl);

        if(urlToRet == null)
        {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("This short URL does not exist");
            urlErrorResponseDto.setStatus("200");

            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
        }

        UrlResponseDto urlResponseDto = new UrlResponseDto();
        urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());

        response.sendRedirect(urlToRet.getOriginalUrl());

        return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);

//        return null;
    }
}
