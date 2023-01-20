package com.example.userservice.service;

import com.example.userservice.dto.DepartmentDto;
import com.example.userservice.dto.ResponseDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long id) {


        User user = userRepository.findById(id).orElseThrow();
        UserDto userDto =UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://department-service/department/"+user.getDepartmentId(),DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        return ResponseDto.builder()
                .userDto(userDto)
                .departmentDto(departmentDto)
                .build();
    }
}
