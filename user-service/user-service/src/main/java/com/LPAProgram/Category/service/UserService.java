package com.LPAProgram.Category.service;


import com.LPAProgram.Category.VO.Department;
import com.LPAProgram.Category.VO.ResponseTemplateVO;
import com.LPAProgram.Category.entity.User;
import com.LPAProgram.Category.repository.UserRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);
        Gson gson = new Gson();
        String json = gson.toJson(department);
        System.out.println("json object... :"+json);
        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
