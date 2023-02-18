package org.maxkizi.socialnetworkbackend.dto;

import lombok.Data;

@Data
public class ShortUserInfoDto {
    private Long id;
    private String userPhotoUrl;
    private String firstName;
    private String lastName;
    private String country;
}
