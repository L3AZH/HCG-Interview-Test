-- Reset counter to 1 
ALTER TABLE tablename AUTO_INCREMENT = 1;
-- Drop table
use bookingsystemdb;
DROP TABLE IF EXISTS `hotel_rel_room_type`;
DROP TABLE IF EXISTS `hotel_rel_rate_plan`;
DROP TABLE IF EXISTS `period_rel_rate_plan`;
DROP TABLE IF EXISTS `room_type_rel_rate_plan`;
DROP TABLE IF EXISTS `period`;
DROP TABLE IF EXISTS `room_rate`;
DROP TABLE IF EXISTS `room_availability`;
DROP TABLE IF EXISTS `booking`;
DROP TABLE IF EXISTS `room_type`;
DROP TABLE IF EXISTS `rate_plan`;
DROP TABLE IF EXISTS `guest`;
DROP TABLE IF EXISTS `hotel`;