
use IS_202;
 
Create table delivery (
	Delivery_ID int not null AUTO_INCREMENT,
	Comment varchar(200),
	File mediumblob,
	constraint delivery_PK primary key (Delivery_ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

select * from delivery;
drop table delivery;

Create table Module (
	Module_ID int not null AUTO_INCREMENT,
	Title varchar(50) not null,
	Description varchar(1000),
	Delivery_date date,
	constraint Module_PK primary key (Module_ID)
);