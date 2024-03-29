create table authors
(
    id        bigserial primary key,
    full_name varchar(255)
);

create table books
(
    id        bigserial primary key,
    title     varchar(255),
    author_id bigint,
    foreign key (author_id) references authors (id)
);

create table reviews
(
    id          bigserial primary key,
    book_id     bigint,
    author_name varchar(255),
    text        varchar(1000),
    rating      int,
    review_date date,
    foreign key (book_id) references books (id)
);

create table books_details
(
    id                  bigserial primary key,
    book_id             bigint,
    description         varchar(1000),
    year_of_publication int,
    pages_count         int,
    price               numeric,
    foreign key (book_id) references books (id)
);

create table genres
(
    id         bigserial primary key,
    genre_name varchar(30),
    book_id    bigint,
    foreign key (book_id) references books (id)
);

insert into authors (full_name)
values ('Толкиен'),
       ('Роулинг'),
       ('Сандерсон'),
       ('Азимов');

insert into books (title,
                   author_id)
values ('Властелин колец: Братство кольца', 1),
       ('Гарри Поттер и Философский камень', 2),
       ('Рожденный туманом: Пепел и сталь', 3),
       ('Рожденный туманом: Источник вознесения', 3),
       ('Рожденный туманом: Герой веков', 3),
       ('Архив Буресвета: Путь королей', 3),
       ('Академия', 4);

insert into genres (genre_name,
                    book_id)
values ('Фантастика', 1),
       ('Фантастика', 2),
       ('Фантастика', 3),
       ('Фантастика', 4),
       ('Фантастика', 5),
       ('Фантастика', 6),
       ('Научная фантастика', 7);

insert into books_details (book_id,
                           description,
                           year_of_publication,
                           pages_count,
                           price)
values (1, 'Книга про Властелина колец', 1954, 549, 419),
       (2, 'Книга про Гарри Поттера', 1997, 432, 890),
       (3, 'Книга про Рожденного туманом: Пепел и сталь', 2006, 772, 389),
       (4, 'Книга про Рожденного туманом: Источник вознесения', 2007, 882, 408),
       (5, 'Книга про Рожденного туманом: Герой веков', 2008, 886, 408),
       (6, 'Книга про Архив Буресвета', 2010, 1383, 499),
       (7, 'Книга про Академию. Основная трилогия', 1993, 1000, 832);