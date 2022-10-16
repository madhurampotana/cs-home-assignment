package com.problem.three.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.problem.three.model.ExpressionForm;
import com.problem.three.service.EvaluateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EvaluateController {

	private static final Logger logger = LoggerFactory.getLogger(EvaluateController.class);

	@Autowired
	private EvaluateService evaluateService;

	@Operation(summary = "Evaluates arithmetic expressions written in Polish notation")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Calculated double-precision value", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Unable to evalute the expression", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/evaluateExpression")
	public ResponseEntity<String> doEvaluateExpression(@RequestBody ExpressionForm expressionForm) {
		logger.info("Recevied Experssion : " + expressionForm.getInputExp());
		return new ResponseEntity<>(evaluateService.doArithmeticEvaluation(expressionForm.getInputExp()),
				HttpStatus.OK);
	}

}
