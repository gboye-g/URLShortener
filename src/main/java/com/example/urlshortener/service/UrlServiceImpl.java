package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.model.UrlDto;
import com.example.urlshortener.repository.UrlRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;


@Component
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortUrl(UrlDto urlDto) {

        if (StringUtils.isNotEmpty(urlDto.getOriginalUrl())) {
            String encodedUrl = encodeUrl(urlDto.getOriginalUrl(), urlDto.getShortUrlLength());
            Url urlToPersist = new Url();
            urlToPersist.setOriginalUrl(urlDto.getOriginalUrl());
            urlToPersist.setShortUrl(encodedUrl);
            urlToPersist.setShortUrlLength(urlDto.getShortUrlLength());

            if (urlDto.getShortUrlLength() < 3) {
                return null;
            }

            Url urlToRet = urlRepository.saveRecord(urlToPersist);

            if (urlToRet != null) {
                return urlToRet;
            }

            return null;
        }

        return null;
    }

    private String encodeUrl(String url, int shortUrlLength) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        try {
            encodedUrl = HashUtils.sha256(url.concat(time.toString()), shortUrlLength);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return encodedUrl;
    }

    public Url searchRecordsByShortUrl(UrlDto urlDto) {
        Url urlToRet = urlRepository.findRecord(urlDto.getShortUrl());

        if (urlToRet != null) {
            return urlToRet;
        }
        return null;
    }

    @Override
    public Url getEncodedUrl(String shortUrl) {
        Url urlToRet = urlRepository.findRecord(shortUrl);

        return urlToRet;
    }

}
