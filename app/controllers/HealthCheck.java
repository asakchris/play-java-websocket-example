package controllers;

import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class HealthCheck extends Controller {

    private HttpExecutionContext executionContext;

    @Inject
    public HealthCheck(HttpExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    public CompletionStage<Result> health() {
        return CompletableFuture.supplyAsync(() -> ok("Ok"), executionContext.current());
    }
}
