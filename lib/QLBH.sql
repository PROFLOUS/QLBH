--tao CSDL QLBH
CREATE DATABASE QLBH;

use QLBH;

--Tao table DanhMucSP
CREATE TABLE DanhMucSP (
	MaLoai varchar(30) primary key,
    TenLoai varchar(255),
   
);
ALTER TABLE DanhMucSP
ALTER COLUMN TenLoai nvarchar(255);

--tao table SanPham
CREATE TABLE SanPham (
	MaSP varchar(30) primary key,
    TenSP varchar(255) not null,	
	
	SoLuong integer not null,
	DonGia float not null,
	HinhAnh varchar(255),
	Size varchar(25),
	MauSac varchar(255),

	MaLoai varchar(30) FOREIGN KEY REFERENCES DanhMucSP(MaLoai),
);
ALTER TABLE SanPham
ALTER COLUMN TenSP nvarchar(255);

ALTER TABLE SanPham
ALTER COLUMN MauSac nvarchar(255);


--tao table NhaCC
CREATE TABLE NhaCC (
	MaNCC varchar(30) primary key,
    TenNCC varchar(255) not null,	
	SDT varchar(255) not null,
	Mail varchar(25) not null,
	DiaChi varchar(255),

	
);
ALTER TABLE NhaCC
ALTER COLUMN TenNCC nvarchar(255);
ALTER TABLE NhaCC
ALTER COLUMN DiaChi nvarchar(255);


--tao table ChucVu
CREATE TABLE ChucVu (
	MaCV varchar(30) primary key,
    TenCV varchar(255) not null,	
	HSLuong  float  not null

	
);
ALTER TABLE ChucVu
ALTER COLUMN TenCV nvarchar(255);

--tao table NhanVien
CREATE TABLE NhanVien (
	MaNV varchar(30) primary key,
    TenNV varchar(255) not null,	
	SDT varchar(255),	
	NgaySinh date,
	DiaChi varchar(255),
	NgayVaoLam date,
	TinhTrang varchar(30) not null,
	MaCV varchar(30) FOREIGN KEY REFERENCES ChucVu(MaCV),
);
ALTER TABLE NhanVien
ALTER COLUMN TenNV nvarchar(255);

ALTER TABLE NhanVien
ALTER COLUMN DiaChi nvarchar(255);

--tao table CaLam
CREATE TABLE CaLam (
	MaCa varchar(30) primary key,
   NgayLam date,
   Buoi varchar(25),
	MaNV varchar(30) FOREIGN KEY REFERENCES NhanVien(MaNV),

);


ALTER TABLE CaLam
ALTER COLUMN Buoi nvarchar(255);


--tao table TaiKhoan
CREATE TABLE TaiKhoan (
	
	MatKhau varchar(25) not null,
	TenQuyen varchar(255) not null,
	TrangThau varchar(30) not null,
	MaNV varchar(30) FOREIGN KEY REFERENCES NhanVien(MaNV),

);
ALTER TABLE TaiKhoan
ALTER COLUMN TenQuyen nvarchar(255);

ALTER TABLE TaiKhoan
ALTER COLUMN TrangThau nvarchar(255);

--tao table HDNhapHang
create table HDNhapHang(
		
		MaHDNhap varchar(30) primary key,
		NgayLapHD date,
		SoLuong int not null,
		TongTien float,
		GhiChu varchar(255),
		MaNV varchar(30) FOREIGN KEY REFERENCES NhanVien(MaNV),
		MaNCC varchar(30) FOREIGN KEY REFERENCES NhaCC(MaNCC),

);
ALTER TABLE HDNhapHang
ALTER COLUMN TongTien money


ALTER TABLE HDNhapHang
ALTER COLUMN GhiChu nvarchar(255);
--tao table CT_HoaDonNhap

create table CT_HoaDonNhap(
		
		SoLuong int not null,
		DonGia float not null,
		MaHDNhap varchar(30) FOREIGN KEY REFERENCES HDNhapHang(MaHDNhap),
		MaSP varchar(30) FOREIGN KEY REFERENCES SanPham(MaSP),
		CONSTRAINT PK_CT_HDNhap PRIMARY KEY (MaSP,MaHDNhap)
);
ALTER TABLE CT_HoaDonNhap
ALTER COLUMN DonGia money
--tao table KhachHang
create table KhachHang(
	MaKH varchar(30) primary key,
	TenKH varchar(255) not null,
	SDT varchar(30)

);
ALTER TABLE KhachHang
ALTER COLUMN TenKH nvarchar(255);
--tao table HDBanHang
create table HDBanHang(
		
		MaHD varchar(30) primary key,
		NgayLapHD date,
		SoLuong int not null,
		TongTien float,
		TienKhachDua float,
		GhiChu varchar(255),
		MaNV varchar(30) FOREIGN KEY REFERENCES NhanVien(MaNV),
		MaKH varchar(30) FOREIGN KEY REFERENCES KhachHang(MaKH),

);
ALTER TABLE HDBanHang
ALTER COLUMN TongTien money


ALTER TABLE HDBanHang
ADD PhanTramGiamGia float;



ALTER TABLE HDBanHang
ALTER COLUMN GhiChu nvarchar(255);

--tao table CT_HoaDonBanHang

create table CT_HoaDonBanHang(
		
		SoLuong int not null,
		DonGia float not null,
		MaHD varchar(30) FOREIGN KEY REFERENCES HDBanHang(MaHD),
		MaSP varchar(30) FOREIGN KEY REFERENCES SanPham(MaSP),
		CONSTRAINT PK_CT_HDBanHang PRIMARY KEY (MaHD,MaSP)
);

