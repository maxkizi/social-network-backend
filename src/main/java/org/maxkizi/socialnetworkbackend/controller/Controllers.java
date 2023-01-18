package org.maxkizi.socialnetworkbackend.controller;

public final class Controllers {
    private static final String BASE_URL = "/api/v1";
    private static final String BY_ID = "/{id}";
    public static final String USERS = BASE_URL + "/users";
    public static final String PROFILE = BASE_URL + "/profile";
    public static final String PROFILE_BY_ID = BASE_URL + "/profile" + BY_ID ;


    private Controllers() {

    }
}
