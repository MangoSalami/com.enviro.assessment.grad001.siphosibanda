-- Investor table
CREATE TABLE IF NOT EXISTS investor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    address VARCHAR(255),
    contact VARCHAR(20),
    age INT
);

-- Product table
CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    investor_id INT,
    type VARCHAR(50),
    name VARCHAR(255),
    balance DECIMAL(10, 2),
    FOREIGN KEY (investor_id) REFERENCES investor(id)
);

-- WithdrawalNotice table
CREATE TABLE IF NOT EXISTS withdrawal_notice (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    withdrawal_amount DECIMAL(10, 2),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
