package com.example.helloworld.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.Saying;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/hello-world")
@Api(value = "/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	public HelloWorldResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	@ApiOperation(value = "Enter name", notes = "Returns a hello message with name.", response = Saying.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Pet not found") })
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		final String value = String.format(template, name.orElse(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
}
