-- Adminer 4.8.1 MySQL 5.5.5-10.6.5-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `db_tugas2`;
CREATE DATABASE `db_tugas2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `db_tugas2`;

DROP TABLE IF EXISTS `matakuliah`;
CREATE TABLE `matakuliah` (
  `matkul_kode` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `matkul_nama` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `matkul_sks` tinyint(4) NOT NULL,
  `matkul_kode_prasyarat` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `matakuliah` (`matkul_kode`, `matkul_nama`, `matkul_sks`, `matkul_kode_prasyarat`) VALUES
('PG061',	'Pemrograman Berorientasi Obyek',	3,	'S3'),
('EK066',	'Entrepreneurship',	2,	'T2'),
('IF075',	'Proses Bisnis Dan Sistem Informasi',	3,	'T1'),
('KP130',	'Perancangan Basis Data',	3,	'T1'),
('KP002',	'Algoritma Dan Struktur Data 1',	3,	'S1');

-- 2022-02-23 08:07:09
