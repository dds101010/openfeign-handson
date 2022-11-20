package org.zenith.openfeignHandson.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zenith.openfeignHandson.model.User;

import java.util.List;

@FeignClient(
        name = "user",
        url = "${openfeign.jsonplaceholder.baseUrl}/users"
)
public interface UserClient {

    @GetMapping
    List<User> getUsers();

    @GetMapping(value = "/{userId}")
    User getUserById(@PathVariable("userId") Long userId);
}
