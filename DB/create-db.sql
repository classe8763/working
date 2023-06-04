CREATE SCHEMA `db-social-plaform`;

use `db-social-plaform`;
SET FOREIGN_KEY_CHECKS = 0;

create table `user`(
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
    `phone_number`  varchar(22) NOT NULL,
    `password` char(68) not null,
    `cover_image` varchar(255),
    `biography` varchar(255),
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

create table `post`(
	`post_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `content` text NOT NULL,
    `image` varchar(255),
    `create_at` datetime,
    PRIMARY KEY (`post_id`),
    KEY `FK_USER_idx` (`user_id`),
    CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

create table comment(
	`comment_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
	`post_id` int(11) NOT NULL,
    `content` text NOT NULL,
    `create_at` datetime,
    
    PRIMARY KEY (`comment_id`),
    
	KEY `FK_POST_idx` (`post_id`),
     CONSTRAINT `FK_POST_COMMENT` FOREIGN KEY (`post_id`) 
        REFERENCES `post` (`post_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
        
    CONSTRAINT `FK_USER_COMMENT` FOREIGN KEY (`user_id`) 
        REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;

SET FOREIGN_KEY_CHECKS = 1;





