package uy.com.mattia.hw.stepstone;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uy.com.mattia.hw.stepstone.model.HttpResponseEntity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unmarshaller
 *
 * Class that allows the unmarshalling of json representing the POJO HttpResponseEntity
 * encapsulating the use of Jackson.
 *
 * From HW text:
 * A) Write java classes capable of representing data from the JSON
 *
 * Used to unmarshall the json example into uy.com.mattia.hw.stepstone.model
 * pojos.
 *
 * Created by mattia on 11/8/17.
 */
public class Unmarshaller {

    private ObjectMapper mapper = new ObjectMapper();

    public HttpResponseEntity unmarshall(InputStream jsonFile) {

        HttpResponseEntity response = null;

        try {
            response = mapper.readValue(jsonFile, HttpResponseEntity.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}
