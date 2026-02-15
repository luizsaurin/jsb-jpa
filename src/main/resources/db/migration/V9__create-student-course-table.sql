-- DROP TABLE student_course;

CREATE TABLE student_course (
	course_id int8 NOT NULL,
	student_id int8 NOT NULL,
	CONSTRAINT student_id_fk FOREIGN KEY (student_id) REFERENCES students(id),
	CONSTRAINT course_id_fk FOREIGN KEY (course_id) REFERENCES courses(id)
);