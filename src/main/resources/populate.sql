INSERT INTO users(username,password,enabled,role) VALUES ('admin','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true,'ROLE_ADMIN');
INSERT INTO users(username,password,enabled,role) VALUES ('jobseeker','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true, 'ROLE_JOBSEEKER');
INSERT INTO users(username,password,enabled,role) VALUES ('employer','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true, 'ROLE_EMPLOYER');
INSERT INTO users(username,password,enabled,role) VALUES ('all','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true,'ROLE_ADMIN,ROLE_EMPLOYER,ROLE_JOBSEEKER');

INSERT INTO job_seeker(about_you,email,profile_title, experience,first_name,last_name,phone,user_id) VALUES('I am a Job Seeker','job@seeker.com','java developer',3,'jobs','seeker1','(555) 555-1234',2);
INSERT INTO job_seeker(about_you,email,profile_title, experience,first_name,last_name,phone,user_id) VALUES('I am a Job Seeker','job@seeker.com','java developer',1,'jobs','seeker2','(555) 555-1234',1);
INSERT INTO job_seeker(about_you,email,profile_title, experience,first_name,last_name,phone,user_id) VALUES('I am a Job Seeker','job@seeker.com','java developer',3,'jobs','seeker3','(555) 555-1234',2);
INSERT INTO JobSeeker_skills (JobSeeker_id, skills) VALUES(1,'Java');
INSERT INTO JobSeeker_skills (JobSeeker_id, skills) VALUES(1,'J2EE');
INSERT INTO JobSeeker_skills (JobSeeker_id, skills) VALUES(1,'Spring');