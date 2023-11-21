package com.example.articlemanagementsystem.Service;

import com.example.articlemanagementsystem.Api.ApiArticle;
import com.example.articlemanagementsystem.Model.ArticleMod;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class ArticleService {

ArrayList<ArticleMod> Articles=new ArrayList<>();
ArrayList<ArticleMod> categoryList=new ArrayList<>();


public  ArrayList<ArticleMod> getArticles(){
    return Articles;
}

public void addArticles(ArticleMod articleMod){
    Articles.add(articleMod);
}


public boolean upddateArticles(String id,ArticleMod articleMod){
    for (int i = 0; i <Articles.size() ; i++) {
        if (Articles.get(i).getId().equals(id)){
            Articles.set(i,articleMod);
            return true;
        }
    }
    return  false;
}


public boolean deleteArticles(String id){
    for (int i = 0; i <Articles.size() ; i++) {
        if (Articles.get(i).getId().equals(id)){
            Articles.remove(i);
        return  true;
        }
    }
    return  false;
}




public ArrayList<ArticleMod> DisplayCategorys(String searchCategs){
    ArrayList<ArticleMod> categoryList=new ArrayList<>();
    for (ArticleMod searchCateg:Articles) {
        if (searchCateg.getCategory().equalsIgnoreCase(searchCategs)){

            categoryList.add(searchCateg);
    }
    }
    return categoryList;
    }



}





