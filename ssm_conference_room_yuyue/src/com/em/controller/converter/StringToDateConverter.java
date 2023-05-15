// 
// 
// 

package com.em.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>
{
    public Date convert(final String source) {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(source.trim());
        }
        catch (ParseException e2) {
            try {
                dateFormat = new SimpleDateFormat("hh:mm:ss");
                date = dateFormat.parse(source.trim());
            }
            catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return date;
    }
}
