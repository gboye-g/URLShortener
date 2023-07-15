package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.dto.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortUrl(UrlDto urlDto);
    public Url searchRecordsByShortUrl(UrlDto urlDto);

    Url getEncodedUrl(String shortUrl);
}
