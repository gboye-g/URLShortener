package com.example.urlshortener.model;

public class UrlResponseDto {
    private String originalUrl;
    private String shortLink;
    private int shortLinkLength;

    public UrlResponseDto(String originalUrl, String shortLink, int shortLinkLength) {
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.shortLinkLength = shortLinkLength;
    }

    public UrlResponseDto() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public int getShortLinkLength() {
        return shortLinkLength;
    }

    public void setShortLinkLength(int shortLinkLength) {
        this.shortLinkLength = shortLinkLength;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" +
                "originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", shortLinkLength=" + shortLinkLength +
                '}';
    }
}
