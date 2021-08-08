-- select Email from (
--     select Email, count(Email) as num
--     from Person
--     group by Email
-- ) as temptable
-- where num > 1;
select Email
from Person
group by Email
having count(Email) > 1;