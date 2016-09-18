CREATE DATABASE IF NOT EXISTS library;
use library;

drop table if exists books;

CREATE TABLE books (
	id int(5) Primary Key auto_increment,
	title varchar(20) NOT NULL,
	author varchar(20) NOT NULL,
	pages int(4) not null,
    price int(4) not null

  );

insert into books (title, author, pages,price) values ("Epic of Gilgamesh", "Unknown", 12, 70);
insert into books (title, author, pages,price) values ("Det evige liv", "Fernando Savater", 270, 50);
insert into books (title, author, pages,price) values ("Staten", "Platon", 321, 68);

