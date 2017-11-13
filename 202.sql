
use IS_202;
 
Create table delivery (
	Delivery_ID int not null AUTO_INCREMENT,
    #Module_ID int not null,
	#email varchar(255) not null,
	Comment varchar(200),
	File mediumblob,
    approved boolean,
	constraint delivery_PK primary key (Delivery_ID)
    #foreign key (Module_ID) references Module(Module_ID),
	#foreign key (email) references bruker(email)
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

select * from bruker;