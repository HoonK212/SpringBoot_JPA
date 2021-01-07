create table user (
    id bigint auto_increment,
    name varchar(255) not null,
    pw varchar(255) not null,
    primary key (id)
);

create table product (
     id bigint auto_increment,
     name varchar(255) not null,
     price bigint not null,
     primary key (id)
);

create table `order` (
    userId bigint not null,
    productId bigint not null,
    amount bigint not null,
    date date not null,
    foreign key (userId) references user (id),
    foreign key (productId) references product (id)
);
