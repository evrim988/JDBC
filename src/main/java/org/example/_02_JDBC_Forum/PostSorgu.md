CREATE TABLE tblpost 
(
id serial PRIMARY KEY,
user_id Integer REFERENCES tbluser(id) NOT NULL,
baslik varchar(150),
icerik text,
paylasimTarihi timestamp Default NOW(),
state int DEFAULT 1,
createAt bigInt Default EXTRACT(epoch FROM Now()),
updateAt bigInt Default EXTRACT(epoch FROM Now())
);