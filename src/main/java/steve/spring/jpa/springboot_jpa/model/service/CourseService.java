package steve.spring.jpa.springboot_jpa.model.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import steve.spring.jpa.springboot_jpa.model.pojo.Course;

/**
 * @Author steve
 * @Date 2019/7/30
 * @Time 10:51
 * @Version 1.0
 */
public interface CourseService {


    Page<Course> getCourseInfoPage(Pageable pageable);

}
