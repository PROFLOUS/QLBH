USE [master]
GO
/****** Object:  Database [QLBHDAD]    Script Date: 12/6/2021 11:12:06 AM ******/
CREATE DATABASE [QLBHDAD]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLBHDAD', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLBHDAD.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLBHDAD_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLBHDAD_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLBHDAD] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLBHDAD].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLBHDAD] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLBHDAD] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLBHDAD] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLBHDAD] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLBHDAD] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLBHDAD] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLBHDAD] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLBHDAD] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLBHDAD] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLBHDAD] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLBHDAD] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLBHDAD] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLBHDAD] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLBHDAD] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLBHDAD] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLBHDAD] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLBHDAD] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLBHDAD] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLBHDAD] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLBHDAD] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLBHDAD] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLBHDAD] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLBHDAD] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLBHDAD] SET  MULTI_USER 
GO
ALTER DATABASE [QLBHDAD] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLBHDAD] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLBHDAD] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLBHDAD] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLBHDAD] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLBHDAD] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLBHDAD] SET QUERY_STORE = OFF
GO
USE [QLBHDAD]
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDCL]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDCL]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaCa]) FROM [dbo].[CaLam]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaCa], 3)) FROM [dbo].[CaLam]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'CA00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'CA0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDCV]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDCV]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaCV]) FROM [dbo].[ChucVu]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaCV], 3)) FROM [dbo].[ChucVu]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'CV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'CV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDDM]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDDM]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaLoai]) FROM [dbo].[DanhMucSP]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaLoai], 3)) FROM [dbo].[DanhMucSP]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'DM00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'DM0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDHDBH]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDHDBH]()
RETURNS VARCHAR(9)
AS
BEGIN
	DECLARE @ID VARCHAR(9)
	IF (SELECT COUNT([MaHD]) FROM [dbo].[HDBanHang]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaHD], 3)) FROM [dbo].[HDBanHang]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HDBH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HDBH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDHDNH]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDHDNH]()
RETURNS VARCHAR(9)
AS
BEGIN
	DECLARE @ID VARCHAR(9)
	IF (SELECT COUNT([MaHDNhap]) FROM[dbo].[HDNhapHang] ) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaHDNhap], 3)) FROM [dbo].[HDNhapHang]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HDNH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HDNH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDKH]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDKH]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaKH]) FROM [dbo].[KhachHang]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaKH], 3)) FROM [dbo].[KhachHang]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'KH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'KH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDNCC]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDNCC]()
