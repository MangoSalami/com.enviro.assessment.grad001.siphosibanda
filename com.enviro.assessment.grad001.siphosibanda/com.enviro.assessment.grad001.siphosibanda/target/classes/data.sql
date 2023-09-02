-- Insert sample data into Investor table
INSERT INTO investor (first_name, last_name, address, contact,age)
VALUES ('John', 'Doe', '123 Main St', '555-1234',23),
       ('Jane', 'Smith', '456 Elm St', '555-5678',70);

-- Insert sample data into Product table
INSERT INTO product (investor_id, type,name, balance)
VALUES (1, 'Savings','savings1', 1000.00),
       (2, 'Retirement','retire2', 500.00);

-- Insert sample data into WithdrawalNotice table
INSERT INTO withdrawal_notice (product_id, withdrawal_amount)
VALUES (1, 200.00),
       (2, 50.00);
