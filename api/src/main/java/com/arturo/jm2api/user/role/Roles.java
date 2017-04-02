package com.arturo.jm2api.user.role;

public class Roles {
    
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    public static final String DEFAULT = USER;

    private Roles() {
        throw new IllegalAccessError("Utility class");
    }

}
