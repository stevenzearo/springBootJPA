package steve.spring.jpa.springboot_jpa;

import java.util.Objects;

/**
 * @Author steve
 * @Date 2019/8/1
 * @Time 15:42
 * @Version 1.0
 */
public class ObjectTest implements Comparable<ObjectTest>{
    private String name;
    private Integer value;

    public ObjectTest(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ObjectTest{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectTest that = (ObjectTest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public int compareTo(ObjectTest o) {
        return 0;
    }
}
