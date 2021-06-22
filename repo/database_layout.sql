# ===================================================================== #
# Customer Tables #
# ===================================================================== #

CREATE TABLE `Customer` (
	customer_id BINARY(16),
    identifier INT(9),
    PRIMARY KEY (`customer_id`, `identifier`)
);

CREATE TABLE `Customer_Name` (
	customer_id BINARY(16),
    name VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (`customer_id`), 
    FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`)
);

CREATE TABLE `Customer_Username` (
	customer_id BINARY(16),
    username VARCHAR(255) UNIQUE NOT NULL,
    
    PRIMARY KEY (`customer_id`), 
    FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`)
);

CREATE TABLE `Customer_Password` (
	customer_id BINARY(16),
    password VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (`customer_id`), 
    FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`)
);

# ===================================================================== #
# Account Tables #
# ===================================================================== #

CREATE TABLE `Account` (
	account_id BINARY(16),
    PRIMARY KEY (`account_id`)
);

CREATE TABLE `Account_Type` (
	account_id BINARY(16),
    type ENUM('checking', 'saving', 'credit') DEFAULT 'checking',
    
    PRIMARY KEY (`account_id`),
    FOREIGN KEY (`account_id`) REFERENCES `Account`(`account_id`)
);

CREATE TABLE `Account_Balance` (
	account_id BINARY(16),
    balance DECIMAL(8,2) DEFAULT '0.0',
    
    PRIMARY KEY (`account_id`), 
    FOREIGN KEY (`account_id`) REFERENCES `Account`(`account_id`)
);

# ===================================================================== #
# Contact Tables #
# ===================================================================== #

CREATE TABLE `Contact` (
	contact_id BINARY(16),
    PRIMARY KEY(`contact_id`)
);

CREATE TABLE `Contact_Type` (
	contact_id BINARY(16),
    type ENUM('email', 'phone', 'address', 'other') DEFAULT 'other',
    
    PRIMARY KEY (`contact_id`), 
    FOREIGN KEY (`contact_id`) REFERENCES `Contact`(`contact_id`)
);

CREATE TABLE `Contact_Details` (
	contact_id BINARY(16),
    detail VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (`contact_id`),
    FOREIGN KEY (`contact_id`) REFERENCES `Contact`(`contact_id`)
);

# Log Tables #

CREATE TABLE `Log` (
	log_id BINARY(16),
    PRIMARY KEY (`log_id`)
);

CREATE TABLE `Log_Timestamp` (
	log_id BINARY(16),
    `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (`log_id`),
    FOREIGN KEY (`log_id`) REFERENCES `Log`(`log_id`)
);

CREATE TABLE `Log_Statement` (
	log_id BINARY(16),
    statement VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (`log_id`),
    FOREIGN KEY (`log_id`) REFERENCES `Log`(`log_id`)
);

# ===================================================================== #
# Relational Tables #
# ===================================================================== #

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #
# CustomerAccount Tables #
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #

CREATE TABLE `CustomerAccount` (
	customeraccount_id BINARY(16),
	customer_id BINARY(16),
	account_id BINARY(16),
    
    PRIMARY KEY (`customeraccount_id`, `customer_id`, `account_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`),
    FOREIGN KEY (`account_id`) REFERENCES `Account`(`account_id`)
);

CREATE TABLE `CustomerAccount_Nickname` (
	customeraccount_id BINARY(16),
	nickname VARCHAR(255) NOT NULL,
    
    PRIMARY KEY(`customeraccount_id`),
    FOREIGN KEY(`customeraccount_id`) REFERENCES `CustomerAccount`(`customeraccount_id`)
);

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #
# Card Tables #
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #

CREATE TABLE `Card` (
	card_id VARCHAR(16),
    customeraccount_id BINARY(16),
    
    PRIMARY KEY (`card_id`),
    FOREIGN KEY(`customeraccount_id`) REFERENCES `CustomerAccount`(`customeraccount_id`)
);

CREATE TABLE `Card_Pin` (
	card_id VARCHAR(16),
    pin VARCHAR(4) NOT NULL,
    
    PRIMARY KEY (`card_id`),
    FOREIGN KEY (`card_id`) REFERENCES `Card`(`card_id`)
);

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #
# Log Tables #
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #

CREATE TABLE `CustomerLog` (
	customerlog_id BINARY(16),
	customer_id BINARY(16),
    log_id BINARY(16),
    
    PRIMARY KEY (`customerlog_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`),
    FOREIGN KEY (`log_id`) REFERENCES `Log`(`log_id`)
);

CREATE TABLE `CustomerAccountLog` (
	customeraccountlog_id BINARY(16),
	customeraccount_id BINARY(16),
    log_id BINARY(16),
    
    PRIMARY KEY (`customeraccountlog_id`),
    FOREIGN KEY (`customeraccount_id`) REFERENCES `CustomerAccount`(`customeraccount_id`),
    FOREIGN KEY (`log_id`) REFERENCES `Log`(`log_id`)
);

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #
# Other Tables #
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - #

CREATE TABLE `CustomerContact` (
	customer_id BINARY(16),
    contact_id VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (`customer_id`), 
    FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`)
);