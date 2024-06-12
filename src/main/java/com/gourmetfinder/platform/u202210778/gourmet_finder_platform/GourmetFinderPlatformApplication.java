package com.gourmetfinder.platform.u202210778.gourmet_finder_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GourmetFinderPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(GourmetFinderPlatformApplication.class, args);
	}

}
