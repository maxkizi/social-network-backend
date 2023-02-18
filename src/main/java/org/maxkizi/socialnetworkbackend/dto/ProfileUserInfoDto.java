package org.maxkizi.socialnetworkbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserInfoDto {
    private Long id;
    private String userPhotoUrl;
    private String firstName;
    private String lastName;
    private String country;
    private String status;
    private String info;
    private String createdAt;
    private String updatedAt;
    private List<ShortUserInfoDto> friends;
}
