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

CREATE TABLE medication (
    med_id UUID PRIMARY KEY,
    medication_name VARCHAR(50) NOT NULL,
    medication_quantity INT NOT NULL
);

CREATE TABLE refill (
    refill_id UUID PRIMARY KEY,
    branch_id UUID NOT NULL,
    refill_timestamp TIMESTAMP NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id) ON DELETE CASCADE
);

CREATE TABLE refill_med (
    refill_id UUID NOT NULL,
    med_id UUID NOT NULL,
    PRIMARY KEY (refill_id, med_id),
    FOREIGN KEY (refill_id) REFERENCES refill(refill_id) ON DELETE CASCADE,
    FOREIGN KEY (med_id) REFERENCES medication(med_id) ON DELETE CASCADE
);