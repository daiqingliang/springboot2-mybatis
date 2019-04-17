# Springboot2.1 + Mybatis 2.0.1 + PageHelper1.2.10

### Demo
<pre><code>
# 测试表建表语句
create table register_list(
	id int primary key auto_increment not null,
	register_plc_addr varchar(50),
	register_protocol_addr varchar(50),
	register_type_code varchar(10),
	device_id varchar(50)
);

#插入测试数据
insert into register_list('A1','B1','C1','D1');
insert into register_list('A2','B2','C2','D2');
insert into register_list('A3','B3','C3','D3');
insert into register_list('A4','B4','C4','D4');
insert into register_list('A5','B5','C5','D5');
insert into register_list('A6','B6','C6','D6');
insert into register_list('A7','B7','C7','D7');
insert into register_list('A8','B8','C8','D8');
insert into register_list('A9','B9','C9','D9');
insert into register_list('A10','B10','C10','D10');
insert into register_list('A11','B11','C11','D11');

</code></pre>
