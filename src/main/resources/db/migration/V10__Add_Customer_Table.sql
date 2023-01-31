create table customer
(
    id        bigint not null auto_increment primary key,
    customer_name     varchar(255),
    address  varchar(50),
    city  varchar(50),
    state  varchar(50),
    zip_code  varchar(50),
    phone  varchar(50),
    email  varchar(255),
    created_date    timestamp,
    last_modified_date  timestamp
) engine = InnoDB;

alter table order_header
    add column customer_id bigint;

alter table order_header
    add constraint order_customer_pk
        foreign key (customer_id) references customer(id);

alter table order_header drop column customer_name;

insert into order_header (shipping_address, shipping_city, shipping_state, shipping_zip_code, bill_to_address, bill_to_city, bill_to_state, bill_to_zip_code, order_status, created_date, last_modified_date)
VALUES ('','','','','','','','','New', now(), now());


insert into customer (customer_name, address, city, state, zip_code, phone, email, created_date, last_modified_date)
    values('Customer 1', '123 Duval', 'Key West', 'FL', '22040', '305.292.1435', 'cheeseburger@margaritaville.com', now(), now());



update order_header set order_header.customer_id = (SELECT id from customer limit 1);

