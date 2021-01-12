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
    id bigint auto_increment,
    amount bigint not null,
    stat int not null default 0 comment '0:주문접수 1:배송완료',
    date datetime not null default current_timestamp,
    userId bigint not null,
    productId bigint not null,
    primary key (id),
    foreign key (userId) references user (id),
    foreign key (productId) references product (id)
);
