insert into bhuser (username, userpassword, motto, useremail) values ('user 1','password','motto for user 1','user1@domain.com');
insert into bhuser (username, userpassword, motto, useremail) values ('user 2','password','motto for user 2','user2@domain.com');
insert into bhuser (username, userpassword, motto, useremail) values ('user 3','password','motto for user 3','user3@domain.com');
insert into bhuser (username, userpassword, motto, useremail) values ('user 4','password','motto for user 4','user4@domain.com');

update bhuser set useremail = 'user2@domain.com' where bhuserid=2;
update bhuser set useremail = 'user3@domain.com' where bhuserid=3;
update bhuser set useremail = 'user4@domain.com' where bhuserid=4;
