package steve.spring.jpa.springboot_jpa.pojo;

import javax.persistence.*;

//课程表
@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private Integer courseId;//课程id
	@Column(name = "course_name")
	private String  courseName;//课程名
	@Column(name ="course_category_id")
	private Integer courseCategoryId;//课程类别id
	@Column(name = "course_introduce")
	private String  courseIntroduce;//课程介绍
	@Column(name = "course_notice")
	private String  courseNotice;//课程笔记
	@Column(name = "course_goal")
	private String  courseGoal;//课程学习目标
	@Column(name = "user_teacher_id")
	private Integer userTeacherId;//课程教师id
	@Column(name = "course_picture")
	private String  coursePicture;//课程图片路径
	@Column(name = "course_price")
	private Float   coursePrice;//课程价格
	@Column(name = "course_level")
	private Integer courseLevel;//课程难度系数
	@Column(name = "course_pubdate")
	private String  coursePubDate;//发布时间

	public Course() {
		super();
	}
	public Course(Integer courseId, String courseName, Integer courseCategoryId, String courseIntroduce,
				  String courseNotice, String courseGoal, Integer userTeacherId, String coursePicture,
				  Float coursePrice, Integer courseLevel,String  coursePubDate) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCategoryId = courseCategoryId;
		this.courseIntroduce = courseIntroduce;
		this.courseNotice = courseNotice;
		this.courseGoal = courseGoal;
		this.userTeacherId = userTeacherId;
		this.coursePicture = coursePicture;
		this.coursePrice = coursePrice;
		this.courseLevel = courseLevel;
		this.coursePubDate =coursePubDate;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseCategoryId() {
		return courseCategoryId;
	}
	public void setCourseCategoryId(Integer courseCategoryId) {
		this.courseCategoryId = courseCategoryId;
	}
	public String getCourseIntroduce() {
		return courseIntroduce;
	}
	public void setCourseIntroduce(String courseIntroduce) {
		this.courseIntroduce = courseIntroduce;
	}
	public String getCourseNotice() {
		return courseNotice;
	}
	public void setCourseNotice(String courseNotice) {
		this.courseNotice = courseNotice;
	}
	public String getCourseGoal() {
		return courseGoal;
	}
	public void setCourseGoal(String courseGoal) {
		this.courseGoal = courseGoal;
	}
	public Integer getUserTeacherId() {
		return userTeacherId;
	}
	public void setUserTeacherId(Integer userTeacherId) {
		this.userTeacherId = userTeacherId;
	}
	public String getCoursePicture() {
		return coursePicture;
	}
	public void setCoursePicture(String coursePicture) {
		this.coursePicture = coursePicture;
	}
	public Float getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Float coursePrice) {
		this.coursePrice = coursePrice;
	}
	public Integer getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(Integer courseLevel) {
		this.courseLevel = courseLevel;
	}
	public String getCourseDate() {
		return coursePubDate;
	}
	public void setCourseDate(String courseDate) {
		this.coursePubDate = courseDate;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseCategoryId=" + courseCategoryId
				+ ", courseIntroduce=" + courseIntroduce + ", courseNotice=" + courseNotice + ", courseGoal="
				+ courseGoal + ", userTeacherId=" + userTeacherId + ", coursePicture=" + coursePicture
				+ "," + "coursePrice=" + coursePrice + ", courseLevel=" + courseLevel + ", coursePubDate="
				+ coursePubDate + "]";
	}
	
	
}
