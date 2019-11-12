package org.scrum.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations= {"org/scrum/spring/beans.xml"})
//@ImportResource(locations= {"classpath:beans.xml"})
public class AppXMLConfig {
	
}
