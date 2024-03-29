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

package sample.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SampleLogbackApplication {

    private static final Logger logger = LoggerFactory
            .getLogger(SampleLogbackApplication.class);

    @PostConstruct
    public void logSomething() {
		logger.debug("Sample Debug Message");
		logger.info("Sample Info Message");
		logger.trace("Sample trace Message");
		logger.error("Sample error Message");
        logger.warn("Sample warn Message");
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleLogbackApplication.class, args).close();
    }

}
