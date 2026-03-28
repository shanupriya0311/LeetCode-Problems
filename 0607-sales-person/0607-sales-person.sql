# Write your MySQL query statement below
select name from SalesPerson where sales_id Not in(select sales_id from Orders where com_id = (select com_id from Company where name='RED'));