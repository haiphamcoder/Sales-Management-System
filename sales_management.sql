-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 13, 2023 at 11:12 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sales_management`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Accounts_Check` (IN `pUsername` VARCHAR(50) CHARSET utf8, IN `pPassword` VARCHAR(50) CHARSET utf8)   BEGIN
	SELECT * FROM `accounts` WHERE Username=pUsername AND Password=PASSWORD(pPassword);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Customer_Add` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDiaChi` VARCHAR(50) CHARSET utf8, IN `pSDT` VARCHAR(50) CHARSET utf8)   BEGIN
	INSERT INTO `customer`(`Ma`, `Ten`, `DiaChi`, `SDT`) VALUES (pMa,pTen,pDiaChi,pSDT);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Customer_Check` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
SELECT *FROM `customer` WHERE Ma=pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Customer_Delete` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
DELETE FROM `customer` WHERE pMa=Ma;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Customer_GetAll` ()   BEGIN
	SELECT * FROM customer;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Customer_Update` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDiaChi` VARCHAR(50) CHARSET utf8, IN `pSDT` VARCHAR(50) CHARSET utf8)   BEGIN
UPDATE `customer` SET `Ma`=pMa,`Ten`=pTen,`DiaChi`=pDiaChi,`SDT`=pSDT WHERE Ma=pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Employee_Add` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pHoTen` VARCHAR(50) CHARSET utf8, IN `pDiaChi` VARCHAR(50) CHARSET utf8, IN `pSDT` VARCHAR(50) CHARSET utf8, IN `pChucVu` VARCHAR(50) CHARSET utf8, IN `pNgaySinh` VARCHAR(50) CHARSET utf8, IN `pNgayLam` VARCHAR(50) CHARSET utf8, IN `pGioiTinh` VARCHAR(50) CHARSET utf8)   BEGIN
INSERT INTO `employee`(`MaNV`, `HoTenNV`, `DiaChiNV`, `SdtNV`, `ChucVu`, `NgaySinh`, `NgayLamViec`, `GioiTinh`) VALUES (pMa,pHoTen,pDiaChi,pSDT,pChucVu,pNgaySinh,pNgayLam,pGioiTinh);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Employee_Check` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
SELECT *FROM `employee` WHERE MaNV=pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Employee_Delete` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
DELETE FROM `employee` WHERE MaNV=pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Employee_GetAll` ()   BEGIN
	SELECT * FROM employee;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Employee_Update` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDiaChi` VARCHAR(50) CHARSET utf8, IN `pSDT` VARCHAR(50) CHARSET utf8, IN `pChucVu` VARCHAR(50) CHARSET utf8, IN `pNgaySinh` VARCHAR(50) CHARSET utf8, IN `pNgayLam` VARCHAR(50) CHARSET utf8, IN `pGioiTinh` VARCHAR(50) CHARSET utf8)   BEGIN
UPDATE `employee` SET `MaNV`=pMa,`HoTenNV`=pTen,`DiaChiNV`=pDiaChi,`SdtNV`=pSDT,`ChucVu`=pChucVu,`NgaySinh`=pNgaySinh,`NgayLamViec`=pNgayLam,`GioiTinh`=pGioiTinh WHERE MaNV= pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Product_Add` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDonVi` VARCHAR(50) CHARSET utf8, IN `pLoai` VARCHAR(50) CHARSET utf8, IN `pHan` VARCHAR(50) CHARSET utf8, IN `pGia` VARCHAR(50) CHARSET utf8, IN `pSoLuong` VARCHAR(50) CHARSET utf8)   BEGIN
	INSERT INTO `product`(`Ma`, `Ten`, `DonVi`, `Loai`, `Han`,`Gia`,`SoLuong`) VALUES (pMa ,pTen,pDonVi,pLoai,pHan,pGia,pSoLuong);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Product_Check` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
	SELECT * FROM `product` WHERE Ma=pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Product_Delete` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
	DELETE FROM `product` WHERE Ma = pMA;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Product_GetAll` ()   BEGIN
	SELECT * FROM product;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Product_Update` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDonVi` VARCHAR(50) CHARSET utf8, IN `pLoai` VARCHAR(50) CHARSET utf8, IN `pHan` VARCHAR(50) CHARSET utf8, IN `pGia` VARCHAR(50) CHARSET utf8, IN `pSoLuong` VARCHAR(50) CHARSET utf8)   BEGIN
	UPDATE `product` SET `Ma`=pMa,`Ten`=pTen,`DonVi`=pDonVi,`Loai`=pLoai,`han`=pHan,`Gia`=pGia,`SoLuong`=pSoLuong
WHERE Ma = pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Supplier_Add` (IN `pMA` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDiaChi` VARCHAR(50) CHARSET utf8, IN `pSoDienThoai` VARCHAR(50) CHARSET utf8, IN `pSoTaiKhoan` VARCHAR(50) CHARSET utf8)   BEGIN
	INSERT INTO `supplier`(`Ma`, `Ten`, `DiaChi`, `SoDienThoai`, `SoTaiKhoan`) VALUES (pMa ,pTen,pDiaChi,pSoDienThoai,pSoTaiKhoan);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Supplier_Check` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
	SELECT * FROM `supplier` WHERE Ma=pMa;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Supplier_Delete` (IN `pMa` VARCHAR(50) CHARSET utf8)   BEGIN
	DELETE FROM `supplier` WHERE Ma = pMA;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Supplier_GetAll` ()   BEGIN
	SELECT * FROM supplier;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Supplier_Update` (IN `pMa` VARCHAR(50) CHARSET utf8, IN `pTen` VARCHAR(50) CHARSET utf8, IN `pDiaChi` VARCHAR(50) CHARSET utf8, IN `pSoDienThoai` VARCHAR(50) CHARSET utf8, IN `pSoTaiKhoan` VARCHAR(50) CHARSET utf8)   BEGIN
	UPDATE `supplier` SET `Ma`=pMa,`Ten`=pTen,`DiaChi`=pDiaChi,`SoDienThoai`=pSoDienThoai,`SoTaiKhoan`=pSoTaiKhoan WHERE Ma = pMa;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`Username`, `Password`, `Type`, `Email`) VALUES
('admin', '*4ACFE3202A5FF5CF467898FC58AAB1D615029441', 'Admin', 'admin@admin');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Ma` varchar(50) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `SDT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `MaNV` varchar(50) NOT NULL,
  `HoTenNV` varchar(50) NOT NULL,
  `DiaChiNV` varchar(50) NOT NULL,
  `SdtNV` varchar(50) NOT NULL,
  `ChucVu` varchar(50) NOT NULL,
  `NgaySinh` varchar(50) NOT NULL,
  `NgayLamViec` varchar(50) NOT NULL,
  `GioiTinh` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `Ma` varchar(50) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DonVi` varchar(50) NOT NULL,
  `Loai` varchar(50) NOT NULL,
  `Han` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `SoLuong` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Ma` varchar(50) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `SoDienThoai` varchar(50) NOT NULL,
  `SoTaiKhoan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Ma`, `Ten`, `DiaChi`, `SoDienThoai`, `SoTaiKhoan`) VALUES
('20207587', 'Phạm Thanh Bình', 'Nam Định', '0979633868', '9776463573'),
('20207630', 'Nguyễn Duy Thái', 'Hà Đông - Hà Nội', '66771508', '66771508'),
('20207601', 'Phạm Ngọc Hải ', 'Vụ Bản - Nam Định', '0776463573', '01234567');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
