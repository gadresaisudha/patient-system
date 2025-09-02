CREATE TABLE IF NOT EXISTS patient (
    id UUID PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    age INT NOT NULL,
    birth_date DATE NOT NULL,
    address VARCHAR(255) NOT NULL,
    registered_date DATE NOT NULL
    );

INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'John', 'Doe',
       'john.doe@example.com',
       'Male',
       39,
       '1985-06-15',
       '123 Main St, Springfield',
       '2024-01-10'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174000'
);

-- Jane Smith
INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Jane', 'Smith',
       'jane.smith@example.com',
       'Female',
       33,
       '1990-09-23',
       '456 Elm St, Shelbyville',
       '2023-12-01'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174001'
);

-- Alice Johnson
INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Alice', 'Johnson',
       'alice.johnson@example.com',
       'Female',
       46,
       '1978-03-12',
       '789 Oak St, Capital City',
       '2022-06-20'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174002'
);

-- Bob Brown
INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Bob', 'Brown',
       'bob.brown@example.com',
       'Male',
       41,
       '1982-11-30',
       '321 Pine St, Springfield',
       '2023-05-14'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174003'
);

-- Emily Davis
INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Emily', 'Davis',
       'emily.davis@example.com',
       'Female',
       30,
       '1995-02-05',
       '654 Maple St, Shelbyville',
       '2024-03-01'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '123e4567-e89b-12d3-a456-426614174004'
);

-- Michael Green
INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174005',
       'Michael', 'Green',
       'michael.green@example.com',
       'Male',
       36,
       '1988-07-25',
       '987 Cedar St, Springfield',
       '2024-02-15'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174005'
);

-- Sarah Taylor
INSERT INTO patient (id, first_name, last_name, email, gender, age, birth_date, address, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174006',
       'Sarah', 'Taylor',
       'sarah.taylor@example.com',
       'Female',
       32,
       '1992-04-18',
       '123 Birch St, Shelbyville',
       '2023-08-25'
    WHERE NOT EXISTS (
    SELECT 1 FROM patient WHERE id = '223e4567-e89b-12d3-a456-426614174006'
);