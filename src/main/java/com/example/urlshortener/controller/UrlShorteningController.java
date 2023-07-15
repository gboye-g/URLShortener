package com.example.urlshortener.controller;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.dto.UrlDto;
import com.example.urlshortener.dto.UrlErrorResponseDto;
import com.example.urlshortener.dto.UrlResponseDto;
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

            return new ResponseEntity<>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("There was an error processing your request. Please try again");

        return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        if(StringUtils.isEmpty(shortUrl))
        {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("Invalid Url");
            urlErrorResponseDto.setStatus("404");

            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
        }

        Url urlToRet = urlService.getEncodedUrl(shortUrl);

        if(urlToRet == null)
        {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setError("This short URL does not exist");
            urlErrorResponseDto.setStatus("200");

            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
        }

        response.sendRedirect(urlToRet.getOriginalUrl());

        return null;
    }
}
