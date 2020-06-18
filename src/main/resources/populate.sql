INSERT INTO users(username,password,enabled,role) VALUES ('admin','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true,'ROLE_ADMIN');
INSERT INTO users(username,password,enabled,role) VALUES ('jobseeker','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true, 'ROLE_JOBSEEKER');
INSERT INTO users(username,password,enabled,role) VALUES ('employer','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true, 'ROLE_EMPLOYER');
INSERT INTO users(username,password,enabled,role) VALUES ('perrylugi','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true, 'ROLE_EMPLOYER');
INSERT INTO users(username,password,enabled,role) VALUES ('bleardd','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true, 'ROLE_EMPLOYER');
INSERT INTO users(username,password,enabled,role) VALUES ('all','$2a$10$L25iUbldPKIu2tR4oms.yusz0PQgnv8c9j.iygyS6FyKpiQlAnYfO', true,'ROLE_ADMIN,ROLE_EMPLOYER,ROLE_JOBSEEKER');

INSERT INTO job_seeker(status,about_you,email,profile_title, experience,first_name,last_name,phone,user_id) VALUES('seeking','I am a Job Seeker','job@seeker.com','java developer',3,'Dave','Johnson','(555) 555-1234',2);
INSERT INTO job_seeker(status,about_you,email,profile_title, experience,first_name,last_name,phone,user_id) VALUES('seeking','I am a Job Seeker','job@seeker.com','java developer',1,'Robin','Davidson','(555) 555-1234',2);
INSERT INTO job_seeker(status,about_you,email,profile_title, experience,first_name,last_name,phone,user_id) VALUES('seeking','I am a Job Seeker','job@seeker.com','java developer',3,'John','Robinson','(555) 555-1234',2);
INSERT INTO JobSeeker_skills (JobSeeker_id, skills) VALUES(1,'Java');
INSERT INTO JobSeeker_skills (JobSeeker_id, skills) VALUES(1,'J2EE');
INSERT INTO JobSeeker_skills (JobSeeker_id, skills) VALUES(1,'Spring');

INSERT INTO employer(about_you,email,first_name,last_name,phone,user_id) VALUES('I am a Employer','bleardd@gmail.com','Bleard','Rexhaj','(555) 555-1234',3);
INSERT INTO employer(about_you,email,first_name,last_name,phone,user_id) VALUES('I am a Employer','perryluigi@gmail.com','Perry','Luigi','(555) 555-1234',5);
INSERT INTO job(job_company_name,job_description,job_name,job_salary,status,publisher_id,employee_id) VALUES('Tech Riders','Back-End Development','Java Spring Boot Developer',9000,'available',1,null);
INSERT INTO job(job_company_name,job_description,job_name,job_salary,status,publisher_id,employee_id) VALUES('Tech Riders','Front-End Development','PHP Laravel Developer',9000,'available',1,null);
INSERT INTO job(job_company_name,job_description,job_name,job_salary,status,publisher_id,employee_id) VALUES('Tech Riders','Full-Stack Development','Java Spring, Angular JS',9000,'available',1,null);
