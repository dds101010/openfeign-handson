package org.zenith.openfeignHandson;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zenith.openfeignHandson.client.UserClient;
import org.zenith.openfeignHandson.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class OpenfeignHandsonApplicationTest {

    @Autowired
    private UserClient userClient;

    @Test
    void test_UserClient() {
        List<User> users = userClient.getUsers();
        log.debug("Got users ::: {}", users);
        assertNotNull(users);
        assertEquals(10, users.size());

        User user = userClient.getUserById(1L);
        log.debug("Got user by id ::: {}", user);
        assertNotNull(user);

        FeignException feignException = assertThrows(FeignException.class, () -> {
            userClient.getUserById(11L);
        });
        assertTrue(feignException.getMessage().contains("404 Not Found"));
    }
}