RETURNS VARCHAR(6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT([MaNCC]) FROM [dbo].[NhaCC]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaNCC], 3)) FROM [dbo].[NhaCC]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NCC00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NCC0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDNV]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDNV]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaNV]) FROM [dbo].[NhanVien]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaNV], 3)) FROM [dbo].[NhanVien]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IDSP]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IDSP]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaSP]) FROM [dbo].[SanPham]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaSP], 3)) FROM [dbo].[SanPham]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'SP00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'SP0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_IIDCV]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_IIDCV]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(MACV) FROM CHUCVU) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MACV, 3)) FROM CHUCVU
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'CV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'CV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_MACV]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[AUTO_MACV]()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT(MACV) FROM CHUCVU) = 0
		SET @ID = '00'
	ELSE
		SELECT @ID = MAX(RIGHT(MACV, 3)) FROM CHUCVU
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'CV000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'CV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  Table [dbo].[CaLam]    Script Date: 12/6/2021 11:12:06 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CaLam](
	[MaCa] [varchar](30) NOT NULL,
	[Buoi] [nvarchar](255) NULL,
	[MaNV] [varchar](30) NULL,
	[NgayLam] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[MaCV] [varchar](30) NOT NULL,
	[TenCV] [nvarchar](255) NULL,
	[HSLuong] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HoaDonBanHang]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HoaDonBanHang](
	[SoLuong] [int] NOT NULL,
	[DonGia] [money] NULL,
	[MaHD] [varchar](30) NOT NULL,
	[MaSP] [varchar](30) NOT NULL,
 CONSTRAINT [PK_CT_HDBanHang] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HoaDonNhap]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HoaDonNhap](
	[SoLuong] [int] NOT NULL,
	[DonGia] [money] NULL,
	[MaHDNhap] [varchar](30) NOT NULL,
	[MaSP] [varchar](30) NOT NULL,
 CONSTRAINT [PK_CT_HDNhap] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC,
	[MaHDNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSP]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSP](
	[MaLoai] [varchar](30) NOT NULL,
	[TenLoai] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDBanHang]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDBanHang](
	[MaHD] [varchar](30) NOT NULL,
	[NgayLapHD] [smalldatetime] NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [money] NULL,
	[TienKhachDua] [float] NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaNV] [varchar](30) NULL,
	[MaKH] [varchar](30) NULL,
	[PhanTramGiamGia] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HDNhapHang]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HDNhapHang](
	[MaHDNhap] [varchar](30) NOT NULL,
	[NgayLapHD] [date] NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [money] NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaNV] [varchar](30) NULL,
	[MaNCC] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHDNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [varchar](30) NOT NULL,
	[TenKH] [nvarchar](255) NULL,
	[SDT] [varchar](30) NULL,
	[DiaChi] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCC]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCC](
	[MaNCC] [varchar](30) NOT NULL,
	[TenNCC] [nvarchar](255) NULL,
	[SDT] [varchar](255) NOT NULL,
	[Mail] [varchar](25) NOT NULL,
	[DiaChi] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](30) NOT NULL,
	[TenNV] [nvarchar](255) NULL,
	[SDT] [varchar](255) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](255) NULL,
	[NgayVaoLam] [date] NULL,
	[MaCV] [varchar](30) NULL,
	[TrangThai] [nvarchar](255) NULL,
	[img] [image] NULL,
	[email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [varchar](30) NOT NULL,
	[TenSP] [nvarchar](255) NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [float] NOT NULL,
	[HinhAnh] [varchar](255) NULL,
	[Size] [varchar](25) NULL,
	[MauSac] [nvarchar](255) NULL,
	[MaLoai] [varchar](30) NULL,
	[GiaNhap] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 12/6/2021 11:12:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenTaiKhoan] [nvarchar](25) NOT NULL,
	[MatKhau] [varchar](25) NOT NULL,
	[TenQuyen] [nvarchar](255) NULL,
	[TrangThau] [nvarchar](255) NULL,
	[MaNV] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[TenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA001', N'Sáng', N'NV001', CAST(N'2015-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA002', N'Chiều', N'NV002', CAST(N'2019-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA003', N'Tối', N'NV001', CAST(N'2020-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA004', N'Chiều', N'NV001', CAST(N'2003-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA005', N'Chiều', N'NV002', CAST(N'2009-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA006', N'Tối', N'NV001', CAST(N'2015-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA007', N'Sáng', N'NV002', CAST(N'2019-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA008', N'Sáng', N'NV002', CAST(N'2020-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA009', N'Chiều', N'NV001', CAST(N'2020-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA010', N'Tối', N'NV002', CAST(N'2021-01-01' AS Date))
INSERT [dbo].[CaLam] ([MaCa], [Buoi], [MaNV], [NgayLam]) VALUES (N'CA011', N'Tối', N'NV001', CAST(N'2020-01-01' AS Date))
GO
INSERT [dbo].[ChucVu] ([MaCV], [TenCV], [HSLuong]) VALUES (N'CV001', N'Nhân viên Bán Hàng', 200000.0000)
INSERT [dbo].[ChucVu] ([MaCV], [TenCV], [HSLuong]) VALUES (N'CV002', N'Nhân viên Kế Toán', 250000.0000)
INSERT [dbo].[ChucVu] ([MaCV], [TenCV], [HSLuong]) VALUES (N'CV003', N'Nhân viên Kiểm Tra', 200000.0000)
INSERT [dbo].[ChucVu] ([MaCV], [TenCV], [HSLuong]) VALUES (N'CV004', N'Nhân viên Kinh Doanh', 300000.0000)
INSERT [dbo].[ChucVu] ([MaCV], [TenCV], [HSLuong]) VALUES (N'CV005', N'Nhân viên Thu Ngân', 350000.0000)
INSERT [dbo].[ChucVu] ([MaCV], [TenCV], [HSLuong]) VALUES (N'CV006', N'Quản Lý', 500000.0000)
GO
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (2, 500000.0000, N'HD11131343', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD11396277', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (2, 500000.0000, N'HD15292274', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD17557604', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 250000.0000, N'HD19969830', N'SP005')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 350000.0000, N'HD19969830', N'SP008')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD22365817', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD24166294', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD2583075', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD26209491', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 400000.0000, N'HD26209491', N'SP002')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD280838', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 400000.0000, N'HD280838', N'SP002')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD31002204', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD31500300', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (2, 500000.0000, N'HD3488013', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD35050216', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD39018818', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 350000.0000, N'HD42921280', N'SP004')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 350000.0000, N'HD44911154', N'SP004')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD44916281', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 400000.0000, N'HD4711811', N'SP002')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 350000.0000, N'HD4711811', N'SP004')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (2, 500000.0000, N'HD49256967', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD58231601', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD59375137', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (3, 500000.0000, N'HD61229289', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 400000.0000, N'HD61690918', N'SP002')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD62279744', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD62835631', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD71268612', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (2, 500000.0000, N'HD81243925', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (10, 400000.0000, N'HD8126902', N'SP002')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (4, 500000.0000, N'HD8126902', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD83592867', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD87669248', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (3, 500000.0000, N'HD90165293', N'SP001')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD96788436', N'SP003')
INSERT [dbo].[CT_HoaDonBanHang] ([SoLuong], [DonGia], [MaHD], [MaSP]) VALUES (1, 500000.0000, N'HD97419286', N'SP001')
GO
INSERT [dbo].[CT_HoaDonNhap] ([SoLuong], [DonGia], [MaHDNhap], [MaSP]) VALUES (1000, 300000.0000, N'HDNH001', N'SP002')
INSERT [dbo].[CT_HoaDonNhap] ([SoLuong], [DonGia], [MaHDNhap], [MaSP]) VALUES (1000, 300000.0000, N'HDNH002', N'SP003')
GO
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM001', N'Áo Phông')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM002', N'Áo Vest')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM003', N'Áo Hoodie')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM004', N'Áo Khoác Gió')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM005', N'Áo Sơ mi')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM006', N'Áo Thun')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM007', N'Quần Jeans')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM008', N'Quần Tay')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM009', N'Quần Thể Thao')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM010', N'Nón GuCi')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM011', N'Váy Hoa')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM012', N'Váy Xẽ Tà')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM013', N'Đàm Ngủ')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM014', N'Quần KaKi')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM015', N'Áo Phông')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM016', N'Áo Vest')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM017', N'Áo Hoodie')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM018', N'Áo Khoác Gió')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM019', N'Áo Sơ mi')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM020', N'Áo Thun')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM021', N'Quần Jeans')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM022', N'Quần Tay')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM023', N'Quần Thể Thao')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM024', N'Nón GuCi')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM025', N'Váy Hoa')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM026', N'Váy Xẽ Tà')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM027', N'Đàm Ngủ')
INSERT [dbo].[DanhMucSP] ([MaLoai], [TenLoai]) VALUES (N'DM028', N'Quần KaKi')
GO
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD11131343', CAST(N'2021-11-23T10:38:00' AS SmallDateTime), 2, 1000000.0000, 1000000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD11396277', CAST(N'2021-12-02T22:09:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD15292274', CAST(N'2021-11-23T11:34:00' AS SmallDateTime), 2, 1000000.0000, 1000000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD17557604', CAST(N'2021-12-01T22:53:00' AS SmallDateTime), 1, 500000.0000, 500000, N'Nhập ghi chú', N'NV001', N'KH004', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD19969830', CAST(N'2021-12-01T23:00:00' AS SmallDateTime), 2, 600000.0000, 600000, N'Nhập ghi chú', N'NV001', N'KH007', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD22365817', CAST(N'2021-11-20T11:13:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD24166294', CAST(N'2021-12-01T23:57:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD2583075', CAST(N'2021-12-06T11:05:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD26209491', CAST(N'2021-12-02T09:29:00' AS SmallDateTime), 2, 900000.0000, 850000, N' ', N'NV001', N'KH005', 50000)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD280838', CAST(N'2021-12-03T13:56:00' AS SmallDateTime), 2, 900000.0000, 900000, N' ', N'NV001', N'KH004', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD31002204', CAST(N'2021-11-22T16:42:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV002', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD31500300', CAST(N'2021-12-02T16:20:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD3488013', CAST(N'2021-11-22T16:24:00' AS SmallDateTime), 2, 1000000.0000, 1000000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD35050216', CAST(N'2021-11-20T17:51:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH004', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD39018818', CAST(N'2021-12-02T09:10:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD42921280', CAST(N'2021-11-20T23:09:00' AS SmallDateTime), 1, 350000.0000, 350000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD44911154', CAST(N'2021-11-19T13:14:00' AS SmallDateTime), 1, 350000.0000, 340000, N'', N'NV001', N'KH002', 10000)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD44916281', CAST(N'2021-11-19T12:54:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD4711811', CAST(N'2021-12-01T23:07:00' AS SmallDateTime), 2, 750000.0000, 650000, N' ', N'NV001', N'KH008', 100000)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD49256967', CAST(N'2021-12-01T18:01:00' AS SmallDateTime), 2, 1000000.0000, 1000000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD58231601', CAST(N'2021-11-22T16:26:00' AS SmallDateTime), 1, 500000.0000, 1000000, N'', N'NV002', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD59375137', CAST(N'2021-11-19T14:22:00' AS SmallDateTime), 1, 500000.0000, 490000, N'', N'NV001', N'KH002', 10000)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD61229289', CAST(N'2021-12-01T22:53:00' AS SmallDateTime), 3, 1500000.0000, 1500000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD61690918', CAST(N'2021-11-19T12:55:00' AS SmallDateTime), 1, 400000.0000, 400000, N'Nhập ghi chú', N'NV001', N'KH005', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD62279744', CAST(N'2021-12-06T11:00:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD62835631', CAST(N'2021-12-03T09:35:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD71268612', CAST(N'2021-12-02T09:29:00' AS SmallDateTime), 1, 500000.0000, 480000, N' ', N'NV001', N'KH001', 20000)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD81243925', CAST(N'2021-11-19T14:52:00' AS SmallDateTime), 2, 1000000.0000, 1000000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD8126902', CAST(N'2021-11-19T14:58:00' AS SmallDateTime), 14, 6000000.0000, 7000000, N'Nhập ghi chú', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD83592867', CAST(N'2021-11-30T11:08:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH002', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD87669248', CAST(N'2021-12-02T16:11:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH001', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD90165293', CAST(N'2021-11-19T13:30:00' AS SmallDateTime), 3, 1500000.0000, 2000000, N'', N'NV001', N'KH007', 100000)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD96788436', CAST(N'2021-11-19T12:55:00' AS SmallDateTime), 1, 500000.0000, 500000, N'Nhập ghi chú', N'NV001', N'KH003', 0)
INSERT [dbo].[HDBanHang] ([MaHD], [NgayLapHD], [SoLuong], [TongTien], [TienKhachDua], [GhiChu], [MaNV], [MaKH], [PhanTramGiamGia]) VALUES (N'HD97419286', CAST(N'2021-12-01T23:50:00' AS SmallDateTime), 1, 500000.0000, 500000, N' ', N'NV001', N'KH005', 0)
GO
INSERT [dbo].[HDNhapHang] ([MaHDNhap], [NgayLapHD], [SoLuong], [TongTien], [GhiChu], [MaNV], [MaNCC]) VALUES (N'HDNH001  ', CAST(N'2021-11-10' AS Date), 117, 63000000.0000, N'', N'NV001', N'NCC001')
INSERT [dbo].[HDNhapHang] ([MaHDNhap], [NgayLapHD], [SoLuong], [TongTien], [GhiChu], [MaNV], [MaNCC]) VALUES (N'HDNH002  ', CAST(N'2020-10-10' AS Date), 117, 63000000.0000, N'', N'NV002', N'NCC003')
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH001', N'Nguyễn Tiến Đạt', N'0998765456', N'127 Man Thiện Thủ Đức')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH002', N'Tấn Đăng', N'0397578976', N'127 Man Thiện Thủ Đức')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH003', N'Hoàng Anh', N'012454515', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH004', N'Tèo', N'0125485657', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH005', N'Vân Ly', N'0124545145', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH006', N'Trần Tấn Phát', N'012454785', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH007', N'Bùi Văn Vui', N'0312454547', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH008', N'Vân Ky', N'0324545145', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH009', N'Trần Tấn Phát', N'085454785', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH010', N'Bùi Văn Vui', N'0712454547', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH011', N'Vân', N'0324547145', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH012', N'Trần A', N'005454785', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [SDT], [DiaChi]) VALUES (N'KH013', N'Bùi Văn Sai', N'0412454547', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
GO
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC001', N'Nhà máy Á Châu', N'0397578976', N'achauzyz@gmail.com', N'127 Láng Hạ Chùa Láng HN')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC002', N'Nhà may Gia Nghĩa', N'0397578761', N'gianghiazyz@gmail.com', N'127 Man Thiện Thủ Đức')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC003', N'Công ty Visico', N'0398756463', N'visicoabc@gmail.com', N'27 D1 Thủ Đức')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC004', N'Công ty Đông Á', N'0397578984', N'dongazyz@gmail.com', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC005', N'Nhà máy Việt Trí', N'0378578976', N'viettri@gmail.com', N'Phường Tân Quy, Quận 7, TP Hồ Chí Minh')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC006', N'Nhà may Gia Tài', N'0397578758', N'giatai@gmail.com', N'127 Man Thiện Thủ Đức')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC007', N'Công ty Visico', N'0398756563', N'visicoabc@gmail.com', N'127 Lê văn việt thủ đức')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC008', N'Nhà máy Á Đông', N'0397508976', N'achauzyz@gmail.com', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC009', N'Khanh Vy chung', N'0398767909', N'hoanganh1410tb@gmail.com', N'1/10 man thien quan 09')
INSERT [dbo].[NhaCC] ([MaNCC], [TenNCC], [SDT], [Mail], [DiaChi]) VALUES (N'NCC010', N'nhà may colorhunt', N'0398769999', N'colorhunt@gmali.com', N'1 ngô gia tự p15 q10')
GO
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SDT], [NgaySinh], [DiaChi], [NgayVaoLam], [MaCV], [TrangThai], [img], [email]) VALUES (N'NV001', N'Nguyễn Hoàng Anh', N'0397530256', CAST(N'2000-03-01' AS Date), N'127 Lê văn việt thủ đức', CAST(N'2021-10-01' AS Date), N'CV006', N'offline', 0xFFD8FFE000104A46494600010200000100010000FFDB004300080606070605080707070909080A0C140D0C0B0B0C1912130F141D1A1F1E1D1A1C1C20242E2720222C231C1C2837292C30313434341F27393D38323C2E333432FFDB0043010909090C0B0C180D0D1832211C213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232FFC0001108008C008103012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00EB349B7B5BC9EE4C0C5207901588BE3701DC679C735B8BA21B5B3731CA8C89963938C0AB306918B95657610C67318560147AE07BD6A3A0113989D9411829EF5D34E5282D0C25152DCF3B94EECC334666918E42B1E47700FF003AE7F58BC8EC647330292BA801578C923A631FE79AF4E4D2C32482687CA99C6EF3579E7FAD739ACE886E6368C498957F8881F37D6B74DCD69B98B8F2BD4E16DB4D7BCB23340ED290C7EF3F504723DAA6B1D285B5F23C506EF94AB6DEB8C60AB1F5AEBF49D2E2B180C4AA001D7DF3EB56EF6DF3186B7540C396C8EB8E805354B44D89CBA18B6503A088A2BDB206CF9608C11EB9EB5B9E4A336FC6491D69238E4902864CC9B78239C5761A1E9D6F169E9BF6CF70B9DF232F7F4AD25563496BA8A3073670DE47FA5B204DC9B36B0623047D2A9DE682AA3CDB418C0E633CE7E86BAD7D05BFB525788950413C9E3F2A91B419D222EF3EDDBF3600ED513952947DF2A31A89FBA7031C073B76E187073C62AEC36E171DCFAD5DBD82596E808A0C91F79B70E833F9D470A1FE3E3DAB82AD270763A6135243A38893C0AB71C001CD3E3DBB7278153C60BFDD1F2FF78D6762EE0ABB714F113377DA3F5A951028CF53EA7AD0D22AE39C93D00E49A7615C8FC95FF6BFEFA3453B749FF3EF27FDF4BFE3451603523902E30723AF07A5685B5E80B865538F7E6B9612907826A449DB77079AEB71B992958EAE5BB8A44C151822B9BBDB39649DCC6ACCBD720F6A459652FB390DDB35344F7092155C927B5385E1B0A5696E68E93A320559EE172DD429ED4B7BA14734EF309447B8F0B8E2B52CC4A2D97CC23355E49199DB7F383C567ED67CEDDCD3D9C6D6B069DA54363B995B7961824D5A0A6276C6363124FB1A82199B7019E2AC4D2218C82739F43594F9A52BB292495919F3A6640C1C865CEE5F5154AE3527BBB6921891CC8D953B815C638ABDE660E00C0A254DB22EDC1DE326B44ACEEC97B18B67A185B58E59E49B78279CE7F0C7A550D574B36BBA68991B9F99471F8D75B2C854430464A3B364FCB90477C9ED52B5A239732AA952BB76F63F5A52AADDD0A304B5470302670643B88E83B0FC2AE895570B9C93D00EB50DF58CBA7DE185C80A46E52A7A8FAD3A16541C002B3B145C48DDFEF36D5F41D69C1162E114007A9F5FAD3239B238E68721FEF138F40714810ECD14CCC5FDD5FCA8A2E33284C33D6AC5BB8690722B104C6A78666DE3071EF5D860745249B8A9383B7D3AD58B7BA8F706791908FD69C914573656E148DC78CF435627F0F7C998A704633F30A39E1B30E597435ECAF127846D3922A2B8595DBE499403DB6F359B63A6DC26E123B8DBF77078ADF68BF741475C75AE795A2F436576B52BA6D84E251C11C1A7C8102640E0F435E5BF13FE205DF86E41A4E9E57EDAE819E6201F281E800F5EFCF4FC6BC56F7C57AFEA38FB5EAF7B281D034ED81F8671428DF506D1F57C8EA07506A3694BB8C75ED5F2BE99E32F10692CBF65D4EE4460FF00AB772CBF91AF65F007C40FF849B7DA5E4423BE8577E57EEC8BD33EC7915A24433D4ECEE3CC2518608152CCEA0F5AA9A71219CC8B8C8E09E953482395B01C7E15934B98B4F4313C45109EC7CE4FF591739C6783D6B988DB0724926BB69ED598B45F795860FD2B88B8B76B5BC9617727636318C669B4BA08B6B353D599BA8DBF5AA892E0718A93327718FAF15204F8FF006C7E54557F9BFBEBFAD14B41DCCC30A8EF4E400639ADC3A14A47F0FE74ABE1F739391C75AE8E6465CACA96B2E3182722BABB0D444918865EC386AC9B68ADED5304E5BD314EF3E353B95466A65A96B43A985D360F9B3F5A9C104572C9A9B00011F955D8355223202924D64E0CBE6478BFC59D30DD789A7BF689E2DECB1956233F2A819E32391823F515C0C3A40746636F2B2B64236EE98EBDB9EB5EDDF1063FB54B6D74F6E8CBB4A13B73C8E7F97F2AE0C5C3B478F2D7C81C0448FE7FC89047E5439B5A1AC29A92B9CF5AE9DE7C5F639B4F5640A7F7BB76B0E78E6BA6F851A14DA7F8C24B99D808A3B77C21E4B7207D3DE9E2491211BE158C1E70400C3EB8AEDBC35A725A5B8BD0DBA49931D3A0CFEB4536E52B20AB18C637677936A109B7F2E30391D31D2B3E0B968240F9CE2A879841C9A779A0F35D0A091C8E573706A3E710163F98D735E218CA6A7E611F7D013F51C7F415792E243C0E4551D66379120739032466A250B2294AE66ACBB47CBC7D290C99381D7D853D2389472A58FF00B469FF0068D98DAAA3E80562CB22CC9FDD7FCA8A97ED52FABFE7450074324E3B13507DB9A33D48AE38789757670CF18550795299C8ABCFE2AB6DB992D9BA7241E95AA9C086A48DE7BD32672AA73FECD566C31EE2B965F16BCB3811C71A461BE6CF248A74FE2B9A1B80D1C2AF0B742474AA52893767676F67149017339561FC2454896EC3857CD73363E2313A3C928C2632A17AD721E21F11DF6A32FD9BCC68E18FAA212037B9F5E98A89558C75DCD6952755D91E8DA8DCE8AF6D25AEA3A9DB47DF1E60DEA47702BCC6F753C4B349A688E7811D9164917693838E9DBA67F1AE7E468D5D448E73C81C13C027FC6B5346B517B73730DB4A36B36FD8D9079EF835CF39A96B63B2149C344CAD1FF68EAD700CB3048F3CAA0C5757A1F8CEEB44965B5B8B68AEED637C207E19460700FD73D6B36ECC3E1EB66FB5488B339C228E49CF7C0E6B105CC337C9117776F446FF000ACF9DAD51A7B34F491EA27E21E8B2E0B6933AE7FBAE0D5CB1F14F872FA758834903B74F3BE519FAF4AF2994344BC761544DD30F2D811D79F7A71C44D04B0949F91F47C3A7DAE415DDCF6350F88218E3D3E15008CC9D47D0D713E04F1149291A3DC484FCA5AD9C9EC3AAFF0051F8FB5757A939955112646652770DDBB1F91AE98CF9E3CD7386A41D3972B31844A0E423107A6EFF00EB53E2561B9CA6C0BC0C0C66A664BA312AA4EC9DB841FD734C36A8D2FEF6E27700F3FBC2BFC8D4B64A4370DFDEA29FFD9F69FDF97FEFF37F8D14AE338CDF21EAC4D26C8D936B2E47B0AB9E4151BB6B01E9D699E5A9E7383F9573A675F3C5943FB3626E621B7DB1C7E54E8AD8431796EB800E73DAAFAAA0072F81EB4F84C52B98D26576E98069F33339C29CBAEA536815619263B0222920AF7C0CD7253300CCEE704E493EC79AED751B78E0B194C876E46D51DB27FF00AD5CC4912B00460E056152A7BD63AF0943962DF72BC16EAF0A310371193F8D2B41E54BE7461BCF41FBB28DB493E99A65B484DB8743940CCA463D0E054FBC8E0938EA1875151CCEE75593440F673DCDD2DEEA2DE65D328E0F45F6ABF142A8A00029007775C12CA072C6A46F957AD2736F71A8A5B15AE635242FAD72921F2EE7C9CF2319FAF20FF2AEB2342E59CFD0572FA8DA4B0EB3E6726390E47B1F4FE7F9D694DF433AAB666FE9F3B466360C55979561DABD43C25A7E34A3722772D3B6791D00E3F9E6BC7E3BC8E25E493F4AF48F871A9CF39B8B4DE8222BBD012720F038FEB5A516E32B7439B1508CA37EA8EDBEC9BFE6F31B03B63AD426046620EF073E981570C1941FBFC63A902A30B8F951C9CF24915BCA470A441E42FF0075BFEFAA2A7F267F45FCA8A9B8EC79BFDA1D9619566DC01F5A249CC9383B1F391874A6DC590B63F20731273D33C5548750B0BB6F263F9641D0D64D7548C6526695FD95D5C20F2DD548E391D6A8C1A46A304AAC026E61C9CF4F7A86E2E6EA156118790E7F879E2AF685A8CD77729048CC739DC0F51819356AEA3A949B93D4D4B0D1F360EBA98121672F80C460607A77AE7F58D16CE32CF6924CAAA8D248B9CFCA0763F90AEDA67C5A393E95CFCD04A740BCBBF9446E9E5F3D4807B7E3FCAB9E525F133D456A6947E471DA24405A49111C6EDC3F1AB423313153D292C1424C4E3E53C568CD06E191D6B194BDE3B631F74AAA180F95BAD24A840080EE66EBED4F5528718E6A648FF88F24F7A571D88C2048F154A38D26D42D430FF96C3F9D684C4246C4F615534C81AEF55B38636DACF2AA86F424800D38B22A2F75A2CEA9E13DD6B3EAF6B16EB781D7CF8D781CF7C7D7A8AD9D31974A482F6D976B478600771DC7E55E857BA441A5783EF6DA22C556DE463C7DE6C6726BCED9FF00D01571C6D15D534E291E6E1DB945A67A6C245DD945344EA629630EA4FA1E7F3AAFF679B3C321C77C9069342877786AC3248C45C7E7578249B00C07007635ADAE62F4D0A9B2EBFBE9FF007D1FF0A2A7DD27FCF21F9D145847927DAEE7ECCE9E49DDD00E80FE473590B66A651245124726724A9CFF00FAABA0D0258EDAE0695AB48622DC43778E07FBD9EA3F51F4E9BF7DE1DB9D3E113944BBB7EA658F278F5C0E959CA4D2B98CA9C91CC59A5F05DC226C37F11391F856A68D632477B71349D4A818C7A9EB9FC2A582F630ED0469C2827FFD55734F99A44766EBBF1F901FE34A69A5746B8785EA20D5E564B3F2E31996421107A93C0A8B5CC5B786BEC892EE6C2A051DF914AE5AE35D4014ECB742C4F6048201FE7595AE6A46DC18637994B46584C146D46FC48F7E9ED5CB3526D451D729DEB45744644C6D34AB70D7B2AC6F8CEDCF3F955083C51633FCA44AA3380C5320FE5582134EB7B8F3242F70C58B31CEF627D7248AB0DE22B2DDE54292A8FEE189727F10D9ABFABCBB36762C4C1FDA48EA62F2EE712444953EA08FE75659638A22CEE1547524E0572835CB15056417B191F7BE69063F5347F6868533076BA99DBFE9A34A7150E94FB3FB8D556A7D1AFBCBF7778F76C20B18DDE327E6948C2FE15B9E16B38E1F10E99131CC8D708CC7BF073FD2B96FB4D84AE15357B98C7A17207E645745E18B37875FD3EF2DAE5AE184C830CE4EEC9C75CE3BD525CAD5F425C94A2F9753D975E577D035150D9CDB4981FF000135E57328FB203EC2BD5B5A263D0F506273FE8EE00C7FB26BCD560FB4DDDADA0E8EEA87E84E2BAAB6E8F3B0FB33BFD201B6D1EC627490158573D31D2AE3BA311B180FF79714F7F2C8DBBB601C7B7E74CBAB882C6D1AE269008D075CD6C91CCDDD8B887D53F4A2B88FF85A5A57FCF95F7FE039A28BC43959E6369E228A5582D35A1BADDFE586F319071FC2F8FBAC3D7A1AEB746F10EABE19794C6CF7961B430819B3B72474F4E33D38F6AF25D2EE9B5292E6D258E28E078246DB12EDC328DC083EBC639CF157BC19AC5EDAEB36FA7ACC5ED669190C727CDB31FDDF4E9F4ACD2BEA5CB43DBEEBC5DE1ED492D8DAE9D1CF7139C4AACBB1A2F5248EA07D6B225BE4501EDE3F26DD8B1420EE0547F167EB589AA2FD850DF5A620B9646469114720FD41FCEA87882F6E2C62BC82190EC4822897772554EECE3F215324E5A336A3CA93925A9ADFF091410D84B24172CD34EC4382836AA818183DCF5AE1756D53ED0E71248C4F72D9A89DD85B2A83C6718F6ACD9CFCAEDDC74AE88528C3639252E693914E7B93BF86F9877A499D660BBD416C75AAF3F078EF4D63B381F4E6AC9264BC7DE222C5C8F7E6B4A18C4A9F386191915816E4B6A4013C007F9574967FEA93F1FEB54205B6DF8C139C75C54F67A85EE97309AD2E1A2994E5587A8F5F5AB08C7CF03B600FD2A8DF01F31EF9353249E8CA4DA7747D053EB37D7DF0DEDEF7508A3B6BFBA48B746AE1958960495209E0A8271D6B9FB4BF8EDB50B7B9F2CB04901231D715C4699AC5E49E118626932BA7AEF83D8B48739F5AE8E0BA91ACD6460A5981278AE4ADF11DF878DE1EA779AA78E749D36CA3954BCD752F11DA20F9C9F53E83DEBCFF00C43E296D467796E2262C87F756E8D800723E6F739FE58AC9F125C490AC72237CF92B9F41853FCCD73535CCA9A689B79666895C83D3924638EDFF00EA391C53E66D18CA0A3268D2FEDBBAFF009F28BF37A297FB2C7FCFDDC7FE39FF00C4D14B40E53FFFD9, N'hoanganh141000tb@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SDT], [NgaySinh], [DiaChi], [NgayVaoLam], [MaCV], [TrangThai], [img], [email]) VALUES (N'NV002', N'Tân Đăng', N'0397545677', CAST(N'2000-03-01' AS Date), N' Lê văn việt thủ đức', CAST(N'2021-10-01' AS Date), N'CV002', N'offline', 0xFFD8FFE000104A46494600010200000100010000FFDB004300080606070605080707070909080A0C140D0C0B0B0C1912130F141D1A1F1E1D1A1C1C20242E2720222C231C1C2837292C30313434341F27393D38323C2E333432FFDB0043010909090C0B0C180D0D1832211C213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232FFC0001108008C008103012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00BBE1E6FF008A774E1FF4EE9FCAB501007B56568112FF00C239A7302726DD3A7D05686181E1AB1364484E0F5A43D7D699F37B1A3791D54D201DEDCE28CF3C530C833CF1F5A3CC4CE0303400F2C40EB4D3C8A69718A8D9F03AD031E147348CFB149DC7F1A89A7445C96E6A28DFCF3B8F2A28B816033B618A8E2A40FC0CE45341E297A8E69887AB827048A5CE6998CD28518EBC8A007F6C53581D871E949B5B9F9BF03416214E476A00E228A5FC28AA24EA34027FE11ED3BFEBDD3F956813543C3E8CDE1EB12A3216D9093F855ECD4B290678A5C83D69BF41413DF1400A4629BB573CA8A5C9248A4CF634011C91AE0E2AACB1FCA70E722AE37B5539A50A70A32D4866035FA35E3C6725E319E7A1AB3A45C4B362503E4271B6A2BF822697CCD80023903839ABBA3B187721384EA871D0D25B81AA1BD41A9558118A140CFAD38019C62A805040A55EB4D0BE829C14F18278A0428F4A47FBA7E9484119E4534AB907A74A00E3B145183E828AA24E8B422C3C3F600679B74EFED5A19C0E6B3F433FF121D3FF00EBDD3F955FFAD2296C1B877146471CD07149DE900ECE47D6938A4F6A300D001C73595712BDA39578CB29390E2B4B6E4FB5298D5D486E47BD03395D5E096FD636B4940DA4EE078A215BA8A3552F961EFD6BA53650E3EE00A7A5571A54424DDC9E738A403F4D924921224209157F1ED51C48215DA8800F6A9C02572053015080D9C5181D7342A92401D4D4ED67718E61703E945857206C6EA46E54FD2A6785D40CA3671DC53197E46C834D215CE1F6FBD1526C1FDD345324DCD0C8FEC2D3FF00EBDD3F90AD0C8231E959BA260687603FE9DD3FF41157B183C134BA9687FF008D2820023AD308C8EB4BF43400E5F99C2938CF14D230C79E075A6B06EC6800E31ED4863C51DFA51F31C8C551D47514D3ADFCD7009CE00F53401A1C9503AE3B53861482467DAB9EFF00849225B712329563D1715524F18C51A16C0047AF7A0573AD1F4A70E3E9583A4789ACF5052B2CA91CA3F84F19ADD1B4F20820D315CD1B15B558F74ACA5C9EFDAB496E603C0957F3AE7BDF14EE7D29A64B4745E6C6C71E6AE3EB4D7F2DD48F90FE558200C53BA020134D3158C2F93FBA9F95159783FDE3453B88D2D14FFC492C3FEBDD3F90ABE0F73D2A868AA0E8963C71F674FE42B430306A19AA13A77A3701DE8C0C720526D1E9C520141CF19A50307AD2607614703B50321BBBD4B084C8E7DBEB5C1EBFE207BC558E389BCBCF5C77ABBE2CD472E2D95BE61C9AE69AE96340770DDDAA9225B11A694220EC4704D569A6F2F20939A2EAF512352C32CA38C552FB70970768F4E69D88D4B0B7BB482A0E73D6BD17C2FE244BB11DAC87E71C2FBD79D3CC00FB82A4B3BA96D5C4B031564390476A4D0CF73C7A734E0A6AA68427BBD1ADAEDC732206CE6B44293D68417210A4F4A76CC29A9D531D4538A7C878ED4EC2384C1F7A2ADECF6A28B016346CFF00625863FE7827F2157724D53D1C01A1D875FF00509FFA08AB2D201C73F954B3443D5B6B024022933826A232007149E60F6A43240E49F4E6949257D2A20D4E64F3A16439C30C66803CB35C9D5F56BACBEE6DE4019E80562492BBB003A55DD6AC64D3B5C9A3903001C904F520D58D1B4DFED19FCDC7EE94F34DBB2B8A31BBB15BEC82680863F362ACD8684EC779194F4ADCBC7B5B5511C5133BE71F2AE6AE6945E7EB1903DC564EA33A55247353E90C5B01F68F7AB0DA0C89A7B4F0B891947CCBEA2BA0D474596725519941EE2B4747D17EC481E4396231C9CD0A6C52A713A8F0C898F862C12439C440F15AE23E3915168F14634D89106153E5C7A568043D00045742D8E37A3B1008F032294A10B9F6A99541CF38C52B2900FD3D698AE711B28AB3B4FAD1405CBFA1E9AAFE1EB0727FE5D90F5FF645559A4D3B760DF22F24600AE5F4DD57531E1FB6B68EED845E528C7703038CFE3442AAA899192B26D24F7AC5CD74378D37D4DC7BBD29719B899B9EC9482FF4A046EFB4B738E00AC96555DDC0E181A4942869063B6462A39D9A2A68E8ADF53D15490C93020FF10CE6A44F10690124FDC3AB2E76823EF5736E53CDC823040619A63ED5BA70471C7EB4F9C4E922DF8E7C336FA969AD770E1278C82189EABE958FE19D324B5D3DE2994021BF315DB0C6A3A008D8F2F1143F55AC1B4134734A928EE76FA6289B7B0E9456FD499F4CB778817505874A813ECD67BCB32AA20C9AB72BB347C1E2B2E58E07045CBE3BF3DEB376365E64F71AD5B468B805836002BCD5A8EE8C91838207BD63ADC5A5B9C08D9FD323A55CB5D462B9CAAA32EDF514F5068ECFC3EFBAD5C7421AB5C103A561F87DCB5B481146411C935B4048783B4574C763827F133335CD72D740B53717592181DAABDCD7975CFC42D7269D8C773E54658ED5541C0AD9F8A8B7224B0DCF98486C003806B83B7B5DD200D904FAF7AAD3A92916BFE12FD67FE7ECFF00DF0BFE14554FECB93DA8A5743E53ACD3491616CBEB0A1FD2A76252474C71B81FD2A92DF476BA5DA051BA41128C0FA5675EDEEA0119E48DE189B00315EB58F29D1ED3437A79B66E6C819EBCF6A55669986C75E981CD71725DCD2FEEC33B76351C52DE23B1123A95E8568F662F6DDCEF04121D9F37518FA5492DBEE9E3193F3A0FCEB2B44D5DAE82DBDCE04EBD0FF7857453C4404603904E3F9D44958D5493D8D1D0554C4EA0B6564E549E3E6153DD5A06899D3875E4003AD56D39BCAD4232BC2CC99FC41CD686B772BA6D95C5CB7F08F97EBDAB44AE8C24F96462F50463154EE2C62B865322E4AF4A6585EFDA2CE39C9E589C9F7ABA254233B8562F73A5333268B610A887F2A9A189963C15C1EF5667942AFCA463D4532D01B89D46ECF34D6A12968763A35A1B5B1889E19F96FE95ABD3A5665B5F451C2B6F2362445FD2B45196450EAC08F6AE956B1C524EFA981E30D13FB6B449163506E21CC9193DC81D3F1AE1ED2C2DEF2DD1DE351B40DB8EA08EA2BD6473FD2B8CD5B4D8F4FBE9A581311C877E31C027AD296C5526B638BFB0C1FDD7FCE8A3ED43D0D1506D645EF0BD922E8D16A77710672A3CB5619E83AD6D1B21A846B3DFC7E73F58E1270A9EF5C25978C35286C6DE054B6291C4028287B7E34973E37D60DBB906052463843FE343BDC516B9497C4369269B23CEC615690F091FF08AE705F31500D65DD6A977772192794BB1F5AACB772E7B7E55A23096E6FC5772060E8C43A9CA9AF54D32E46A5A2DADCE3E6E037D6BC423BC9411F77F2AEBB4AF15EA365A52C31087606C8DCA4FF5A89A2A94ACCF4C50D1885BA18DF153F8E217B9F0B4AD1649F958E3BD79B3F8D755DB2716FD7FB87FC6AFDBF8FB596B248596D59318C3464FF5A50455469B3A2D1B4E6B6D1228A41F36DDCC0FA9A8E5882498390335CB3F8DB560EF85B7FF00BE0FF8D539FC5DA9C8016107E087FC6B371D4DA32D0EB9E3E0B066C7D6AD69808936C4D873D0D7007C51A8918CC5FF007C9FF1A92DFC5BA94322B2F939F743FE34288A533D026B9B94BC9FA9768F62FB107AD6C681AABDBE21B924A13DFB1AF363E2ED4649373476D9F5D87FC6A09BC5DA92B821601CFF0070FF008D69B3139292B347BCB48AAA0E7AF231DEB3EE7CBBA578A45041FCC579343F1075C54D99B72074CA1FF1A53E3DD6436EC5B64F5FDD9FF1ADB74726CF43A1FEC4B6FEF3FE745719FF0009A6ABE96FFF007C1FF1A2A6C87CCCFFD9, N'tandang221@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SDT], [NgaySinh], [DiaChi], [NgayVaoLam], [MaCV], [TrangThai], [img], [email]) VALUES (N'NV003', N'Nguyễn tiếến đạt', N'0397537654', CAST(N'2000-09-26' AS Date), N'1/10 quang trung gò vấp', CAST(N'2021-11-24' AS Date), N'CV006', N'offline', 0xFFD8FFE000104A46494600010200000100010000FFDB004300080606070605080707070909080A0C140D0C0B0B0C1912130F141D1A1F1E1D1A1C1C20242E2720222C231C1C2837292C30313434341F27393D38323C2E333432FFDB0043010909090C0B0C180D0D1832211C213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232FFC0001108008C008103012200021101031101FFC4001F0000010501010101010100000000000000000102030405060708090A0BFFC400B5100002010303020403050504040000017D01020300041105122131410613516107227114328191A1082342B1C11552D1F02433627282090A161718191A25262728292A3435363738393A434445464748494A535455565758595A636465666768696A737475767778797A838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE1E2E3E4E5E6E7E8E9EAF1F2F3F4F5F6F7F8F9FAFFC4001F0100030101010101010101010000000000000102030405060708090A0BFFC400B51100020102040403040705040400010277000102031104052131061241510761711322328108144291A1B1C109233352F0156272D10A162434E125F11718191A262728292A35363738393A434445464748494A535455565758595A636465666768696A737475767778797A82838485868788898A92939495969798999AA2A3A4A5A6A7A8A9AAB2B3B4B5B6B7B8B9BAC2C3C4C5C6C7C8C9CAD2D3D4D5D6D7D8D9DAE2E3E4E5E6E7E8E9EAF2F3F4F5F6F7F8F9FAFFDA000C03010002110311003F00CA93C490F9AD13707DC565DEBC72169CE318CF5AD7B8F09A97320739FAD733ABA4B6A1ADC9E3EB5BCA5643E57730B5374967050551DB53B2967C019AB2B64447B98552AB14AEC9F6726F433F6D5AB1B17BEBA4B78C80CDDE9AF16DE94FB4B996CEE16688E1D7A574D3717A994D35EA696ABE19B9D2E3593CC5910FA0C62AF7857428AFEF17ED6B94FEE9EF5686A57DA8C31B4D6ADB33FC23AD5CDD7EB22FD82D5CBA7279ADA505D0E78CE56D4B9E28F0DE9FA65A09ADE311B01D54115CA457B0F96431F9BDEBB8FF008486CA6D3BC8D4D765C818646EB5C6EA274F7958C3C7E02B5C3CDD322AC554DCCF9A552495E950A499CD364C1E074A9ECEC1EE77153802AE559B668A09228CE79355FBD5DB98363153D4555F2D87638AE2A92D4DE2B41805488A49E052015A3A65BF9F230C74158B762D14FCB6F4A2B7BEC1454F30F94E997C4573C875CFE3599796171AB23CE060E38AEF4783EDDB50DEDF77FBB5AF79A4DBDA69CC224030A7802B9273E68E86F0D1FBC7865969D27DA1FCD5C6D38AD4B885560231DAB7B41B34D4B52BA8D86195C8C55BF10785E5B581A58812B8CE2B966A4F53AE9382D0F3F306F56C0AA6232B20C0C9CD765A1685717F0CE563248CF6AE7AFED1ED2E9E3914AB29AF5308E3C9B9C58A8BE6D8EE34FF00B45BE8D1CEF6A360039F2FFAD5AD3BC41225CCAD05909063F862FE95C2C5AEDF2DB2DBF9998876AE8FC3BE32874B0CB358ACA58F5619AE994D58E154CA5ACDBCBAA6A8D2BC1E5393F7769159F75E1AB8874F7BD23080E2BA6B9F1F594DA967EC2B10C614AF041F5AB1AD788F4D93C306DE2DED2B7273EA7AD10ABCDB16E1CBB9C12DB225A0B86607DA991EA2B0AB040413EF51CA55E1C46C781C8ACF02A252D4B48B2B3092E15A4E416E6B5F5236ED6C9E528CFB561443E715A53FCB0FFF005EA6F763B19B8E6B5F456D8F2103D2B24E49AD8D1B0164DD4A7B0E3B9A5E7FB514DDE9456562CF6396ECFF00AC5E94E7B959AD1B71CF1582976F2DAE00A5B59D9E368C9AE48ABA3796E73BA14D1A78D2F16338048CD7A4DD2453D932B80415AF31B6B3365E31F317A4BC9AEF2EAE71122E7934EC2B8DF0C582DB0BA0140018D701E3DD3D7FB700840DF22E702BD5F4B555B491863902BCB3E204DF64F13C32292AFB6B28FBB2BA356F9F467116F11170158743822A469112E1463E50DCD749A3F85DF5457BAF3761197DBEC31FE35CE5EC0F6974E920E7920D6CF10A6EC8C7D83824D9B1A87876DAE7CBD4AD2F216CE18C3BB9154F529DD74F3179002961F3E3FAD61BDDBC6014720FB1AD78EFE7D534B581E58D5623962C42EEF4FAD6F869F2AE56675D734B9914ADAD639A1766936ED524F1540AE338E79AB6770774889DBD0E3BD74FA878324B5F0DDAEA96E1A712A6E9368C843553A893D498C1B5747250C12160DB1B19EB8AD3923567457076E79C8AED3434D2E3F0FB49771C425F2B80CBCEE1BBFF00AD5C5CF3C72CAC63002E7B5673ABCB1D07CA45750C08DFBBABDA75BC62DDDB2338F5ACD2412E0F51D2AE58B11038DC7E95CEAAC9BD4AE5B163627AD1557E6FEF515A7B50E5675FA7F89ED962319601FA62B634FB8F3A4DE3A1AF2D9498AF06DF5AF46F0F4C8634DC45102E4CE8A1D2124BC174FF007874A4D655E2844A87EED6B5BB46E8016007D6AB6B8B19D325DA41C0CD4C9E8387C4AE79E41F10350B1D464B171942E7AF6AC7F17EA8FAC6A76F308F6AA00BD739FF0039AE735A949D76565383BCFF003AECF42D2BFB4EE2079B1B1597E5EA5CFA54E895D8D5DCAC8F4EF0E699A7AF8316650BF69972A8E7900F6FC2BCF1B487F126AB15C6A12C51A2CC6D648E0E0A900907D39C1AED6EB558F40BC1A0DB9478A58CCF01CFCC1F1F74FB1C1AE43C3BA8EDB61713468564BF76C30036E578FE66B0BDB548DED7DDE871B75E0DD7BFD22EADB4BB892C239591640324807AE3AD4DA0787EE352B85B2746B77793606981519E383C76C8FCEBDB2EF528A2D3E3F22EF643E517C04C8627A735811EB76FA5DFC534D1C53DC12C23998602C98033F88E288576D8E786B46E71D2F83353D32EAE62FB37DA04281CB42778C16201E3E86BDCACE1B5B5D1A1B216D1AC2B1209232BC13819CD53318B1BB96FC41B60BC8D4CE3BA903D3A60E79FFEBD59B60F7162B2B4C0BCC0BE38CF2381F962B4E76F431E5491E37E3FB46D264B88D00549252EB86FE1238E2B88864416C09EB9AF41D566D3FC55E26BDDF23986DE25183C6768C1C7EB5CC788B45B2D296316B3F985C648C74ABE55CBAB329BBCAF6309265FB49017EF715B96DA55DB025626C6339154FC33A23EB3ADA44AC1550EE39AF74B6D3ADE1B58E3F29090A0138EB5364DD8ABF53C6FFB2AEBFE78BFE5457B3FD86DBFE7927E5453E441CC7CE77778826DD91C55D4F13182DC795261C0F5AE7C595C5C125509AA52234521561861DAAD19BB9D58F18EAAEB8FB411F4AB7A6F89351B8BA58A6B962ADC1E6B8D849AECBC15A0C9AB5F799D110E687B0E1BA2C2E871C9AA3CD39DEA5B231DEB4EE60BBB5D56D25B49DA08BE50761EE3A5741AC68E6C648DA35251D7AFA11D6B3A5673E472BB7386C8CD631959FBC75CE9F346F013C47A16B161ABA6B30C80C08A989247DC791CF1F9D725A9DD343118518819DC003DCF5AEFFC7BAB0FF41D3E37F90C7E73FD7181FA57966A1234928DA0E73C71D6886BA913D343B2D37C43A81F07CBB19244B51B64120C941FC273FA63DAB47C01A81BC4B882F409C0724B380783E99EF915BD1E876BA7FC37B8B59C04DD66CF2BE39DD8CE7F038FCAB85F005FA45A8794C8EC5E45385193C7B50A11B329D493B267B35DEAB71790BDBCA90DBC7213182C49240E38F4EF5CD6BEF34F76D0D91722D91422A9C067F4FD2997BA98B8BBD31A35630F9B92DB481D7D7A1ABB74B1C2F79F29569265031EF8A1E89344C55DD99E6D79E1CD5A0BC7943C56EF38242799CF5AD5D574E86E7C3B6A2291EE3524CAC817E61C77FF00EBFB55ED7AFD27BD631AB0653B48238AB7E14B8F3B560A62418439207B50E4D4399872AE6E5472DE12D37518F57F30092252082C057ABC57F1A1489E552C0608DDCD636A122E9F099B003B1242FB572363F6BD42F6568D9C36FE0F61514EADEF2654E8A56513D4BED517F787E745719FD95AA7FCFCB7E7455FB7811F5799CBC7A5A20384FD2B84F135A8B7D4B206370AF74B1B3B6780E42E715E5FF116D625D5ADA38B196073554E5A13596A71110AF59F00A18EC47963E66C64D798496A622BE86BD77C0AC9058C608E48AB6F4328EE76AEAAD62EB200485E335C5CF14461B92460AAE57F3AEA66B95F31973C62A85D58C2F6170EA026D88966F6AE79AB9D54E56D0F3AD76ED750BF9672ECC2301133C6303158965771C77092655A58DC30DCA08241C8AAFA85D3098AEFF94678F5AEAB57D334AB8F86B61AD59DB3417714DE44CF9FF5B904E6B4DAC67CD7773535CF1DC1A9785AF2C1E0786E1E02AA50EE0DEA3DAB8EF06498D483062AE065194E0E7FFD55A7F0DA4B3B8F11B2DEA8731C24C7BF91BBFF00D54DF155841E1EF132DCD8E12099BCC451C6C60791FE7D6A54ED2E42B91B8A9F43B6B5BA97CA58279E616E8432A8218641CF43EF4CBC98CBE7C86E58EF94328E010477AC9D2EFAFAFECFED50A2E3241040CFE19AB8B78EAA56EA08476CEC028682E55B866BA98B4B207918F278E7F2AD4F0E148351DC39620818359C7FB2E69399361F402AEC0F0E9EC1A0958FE343D55816F727D6E6926D40A17DC0F1815AD6B1C3A65879A1007239AC8FED2889DC6225AA77BB1790888A30159B8AB58B5269DCB1FF000908F514550FECD4F43453F6711FB491422D74DBCAC85B8AE3BC59762EEFE0981C9538A59E57772DCD6959786A7D4E0131031D4135BC636473CDF3339693E72B9F5AF48F0F4AB058C614F38AE7350F0B496D1893772A7915BDA4A42966A59B040A4E5704ADB9A773772C2AD2E41C73C8AC6BCF12CF736CF0AB042C0A9C0EB9F5AD09B5086488C65338F6AE52EA35FB4330CA8CF4E69683B9911F86AF3519CAC646E639C935D6F8AB1A77C30D2B4E4EAD2B3BE3D471FD6B32DE578E55F29D8126BABD5B479B50D2F4D4118748959A40DD066A652B340A374EC78C5BDCDCDB4FE6DBBBA38E857AD5C37F7BA84F10BA792501F396EDD3FC2BB28EC2DAD27313DBC2ADEAC3357E186DA36F96DEDCFB84156DA62575A5CD492F775A5B7D816389546C618F4E3355A48E69989918367D00A66C2F9D81540EC284F3938D84F3D454D9256349CB9A5726B7D1A198649F9BB60D5A3A2B31DCD23311D326AA2BC91364641ABD6F7EEBC3734894C96D6CBC9932EA4FD6B4D1D0301B07E54CB5BA89C80F806AF3240C415C548C8FCC8FFBB4558F2A1FEF0A28D0353CEAE34B6B64CBA8C575DE13BEB79208ED0637E718AE5F5BD6D2E53CB8064FA8ACED07516D2F548EE9F242F5AD9B44A47AA7883488FEC45B68E6B85C470486335B3AB78F2DAEED44712B16C73915C4CF7F25C4E64C60566ED62CE8775B91DAABDC2DAB210D8158BE7B91D6A372CFD49A8BB1D91A3A5496706B09F68E61CD7A5437166C8EC9711F93273866008AF2258C1356C4B2C718559580F406A64B981685AF1045126AEE219BCD4F506AA42EC8C0827E942B2904904B7A9A10F3549B26C5F4BBDA385E6AC25F606428CD6790303839EF4F8C7355A8179E769B076814AA581A8524C0C54C926281161646C8C715762B8940EA6A923026AF400134863BED53FAD156362FB515560B9E72B11029C632A2AECA8B1CA5474A73A28514740EA66B06C7029CB9DBC8ABC5463A5425467A56655C84123B54FF0067668F702290A0A995C88B14D0AE510486A9049D8D4F146A64391523C481BA5160B9590B67A706A648D99B2B56628D7674A453B58E29A4263C02400DDA9E140A139049A01E6AEE22655EF52AE2A1526A64E94864D1900D5C89EA80E0D4E8C71480D0F328AA7B8D14AE07FFD9, N'td2001@gmail.com')
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [SDT], [NgaySinh], [DiaChi], [NgayVaoLam], [MaCV], [TrangThai], [img], [email]) VALUES (N'NV004', N'Nguyễn Hoàng Minh', N'0394858483', CAST(N'2000-09-26' AS Date), N'127 D2 Thủ Đức', CAST(N'2021-12-25' AS Date), N'CV006', N'offline', NULL, N'minh09@gmail.com')
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP001', N'Áo Hoodie AlenWarker', 482, 500000, N'src\ImgSp\aohoodieAlanWaker.png', N'M', N'Trắng', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP002', N'Áo Hoodie AlenWarker', 31, 400000, N'src\ImgSp\aohoodieAlanWaker.png', N'L', N'Trắng', N'DM003', 370000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP003', N'Áo Hoodie AlenWarker', 32, 500000, N'src\ImgSp\aohoodieAlanWaker.png', N'S', N'Nâu', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP004', N'Áo Hoodie AlenWarker', 43, 350000, N'src\ImgSp\aohoodieAlanWaker.png	', N'XXL', N'Đen', N'DM003', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP005', N'Áo Hoodie Essentials', 44, 250000, N'src\ImgSp\aohoodientisal.jpg', N'M', N'Trắng', N'DM003', 220000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP006', N'Áo Hoodie Essentials', 34, 500000, N'QLBH\src\ImgSp\aohoodientisal.jpg', N'XXL', N'Đen', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP007', N'Áo Hoodie Essentials', 48, 500000, N'src\ImgSp\aohoodientisal.jpg', N'L', N'Trắng', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP008', N'Quần Jeans Nam Đại Bàng', 99, 350000, N'src\ImgSp\quanJean_daibang.png', N'L', N'Trắng', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP009', N'Quần Jeans Nam Đại Bàng', 234, 350000, N'src\ImgSp\quanJean_daibang.png', N'M', N'Trắng', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP010', N'Quần Jeans Nam Đại Bàng', 30, 350000, N'src\ImgSp\quanJean_daibang.png', N'S', N'Đen', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP011', N'Quần Jeans Nam Đại Bàng', 35, 350000, N'src\ImgSp\quanJean_daibang.png', N'XXL', N'Xanh', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP012', N'Quần Jeans Nam Đại Bàng', 45, 350000, N'src\ImgSp\quanJean_daibang.png', N'L', N'Trắng', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP013', N'Quần Jeans Nam Đại Bàng', 45, 350000, N'src\ImgSp\quanJean_daibang.png', N'M', N'Trắng', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP014', N'Áo Hoodie AlenWarker', 500, 500000, N'src\ImgSp\aohoodieAlanWaker.png', N'M', N'Trắng', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP015', N'Áo Hoodie AlenWarker', 45, 400000, N'src\ImgSp\aohoodieAlanWaker.png', N'L', N'Trắng', N'DM003', 370000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP016', N'Áo Hoodie AlenWarker', 55, 500000, N'src\ImgSp\aohoodieAlanWaker.png', N'S', N'Nâu', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP017', N'Áo Hoodie AlenWarker', 46, 350000, N'src\ImgSp\aohoodieAlanWaker.png	', N'XXL', N'Đen', N'DM003', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP018', N'Áo Hoodie Essentials', 45, 250000, N'src\ImgSp\aohoodientisal.jpg', N'M', N'Trắng', N'DM003', 220000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP019', N'Áo Hoodie Essentials', 34, 500000, N'QLBH\src\ImgSp\aohoodientisal.jpg', N'XXL', N'Đen', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP020', N'Áo Hoodie Essentials', 48, 500000, N'src\ImgSp\aohoodientisal.jpg', N'L', N'Trắng', N'DM003', 470000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP021', N'Quần Jeans Nam Đại Bàng', 100, 350000, N'src\ImgSp\quanJean_daibang.png', N'L', N'Trắng', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP022', N'Quần Jeans Nam Đại Bàng', 234, 350000, N'src\ImgSp\quanJean_daibang.png', N'M', N'Trắng', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP023', N'Quần Jeans Nam Đại Bàng', 30, 350000, N'src\ImgSp\quanJean_daibang.png', N'S', N'Đen', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP024', N'Quần Jeans Nam Đại Bàng', 35, 350000, N'src\ImgSp\quanJean_daibang.png', N'XXL', N'Xanh', N'DM007', 320000.0000)
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [SoLuong], [DonGia], [HinhAnh], [Size], [MauSac], [MaLoai], [GiaNhap]) VALUES (N'SP026', N'Quần Jeans Nam Đại Bàng', 45, 350000, N'src\ImgSp\quanJean_daibang.png', N'M', N'Trắng', N'DM007', 320000.0000)
GO
INSERT [dbo].[TaiKhoan] ([TenTaiKhoan], [MatKhau], [TenQuyen], [TrangThau], [MaNV]) VALUES (N'19444531', N'12345678', N'Quản lý', N'hoạt động', N'NV001')
INSERT [dbo].[TaiKhoan] ([TenTaiKhoan], [MatKhau], [TenQuyen], [TrangThau], [MaNV]) VALUES (N'tandang123', N'12345678', N'nhân viên', N'hoạt động', N'NV002')
GO
ALTER TABLE [dbo].[CaLam] ADD  CONSTRAINT [IDCL]  DEFAULT ([DBO].[AUTO_IDCL]()) FOR [MaCa]
GO
ALTER TABLE [dbo].[ChucVu] ADD  CONSTRAINT [IDCV]  DEFAULT ([DBO].[AUTO_IDCV]()) FOR [MaCV]
GO
ALTER TABLE [dbo].[DanhMucSP] ADD  CONSTRAINT [IDDM]  DEFAULT ([DBO].[AUTO_IDDM]()) FOR [MaLoai]
GO
ALTER TABLE [dbo].[HDBanHang] ADD  CONSTRAINT [IDHDBH]  DEFAULT ([DBO].[AUTO_IDHDBH]()) FOR [MaHD]
GO
ALTER TABLE [dbo].[HDNhapHang] ADD  CONSTRAINT [IDHDNH]  DEFAULT ([DBO].[AUTO_IDHDNH]()) FOR [MaHDNhap]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [IDKH]  DEFAULT ([DBO].[AUTO_IDKH]()) FOR [MaKH]
GO
ALTER TABLE [dbo].[NhaCC] ADD  CONSTRAINT [IDNCC]  DEFAULT ([DBO].[AUTO_IDNCC]()) FOR [MaNCC]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [IDNV]  DEFAULT ([DBO].[AUTO_IDNV]()) FOR [MaNV]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [IDSP]  DEFAULT ([DBO].[AUTO_IDSP]()) FOR [MaSP]
GO
ALTER TABLE [dbo].[CaLam]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[CT_HoaDonBanHang]  WITH CHECK ADD FOREIGN KEY([MaHD])
REFERENCES [dbo].[HDBanHang] ([MaHD])
GO
ALTER TABLE [dbo].[CT_HoaDonBanHang]  WITH CHECK ADD FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[CT_HoaDonNhap]  WITH CHECK ADD FOREIGN KEY([MaHDNhap])
REFERENCES [dbo].[HDNhapHang] ([MaHDNhap])
GO
ALTER TABLE [dbo].[CT_HoaDonNhap]  WITH CHECK ADD FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[HDBanHang]  WITH CHECK ADD FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HDBanHang]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HDNhapHang]  WITH CHECK ADD FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCC] ([MaNCC])
GO
ALTER TABLE [dbo].[HDNhapHang]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([MaCV])
REFERENCES [dbo].[ChucVu] ([MaCV])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([MaLoai])
REFERENCES [dbo].[DanhMucSP] ([MaLoai])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
USE [master]
GO
ALTER DATABASE [QLBHDAD] SET  READ_WRITE 
GO
