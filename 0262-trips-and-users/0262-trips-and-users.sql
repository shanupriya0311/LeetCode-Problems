# Write your MySQL query statement below
select t.request_at As Day,Round(count(case
                                when t.status in('cancelled_by_driver','cancelled_by_client') 
                                then 1  
                                End)/count(*),2) As "Cancellation Rate" from Trips t join Users u on t.client_id=u.users_id  and u.banned="No"
join Users d on t.driver_id=d.users_id and  d.banned="No" where request_at between'2013-10-01' and '2013-10-03'  group by t.request_at order by(request_at) asc;