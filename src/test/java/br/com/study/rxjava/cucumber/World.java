package br.com.study.rxjava.cucumber;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Scope("cucumber-glue")
public class World {
    public CountDownLatch countDown;
}

