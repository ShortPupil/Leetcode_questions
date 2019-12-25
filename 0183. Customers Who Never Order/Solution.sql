# 498ms
select c.Name as Customers from Customers c left join Orders o on o.CustomerId = c.Id where o.Id is null;

# 532ms
select c.Name as Customers from Customers c where not exists (select 1 from Orders o where o.CustomerId = c.Id);

# 455ms
select c.Name as Customers from Customers c where c.Id not in (select distinct o.CustomerId from Orders o);