package br.com.study.rxjava;

import br.com.study.rxjava.cucumber.World;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {
                RxjavaApplication.class,
                World.class
        })
public class TestConfig {}
