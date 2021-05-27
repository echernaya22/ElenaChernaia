package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetalsColorsInfo extends DataClass<MetalsColorsInfo> {

    @JsonProperty("summary")
    private String[] summary;

    @JsonProperty("elements")
    private String[] elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metal;

    @JsonProperty("vegetables")
    private String[] vegetables;

}
