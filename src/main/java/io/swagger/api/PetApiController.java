package io.swagger.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Pet;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-11-28T23:48:00.873Z")

@Controller
public class PetApiController implements PetApi {

    private static final Logger log = LoggerFactory.getLogger(PetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ResponseConverter converter;



    @Autowired
    public PetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet to return",required=true) @PathVariable("petId") String petId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Pet>(objectMapper.readValue("{  \"name\" : \"doggie\",  \"id\" : \"id\"}", Pet.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Pet>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }

        	Pet pet = converter.convert(String.valueOf(petId));
        	return new ResponseEntity<Pet>(pet,HttpStatus.OK);

        }

        return new ResponseEntity<Pet>(HttpStatus.NOT_IMPLEMENTED);



    }

}
