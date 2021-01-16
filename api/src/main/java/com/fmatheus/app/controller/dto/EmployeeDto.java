package com.fmatheus.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fmatheus.app.controller.util.AppUtil;
import com.fmatheus.app.controller.util.LocalDatetUtil;
import com.fmatheus.app.model.entity.ContactEntity;
import com.fmatheus.app.model.entity.EmployeeEntity;
import com.fmatheus.app.model.entity.OccupationEntity;
import com.fmatheus.app.model.entity.PersonEntity;
import com.fmatheus.app.model.entity.PersonTypeEntity;
import com.fmatheus.app.model.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author fmatheus
 */
@JsonPropertyOrder({ "id", "name", "document", "occupation", "email", "phone", "created_at", "updated_at" })
@JsonInclude(Include.NON_NULL)
@Api(tags = "Employee", description = "API Employee")
public class EmployeeDto {

	@Getter
	@Setter
	@JsonProperty("id")
	@ApiModelProperty(notes = "Employee ID")
	private int id;

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

	@Getter
	@Setter
	@NotNull
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("id_created_user")
	@ApiModelProperty(notes = "Created user ID", required = true)
	private int idCreatedUser;

	@Getter
	@Setter
	@NotNull(message = "{email.not.null}")
	@NotBlank(message = "{email.not.blank}")
	@JsonProperty("email")
	@ApiModelProperty(notes = "Email")
	private String email;

	@Getter
	@Setter
	@NotNull(message = "{phone.not.null}")
	@NotBlank(message = "{phone.not.blank}")
	@JsonProperty("phone")
	@ApiModelProperty(notes = "Phone")
	private String phone;

	@Getter
	@Setter
	@NotNull(message = "{id_occupation.not.null}")
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("id_occupation")
	@ApiModelProperty(notes = "Occupation ID")
	private int idOccupation;

	@Getter
	@Setter
	@JsonProperty("name_occupation")
	@ApiModelProperty(notes = "Occupation name")
	private String occupation;

	@Getter
	@Setter
	@JsonProperty("created_at")
	@ApiModelProperty(notes = "Created At")
	private LocalDateTime createdAt;

	@Getter
	@Setter
	@JsonProperty("updated_at")
	@ApiModelProperty(notes = "Updated At")
	private LocalDateTime updatedAt;

	@Getter
	@Setter
	@JsonProperty("created_user")
	@ApiModelProperty(notes = "Created user")
	private String createdUser;

	@Getter
	@Setter
	@JsonProperty("updated_user")
	@ApiModelProperty(notes = "Updated user")
	private String updatedUser;

	@Getter
	@Setter
	@JsonProperty("person_type")
	@ApiModelProperty(notes = "Type of person")
	private String personType;

	public PersonEntity create(EmployeeDto dto) {

		var person = new PersonEntity();
		var employee = new EmployeeEntity();
		var contact = new ContactEntity();

		// Pega o objeto personDto que vem do json e converte para a entidade JPA
		person.setName(dto.getName());
		person.setDocument(dto.getDocument());

		// Como todo funcionario e pessoa fisica, ja atribui o valor 1 que corresponde a
		// Pessoa Fisica
		person.setIdPersonType(new PersonTypeEntity(1));

		employee.setIdOccupation(new OccupationEntity(dto.getIdOccupation()));
		employee.setIdCreatedUser(new UserEntity(dto.getIdCreatedUser()));
		employee.setIdUpdatedUser(new UserEntity(dto.getIdCreatedUser()));
		employee.setCreatedAt(LocalDatetUtil.currentDateTime());
		employee.setUpdatedAt(LocalDatetUtil.currentDateTime());
		employee.setFilter(this.converterJson(dto.getName(), dto.getDocument(), dto.getEmail(), dto.getPhone(),
				dto.getOccupation()));
		employee.setIdPerson(person);
		person.setEmployeeEntity(employee);

		contact.setEmail(dto.getEmail());
		contact.setPhone(dto.getPhone());
		contact.setIdPerson(person);
		person.setContactEntity(contact);

		return person;

	}

	public static EmployeeDto converterObject(EmployeeEntity entity) {

		var employee = new EmployeeDto();

		employee.setId(entity.getId());
		employee.setName(entity.getIdPerson().getName());
		employee.setDocument(entity.getIdPerson().getDocument());

		employee.setOccupation(entity.getIdOccupation().getName());
		employee.setCreatedUser(entity.getIdCreatedUser().getIdEmployee().getIdPerson().getName());
		employee.setUpdatedUser(entity.getIdUpdatedUser().getIdEmployee().getIdPerson().getName());
		employee.setCreatedAt(entity.getCreatedAt());
		employee.setUpdatedAt(entity.getUpdatedAt());
		
		employee.setEmail(entity.getIdPerson().getContactEntity().getEmail());
		employee.setPhone(entity.getIdPerson().getContactEntity().getPhone());

		return employee;
	}

	private String converterJson(String name, String document, String email, String phone, String occupation) {
		JSONObject obj = new JSONObject();
		obj.put("name", AppUtil.convertAllLowercaseCharacters(AppUtil.removeAccent(name)));
		obj.put("document", AppUtil.removeSpecialCharacters(document));
		obj.put("email", AppUtil.convertAllLowercaseCharacters(email));
		obj.put("phone", AppUtil.removeSpecialCharacters(phone));
		obj.put("occupation", AppUtil.convertAllLowercaseCharacters(AppUtil.removeAccent(occupation)));
		return obj.toString();
	}

}
