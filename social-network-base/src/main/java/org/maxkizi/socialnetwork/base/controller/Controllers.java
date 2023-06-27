package org.maxkizi.socialnetwork.base.controller;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Controllers {
    private static final String BASE_URL = "/api/v1";
    private static final String BY_ID = "/{id}";
    public static final String PROFILE = BASE_URL + "/profile";
    private static final String AUTH = "/auth";

    public static final String USERS = BASE_URL + "/users";
    public static final String FOLLOWERS = BASE_URL + "/followers";
    public static final String FOLLOW = BASE_URL + "/follow"+ BY_ID;
    public static final String PROFILE_BY_ID = PROFILE + BY_ID;
    public static final String BASE_URL_ASTERISC = BASE_URL + "/*";
    public static final String BASE_URL_DOUBLE_ASTERISC = BASE_URL + "/**";
    public static final String ME = BASE_URL + AUTH + "/me";

}
