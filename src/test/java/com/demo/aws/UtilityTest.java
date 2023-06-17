package com.demo.aws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class UtilityTest {

    @Test
    public void test_Get_HostName() {
        String hostname = System.getenv("HOSTNAME");
        assertThat(hostname).isNotNull();
    }

    @Test
    public void test_Failure() {
       fail();
    }
}
