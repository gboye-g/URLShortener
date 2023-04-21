package com.example.urlshortener.repository;

import com.example.urlshortener.model.Url;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    public Url findByShortLink(String shortLink);
}