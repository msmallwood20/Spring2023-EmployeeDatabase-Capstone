insert into role values(1, 'USER');
insert into role values(2, 'ADMIN');

insert into user values(1, 'mayasmallwood41@gmail.com', 'Maya', 'Maya Smallwood', 'Smallwood', '', '', '', 'mns1013');
insert into user values(2, '', 'Paul', 'Paul Schlabach', 'Schlabach', '', '', '', 'pms1006');
insert into user values(3, '', 'Bradon', 'Bradon Walters', 'Walters', '', '', '', 'bdw1006');
insert into user values(4, 'sam.thangiah@sru.edu', 'Dr.Sam', 'Dr.Sam Thangiah', 'Thangiah', '', '', '', 'sam488');

insert into user values(5, '', 'Franics', 'Franics Tube', 'Tube', '', '', '', 'fra488');
insert into user values(6, '', 'Alex', 'Alex Schema', 'Schema', '', '', '', 'alx488');

insert into user_role values(1, 2);
insert into user_role values(2, 2);
insert into user_role values(3, 2);
insert into user_role values(4, 2);
insert into user_role values(5, 1);
insert into user_role values(6, 1);