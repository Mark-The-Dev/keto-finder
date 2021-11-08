CREATE TABLE restaurant_list
(
    id serial PRIMARY KEY,
    restaurant_name varchar(60) NOT NULL
);

CREATE TABLE restaurant_item
(
    id serial PRIMARY KEY,
    restaurant_id serial REFERENCES restaurant_list (id),
    item_name varchar(60) NOT NULL,
    item_description text NOT NULL,
    calories float NOT NULL,
    protein_value float NOT NULL,
    fat_value float NOT NULL,
    carb_value float NOT NULL,
    net_carb_value float NOT NULL
);

INSERT INTO restaurant_list (restaurant_name)
VALUES
    ('Chipotle'),
    ('Red Robin');

INSERT INTO restaurant_item (restaurant_id, item_name, item_description, calories, protein_value, fat_value, carb_value, net_carb_value)
VALUES
    (1,'Custom Chicken Bowl', 'A custom chicken bowl containing: chicken, lettauce, tomatillo red salsa, cheese, and guacamole.', 550, 41, 36.5, 15, 6),
    (1, 'Keto Salad Bowl (Carnitas)', 'A keto salad bowl with: carnitas, lettauce, cheese, guacamole, and tomatillo red salsa.', 585, 31, 42, 14, 6),
    (2, 'California Chicken Sandwich (No Bun)', 'The California chicken sandwich comes with a grilled chicken breast, provolone cheese, housemade guacamole, bacon, pickles, lettuce, mayo and tomatoes.', 490, 35, 33.5, 7, 6),
    (2, 'Royal Red Robin Burger (No Bun)', 'The royal Red Robin burger comes with a beef patty, bacon, an egg, American cheese, lettuce, tomatoes and mayo.', 890, 47, 74.5, 8, 7);