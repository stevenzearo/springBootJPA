package steve.spring.jpa.springboot_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import steve.spring.jpa.springboot_jpa.model.pojo.Course;
import steve.spring.jpa.springboot_jpa.model.service.CourseService;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 10:57
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/course")
public class CoursePageInfoController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/pageInfo")
    public Page<Course> getCoursePageInfo(
            @PageableDefault(page = 0, size = 5, sort = {"coursePubDate"}, direction = Sort.Direction.DESC) Pageable pageable
    ){
        return  courseService.getCourseInfoPage(pageable);
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "this is a test response.";
    }
}
