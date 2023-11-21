package com.example.articlemanagementsystem.Controller;

import com.example.articlemanagementsystem.Model.ArticleMod;
import com.example.articlemanagementsystem.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    @GetMapping("/get")
    public ResponseEntity getArticles() {

        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticles());
    }


    @PostMapping("add")
    public ResponseEntity addArticles(@Valid @RequestBody ArticleMod articleMod, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        articleService.addArticles(articleMod);
        return ResponseEntity.status(HttpStatus.OK).body("add  News Articles");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateArticles(@PathVariable String id, @Valid @RequestBody ArticleMod articleMods, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        boolean isUpdated = articleService.upddateArticles(id, articleMods);
    if (isUpdated){
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }else {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not Found");
    }


    }



    @DeleteMapping("/Delete/{id}")
    public  ResponseEntity deleteArticles(@PathVariable String id){

        boolean isDeleted = articleService.deleteArticles(id);
                if(isDeleted){
                    return ResponseEntity.status(HttpStatus.OK).body("Delete");
                }else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND");
                }
    }


}
