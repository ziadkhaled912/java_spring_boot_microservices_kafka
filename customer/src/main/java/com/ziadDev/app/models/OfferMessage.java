package com.ziadDev.app.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferMessage {
    @NotEmpty
    private String item;
    @NotNull
    private Float percentage;

    @NotNull
    private Integer quantity;
}
