package com.stackroute.unservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



 //   @Entity //declare User class as entity bean
    @Data // altogeher @getter @setter @tostring
    @NoArgsConstructor // create constructor with no parameters
    @AllArgsConstructor // create constructor with 1 parameter for each field in class
    @Builder

    @Document(collection = "Music")

    public class Music {
        @Id
                 int id;
                String name;
                String comments;


    }


