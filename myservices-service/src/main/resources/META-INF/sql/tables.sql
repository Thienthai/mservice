create table guest_books2 (
	myId LONG not null primary key,
	name VARCHAR(75) null,
	myDate VARCHAR(75) null,
	message VARCHAR(75) null,
	createdId LONG,
	imageUrl VARCHAR(75) null
);