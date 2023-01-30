ALTER TABLE ORDER_HEADER
    add column shipping_address varchar(50),
    add column shipping_city varchar(50),
    add column shipping_state varchar(50),
    add column shipping_zip_code varchar(50),
    add column bill_to_address varchar(50),
    add column bill_to_city varchar(50),
    add column bill_to_state varchar(50),
    add column bill_to_zip_code varchar(50);

