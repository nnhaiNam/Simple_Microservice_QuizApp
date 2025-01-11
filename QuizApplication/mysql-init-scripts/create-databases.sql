CREATE DATABASE IF NOT EXISTS questiondb;
CREATE DATABASE IF NOT EXISTS quizdb;

USE questiondb;

CREATE TABLE IF NOT EXISTS question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_title VARCHAR(255),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    right_answer VARCHAR(255),
    difficulty_level VARCHAR(50),
    category VARCHAR(100)
);

INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('What is the capital of VietNam','Ho Chi Minh City','Ha Noi','Da Nang','Long An','Ha Noi','medium','questionVN');

INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('How many provinces and cities does Vietnam have?','60','61','64','63','63','medium','questionVN');

INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('Where is "Pia" cake a specialty?','Long AN','Tra Vinh','Soc Trang','Ha Noi','Soc Trang','easy','questionVN');

INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('Where is "Bun Cha" cake a specialty?','Long AN','Tra Vinh','Soc Trang','Ha Noi','Ha Noi','easy','questionVN');

INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('Where is "Mi Quang" cake a specialty?','Quang Nam','Tra Vinh','Soc Trang','Ha Noi','Quang Nam','easy','questionVN');


INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('Where is "Ca kho lang Vu Dai" cake a specialty?','Quang Nam','Ha Nam','Soc Trang','An Giang','Ha Nam','hard','questionVN');


INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('How many ethnic groups does Vietnam have?','45','50','52','54','54','easy','questionVN');

INSERT INTO question (question_title,option1,option2,option3,option4,right_answer,difficulty_level,category)
VALUES ('Which king reigned the longest in Vietnamese history??','Ly Nhan Tong','Le Thanh Tong','Tran Thanh Tong','Ly Thanh Tong','Ly Nhan Tong','hard','questionVN');

