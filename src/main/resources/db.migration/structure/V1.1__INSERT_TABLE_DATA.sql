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
-- Tabla medication con UUIDs únicos
INSERT INTO medication (med_id, medication_name, medication_quantity)
VALUES
    ('550e8400-e29b-41d4-a716-446655442010', 'Paracetamol', 100),
    ('550e8400-e29b-41d4-a716-446655443020', 'Ibuprofeno', 200);

-- Tabla refill con UUIDs únicos
INSERT INTO refill (refill_id, branch_id, refill_timestamp)
VALUES
    ('660e8400-e29b-41d4-a716-446655442012', '770e8400-e29b-41d4-a716-446655440000', '2025-02-24 10:00:00'),
    ('660e8400-e29b-41d4-a716-446655443022', '770e8400-e29b-41d4-a716-446655440001', '2025-02-24 14:30:00');

-- Tabla refill_med con UUIDs únicos
INSERT INTO refill_med (refill_id, med_id)
VALUES
    ('660e8400-e29b-41d4-a716-446655442012', '550e8400-e29b-41d4-a716-446655442010'),
    ('660e8400-e29b-41d4-a716-446655442012', '550e8400-e29b-41d4-a716-446655443020'),
    ('660e8400-e29b-41d4-a716-446655443022', '550e8400-e29b-41d4-a716-446655442010'),
    ('660e8400-e29b-41d4-a716-446655443022', '550e8400-e29b-41d4-a716-446655443020');
