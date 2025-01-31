package com.ifs.gateway.filter;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

 

import lombok.Getter;

 

@Component
@Getter
public class RouteValidator {

	
	Logger logger = LoggerFactory.getLogger(RouteValidator.class);

 

	public static final List<String> openApiEndpoints = List.of(
			"/api/auth/create-user", 
			"/api/auth/authenticate",
			"/eureka"
			);

 

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));

 

	public static final List<String> commonApiEndpoints = List.of(
			"/api/feedback/getTest"
			);

 

	public Predicate<ServerHttpRequest> isSecuredCommon = request -> commonApiEndpoints.stream()
			.anyMatch(uri -> request.getURI().getPath().contains(uri));

 

	public static final List<String> hrApiEndpoints = List.of(
			"/api/feedback/getTest22");

 

	public Predicate<ServerHttpRequest> isSecuredHR = request -> hrApiEndpoints.stream()
			.anyMatch(uri -> request.getURI().getPath().contains(uri));

 

	public static final List<String> interviewerApiEndpoints = List.of(
			"/api/feedback/getTest33");

 

	public Predicate<ServerHttpRequest> isSecuredInterviewer = request -> interviewerApiEndpoints.stream()
			.anyMatch(uri -> request.getURI().getPath().contains(uri));
}