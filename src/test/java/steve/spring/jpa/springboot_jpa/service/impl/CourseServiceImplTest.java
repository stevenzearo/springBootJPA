package steve.spring.jpa.springboot_jpa.service.impl;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import steve.spring.jpa.springboot_jpa.pojo.Course;
import steve.spring.jpa.springboot_jpa.service.CourseService;

import static org.junit.Assert.*;

/**
 * @Author steve
 * @Date 2019/7/30
 * @Time 15:33
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void getCourseInfoPage() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Page<Course> courseInfoPage = courseService.getCourseInfoPage(1, 5);
        courseInfoPage.getContent().forEach(course -> logger.info(course.getCourseDate()));

    }
}