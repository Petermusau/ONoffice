-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2019 at 09:38 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `office`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_table`
--

CREATE TABLE `login_table` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_table`
--

INSERT INTO `login_table` (`id`, `username`, `email`, `phone_number`, `password`) VALUES
(1, 'peter', 'petermusau@gmail.com', '0758306702', '123'),
(4, 'mike', 'mike@gmail.com', '0759152661', 'mike'),
(5, 'Onyango', 'phettyandrew@gmail.com', '0758645732', '23'),
(9, 'musa', 'w@gmail.com', '078883336', 'we'),
(10, 'mikembevo', 'mikembevo@gmail.com', '0759152661', 'mike1999'),
(11, 'uu', 'p@gmail.com', '088', 'p');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_table`
--
ALTER TABLE `login_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_table`
--
ALTER TABLE `login_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
