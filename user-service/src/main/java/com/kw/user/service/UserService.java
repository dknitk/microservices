package com.kw.user.service;

import com.kw.user.entity.User;
import com.kw.user.repository.UserRepository;
import com.kw.user.vo.Department;
import com.kw.user.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User findByUserId(Long userId) {

        return userRepository.findByUserId(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
