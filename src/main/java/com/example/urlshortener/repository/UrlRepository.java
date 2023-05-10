package com.example.urlshortener.repository;

import com.example.urlshortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class UrlRepository {

    public static final String Result = "result";
    private final SimpleJdbcCall persistShortUrl;
    private final SimpleJdbcCall getShortUrl;

    @Autowired
    public UrlRepository(DataSource dataSource) {

        this.persistShortUrl = new SimpleJdbcCall(dataSource)
                .withProcedureName("save_Url_object")
                .returningResultSet(Result, BeanPropertyRowMapper.newInstance(Url.class));

        this.getShortUrl = new SimpleJdbcCall(dataSource)
                .withProcedureName("find_record_using_shortUrl")
                .returningResultSet(Result, BeanPropertyRowMapper.newInstance(Url.class));

    }

    public Url saveRecord(Url url){
        SqlParameterSource param = new BeanPropertySqlParameterSource(url);
        Map<String, Object> map = persistShortUrl.execute(param);
        return ((List<Url>)map.get(Result)).get(0);
    }
    public Url findRecord(String shortUrl){
        SqlParameterSource param = new MapSqlParameterSource("shortUrl",shortUrl);
        Map<String, Object> map = getShortUrl.execute(param);
        return ((List<Url>)map.get(Result)).get(0);
    }



}