CREATE TABLE cg_connections (id INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
        name varchar(20) not null unique,
        host varchar(100) not null,
        port int not null);
        
CREATE TABLE cg_caches (id INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
        name varchar(20) not null unique,
        description varchar(100) ,
        dbname varchar(10) not null,
        con_id int not null, 
        CONSTRAINT con_id_ref FOREIGN KEY (con_id) REFERENCES cg_connections(id));        