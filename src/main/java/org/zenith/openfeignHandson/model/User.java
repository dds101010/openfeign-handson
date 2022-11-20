package org.zenith.openfeignHandson.model;

public record User(
        Integer id,
        String name,
        String username,
        String email,
        String phone,
        Company company
) {
}
