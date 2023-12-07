create database computer;
-- drop database computer;
use computer;
create table tinh_trang(
	ma_tinh_trang int primary key auto_increment,
    ten_tinh_trang varchar(50)
);
create table tinh_trang_chi_tiet(
id_tinh_trang_chi_tiet int key auto_increment,
mo_ta_tinh_trang varchar(45),
ma_tinh_trang int,
foreign key (ma_tinh_trang) references tinh_trang(ma_tinh_trang)
);
create table may_tinh(
	ma_may_tinh int primary key auto_increment,
    ten_may_tinh varchar(50) not null,
    ram varchar(50),
    chip varchar(50),
    hang varchar(50),
    ma_tinh_trang int ,
    is_delete bit default 0,
    `status` bit default 0,
	foreign key (ma_tinh_trang) references tinh_trang(ma_tinh_trang)
);
create table loai_dich_vu(
	id_loai_dich_vu int primary key auto_increment,
    ten_loai_dich_vu varchar(50)
);
create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key auto_increment,
    ten_dich_vu_di_kem varchar(50),
    gia_dich_vu_di_kem double,
    id_loai_dich_vu int,
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);
create table tai_khoan(
id_tai_khoan int key auto_increment,
tai_khoan varchar(45) unique,
mat_khau varchar(45),
loai_tai_khoan varchar(45)
);
create table nhan_vien(
id_nhan_vien int key auto_increment,
ten_nhan_vien varchar(45),
so_dien_thoai varchar(45) unique,
id_tai_khoan int,
foreign key (id_tai_khoan) references tai_khoan(id_tai_khoan)
);
create table bang_su_dung(
	id_bang_su_dung int primary key auto_increment,
    thoi_gian_bat_dau datetime,
    thoi_gian_ket_thuc datetime,
    ma_may_tinh int,
    id_nhan_vien int,
    foreign key (id_nhan_vien)references nhan_vien(id_nhan_vien),
    foreign key (ma_may_tinh) references may_tinh(ma_may_tinh)
);
create table su_dung_chi_tiet(
	id_dich_vu_chi_tiet int primary key auto_increment,
    id_dich_vu_di_kem int,
    id_bang_su_dung int,
    so_luong int,
    foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),
    foreign key (id_bang_su_dung) references bang_su_dung(id_bang_su_dung)
);
-- Thêm dữ liệu vào bảng tinh_trang
INSERT INTO tinh_trang (ten_tinh_trang) VALUES
    ('Tình trạng 1'),
    ('Tình trạng 2'),
    ('Tình trạng 3');
-- Thêm dữ liệu vào bảng tinh_trang_chi_tiet
INSERT INTO tinh_trang_chi_tiet (mo_ta_tinh_trang, ma_tinh_trang) VALUES
    ('Mô tả 1', 1),
    ('Mô tả 2', 2),
    ('Mô tả 3', 3);
-- Thêm dữ liệu vào bảng may_tinh
INSERT INTO may_tinh (ten_may_tinh, ram, chip, hang, ma_tinh_trang) VALUES
    ('Máy tính 1', '8GB', 'Intel i5', 'HP', 1),
    ('Máy tính 2', '16GB', 'AMD Ryzen 7', 'Dell', 2),
    ('Máy tính 3', '4GB', 'Intel i3', 'Lenovo', 3),
    ('Máy tính 4', '32GB', 'Intel i5', 'Asus', 1),
    ('Máy tính 5', '16GB', 'Intel i7', 'HP', 1);
-- Thêm dữ liệu vào bảng loai_dich_vu
INSERT INTO loai_dich_vu (ten_loai_dich_vu) VALUES
    ('Dịch vụ 1'),
    ('Dịch vụ 2'),
    ('Dịch vụ 3');
-- Thêm dữ liệu vào bảng dich_vu_di_kem
INSERT INTO dich_vu_di_kem (ten_dich_vu_di_kem, gia_dich_vu_di_kem, id_loai_dich_vu) VALUES
    ('Dịch vụ đi kèm 1', 50.0, 1),
    ('Dịch vụ đi kèm 2', 75.0, 2),
    ('Dịch vụ đi kèm 3', 100.0, 3);
-- Thêm dữ liệu vào bảng tai_khoan
INSERT INTO tai_khoan (tai_khoan, mat_khau, loai_tai_khoan) VALUES
    ('user1', 'password1', 'user'),
    ('admin1', 'adminpass1', 'admin'),
    ('user2', 'password2', 'user');
-- Thêm dữ liệu vào bảng nhan_vien
INSERT INTO nhan_vien (ten_nhan_vien, so_dien_thoai, id_tai_khoan) VALUES
    ('Nguyễn Văn A', '123456789', 1),
    ('Trần Thị B', '987654321', 2),
    ('Lê Văn C', '555555555', 3);
-- Thêm dữ liệu vào bảng bang_su_dung
INSERT INTO bang_su_dung (thoi_gian_bat_dau, thoi_gian_ket_thuc, ma_may_tinh, id_nhan_vien) VALUES
    ('2023-01-01 08:00:00', '2023-01-01 17:00:00', 1, 1),
    ('2023-02-01 09:00:00', '2023-02-01 18:00:00', 2, 2),
    ('2023-03-01 10:00:00', '2023-03-01 19:00:00', 3, 3);
-- Thêm dữ liệu vào bảng su_dung_chi_tiet
INSERT INTO su_dung_chi_tiet (id_dich_vu_di_kem, id_bang_su_dung, so_luong) VALUES
    (1, 1, 2),
    (2, 2, 1),
    (3, 3, 3);