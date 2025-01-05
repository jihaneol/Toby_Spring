package test;

import main.proxy.Hello;
import main.proxy.HelloTarget;
import main.proxy.UppercaseHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    @DisplayName("심플 프록시 테스트")
    void simpleProxy() throws Exception {
        // given
        Hello hello = new HelloTarget();
        Assertions.assertEquals(hello.sayHello("Toby"), "Hello Toby");
        //when

        //then

    }
    @Test
    @DisplayName("대문자 테스트")
    void Upper() throws Throwable {
        // given
        var uppercaseHandler = new UppercaseHandler(new HelloTarget());
        Assertions.assertEquals(uppercaseHandler.invoke(null, HelloTarget.class.getMethod("sayHello", String.class), new Object[] {"Toby"}),"HELLO TOBY");
        //when

        //then

    }
}
