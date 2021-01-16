
package com.fmatheus.app.controller.resource;

import com.fmatheus.app.controller.rule.EmployeeRule;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.fmatheus.app.controller.dto.EmployeeDto;
import com.fmatheus.app.model.repository.RepositoryFilter;

/**
 *
 * @author fmatheus
 */
@RestController
@RequestMapping("/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeRule employeeRule;

	@ApiOperation(value = "List of employees")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Returns List"),
			@ApiResponse(code = 204, message = "No Content"), @ApiResponse(code = 403, message = "Access Denied"),
			@ApiResponse(code = 500, message = "Server Error"), 
			})
	@PreAuthorize("hasAnyAuthority('ADMIN') and #oauth2.hasScope('read')")
	@GetMapping()
	public ResponseEntity<Page<EmployeeDto>> list(Pageable pageable, RepositoryFilter filter) {
		return employeeRule.findAllPaginator(pageable, filter);
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable String id) {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
		return null;
	}

	@ApiOperation(value = "Register a new employee")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Record Created"),
			@ApiResponse(code = 403, message = "Access Denied"), 
			@ApiResponse(code = 500, message = "Server Error"), 
			})
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER') and #oauth2.hasScope('write')")
	@PostMapping
	public ResponseEntity<?> post(@RequestBody @Valid EmployeeDto dto, HttpServletResponse response) {
		return employeeRule.create(dto, response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return null;
	}

}
