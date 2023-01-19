package com.crudlover.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;

public record CarsDTO(
        @NotBlank @NotEmpty String modelo,

        @NotBlank @NotEmpty String fabricante,

        @Past Date dataFabricacao,

        double valor,

        int anoModelo) {

}
