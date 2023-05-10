package com.example.urlshortener.model;

public class UrlResponseDto {
    private String originalUrl;
    private String shortUrl;
    private int shortUrlLength;

    public UrlResponseDto(String originalUrl, String shortUrl, int shortUrlLength) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.shortUrlLength = shortUrlLength;
    }

    public UrlResponseDto() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getShortUrlLength() {
        return shortUrlLength;
    }

    public void setShortUrlLength(int shortUrlLength) {
        this.shortUrlLength = shortUrlLength;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", shortUrlLength=" + shortUrlLength +
                '}';
    }
}
