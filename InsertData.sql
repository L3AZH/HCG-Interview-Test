-- insert data for entity
use bookingsystemdb;
insert into hotel(`name`) 
	values 
    row('hotel_a'),
    row('hotel_b'),
    row('hotel_c'),
    row('hotel_d');
    
insert into room_type(`name`) 
	values 
    row('single_0'),
    row('single_1'),
    row('double_0'),
    row('family_0');
    
insert into rate_plan(`name`) 
	values 
    row('summer_plan_0'),
    row('winter_plan_0'),
    row('atum_plan_0'),
    row('spring_plan_0');
    
insert into period(`start_date`,`end_date`) 
	values 
    row('2024-01-06 00:00:00','2024-01-31 00:00:00'),
    row('1000-01-07 00:00:00','2024-01-24 00:00:00'),
    row('1000-01-10 00:00:00','2024-01-15 00:00:00'),
    row('1000-02-01 00:00:00','2024-02-15 00:00:00');
    
insert into room_rate(`room_type_id`,`date`,`price`,`default_rate_plan`) 
	values 
    row(1,'2024-01-06',203.99,1),
    row(1,'2024-01-07',143.98,3),
    row(2,'2024-01-06',203.99,2),
    row(2,'2024-01-07',89.99,1);
    
insert into room_availability(`room_type_id`,`date`,`available_to_sell`) 
	values 
    row(1,'2024-01-06',20),
    row(1,'2024-01-07',10),
    row(2,'2024-01-06',5),
    row(2,'2024-01-07',8);

insert into guest(`email`,`phone_number`) 
	values 
    row('test1@test.com','+8400000001'),
    row('test2@test.com','0985623261'),
    row('test3@test.com','0852612654'),
    row('test4@test.com','0131314512');

insert into booking(`guest_email`,`price`,`room_type_id`,`rate_plan_id`) 
	values 
    row('test1@test.com',1235.12,1,3),
    row('test1@test.com',15382.45,2,4),
    row('test1@test.com',9878.12,4,2),
    row('test2@test.com',122.40,2,1);
    
-- insert data for relationship
insert into hotel_rel_room_type(`hotel_id`,`room_type_id`)
	values
    row(1,1),
    row(1,2),
    row(1,3),
    row(1,4);
    
insert into hotel_rel_rate_plan(`hotel_id`,`rate_plan_id`)
	values
    row(1,1),
    row(1,2),
    row(1,3),
    row(1,4);
    
insert into period_rel_rate_plan(`period_id`,`rate_plan_id`)
	values
    row(4,1),
    row(2,2),
    row(3,3),
    row(1,4);

insert into room_type_rel_rate_plan(`room_type_id`,`rate_plan_id`)
	values
    row(4,1),
    row(2,2),
    row(3,3),
    row(1,4);