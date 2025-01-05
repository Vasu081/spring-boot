package com.task_1.azure_basic_app.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserSummaryDTO {

    private long userId;
    private String firstName;
    private String lastName;
}
