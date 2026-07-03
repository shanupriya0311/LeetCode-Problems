# Write your MySQL query statement below
select Distinct c.customer_id from Customer c group by c.customer_id having count(Distinct c.product_key)=(Select count(*) from Product);