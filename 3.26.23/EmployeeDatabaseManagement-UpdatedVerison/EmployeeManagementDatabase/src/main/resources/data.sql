replace into role values(1, 'USER');
replace into role values(2, 'ADMIN');

replace into user values(1, 'Maya', 'Maya Smallwood', 'Smallwood', '', '', '', 'mns1013');

replace into user_role values(1, 2)