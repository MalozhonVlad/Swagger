package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Accessors(chain = true)
@ApiModel(value = "class language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull
    @Size(min = 1,max = 30)
    @ApiModelProperty(value = "name of language", example = "python")
    private String name;

    @NotNull
    @Size(min = 1,max = 255)
    @ApiModelProperty(value = "authors' name", example = "gvido")
    private String author;

}
