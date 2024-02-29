CREATE TABLE "rm_user" (
	user_id SERIAL  not null primary key,
	user_name varchar(255),
	user_password varchar(255),
	contact_number varchar(255),
	email varchar(255),
	user_role varchar(255),
	status varchar(255)
)