ALTER TABLE CT_HoaDonBanHang
ALTER COLUMN DonGia money


---------------Tao Du lieu Mau-------------------------------------
--thong tin table DanhMucSP
INSERT INTO DanhMucSP(MaLoai,TenLoai)
VALUES ('DMSP001', 'Áo khoác');

INSERT INTO DanhMucSP(MaLoai,TenLoai)
VALUES ('DMSP002', 'Áo vest');


INSERT INTO DanhMucSP(MaLoai,TenLoai)
VALUES ('DMSP003', 'Áo sơ mi');
INSERT INTO DanhMucSP(MaLoai,TenLoai)
VALUES ('DMSP004', 'Áo thun');
INSERT INTO DanhMucSP(MaLoai,TenLoai)
VALUES ('DMSP005', 'Quần Jeans');
INSERT INTO DanhMucSP(MaLoai,TenLoai)
VALUES ('DMSP006', 'Áo Polo');


select * from DanhMucSP


------Thông tin table SanPham
INSERT INTO SanPham
VALUES ('SP001', 'Áo khoác Chino thời thượng', 99, 480000, '', 39,'Trắng', 'DMSP001' );

INSERT INTO SanPham
VALUES ('SP002', 'Áo khoác đầm dáng xòe nút bọc', 99, 280000, '', 40,'Hồng', 'DMSP001' );

INSERT INTO SanPham
VALUES ('SP003', N'Áo khoác đầm dáng xòe nút bọc', 19, 280000, '', 39, N'Đen', 'DMSP001' );


select * from SanPham


------Thông tin table SanPham
INSERT INTO NhaCC
VALUES ('NCC001', N'Nhà máy Á Châu', '0397578976', 'achauzyz@gmail.com', N'127 Láng Hạ Chùa Láng HN' );

INSERT INTO NhaCC
VALUES ('NCC002', N'Nhà may Gia Nghĩa', '0397578761', 'gianghiazyz@gmail.com', N'127 Man Thiện Thủ Đức' );

INSERT INTO NhaCC
VALUES ('NCC003', N'Công ty Visico', '0398756463', 'visicoabc@gmail.com', N'27 D1 Thủ Đức' );


select * from NhaCC

------Thông tin table ChucVu
INSERT INTO ChucVu
VALUES ('CV001',N'Nhân viên Bán Hàng', 1.5  );

INSERT INTO ChucVu
VALUES ('CV002',N'Nhân viên Thu Ngân', 1.8  );

select * from ChucVu



------Thông tin table NhanVien
INSERT INTO NhanVien
VALUES ('NV001',N'Nguyễn Hoàng Anh', '0397545987', '', N'127 Lê văn việt thủ đức', '2021-10-01', 'Đang làm','CV002'  );

select * from NhanVien


------Thông tin table CaLam
INSERT INTO CaLam
VALUES ('CL001','', N'Sáng', 'NV001'  );

select * from CaLam


------Thông tin table TaiKhoan
INSERT INTO TaiKhoan
VALUES ('12345678','nhanvien', N'hoạt động', 'NV001'  );

select * from TaiKhoan



------Thông tin table TaiKhoan
INSERT INTO KhachHang
VALUES ('KH001', N'Nguyễn tiến đạt', '0998765456'  );

INSERT INTO KhachHang
VALUES ('KH002', N'Tấn Đăng', '0998765555'  );

select * from KhachHang



------Thông tin table HoaDonBanHang
INSERT INTO HDBanHang
VALUES ('HDBH001','2021-10-23', 2, 760000, 760000, '', 'NV001', 'KH001');


INSERT INTO HDBanHang
VALUES ('HDBH002','2021-10-20', 1, 280000, 300000, '', 'NV001', 'KH001');

INSERT INTO HDBanHang
VALUES ('HDBH003','2021-10-21', 1, 280000, 300000, '', 'NV001', 'KH002', 0);

INSERT INTO HDBanHang
VALUES ('HDBH004','2021-10-24', 2, 540000, 600000, '', 'NV001', 'KH002', 0);
select * from HDBanHang



------Thông tin table CT_HoaDonBanHang
INSERT INTO CT_HoaDonBanHang
VALUES (1, 280000, 'HDBH002', 'SP002');

INSERT INTO CT_HoaDonBanHang
VALUES (1, 280000, 'HDBH001', 'SP002');

INSERT INTO CT_HoaDonBanHang
VALUES (1, 280000, 'HDBH001', 'SP003');


INSERT INTO CT_HoaDonBanHang
VALUES (1, 280000, 'HDBH003', 'SP002');


INSERT INTO CT_HoaDonBanHang
VALUES (1, 280000, 'HDBH004', 'SP002');

INSERT INTO CT_HoaDonBanHang
VALUES (1, 280000, 'HDBH004', 'SP003');




select * from CT_HoaDonBanHang




------Thông tin table HoaDonNhapHang
INSERT INTO HDNhapHang
VALUES ('HDNH001','2021-10-10', 117, 63000000, '', 'NV001', 'NCC001');

select * from HDNhapHang


------Thông tin table CT_HoaDonNhap
INSERT INTO CT_HoaDonNhap
VALUES (99, 400000, 'HDNH001', 'SP001');

INSERT INTO CT_HoaDonNhap
VALUES (99, 200000, 'HDNH001', 'SP002');

INSERT INTO CT_HoaDonNhap
VALUES (19, 200000, 'HDNH001', 'SP003');

select * from CT_HoaDonNhap

