package com.example.articlemanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Data
public class ArticleMod {


    @NotNull(message = "Cannot be id null. \n")
    private String id;


    @NotNull(message = "Cannot be title null. \n")
    @Size(max = 100, message = "Maximum title length of 100 characters. \n")
    private String title;


    @NotNull(message = "Cannot author be null.\n")
    @Size(min = 4, max = 20, message = "Must be author more than 4 characters. \n" +
            "Maximum be author length of 20 characters.")
    private String author;


    @NotNull(message = "Cannot content be null.\n")
    @Size(min = 20, message = "Must be content more than 200 characters. \n")
    private String content;


    @NotNull(message = "Cannot category be null.\n")
    @Pattern(regexp = "^(?i)(politics|sports|technology)$")

    private String category;


    @NotNull(message = "Cannot imageUrl be null.\n")
    private String imageUrl;

    @AssertFalse(message = "default false")
    private boolean isPublished;

    //@JsonFormat(pattern = "yyyy-MM-dd")
   // private LocalDateTime publishDate;
 //=LocalDateTime.now()


}
