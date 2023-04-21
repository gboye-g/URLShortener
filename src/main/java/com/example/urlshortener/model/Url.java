package com.example.urlshortener.model;

@Table("Url")
public class Url {
    @Id
//    @GeneratedValue
    private long id;
    @Lob
    private String originalUrl;
    private String shortLink;
    private int shortLinkLength;

    public Url(long id, String originalUrl, String shortLink, int shortLinkLength) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.shortLinkLength = shortLinkLength;
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
        return "Url{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", shortLinkLength=" + shortLinkLength +
                '}';
    }

}
