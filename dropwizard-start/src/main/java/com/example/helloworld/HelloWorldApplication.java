package com.example.helloworld;

import com.example.helloworld.health.TemplateHealthCheck;
import com.example.helloworld.resources.HelloWorldResource;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment) {

		final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(),
				configuration.getDefaultName());
		final ApiListingResource apiListingResource = new ApiListingResource();
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(apiListingResource);
		environment.jersey().register(new SwaggerSerializers());
		environment.jersey().register(resource);

		environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

		BeanConfig config = new BeanConfig();
		config.setTitle("Swagger sample app");
		config.setVersion("1.0.0");
		config.setResourcePackage("io.swagger.sample.resource");
		config.setScan(true);
	}

	@Override
	public String getName() {
		return "hello-world";
	}

	/*
	 * @Override public void initialize(Bootstrap<HelloWorldConfiguration>
	 * bootstrap) { // nothing to do yet }
	 */
}
