package com.example.urlshortener.model;

public class UrlDto {
    private String url;
    private int shortLinkLength;

    public UrlDto(String url, int shortLinkLength) {
        this.url = url;
        this.shortLinkLength = shortLinkLength;
    }

    public UrlDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getShortLinkLength() {
        return shortLinkLength;
    }

    public void setShortLinkLength(int shortLinkLength) {
        this.shortLinkLength = shortLinkLength;
    }

    @Override
    public String toString() {
        return "UrlDto{" +
                "url='" + url + '\'' +
                ", shortLinkLength=" + shortLinkLength +
                '}';
    }
}
