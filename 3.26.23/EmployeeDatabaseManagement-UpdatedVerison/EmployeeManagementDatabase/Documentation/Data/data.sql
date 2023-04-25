insert into role values(1, 'USER');
insert into role values(2, 'ADMIN');

insert into user values(1, 'mns1013@sru.edu', 'Maya', 'Maya Smallwood', 'Smallwood', '', '', '', 'mns1013');
insert into user values(2, 'pms1006@sru.edu', 'Paul', 'Paul Schlabach', 'Schlabach', '', '', '', 'pms1006');
insert into user values(3, 'bdw1006@sru.edu', 'Bradon', 'Bradon Walters', 'Walters', '', '', '', 'bdw1006');
insert into user values(4, 'sam.thangiah@sru.edu', 'Dr.Sam', 'Dr.Sam Thangiah', 'Thangiah', '', '', '', 'sam488');
insert into user values(5, 'fra488@sru.edu', 'Franics', 'Franics Tube', 'Tube', '', '', '', 'fra488');
insert into user values(6, 'alx488@sru.edu', 'Alex', 'Alex Schema', 'Schema', '', '', '', 'alx488');

insert into timesheets values('1','5:00 PM','Maya','10.50','40','Smallwood','$400.20','4/24/2023-5/06/2023','8:00 AM','mns1013');
insert into timesheets values('2','5:00 PM','Paul','10.50','40','Schlabach','$400.20','4/24/2023-5/06/2023','8:00 AM','pms1006');
insert into timesheets values('3','5:00 PM','Bradon','10.50','40','Walters','$400.20','4/24/2023-5/06/2023','8:00 AM','bdw1006');
insert into timesheets values('4','5:00 PM','Dr.Sam','500','80','Thangiah','$25,008','4/24/2023-5/06/2023','8:00 AM','sam488');
insert into timesheets values('5','5:00 PM','Franics','10.50','31','Tube','$225.12','4/24/2023-5/06/2023','8:00 AM','fra488');

insert into user_role values(1, 2);
insert into user_role values(2, 2);
insert into user_role values(3, 2);
insert into user_role values(4, 2);
insert into user_role values(6, 1);

insert into user_sheet values('mns1013', 'mns1013');
insert into user_sheet values('sam488', 'sam488');
insert into user_sheet values('bdw1006', 'bdw1006');
insert into user_sheet values('pms1006', 'pms1006');
insert into user_sheet values('fra488', 'fra488');
insert into user_sheet values('alx488', 'alx488');
insert into user_sheet values('nsa488', 'nsa488');