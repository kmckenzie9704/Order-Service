create table category(
    id bigint not null auto_increment primary key,
    description varchar(50),
    created_date timestamp,
    last_modified_date timestamp
) engine = InnoDB;

create table product_category(
    product_id bigint not null,
    category_id bigint not null,
    primary key (product_id, category_id),
    constraint pc_product_id_fk FOREIGN KEY (product_id) references product(id),
    constraint pc_category_id_fk foreign key (category_id) references category(id)
) engine = InnoDB;

insert into product (description, product_status, created_date, last_modified_date)
values ('Bicycle 1', 'NEW', now(), now());

insert into product (description, product_status, created_date, last_modified_date)
values ('Bicycle 2', 'NEW', now(), now());

insert into product (description, product_status, created_date, last_modified_date)
values ('Bicycle 3', 'NEW', now(), now());

insert into product (description, product_status, created_date, last_modified_date)
values ('Bicycle 4', 'NEW', now(), now());

insert into category(description, created_date, last_modified_date)
values('Category 1', now(), now());

insert into category(description, created_date, last_modified_date)
values('Category 2', now(), now());

insert into category(description, created_date, last_modified_date)
values('Category 3', now(), now());

insert into product_category(product_id, category_id)
    SELECT p.id, c.id FROM product p, category c
        where p.description = 'Bicycle 1' and c.description = 'Category 1';

insert into product_category(product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'Bicycle 2' and c.description = 'Category 1';

insert into product_category(product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'Bicycle 1' and c.description = 'Category 3';

insert into product_category(product_id, category_id)
SELECT p.id, c.id FROM product p, category c
where p.description = 'Bicycle 4' and c.description = 'Category 3'

