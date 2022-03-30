package micro.doris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import micro.doris.entity.CategoryEntityJpa;
import micro.doris.services.CategoryServices;
import micro.doris.to.Convert;

@Validated
@Controller
@RequestMapping("/api")

public class CategoryController {

	@Autowired
	CategoryServices callService;

	// Find By ID
	@GetMapping("/getCategoryByIdJpa/{id}")
	public ResponseEntity<CategoryEntityJpa> findByIdJpa(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(callService.getRecordByIdJpa(id), HttpStatus.OK);
	}

	// Delete By Id
	@DeleteMapping("/deleteCategoryByIdJpa/{id}")
	public ResponseEntity<Convert> deleteJpa(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(callService.deleteRecordJpa(id), HttpStatus.OK);
	}

}
