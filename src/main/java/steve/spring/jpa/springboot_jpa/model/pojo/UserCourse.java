package steve.spring.jpa.springboot_jpa.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//用户课程表
@Entity
@Table(name = "userCourse")
public class UserCourse {

	@Id
	@Column(name = "user_course_id")
	private Integer userCourseId;//用户课程表id
	@Column(name = "user_id")
	private Integer userId;//用户id
	@Column(name = "course_id")
	private Integer courseId;//课程id
	@Column(name = "learned_hours")
	private float   learnedHours;//学习进度/时长
	@Column(name = "pay")
	private Integer pay;//是否付费
	public UserCourse(Integer userCourseId, Integer userId, Integer courseId, float learnedHours, Integer pay) {
		super();
		this.userCourseId = userCourseId;
		this.userId = userId;
		this.courseId = courseId;
		this.learnedHours = learnedHours;
		this.pay = pay;
	}
	public UserCourse() {
		super();
	}
	public Integer getUserCourseId() {
		return userCourseId;
	}
	public void setUserCourseId(Integer userCourseId) {
		this.userCourseId = userCourseId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public float getLearnedHours() {
		return learnedHours;
	}
	public void setLearnedHours(float learnedHours) {
		this.learnedHours = learnedHours;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	
	@Override
	public String toString() {
		return "UserCourse [userCourseId=" + userCourseId + ", userId=" + userId + ", courseId=" + courseId
				+ ", learnedHours=" + learnedHours + ", pay=" + pay + "]";
	}
	
	
}
