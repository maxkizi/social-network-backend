package org.maxkizi.socialnetworkbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String text;
    private String createdAt;
    private String updatedAt;
}
