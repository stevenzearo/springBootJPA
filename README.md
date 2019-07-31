# springBootJPA
springBoot + JPA demo

## JPA Notes
JPA java persistence API java持久层API
### 特点
- 支持XML和注解开发
- 面向对象的表操作
- 全自动的单表操作（封装了丰富的单表操作方法）
### 分页
页码从0开始  
#### 前端参数
- page = 页码
- size = 分页大小
- sort = 实体类的属性名，排序规则（asc, desc）
### 控制层设置默认参数
```
 @PageableDefault(page = 0, size = 5, sort = {"coursePubDate"}, direction = Sort.Direction.DESC)
```
### service层设置分页方法
```
Pageable pageable = PageRequest.of(page, size)
courseDao.findAll(pageable)
```
### 数据的懒加载和立即加载
- 立即加载：在主类被加载时，属性关联的类同时被加载
- 懒加载：在主类被加载时，属性关联的类不会被立即加载，只有在属性被引用时才会被加载（懒加载需要保证主查询session(数据库连接会话)的生命周期没有结束，解决方法：在查询方法上加入@Transactional注解）
- 适用场景：立即加载适用于一对一或多对一，懒加载适用于一对多、多对多（节省内存占用）
