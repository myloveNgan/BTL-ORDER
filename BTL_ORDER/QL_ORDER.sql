create database QLORDER
use QLORDER

create table login(
       useName varchar(20) constraint PK_login primary key(useName),
	   passWd varchar(20) default'123456',
	   hoVaTen nvarchar(20) null,
)
select * from login
insert into login values('Admin','Toiladung123',N'dũng')
update login
set hoVaTen = N'duy' ,passWd = 'Toiladung123' , useName = 'star'
where useName = 'star_love' 
create table dinnerTable(
     numberTable int check(numberTable > 0 and numberTable < 20) constraint PK_DT primary key(numberTable),
	 note nvarchar(30) null,
	 statusTable nvarchar(20) check(statusTable = N'Còn trống' or statusTable = N'Đã có' )
)

	
delete from dinnerTable where numberTable = 3 ;

create table drink(
      nameDrink nvarchar(20) constraint PK_Drink primary key(nameDrink),
	  moneyDrink float , 
	  saleDate date null ,
	  sale float null ,
)
select * from drink
delete drink where nameDrink = N'1'