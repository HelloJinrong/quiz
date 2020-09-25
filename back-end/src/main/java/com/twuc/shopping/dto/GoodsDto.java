package com.twuc.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "goods")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto {
    @Id
    @GeneratedValue
    private int Id;
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String unit;
    @NotNull
    private String imgUrl;


}
