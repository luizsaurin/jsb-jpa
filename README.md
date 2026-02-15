<h1 align="center"><strong>Java Spring Boot - JPA</strong></h1>

This is an example of a Java Spring Boot API using JPA and Postgres database. Here the most used types of mappings between entities and queries were exemplified. A few points of attention will be discussed about the most used mappings below.

&nbsp;

## **How to run**

1. Run the docker-compose.yml to initialize the database
1. Run the Spring Boot project

### Dependencies:
- Docker
- Docker compose
- Java JDK 25
- Maven 3.9.12

&nbsp;

## **Mapping annotations**

The most used JPA mappings are:

- OneToOne
- OneToMany
- ManyToOne
- ManyToMany

This is because these mappings generally resolve almost all situations. However, there are other types of mappings such as:

- ElementCollection
- Embedded
- Embeddable
- MapKey
- OrderBy
- OrderColumn

In this project, only the most used mappings were used.

&nbsp;

## **OneToOne**

This annotation establishes a one-to-one relationship between two entities. It means that one instance of an entity is associated with exactly one instance of another entity. 

There are different ways to perform OneToOne mapping:

```java
@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	private Long id;
	@OneToOne
	private UserProfileEntity userProfile;
}

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity {
	
	@Id
	private Long id;
	private String fullName;
}
```

In this case, @OneToOne establishes a unidirectional one-to-one relationship between User and UserProfile. This means that User entity has a reference to UserProfile, but UserProfile entity doesn't have any reference back to User. In the database, this would typically be represented by a foreign key in the User table referencing the primary key of the UserProfile table.

### mappedBy

```java
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	private Long id;
	private String username;
	@OneToOne(mappedBy = "users")
	private UserProfileEntity userProfile;
}

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity {
	@Id
	private Long id;
	private String fullName;
	@OneToOne
	private UserEntity user;
}
```

Here, mappedBy attribute is used in User entity to indicate that the owning side of the relationship is UserProfile, and it's mapped by the user attribute in UserProfile. This implies that UserProfile entity maintains the foreign key relationship in the database, referencing the primary key of the User table.

### JoinColumn

```java
@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	private Long id;
	private String username;
	@OneToOne
	@JoinColumn(name = "user_profile_id")
	private UserProfileEntity userProfile;
}

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity {
	
	@Id
	private Long id;
	private String fullName;
}
```

In this case, @JoinColumn annotation is used along with @OneToOne to specify the column in the User table that will be used to store the foreign key referencing the UserProfile. This provides more control over the column name and other properties of the foreign key column.

### Summary

- Use simple @OneToOne when you only need a unidirectional relationship where one entity references another.
- Use mappedBy when you need bidirectional mapping, and the other entity is responsible for managing the relationship.
- Use @JoinColumn when you need more control over the column name and properties of the foreign key column in the owning entity's table.

&nbsp;

## **OneToMany**

This annotation establishes a one-to-many relationship between two entities. It means that one instance of an entity is associated with multiple instances of another entity.

```java
@Entity
@Table(name = "posts")
public class PostEntity {
	
	@Id
	private Long id;
	private String title;
	@OneToMany(mappedBy = "posts")
	private List<CommentEntity> comments;
}

@Entity
@Table(name = "comments")
public class CommentEntity {
	
	@Id
	private Long id;
	private String text;
	@ManyToOne
	private PostEntity post;
}
```

&nbsp;

## **ManyToOne**

This annotation establishes a many-to-one relationship between two entities. It means that multiple instances of an entity can be associated with one instance of another entity.

```java
@Entity
@Table(name = "books")
public class BookEntity {
	
	@Id
	private Long id;
	private String title;
	@ManyToOne
	private AuthorEntity author;
}

@Entity
@Table(name = "authors")
public class AuthorEntity {
	
	@Id
	private Long id;
	private String name;
}
```

&nbsp;

## **ManyToMany**

This annotation establishes a many-to-many relationship between two entities. It means that multiple instances of one entity can be associated with multiple instances of another entity.

```java
@Entity
@Table(name = "students")
public class StudentEntity {

	@Id
	private Long id;
	private String name;
	@ManyToMany
	@JoinTable(
		name = "student_course",
		joinColumns = @JoinColumn(name = "student_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<CourseEntity> courses;
}

@Entity
@Table(name = "courses")
public class CourseEntity {
	@Id
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "courses")
	private List<StudentEntity> students;
}
```

### Join Table

A typical Many-to-Many relationship mapping using JPA, you'll need an intermediary table to represent the association between the two entities. This intermediary table is often referred to as a "join table" or "association table".

Let's consider an example with Student and Course entities. Each student can enroll in multiple courses, and each course can have multiple students enrolled. In such a scenario, you'd need a join table to represent which students are enrolled in which courses.

The other mapping types (OneToOne, OneToMany, and ManyToOne) do not require a separate join table because they represent different types of relationships where the mapping can be established directly through foreign key associations in the database schema.

&nbsp;

## **Mapping variations**

This project presented some simple examples of JPA mappings. However, there are several different ways to configure these mappings.

For example: in Many To Many mapping it is optional to use the mappedBy property

```java
@Entity
@Table(name = "courses")
public class CourseEntity {
	@ManyToMany(mappedBy = "courses")
	private List<StudentEntity> students;
}
```

And an example of additional configuration is FetchType:

```java
@Entity
@Table(name = "courses")
public class CourseEntity {
	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	private List<StudentEntity> students;
}
```

This way, JPA mappings can be done in different ways and can have several optional configurations. It is important to evaluate the best strategy for each situation.