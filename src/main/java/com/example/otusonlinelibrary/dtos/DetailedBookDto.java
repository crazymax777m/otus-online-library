package com.example.otusonlinelibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailedBookDto {

    private String title;

    private String fullName;

    private String genreName;

    private String description;

    private Integer yearOfPublication;

    private Integer pagesCount;

    private Double price;

    private Integer averageRating;
}
