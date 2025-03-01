INSERT INTO refill_order (order_id, status, branch_id, created_at, updated_at)
VALUES
    ('1e6e9d88-6e12-4e0f-bc66-55b5c7c8a1a1', 'PENDING', '770e8400-e29b-41d4-a716-446655440000', NOW(), NULL),
    ('1e6e9d88-6e12-4e0f-bc66-55b5c7c8a1a2', 'PROCESSING', '770e8400-e29b-41d4-a716-446655440001', NOW(), NULL);

INSERT INTO order_item (item_id, order_id, product_id, product_name, product_description, quantity, notes)
VALUES
    ('b2a3a80c-10e7-4068-9de3-78b6ea378c46', '1e6e9d88-6e12-4e0f-bc66-55b5c7c8a1a1', '1e6e9d88-6e12-4e0f-bc66-55b5c7c8a1a9', 'Product A', 'Description of Product A', 10.00, 'First order item'),
    ('aa8a7963-eec5-4116-a465-cc3ba761785a', '1e6e9d88-6e12-4e0f-bc66-55b5c7c8a1a2', '1e6e9d88-6e12-4e0f-bc66-55b5c7c8a1aa', 'Product B', 'Description of Product B', 5.00, 'Second order item');
