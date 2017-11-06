
use IS_202;
 
CREATE TABLE contacts (
  contact_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  file mediumblob,
  PRIMARY KEY (contact_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

select * from contacts;