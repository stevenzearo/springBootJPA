package steve.spring.jpa.springboot_jpa.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import steve.spring.jpa.springboot_jpa.model.pojo.Course;

import java.io.Serializable;
import java.util.List;

/**
 * @Author steve
 * @Date 2019/7/30
 * @Time 10:43
 * @Version 1.0
 */
@Repository
public interface CourseDao extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course>, Serializable {
    /**
     * 获取所有课程信息
     * @return 课程信息集合
     */
    List<Course> getCoursesByCourseLevel(Integer courseLevel);

    @Query(value = "from Course where courseName like ?1")
    List<Course> coursesInMyConditionsNameLike(String courseName);
}
