INSERT INTO address (address_id, city_name, country_name, latitude, longitude)
VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 'New York', 'USA', 40.712776, -74.005974),
    ('550e8400-e29b-41d4-a716-446655440001', 'Los Angeles', 'USA', 34.052235, -118.243683);

INSERT INTO contact (contact_id, name, email, phone)
VALUES
    ('660e8400-e29b-41d4-a716-446655440000', 'John Doe', 'john.doe@example.com', '+1234567890'),
    ('660e8400-e29b-41d4-a716-446655440001', 'Jane Smith', 'jane.smith@example.com', '+1987654321');

INSERT INTO branch (branch_id, branch_name, address_id, contact_id)
VALUES
    ('770e8400-e29b-41d4-a716-446655440000', 'NY Main Branch', '550e8400-e29b-41d4-a716-446655440000', '660e8400-e29b-41d4-a716-446655440000'),
    ('770e8400-e29b-41d4-a716-446655440001', 'LA Branch', '550e8400-e29b-41d4-a716-446655440001', '660e8400-e29b-41d4-a716-446655440001');
