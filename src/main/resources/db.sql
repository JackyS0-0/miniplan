CREATE TABLE `user` (
  `id` VARCHAR(32) NOT NULL,
  `wx_openid` VARCHAR(32) DEFAULT NULL,
  `wx_unionid` VARCHAR(32) DEFAULT NULL,
  `username` VARCHAR(50) DEFAULT NULL,
  `nickname` VARCHAR(50) DEFAULT NULL,
  `avatar_url` VARCHAR(255) DEFAULT NULL,
  `mobile` VARCHAR(20) DEFAULT NULL,
  `email` VARCHAR(100) DEFAULT NULL,
  `password_hash` VARCHAR(255) DEFAULT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '状态：0-禁用, 1-正常',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_wx_openid` (`wx_openid`),
  UNIQUE KEY `idx_wx_unionid` (`wx_unionid`),
  KEY `idx_mobile` (`mobile`),
  KEY `idx_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `plan` (
  `id` VARCHAR(32) NOT NULL,
  `userid` VARCHAR(32) DEFAULT NULL,
  `parentplan` VARCHAR(32) DEFAULT NULL,
  `title` VARCHAR(32) DEFAULT NULL,
  `deadline` DATE DEFAULT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '状态：0-已删除, 1-正常, 2-已完结',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `plan_task` (
  `id` VARCHAR(32) NOT NULL,
  `planid` VARCHAR(32) DEFAULT NULL,
  `title` VARCHAR(32) DEFAULT NULL,
  `index` INT DEFAULT NULL,
  `completed` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '完成状态：0-未完成, 1-已完成',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;