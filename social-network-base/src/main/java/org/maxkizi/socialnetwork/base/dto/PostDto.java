package org.maxkizi.socialnetwork.base.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String text;
    private String createdAt;
    private String updatedAt;
}
