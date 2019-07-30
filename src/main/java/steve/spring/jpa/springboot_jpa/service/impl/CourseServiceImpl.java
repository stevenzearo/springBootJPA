package steve.spring.jpa.springboot_jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import steve.spring.jpa.springboot_jpa.dao.CourseDao;
import steve.spring.jpa.springboot_jpa.pojo.Course;
import steve.spring.jpa.springboot_jpa.service.CourseService;

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
    public Page<Course> getCourseInfoPage(Integer pageNum, Integer pageSize) {
        return  courseDao.findAll(PageRequest.of(pageNum,pageSize, Sort.by("coursePubDate")));
    }
}
