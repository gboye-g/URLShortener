package com.example.urlshortener.dto;

public class UrlDto {
    private String originalUrl;
    private int shortUrlLength;
    private String shortUrl;

    public UrlDto(String originalUrl, int shortUrlLength, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortUrlLength = shortUrlLength;
        this.shortUrl = shortUrl;
    }

    public UrlDto() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public int getShortUrlLength() {
        return shortUrlLength;
    }

    public void setShortUrlLength(int shortUrlLength) {
        this.shortUrlLength = shortUrlLength;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "UrlDto{" +
                "url='" + originalUrl + '\'' +
                ", shortUrlLength=" + shortUrlLength +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
