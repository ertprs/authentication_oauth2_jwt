package com.fmatheus.app.controller.rule;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import com.fmatheus.app.controller.dto.EmployeeDto;
import com.fmatheus.app.controller.event.ResourceEvent;
import com.fmatheus.app.controller.util.AppUtil;
import com.fmatheus.app.model.entity.EmployeeEntity;
import com.fmatheus.app.model.repository.RepositoryFilter;
import com.fmatheus.app.model.service.impl.EmployeeServiceImpl;
import com.fmatheus.app.model.service.impl.OccupationServiceImpl;
import com.fmatheus.app.model.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

/**
 *
 * @author fmatheus
 */
@Component
public class EmployeeRule {

	private static final Logger log = LoggerFactory.getLogger(EmployeeRule.class);

	@Autowired
	private MessageResponseRule messageResponseRule;

	/* Publicador de eventos de aplicacao */
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	PersonServiceImpl personServiceImpl;

	@Autowired
	OccupationServiceImpl occupationServiceImpl;

	/* Lista os funcionarios e converte para objeto DTO */
	public ResponseEntity<Page<EmployeeDto>> findAllPaginator(Pageable pageable, RepositoryFilter filter) {
		Page<EmployeeEntity> employees = employeeServiceImpl.findAllPaginator(pageable);
		return !employees.isEmpty() ? ResponseEntity.ok(employees.map(EmployeeDto::converterObject))
				: ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	public ResponseEntity<?> create(EmployeeDto dto, HttpServletResponse response) {

		/* retira todos os pontos e caracteres especiais e deixa somente os numeros */
		String document = AppUtil.removeSpecialCharacters(dto.getDocument());
		var person = personServiceImpl.findByDocument(document);
		if (person != null) {
			log.warn("O ocumento ja esta cadastrado.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageResponseRule.messageResponse(400,
					HttpStatus.BAD_REQUEST, "message.error.documento.exist", null));
		}

		/* Verifica se existe o cargo informado */
		var occupation = occupationServiceImpl.findById(dto.getIdOccupation()).orElse(null);
		if (occupation == null) {
			log.warn("O cargo nao foi encontrado.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageResponseRule.messageResponse(400,
					HttpStatus.BAD_REQUEST, "message.error.not.found.occupation", null));
		}

		dto.setOccupation(occupation.getName());
		var employeeDto = new EmployeeDto();
		var entity = employeeDto.create(dto);
		personServiceImpl.save(entity);

		// publisher.publishEvent(new ResourceEvent(this, response,
		// entity.getEmployeeEntity().getId()));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(messageResponseRule.messageResponse(21, HttpStatus.CREATED, "message.success.create", null));

	}

}
