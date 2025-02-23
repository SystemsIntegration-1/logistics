CREATE TABLE address (
    address_id UUID PRIMARY KEY,
    city_name VARCHAR(25),
    country_name VARCHAR(30),
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8)
);

CREATE TABLE contact (
    contact_id UUID PRIMARY KEY,
    name VARCHAR(30),
    email VARCHAR(25),
    phone VARCHAR(20)
);

CREATE TABLE branch (
    branch_id UUID PRIMARY KEY,
    branch_name VARCHAR(30),
    address_id UUID UNIQUE,
    contact_id UUID UNIQUE,
    FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE CASCADE,
    FOREIGN KEY (contact_id) REFERENCES contact(contact_id) ON DELETE CASCADE
);
