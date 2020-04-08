/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pruebaSpringBoot.service;

import com.example.pruebaSpringBoot.model.Airports;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Contr
 */
public class AirportsService {

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// Note: here we are making this converter to process any kind of response, 
// not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        List<Airports> airports = restTemplate.getForObject("https://www.phptravels.net/admin/ajaxcalls/flightAjex", List.class);

        System.out.println(airports.size());
        for (int i = 0; i <= airports.size(); i++) {
            Airports port = airports.get(i);
            System.out.println(port);
        }

    }

}
