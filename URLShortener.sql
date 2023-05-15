--USE URLShortener

--CREATE table url (
--id int identity(1,1) primary key, original_url varchar(1000), short_url varchar(50), short_url_length int);

--DROP table url;

--CREATE PROCEDURE create_url (
--	@id int, 
--	@original_url varchar(1000), 
--	@short_url varchar(50), 
--	@short_url_length int
--)
--AS
--BEGIN
--	INSERT INTO url (original_url, short_url, short_url_length)
--	OUTPUT inserted.id, inserted.original_url, inserted.short_url, inserted.short_url_length 
--	VALUES (@original_url, @short_url, @short_url_length);
--END

--DROP PROCEDURE create_url

 --CREATE PROCEDURE get_url_using_short_url @short_url varchar(50)
 --AS
 --BEGIN
 --SELECT * from url
 --WHERE short_url = @short_url
 --END

 --DROP PROCEDURE get_url_using_short_url
