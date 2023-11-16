SELECT * from orders 


SELECT * from products WHERE product_id = 1

SELECT * from list_images 

-- categoriess
SET IDENTITY_INSERT categories ON;
INSERT INTO categories (idCate, name)
VALUES (1, 'H&M')
INSERT INTO categories (idCate, name)
VALUES (2, 'Zara')
INSERT INTO categories (idCate, name)
VALUES (3, 'Uniqlo')
INSERT INTO categories (idCate, name)
VALUES (4, 'Gap')
INSERT INTO categories (idCate, name)
VALUES (5, 'Madwell')
SET IDENTITY_INSERT categories OFF;
-- list_images

INSERT INTO list_images (product_id, imgpath)
VALUES (1, 'img1.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (2, 'img2.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (3, 'img3.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (4, 'img1.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (5, 'img2.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (6, 'img3.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (7, 'img1.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (8, 'img2.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (9, 'img3.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (10, 'img1.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (11, 'img2.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (12, 'img3.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (13, 'img3.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (14, 'img3.png');
INSERT INTO list_images (product_id, imgpath)
VALUES (15, 'img3.png');

-- order_items

INSERT INTO order_items (quantity, product_id, order_id)
VALUES (2, 1, 1);
INSERT INTO order_items (quantity, product_id, order_id)
VALUES (1, 1, 2);
INSERT INTO order_items (quantity, product_id, order_id)
VALUES (1, 1, 3);

-- orders
SET IDENTITY_INSERT orders ON;
INSERT INTO orders (order_id, order_date, user_id)
VALUES (1, 2023-08-11, 1);
INSERT INTO orders (order_id, order_date, user_id)
VALUES (2, 2023-03-11, 2);
INSERT INTO orders (order_id, order_date, user_id)
VALUES (3, 2023-05-11, 1);
SET IDENTITY_INSERT orders OFF;
-- products

INSERT INTO products 
VALUES (1, 'A classis black dress with a fitted silhouette', 'Black Fitted Dress', 59000, 'XXL',10,1);
INSERT INTO products 
VALUES (0, 'A pair of distressed ripped jeans with a high-waisted fit', 'Distressed Ripped Jeans', 42429, 'XXL', 12,2);
INSERT INTO products 
VALUES (1, 'A cozy cardigan with a cable knit pattern', 'Cable Knit Cardigan', 59999, 'XXL', 31,3);
INSERT INTO products 
VALUES (1, 'A classis black dress with a fitted silhouette', 'Black Fitted Dress', 59000, 'XXL',10,1);
INSERT INTO products 
VALUES (0, 'A pair of distressed ripped jeans with a high-waisted fit', 'Distressed Ripped Jeans', 42429, 'XXL', 12,2);
INSERT INTO products 
VALUES (1, 'A cozy cardigan with a cable knit pattern', 'Cable Knit Cardigan', 59999, 'XXL', 31,3);
INSERT INTO products 
VALUES (1, 'A classis black dress with a fitted silhouette', 'Black Fitted Dress', 59000, 'XXL',10,1);
INSERT INTO products 
VALUES (0, 'A pair of distressed ripped jeans with a high-waisted fit', 'Distressed Ripped Jeans', 42429, 'XXL', 12,2);
INSERT INTO products 
VALUES (1, 'A cozy cardigan with a cable knit pattern', 'Cable Knit Cardigan', 59999, 'XXL', 31,3);
INSERT INTO products 
VALUES (1, 'A classis black dress with a fitted silhouette', 'Black Fitted Dress', 59000, 'XXL',10,1);
INSERT INTO products 
VALUES (0, 'A pair of distressed ripped jeans with a high-waisted fit', 'Distressed Ripped Jeans', 42429, 'XXL', 12,2);
INSERT INTO products 
VALUES (1, 'A cozy cardigan with a cable knit pattern', 'Cable Knit Cardigan', 59999, 'XXL', 31,3);
INSERT INTO products 
VALUES (1, 'A classis black dress with a fitted silhouette', 'Black Fitted Dress', 59000, 'XXL',10,1);
INSERT INTO products 
VALUES (0, 'A pair of distressed ripped jeans with a high-waisted fit', 'Distressed Ripped Jeans', 42429, 'XXL', 12,2);
INSERT INTO products 
VALUES (1, 'A cozy cardigan with a cable knit pattern', 'Cable Knit Cardigan', 59999, 'XXL', 31,3);

-- users
SET IDENTITY_INSERT users ON;
INSERT INTO users (id, password, role, username)
VALUES (1, 123, 'user', 'sang');
INSERT INTO users (id, password, role, username)
VALUES (2, 123, 'user', 'trung');
INSERT INTO users (id, password, role, username)
VALUES (3, 123, 'admin', 'toan');
INSERT INTO users (id, password, role, username)
VALUES (4, 123, 'user', 'loc');
SET IDENTITY_INSERT users OFF;
