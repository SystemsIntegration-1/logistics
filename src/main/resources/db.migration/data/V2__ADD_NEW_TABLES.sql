CREATE TYPE order_status AS ENUM (
    'PENDING',
    'PROCESSING',
    'FULFILLED',
    'DELIVERED'
);

CREATE TABLE refill_order (
    order_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    status order_status NOT NULL,
    branch_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (branch_id) REFERENCES branch(branch_id) ON DELETE CASCADE
);

CREATE TABLE order_item (
    item_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    product_description TEXT,
    quantity INT NOT NULL,
    notes TEXT,
    FOREIGN KEY (order_id) REFERENCES refill_order(order_id) ON DELETE CASCADE
);
