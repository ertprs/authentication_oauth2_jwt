package com.fmatheus.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fmatheus.app.model.entity.PersonEntity;
import com.fmatheus.app.model.entity.PersonTypeEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
@JsonPropertyOrder({ "name", "person_type", "document" })
@JsonInclude(Include.NON_NULL)
@Api(tags = "Person", description = "API Person")
public class PersonDto {

	@Getter
	@Setter
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("id")
	@ApiModelProperty(notes = "User ID")
	private int id;

	@Getter
	@Setter
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("id_person_type")
	@ApiModelProperty(notes = "Person ID person type")
	private int idPersonType;

	@Getter
	@Setter
	@JsonProperty("person_type")
	@ApiModelProperty(notes = "Type of person")
	private String personType;

	@Getter
	@Setter
	@NotNull
	@NotBlank
	@JsonProperty("name")
	@ApiModelProperty(notes = "Person name")
	private String name;

	@Getter
	@Setter
	@NotNull
	@NotBlank
	@JsonProperty("document")
	@ApiModelProperty(notes = "Person document")
	private String document;

	public static PersonDto converterObject(PersonEntity person) {
		var dto = new PersonDto();
		dto.setPersonType(person.getIdPersonType().getName());
		dto.setName(person.getName());
		dto.setDocument(person.getDocument());
		return dto;
	}

	public static PersonEntity converterEntity(PersonDto dto) {
		var person = new PersonEntity();
		person.setIdPersonType(new PersonTypeEntity(dto.getIdPersonType()));
		person.setName(dto.getName());
		person.setDocument(dto.getDocument());		
		return person;
	}

}
