package com.fmatheus.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
@JsonPropertyOrder({"id", "username", "person", "user_created", "created_at", "user_updated", "updated_at"})
@JsonInclude(Include.NON_NULL)
@Api(tags = "User", description = "API User")
public class UserDto {

    @Getter
    @Setter
    @JsonProperty("id")
    @ApiModelProperty(notes = "User ID")
    private int id;

    @Getter
    @Setter
    @NotNull
    @JsonProperty("id_employee")
    @ApiModelProperty(notes = "Employee ID", required = true)
    private int idEmployee;

    @Getter
    @Setter
    @JsonProperty("id_user_status")
    @ApiModelProperty(notes = "Status ID")
    private int idUserStatus;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @JsonProperty("username")
    @ApiModelProperty(notes = "User username")
    private String username;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @JsonProperty("password")
    @ApiModelProperty(notes = "User password")
    private String password;

    @Getter
    @Setter
    @JsonProperty("avatar")
    @ApiModelProperty(notes = "User avatar")
    private String avatar;

    @Getter
    @Setter
    @JsonProperty("person")
    @ApiModelProperty(notes = "Person")
    private PersonDto personDto;

    @Getter
    @Setter
    @JsonProperty("occupation")
    @ApiModelProperty(notes = "User occupation")
    private OccupationDto occupationDto;

    @Getter
    @Setter
    @JsonProperty("user_created")
    @ApiModelProperty(notes = "User who created the record")
    private String userCreated;

    @Getter
    @Setter
    @JsonProperty("user_updated")
    @ApiModelProperty(notes = "User who changed the record")
    private String userUpdated;

    @Getter
    @Setter
    @JsonProperty("created_at")
    @ApiModelProperty(notes = "Record creation date and time")
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @JsonProperty("updated_at")
    @ApiModelProperty(notes = "Record change date and time")
    private LocalDateTime updatedAt;

}
