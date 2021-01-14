package com.fmatheus.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fmatheus.app.model.entity.OccupationEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
@JsonPropertyOrder({"id", "name"})
@JsonInclude(Include.NON_NULL)
@Api(tags = "Occupation", description = "API Occupation")
public class OccupationDto {

    @Getter
    @Setter
    @JsonProperty("id")
    @ApiModelProperty(notes = "Occupation ID")
    private int id;

    @Getter
    @Setter
    @NotNull
    @JsonProperty("name")
    @ApiModelProperty(notes = "Name")
    private String name;

    public static OccupationDto converterObject(OccupationEntity ocupation) {
        var dto = new OccupationDto();
        dto.setId(ocupation.getId());
        dto.setName(ocupation.getName());
        return dto;
    }

    public OccupationEntity converterEntity(OccupationDto dto) {
        var occupation = new OccupationEntity();
        occupation.setName(dto.getName());
        return occupation;
    }

}
