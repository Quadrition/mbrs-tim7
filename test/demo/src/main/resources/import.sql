insert into category_table (name, description) values ('Fantasy', 'Genre of literature that features magical and supernatural elements that do not exist in the real world');
insert into category_table (name, description) values ('Mystery', 'Genre in literature that focuses on someone solving a puzzle or a crime');
insert into category_table (name, description) values ('Romance', 'Love story between characters');
insert into category_table (name, description) values ('History', 'Consists of events of significant change that happened in the past');

insert into library_table (name) values ('City library');

insert into user_table (first_name, last_name, library_id) values ('Sonja','Marinkovic', 1);
insert into user_table (first_name, last_name, library_id) values ('Mileva', 'Maric', 1);

insert into book_table (age_recommendation, title, year, category_id, library_id) values ('ADULT', 'Romantic book', 2018, 3, 1);
insert into book_table (age_recommendation, title, year, category_id, library_id) values ('ADULT', 'Mistery book', 2018, 2, 1);

insert into review_table (comment, book_id) values ('very interesting book', 1);
insert into review_table (comment, book_id) values ('not very interesting book', 1);
insert into review_table (comment, book_id) values ('boring book', 1);

insert into book_table_reviews (book_id, reviews_id) values (1, 1);
insert into book_table_reviews (book_id, reviews_id) values (1, 2);
insert into book_table_reviews (book_id, reviews_id) values (1, 3);
