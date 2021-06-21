package rw.co.aos.project.asynchronous.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rw.co.aos.project.asynchronous.model.User;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookUpService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubLookUpService.class);

  private final RestTemplate restTemplate;

  public GitHubLookUpService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  @Async
  public CompletableFuture <User> findUser(String username) throws InterruptedException {
    logger.info("Looking up " + username);
    String url = String.format("https://api.github.com/users/%s", username);
    User results = restTemplate.getForObject(url, User.class);
    // Artificial delay of 1s for demonstration purposes
    Thread.sleep(1000L);
    return CompletableFuture.completedFuture(results);
  }
}
