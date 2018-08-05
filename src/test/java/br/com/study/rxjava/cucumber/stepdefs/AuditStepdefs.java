package br.com.study.rxjava.cucumber.stepdefs;

import br.com.study.rxjava.TestConfig;
import br.com.study.rxjava.cucumber.World;
import br.com.study.rxjava.stream.TransactionSubject;
import cucumber.api.java8.En;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@DirtiesContext
public class AuditStepdefs extends TestConfig implements En {

    @Autowired
    private World world;

    public AuditStepdefs() {
        Given("^a running app$", () -> {
        });

        When("^emmit some event$", () -> {
            world.countDown = new CountDownLatch(1);
            TransactionSubject.getTransactionSubject().onNext(
                    new JSONObject()
                            .put("type", "audit")
                            .put("body", "green")
                            .toString()
            );
        });

        Then("^audit TransactionSubject should be aware of it$", () -> {
            TransactionSubject.getTransactionSubject()
                    .subscribe(event -> {
                        world.countDown.countDown();
                    });

            world.countDown.await(5, TimeUnit.SECONDS);
            assert(world.countDown.getCount() == 0);
        });

        When("^no event is emmited$", () -> {
            world.countDown = new CountDownLatch(1);
        });

        Then("^audit TransactionSubject should receive anything$", () -> {
            TransactionSubject.getTransactionSubject()
                    .subscribe(event -> {
                        world.countDown.countDown();
                    });

            world.countDown.await(5, TimeUnit.SECONDS);
            assert(world.countDown.getCount() == 1);
        });
    }
}
