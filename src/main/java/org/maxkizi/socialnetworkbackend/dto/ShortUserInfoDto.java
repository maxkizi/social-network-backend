package org.maxkizi.socialnetworkbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShortUserInfoDto{
    private Long id;
    private String userPhotoUrl;
    private String firstName;
    private String lastName;
    private String country;
    @JsonProperty("isFollow")
    private boolean isFollower;

}
