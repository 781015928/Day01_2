package cn.itcast.ssm.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by czg on 2017/10/19.
 */

public class CustomDateConverter implements Converter<String, Date> {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convert(String source) {
        System.out.println(source);
        try {
            return format.parse(source);
        } catch (ParseException e) {
            return new Date();
        }

    }
}
