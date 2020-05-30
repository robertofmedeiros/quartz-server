package org.roberto.medeiros.quartz.server;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.roberto.medeiros.quartz.server.model.Parametro;
import org.roberto.medeiros.quartz.server.repository.ParametroRepository;
import org.roberto.medeiros.quartz.server.utils.ParametrosBaseH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

@EnableAutoConfiguration
@ComponentScan({"org.roberto.medeiros.quartz.server"})
public class QuartzServerApplication {

	@Autowired
	private ParametroRepository parametroRepository;

	public static void main(String[] args) throws Exception {

		SpringApplication.run(QuartzServerApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}
	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
				DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}
}
