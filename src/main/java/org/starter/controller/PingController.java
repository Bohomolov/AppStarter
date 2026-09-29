package org.starter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health", description = "Service availability checks")
public class PingController {

	@Operation(
			summary = "Check that the service is up",
			description = "Public endpoint, no authentication required. Returns the constant \"1\"."
	)
	@ApiResponse(responseCode = "200", description = "Service is running")
	@GetMapping("/ping")
	public String ping() {
		return "1";
	}
}
