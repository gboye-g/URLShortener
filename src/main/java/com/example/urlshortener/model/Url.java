package com.example.urlshortener.model;

public class Url {
    private long id;
    private String originalUrl;
    private String shortUrl;
    private int shortUrlLength;

    public Url(long id, String originalUrl, String shortUrl, int shortUrlLength) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.shortUrlLength = shortUrlLength;
    }

    public Url() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Url{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", shortUrlLength=" + shortUrlLength +
                '}';
    }

}
