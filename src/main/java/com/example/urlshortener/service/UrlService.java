package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.model.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortUrl(UrlDto urlDto);
    public Url persistShortUrl(Url url);
    public Url searchRecordsByShortUrl(UrlDto urlDto);
}
