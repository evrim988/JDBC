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

--Güncel hali
CREATE TABLE tblpost
(
id serial PRIMARY KEY,
user_id Integer REFERENCES tbluser(id) NOT NULL,
baslik varchar(150),
icerik text,
paylasimTarihi timestamp Default NOW(),
state int DEFAULT 1,
createAt timestamp Default NOW(),
updateAt timestamp Default NOW()
);

-- güncel
CREATE TABLE tbluser
(
id serial PRIMARY KEY ,
ad varchar(20) NOT NULL,
soyad varchar(20) NOT NULL,
username varchar(20) NOT NULL UNIQUE,
password varchar(20) NOT NULL,
state smallint DEFAULT 1,
createat timestamp Default NOW(),
updateat timestamp Default NOW()
);