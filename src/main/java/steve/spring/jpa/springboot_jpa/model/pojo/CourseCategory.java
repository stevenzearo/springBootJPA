package steve.spring.jpa.springboot_jpa.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//课程类别表
@Entity
@Table(name = "course_category")
public class CourseCategory {
	@Id
	@Column(name = "course_id")
	private Integer courseCategoryId;//课程类别id
	@Column(name = "category_name")
	private String  categoryName;//课程类别
	public Integer getCourseCategoryId() {
		return courseCategoryId;
	}
	public void setCourseCategoryId(Integer courseCategoryId) {
		this.courseCategoryId = courseCategoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CourseCategory(Integer courseCategoryId, String categoryName) {
		super();
		this.courseCategoryId = courseCategoryId;
		this.categoryName = categoryName;
	}
	public CourseCategory() {
		super();
	}
	@Override
	public String toString() {
		return "CourseCategory [courseCategoryId=" + courseCategoryId + ", categoryName=" + categoryName + "]";
	}
	
}
