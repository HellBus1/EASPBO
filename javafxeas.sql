-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2019 at 04:57 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javafxeas`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang_javaku`
--

CREATE TABLE `barang_javaku` (
  `id_barangs` int(10) NOT NULL,
  `nama_barangs` varchar(100) DEFAULT NULL,
  `kode_barangs` varchar(100) DEFAULT NULL,
  `harga_barangs` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang_javaku`
--

INSERT INTO `barang_javaku` (`id_barangs`, `nama_barangs`, `kode_barangs`, `harga_barangs`) VALUES
(2, 'Tango', 'A002', '5000'),
(3, 'Cabe', 'A001', '8000');

-- --------------------------------------------------------

--
-- Table structure for table `users_javaku`
--

CREATE TABLE `users_javaku` (
  `id_users` int(10) NOT NULL,
  `nama_users` varchar(100) DEFAULT NULL,
  `password_users` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_javaku`
--

INSERT INTO `users_javaku` (`id_users`, `nama_users`, `password_users`) VALUES
(1, 'syubbans1', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang_javaku`
--
ALTER TABLE `barang_javaku`
  ADD PRIMARY KEY (`id_barangs`);

--
-- Indexes for table `users_javaku`
--
ALTER TABLE `users_javaku`
  ADD PRIMARY KEY (`id_users`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang_javaku`
--
ALTER TABLE `barang_javaku`
  MODIFY `id_barangs` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users_javaku`
--
ALTER TABLE `users_javaku`
  MODIFY `id_users` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
