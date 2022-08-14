INSERT INTO orders(seq,total_price,waiter) VALUES(0,50,'Johnny');
INSERT INTO orders(seq,total_price,waiter) VALUES(1,60,'Cherry');
INSERT INTO orders(seq,total_price,waiter) VALUES(2,80,'Wilson');
INSERT INTO meals(id, name, price, description) VALUES(0,'fries', 20, 'real good');
INSERT INTO meals(id, name, price, description) VALUES(1,'burger', 30, 'real bad');
INSERT INTO meals(id, name, price, description) VALUES(2,'coke', 20, 'real stinky');
INSERT INTO meals(id, name, price, description) VALUES(3,'chips', 40, 'real awful');
INSERT INTO meals(id, name, price, description) VALUES(4,'cookie', 50, 'real nasty');
INSERT INTO meals(id, name, price, description) VALUES(5,'sandwich', 30, 'real poo_poo');
INSERT INTO order_meal(order_seq, meal_id) VALUES(0, 0);
INSERT INTO order_meal(order_seq, meal_id) VALUES(0, 1);
INSERT INTO order_meal(order_seq, meal_id) VALUES(1, 2);
INSERT INTO order_meal(order_seq, meal_id) VALUES(1, 3);
INSERT INTO order_meal(order_seq, meal_id) VALUES(2, 4);
INSERT INTO order_meal(order_seq, meal_id) VALUES(2, 5);


