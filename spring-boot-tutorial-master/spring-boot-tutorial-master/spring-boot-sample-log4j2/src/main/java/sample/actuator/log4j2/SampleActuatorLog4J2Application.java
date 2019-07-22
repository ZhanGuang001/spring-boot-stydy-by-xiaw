/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.actuator.log4j2;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleActuatorLog4J2Application {
	private static final Logger logger = LoggerFactory.getLogger(SampleActuatorLog4J2Application.class);
	
	@PostConstruct
	public void doSomthing() {
		logger.debug("Sample Debug Message");
		logger.info("Sample Info Message");
		logger.trace("Sample trace Message");
		logger.error("Sample error Message");
        logger.warn("Sample warn Message");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SampleActuatorLog4J2Application.class, args);
	}

}
