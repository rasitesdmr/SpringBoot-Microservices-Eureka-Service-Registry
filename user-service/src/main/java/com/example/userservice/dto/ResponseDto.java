package com.example.userservice.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResponseDto {
    private UserDto userDto;
    private DepartmentDto departmentDto;


}
