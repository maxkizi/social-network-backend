package org.maxkizi.socialnetworkbackend.dto;

import lombok.Data;

@Data
public class ProfileUserInfoDto {
    private Long id;
    private String userPhotoUrl;
    private String firstName;
    private String lastName;
    private String country;
    private boolean isFollowed;
    private String status;
    private String info;
}
