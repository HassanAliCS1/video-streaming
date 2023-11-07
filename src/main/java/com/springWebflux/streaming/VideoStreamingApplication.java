package com.springWebflux.streaming;

import com.springWebflux.streaming.StreamingService.StreamingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class VideoStreamingApplication {

	private StreamingService streamingService;

	@GetMapping(value = "video/{title}", produces = "video/mp4")
	public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range){
		System.out.println("range in bytes() : " + range);
		return streamingService.getVideo(title);
	}

	public static void main(String[] args) {
		SpringApplication.run(VideoStreamingApplication.class, args);
	}

}
