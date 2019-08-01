package steve.spring.jpa.springboot_jpa.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import steve.spring.jpa.springboot_jpa.model.dao.CourseDao;
import steve.spring.jpa.springboot_jpa.model.pojo.Course;
import steve.spring.jpa.springboot_jpa.model.service.CourseService;

/**
 * @Author steve
 * @Date 2019/7/30
 * @Time 10:53
 * @Version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Page<Course> getCourseInfoPage(Pageable pageable) {
        return  courseDao.findAll(pageable);
    }
    /*@Scheduled(cron = "1/1 * * * * ?")
    public void taskTest(){
        System.out.println("task running......");
    }*/

}
