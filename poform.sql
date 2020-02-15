-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2020 at 04:48 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `poform`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_tbl`
--

CREATE TABLE `account_tbl` (
  `username` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL,
  `fullname` varchar(225) NOT NULL,
  `acct_date` varchar(225) NOT NULL,
  `acct_time` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_tbl`
--

INSERT INTO `account_tbl` (`username`, `password`, `fullname`, `acct_date`, `acct_time`) VALUES
('admin', 'open', 'crispin uriarte', '11/09/2019', '4:58'),
('test', 'test', 'test', '10/24/2019', '8:37:09');

-- --------------------------------------------------------

--
-- Table structure for table `admin_emp_tbl`
--

CREATE TABLE `admin_emp_tbl` (
  `Position` varchar(225) NOT NULL,
  `Name` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_tbl`
--

CREATE TABLE `employee_tbl` (
  `ID_Number` varchar(225) NOT NULL,
  `Full_Name` varchar(225) NOT NULL,
  `Contact` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `Position` varchar(225) NOT NULL,
  `Date_hire` varchar(225) NOT NULL,
  `Status` varchar(225) NOT NULL,
  `Salary` varchar(225) NOT NULL,
  `Allowance` varchar(225) NOT NULL,
  `SSS` varchar(225) NOT NULL,
  `Philhealth` varchar(225) NOT NULL,
  `Pag_ibig` varchar(225) NOT NULL,
  `ATMnum` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_tbl`
--

INSERT INTO `employee_tbl` (`ID_Number`, `Full_Name`, `Contact`, `Address`, `Position`, `Date_hire`, `Status`, `Salary`, `Allowance`, `SSS`, `Philhealth`, `Pag_ibig`, `ATMnum`) VALUES
('00002', 'Joule Heinrich N. Surposa', '123381238', 'mabuhay', 'Book Encoder', '2005-11-08', 'Regular', '370', '1000', 'ssstest', 'phtest', 'pagibigtest', 'atmnum1'),
('00003', 'Rizalina V. Surposa', '2312', '3123123', 'General Manager', '2019-11-12', 'Regular', '850', '1000', '1234354646', '123243543', '213143546', '1231243543'),
('00004', 'Alma Grace Aboga-a', '143545', '324324', 'HR Head', '2019-11-17', 'Regular', '450', '500', '32143543', '313325', '23423', '5765767876'),
('00005', 'Jessica Alvarez', '123534654', '324234234', 'HR Assistant', '2019-11-10', 'Probationary', '385', '500', '34254654', '423456576', '35465765', '233454654'),
('00006', 'Nicole Pearl V. Mamingo', '2565765', '234354', 'HR Assistant', '2019-11-19', 'Probationary', '385', '500', '324654765', '97886756456', '0879786755', '096786787'),
('00009', 'Dave Alvarez', '8576477', '564576765', 'Book Encoder', '2019-11-18', 'Part-Time', '370', '500', '47684', '374678567', '356468', '367856'),
('00010', 'Cherry Mae Matilano', '676856', '5647676', 'Accounting Staff', '2019-11-19', 'Regular', '365.0', '500', '567467', '574674567', '56745674', '5674567456'),
('00011', 'Jhonna Eusebio', '47474', '45636', 'Accounting Staff', '2019-11-28', 'Regular', '350.0', '500', '63466768657', '75647646', '54675467', '5464624'),
('00012', 'Hicy D. Feliciano', '637375647', '567456754', 'Accounting Staff', '2019-11-18', 'Regular', '350.0', '500', '5674567547', '57567', '43546357', '35435'),
('00016', 'Jenny C. Olarte', '657357', '34534543', 'Book Encoder', '2019-11-19', 'Probationary', '370', '500', '32543252345', '57657547', '25665375', '2645678');

-- --------------------------------------------------------

--
-- Table structure for table `estab_tbl`
--

CREATE TABLE `estab_tbl` (
  `Date` varchar(225) NOT NULL,
  `POnum` varchar(225) NOT NULL,
  `Establishment` varchar(225) NOT NULL,
  `Unit` varchar(225) NOT NULL,
  `Date_return` varchar(225) NOT NULL,
  `Date_release` varchar(225) NOT NULL,
  `Release_to` varchar(225) NOT NULL,
  `Remarks` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estab_tbl`
--

INSERT INTO `estab_tbl` (`Date`, `POnum`, `Establishment`, `Unit`, `Date_return`, `Date_release`, `Release_to`, `Remarks`) VALUES
('11/06/2019', 'A0090', 'TSB Auto Supply', 'FX Blue', '', '09/07/2019', 'Pallero', 'Used'),
('11/06/2019', 'A0091', 'TSB Auto Supply', 'FX Red', '', '09/07/2019', 'Cyril', 'Used'),
('11/06/2019', 'A0092', 'TSB Auto Supply', 'FX White', '', '08/09/2019', 'Camille', 'Used'),
('11/06/2019', 'A0093', 'TSB Auto Supply', 'Adventure Blue', '', '10/04/2019', 'Jhong2x', 'Used'),
('10/03/2019', 'A0094', 'TSB Auto Supply', 'FX White', '', '10/05/2019', 'cyril', 'Used'),
('10/04/2019', 'A0095', 'TSB Auto Supply', 'FX Red', '', '08/03/2019', 'Cyril', 'Used'),
('10/03/2019', 'A0096', 'TSB Auto Supply', 'Adventure Blue', '', '10/08/2019', 'Pallero', 'Used'),
('10/03/2019', 'A0097', 'TSB Auto Supply', 'FX Red', '', '10/18/2019', 'Pallero', 'Used'),
('10/03/2019', 'A0098', 'TSB Auto Supply', 'FX Red', '', '10/18/2019', 'Pallero', 'Used'),
('10/03/2019', 'A0099', 'TSB Auto Supply', 'FX Blue', '', '11/04/2019', 'Adrianne', 'Used'),
('10/03/2019', 'A0100', 'TSB Auto Supply', 'Car Freshener', '', '11/06/2019', 'Sir Joule', 'Used'),
('10/03/2019', 'A0101', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('10/03/2019', 'A0102', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('10/03/2019', 'A0103', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('10/03/2019', 'A0104', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'A0105', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'A0106', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'A0107', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'A0108', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'A0109', 'TSB Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'B0216', 'Ken Motor', 'Oil', '', '09/07/2019', 'Phonics', 'Used'),
('11/06/2019', 'B0217', 'Ken Motor', 'Bajaj 18', '', '09/07/2019', 'Adong', 'Used'),
('11/06/2019', 'B0218', 'Ken Motor', 'Bajaj #16', '', '09/07/2019', 'Ivan', 'Used'),
('11/06/2019', 'B0219', 'Ken Motor', 'XR #3', '', '09/07/2019', 'Daniel', 'Used'),
('11/06/2019', 'B0220', 'Ken Motor', 'Bajaj #12', '', '09/07/2019', 'Marnel', 'Used'),
('11/06/2019', 'B0221', 'Ken Motor', 'Bajaj #14', '', '09/07/2019', 'Adrian', 'Used'),
('11/06/2019', 'B0222', 'Ken Motor', 'Bajaj #9', '', '09/07/2019', 'Oracion', 'Used'),
('11/06/2019', 'B0223', 'Ken Motor', 'Bajaj #13', '', '09/07/2019', 'Eduardo', 'Used'),
('11/06/2019', 'B0224', 'Ken Motor', 'XRM', '', '09/07/2019', 'Bautista', 'Used'),
('11/06/2019', 'B0225', 'Ken Motor', 'Bajaj #15', '', '09/07/2019', 'Baguio', 'Used'),
('11/06/2019', 'B0226', 'Ken Motor', 'Bajaj #6', '', '09/07/2019', 'Tile-tile', 'Used'),
('11/06/2019', 'B0227', 'Ken Motor', 'Bajaj #11', '', '09/07/2019', 'Gallobe', 'Used'),
('11/06/2019', 'B0228', 'Ken Motor', 'Bajaj #11', '', '09/09/2019', 'Pallero', 'Used'),
('11/06/2019', 'B0229', 'Ken Motor', 'Office', '', '09/09/2019', 'Mark', 'Used'),
('11/06/2019', 'B0230', 'Ken Motor', 'Bajaj #11', '', '09/09/2019', 'Gallobe', 'Used'),
('11/06/2019', 'B0231', 'Ken Motor', 'XTZ', '', '10/05/2019', 'Pallero', 'Used'),
('10/03/2019', 'B0232', 'Ken Motor', 'Oil', '', '10/05/2019', 'Phonics', 'Used'),
('10/03/2019', 'B0233', 'Ken Motor', 'Bajaj #18', '', '10/05/2019', 'Alvin', 'Used'),
('10/03/2019', 'B0234', 'Ken Motor', 'Bajaj #15', '', '10/05/2019', 'Baguio', 'Used'),
('10/03/2019', 'B0235', 'Ken Motor', 'Bajaj #06', '', '10/05/2019', 'Brylle Tile-tile', 'Used'),
('10/03/2019', 'B0236', 'Ken Motor', 'Bajaj #12', '', '10/05/2019', 'Marnel', 'Used'),
('10/03/2019', 'B0237', 'Ken Motor', 'XRM', '', '10/05/2019', 'Bautista', 'Used'),
('10/03/2019', 'B0238', 'Ken Motor', 'XR125', '', '10/05/2019', 'Daniel', 'Used'),
('10/03/2019', 'B0239', 'Ken Motor', 'Bajaj #9', '', '10/05/2019', 'Oracion', 'Used'),
('10/03/2019', 'B0240', 'Ken Motor', 'Bajaj #18', '', '10/05/2019', 'Castro', 'Used'),
('10/03/2019', 'B0241', 'Ken Motor', 'Bajaj #16', '', '10/05/2019', 'Ivan', 'Used'),
('10/03/2019', 'B0242', 'Ken Motor', 'Bajaj #11', '', '10/05/2019', 'Gallobe', 'Used'),
('10/03/2019', 'B0243', 'Ken Motor', 'Bajaj #13', '', '10/07/2019', 'Eduardo', 'Used'),
('10/03/2019', 'B0244', 'Ken Motor', 'XTZ White', '', '10/10/2019', 'Phonics', 'Used'),
('10/03/2019', 'B0245', 'Ken Motor', 'Bajaj #07', '', '10/11/2019', 'Bayato', 'Used'),
('10/03/2019', 'B0246', 'Ken Motor', 'CBR-A5', '', '10/11/2019', 'Lino', 'Used'),
('10/03/2019', 'B0247', 'Ken Motor', 'XTZ White', '', '10/15/2019', 'Jhong2x', 'Used'),
('10/03/2019', 'B0248', 'Ken Motor', 'Bajaj #07', '', '11/04/2019', 'Limutin', 'Used'),
('11/06/2019', 'B0249', 'Ken Motor', 'CB-2', '', '11/04/2019', 'Mark M.', 'Used'),
('11/06/2019', 'C0026', 'Pinoy Bossing Tyre Center', 'FX Red', '', '09/07/2019', 'Cyril', 'Used'),
('11/06/2019', 'C0027', 'Pinoy Bossing Tyre Center', 'FX-Blue', '', '09/07/2019', 'Pallero', 'Used'),
('11/06/2019', 'C0028', 'Pinoy Bossing Tyre Center', 'FX Blue', '', '09/09/2019', 'Camillle', 'Used'),
('10/03/2019', 'C0029', 'Pinoy Bossing Tyre Center', 'Revo', '', '10/14/2019', 'Garry', 'Used'),
('10/03/2019', 'C0030', 'Pinoy Bossing Tyre Center', 'FX White', '', '11/04/2019', 'Cyril', 'Used'),
('10/03/2019', 'C0031', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0032', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0033', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0034', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0035', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0036', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0037', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0038', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0039', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'C0040', 'Pinoy Bossing Tyre Center', '', '', '', '', 'Unused'),
('10/03/2019', 'D0009', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0010', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0011', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0012', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0013', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0014', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0015', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0016', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0017', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0018', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0019', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'D0020', 'Gensan Ultimate Auto Suppy', '', '', '', '', 'Unused'),
('10/03/2019', 'E0009', 'Viajero Motorsales', 'Bajaj #07', '', '11/04/2019', 'Limutin', 'Used'),
('10/03/2019', 'E0010', 'Viajero Motorsales', 'Tile-tile/Eduardo/Esguera', '', '10/05/2019', 'Tile-tile/Eduardo/Esguera', 'Used'),
('10/03/2019', 'E0011', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0012', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0013', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0014', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0015', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0016', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0017', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0018', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0019', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('10/03/2019', 'E0020', 'Viajero Motorsales', '', '', '', '', 'Unused'),
('11/06/2019', 'F0057', 'Gensan Aurora Auto Supply', 'FX Blue', '', '09/07/2019', 'Pallero', 'Used'),
('11/06/2019', 'F0058', 'Gensan Aurora Auto Supply', 'FX Red', '', '09/07/2019', 'Cyril', 'Used'),
('11/06/2019', 'F0059', 'Gensan Aurora Auto Supply', '', '', '09/08/2019', 'Office', 'Used'),
('11/06/2019', 'F0060', 'Gensan Aurora Auto Supply', 'FX White', '', '09/09/2019', 'Cyril', 'Used'),
('10/03/2019', 'F0061', 'Gensan Aurora Auto Supply', 'Adventure Blue', '', '10/08/2019', 'Pallero', 'Used'),
('10/03/2019', 'F0062', 'Gensan Aurora Auto Supply', 'Revo, FX Blue, FX White', '', '10/07/2019', 'Garry', 'Used'),
('10/03/2019', 'F0063', 'Gensan Aurora Auto Supply', 'Adventure Red', '', '10/05/2019', 'Nadeth', 'Used'),
('10/03/2019', 'F0064', 'Gensan Aurora Auto Supply', 'Revo', '', '10/05/2019', 'Garry', 'Used'),
('10/03/2019', 'F0065', 'Gensan Aurora Auto Supply', 'Adventure Blue', '', '10/22/2019', 'Sir Joule', 'Used'),
('10/03/2019', 'F0066', 'Gensan Aurora Auto Supply', 'Adventure Blue', '', '10/22/2019', 'Pallero', 'Used'),
('10/03/2019', 'F0067', 'Gensan Aurora Auto Supply', '', '', '', 'Sir Joule', 'Unused'),
('10/03/2019', 'F0068', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused'),
('10/03/2019', 'F0069', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'F0070', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'F0071', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'F0072', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'F0073', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused'),
('11/06/2019', 'F0074', 'Gensan Aurora Auto Supply', '', '', '', '', 'Unused');

-- --------------------------------------------------------

--
-- Table structure for table `inactive_tbl`
--

CREATE TABLE `inactive_tbl` (
  `Date` varchar(225) NOT NULL,
  `ID_Number` varchar(225) NOT NULL,
  `Full_Name` varchar(225) NOT NULL,
  `Contact` varchar(225) NOT NULL,
  `Address` varchar(225) NOT NULL,
  `Position` varchar(225) NOT NULL,
  `Date_hire` varchar(225) NOT NULL,
  `Status` varchar(225) NOT NULL,
  `Salary` varchar(225) NOT NULL,
  `Allowance` varchar(225) NOT NULL,
  `SSS` varchar(225) NOT NULL,
  `Philhealth` varchar(225) NOT NULL,
  `Pag_ibig` varchar(225) NOT NULL,
  `ATMnum` varchar(225) NOT NULL,
  `Reason` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inactive_tbl`
--

INSERT INTO `inactive_tbl` (`Date`, `ID_Number`, `Full_Name`, `Contact`, `Address`, `Position`, `Date_hire`, `Status`, `Salary`, `Allowance`, `SSS`, `Philhealth`, `Pag_ibig`, `ATMnum`, `Reason`) VALUES
('11/10/2019', '00007', 'Charie Mae Odango', '', '', 'Book Encoder', '', 'Probationary', '370', '', '', '', '', '', 'Resign'),
('11/10/2019', '00013', 'Jorgie T. Lozada', '', '', 'Accounting Staff', '', 'Probationary', '320', '', '', '', '', '', 'Resign'),
('11/10/2019', '00015', 'Jerry Deypalubos', '', '', 'MIS Staff', '', 'Probationary', '385', '', '', '', '', '', 'Resign'),
('11/10/2019', '00008', 'Jessy Love Dabucol', '', '', 'Book Encoder', '', 'Probationary', '370', '', '', '', '', '', 'Resign'),
('11/23/2019', '00001', 'Crispin Jose M. Uriarte', '09776794658', '37th IB Military Village Brgy. Fatima, G.S.C.', 'MIS Staff', '2019-08-24', 'Probationary', '385', '500', '1sss', '1ph', '1pi', '1at', 'Resign'),
('12/09/2019', '00014', 'Kathleen Grace Pauline Sibonga', '54657567', '35245235', 'Accounting Staff', '2019-11-19', 'Probationary', '320', '500', '53453265475', '52676354', '35346576', '34534534', 'Resign');

-- --------------------------------------------------------

--
-- Table structure for table `info_estab_tbl`
--

CREATE TABLE `info_estab_tbl` (
  `e_date` varchar(225) NOT NULL,
  `e_establishment` varchar(225) NOT NULL,
  `e_contact` varchar(225) NOT NULL,
  `e_address` varchar(225) NOT NULL,
  `e_description` varchar(225) NOT NULL,
  `e_letter` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info_estab_tbl`
--

INSERT INTO `info_estab_tbl` (`e_date`, `e_establishment`, `e_contact`, `e_address`, `e_description`, `e_letter`) VALUES
('10/02/2019', 'Gensan Aurora Auto Supply', 'input', 'input', 'input', 'F'),
('10/02/2019', 'Gensan Ultimate Auto Suppy', 'input', 'input', 'input', 'D'),
('10/02/2019', 'Ken Motor', 'input', 'input', 'Input', 'B'),
('10/02/2019', 'Pinoy Bossing Tyre Center', 'input', 'input', 'input', 'C'),
('10/02/2019', 'TSB Auto Supply', 'input', 'input', 'input', 'A'),
('10/08/2019', 'Viajero Motorsales', 'input', 'input', 'input', 'E');

-- --------------------------------------------------------

--
-- Table structure for table `inv_entry_tbl`
--

CREATE TABLE `inv_entry_tbl` (
  `entry_id` int(11) NOT NULL,
  `date_entry` varchar(225) NOT NULL,
  `description` varchar(225) NOT NULL,
  `item_name` varchar(225) NOT NULL,
  `type` varchar(225) NOT NULL,
  `update_date` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inv_entry_tbl`
--

INSERT INTO `inv_entry_tbl` (`entry_id`, `date_entry`, `description`, `item_name`, `type`, `update_date`) VALUES
(1, '11/10/2019', '', '1/2 Lenghwise paper', '', '11/10/2019'),
(3, '11/10/2019', '', 'American Map', '', '11/10/2019'),
(4, '11/10/2019', '', 'American Paper Short', '', '11/10/2019'),
(5, '11/10/2019', '', 'Backbone', '', '11/10/2019'),
(6, '11/10/2019', '', 'Ballpen (Black)', '', '11/10/2019'),
(7, '11/10/2019', '', 'Ballpen (Red)', '', '11/10/2019'),
(8, '11/10/2019', '', 'Ballpen (refill-black)', '', '11/10/2019'),
(9, '11/10/2019', '', 'Ballpen (refill-red)', '', '11/10/2019'),
(10, '11/10/2019', '', 'Binder clip (BIG)', '', '11/10/2019'),
(11, '11/10/2019', '', 'Binder clip (MEDIUM)', '', '11/10/2019'),
(12, '11/10/2019', '', 'Binder clip (SMALL)', '', '11/10/2019'),
(13, '11/10/2019', '', 'Bond Paper (A4)', '', '11/10/2019'),
(14, '11/10/2019', '', 'Bond Paper (LONG)', '', '11/10/2019'),
(15, '11/10/2019', '', 'Bond Paper (Short)', '', '11/10/2019'),
(16, '11/10/2019', '', 'Book Cover', '', '11/10/2019'),
(17, '11/10/2019', '', 'Brother ink (black)', '', '11/10/2019'),
(18, '11/10/2019', '', 'Brother ink (Cyan)', '', '11/10/2019'),
(19, '11/10/2019', '', 'Brother ink (Magenta)', '', '11/10/2019'),
(20, '11/10/2019', '', 'Brother ink (Yellow)', '', '11/10/2019'),
(21, '11/10/2019', '', 'Brown Envelope (Long)', '', '11/10/2019'),
(22, '11/10/2019', '', 'Brown Envelope (Short)', '', '11/10/2019'),
(23, '11/10/2019', '', 'Brown Extended Folder long', '', '11/10/2019'),
(25, '11/10/2019', '', 'Brown Folder Short', '', '11/10/2019'),
(26, '11/10/2019', '', 'Carbon', '', '11/10/2019'),
(27, '11/10/2019', '', 'Carbon Brush', '', '11/10/2019'),
(28, '11/10/2019', '', 'Clear Book', '', '11/10/2019'),
(29, '11/10/2019', '', 'Color Paper Short', '', '11/10/2019'),
(30, '11/10/2019', '', 'Columnar', '', '11/10/2019'),
(31, '11/10/2019', '', 'Correction Tape', '', '11/10/2019'),
(32, '11/10/2019', '', 'Cutter', '', '11/10/2019'),
(33, '11/10/2019', '', 'Cutter Blade', '', '11/10/2019'),
(34, '11/10/2019', '', 'Date Stamp Big', '', '11/10/2019'),
(35, '11/10/2019', '', 'Date Stamp Small', '', '11/10/2019'),
(36, '11/10/2019', '', 'Delivery Receipt', '', '11/10/2019'),
(37, '11/10/2019', '', 'Double Sided Tape', '', '11/10/2019'),
(38, '11/10/2019', '', 'Duck Tape', '', '11/10/2019'),
(39, '11/10/2019', '', 'Electrical Tape', '', '11/10/2019'),
(40, '11/10/2019', '', 'Envelope (extended)', '', '11/10/2019'),
(41, '11/10/2019', '', 'Envelope (LONG)', '', '11/10/2019'),
(42, '11/10/2019', '', 'Epson ink (black)', '', '11/10/2019'),
(43, '11/10/2019', '', 'Epson ink (cyan)', '', '11/10/2019'),
(44, '11/10/2019', '', 'Epson ink (magenta)', '', '11/10/2019'),
(45, '11/10/2019', '', 'Epson ink (yellow)', '', '11/10/2019'),
(46, '11/10/2019', '', 'Expenses Form', '', '11/10/2019'),
(47, '11/10/2019', '', 'fastener 4', '', '11/10/2019'),
(48, '11/10/2019', '', 'fastener 6', '', '11/10/2019'),
(49, '11/10/2019', '', 'fastener 8', '', '11/10/2019'),
(50, '11/10/2019', '', 'fastener lock', '', '11/10/2019'),
(51, '11/10/2019', '', 'fastener lock (plastic)', '', '11/10/2019'),
(52, '11/10/2019', '', 'Flyleaf', '', '11/10/2019'),
(53, '11/10/2019', '', 'Folder stick (long)', '', '11/10/2019'),
(54, '11/10/2019', '', 'Folder stick (small)', '', '11/10/2019'),
(55, '11/10/2019', '', 'Fuel float', '', '11/10/2019'),
(57, '11/10/2019', '', 'Glue gun', '', '11/10/2019'),
(58, '11/10/2019', '', 'Graphing paper', '', '11/10/2019'),
(59, '11/10/2019', '', 'Gun Tacker medium', '', '11/10/2019'),
(60, '11/10/2019', '', 'Gun Tacker small', '', '11/10/2019'),
(61, '11/10/2019', '', 'Halogen bulb', '', '11/10/2019'),
(62, '11/10/2019', '', 'Hook', '', '11/10/2019'),
(63, '11/10/2019', '', 'HP ink (black)', '', '11/10/2019'),
(64, '11/10/2019', '', 'HP ink (tri-color)', '', '11/10/2019'),
(65, '11/10/2019', '', 'Laminating film', '', '11/10/2019'),
(66, '11/10/2019', '', 'Lead full color rotating lamp', '', '11/10/2019'),
(67, '11/10/2019', '', 'Ledger', '', '11/10/2019'),
(68, '11/10/2019', '', 'Magazine', '', '11/10/2019'),
(69, '11/10/2019', '', 'Manila Paper', '', '11/10/2019'),
(70, '11/10/2019', '', 'Marker Blue', '', '11/10/2019'),
(71, '11/10/2019', '', 'Marker Dark green', '', '11/10/2019'),
(72, '11/10/2019', '', 'Marker pink', '', '11/10/2019'),
(73, '11/10/2019', '', 'Marker violet', '', '11/10/2019'),
(74, '11/10/2019', '', 'Marker yellow green', '', '11/10/2019'),
(75, '11/10/2019', '', 'Nails small', '', '11/10/2019'),
(76, '11/10/2019', '', 'News Print long', '', '11/10/2019'),
(77, '11/10/2019', '', 'Notebook', '', '11/10/2019'),
(78, '11/10/2019', '', 'Notebook (big)', '', '11/10/2019'),
(79, '11/10/2019', '', 'Orange extended folder long', '', '11/10/2019'),
(80, '11/10/2019', '', 'Packaging tape', '', '11/10/2019'),
(81, '11/10/2019', '', 'Paper Tape', '', '11/10/2019'),
(82, '11/10/2019', '', 'Paper Clip', '', '11/10/2019'),
(83, '11/10/2019', '', 'Paste Board', '', '11/10/2019'),
(84, '11/10/2019', '', 'Pencil', '', '11/10/2019'),
(85, '11/10/2019', '', 'Pentelpen (blue)', '', '11/10/2019'),
(86, '11/10/2019', '', 'Photo Glossy paper', '', '11/10/2019'),
(87, '11/10/2019', '', 'Photo paper (matte)', '', '11/10/2019'),
(88, '11/10/2019', '', 'Pilot marker blue (pentel pen)', '', '11/10/2019'),
(89, '11/10/2019', '', 'Pilot refill ink', '', '11/10/2019'),
(90, '11/10/2019', '', 'Plastic folder long', '', '11/10/2019'),
(91, '11/10/2019', '', 'Plastic folder short', '', '11/10/2019'),
(92, '11/10/2019', '', 'Protactor', '', '11/10/2019'),
(93, '11/10/2019', '', 'PVC', '', '11/10/2019'),
(94, '11/10/2019', '', 'Record Book', '', '11/10/2019'),
(95, '11/10/2019', '', 'Rubber Band', '', '11/10/2019'),
(96, '11/10/2019', '', 'Rubber Stamp small', '', '11/10/2019'),
(97, '11/10/2019', '', 'Ruller', '', '11/10/2019'),
(98, '11/10/2019', '', 'Scotch Tape', '', '11/10/2019'),
(99, '11/10/2019', '', 'Screw Bolt', '', '11/10/2019'),
(100, '11/10/2019', '', 'Sharpener', '', '11/10/2019'),
(101, '11/10/2019', '', 'Specialty Board', '', '11/10/2019'),
(102, '11/10/2019', '', 'Stabillo refill', '', '11/10/2019'),
(103, '11/10/2019', '', 'Stabillo Eraser', '', '11/10/2019'),
(104, '11/10/2019', '', 'Stamp Pad (black)', '', '11/10/2019'),
(105, '11/10/2019', '', 'Stamp Pad (red)', '', '11/10/2019'),
(106, '11/10/2019', '', 'Stamp Pad refill ink', '', '11/10/2019'),
(107, '11/10/2019', '', 'Staple Wire (per box)', '', '11/10/2019'),
(108, '11/10/2019', '', 'Staple Wire (Tailoring box)', '', '11/10/2019'),
(109, '11/10/2019', '', 'Staple wire 10mm', '', '11/10/2019'),
(110, '11/10/2019', '', 'Staple wire 15mm', '', '11/10/2019'),
(111, '11/10/2019', '', 'Staple wire 17mm', '', '11/10/2019'),
(112, '11/10/2019', '', 'Statement Envelope', '', '11/10/2019'),
(113, '11/10/2019', '', 'Stretch Film', '', '11/10/2019'),
(114, '11/10/2019', '', 'Tape (black)', '', '11/10/2019'),
(115, '11/10/2019', '', 'Tape (red)', '', '11/10/2019'),
(116, '11/10/2019', '', 'Tape dispenser roller', '', '11/10/2019'),
(117, '11/10/2019', '', 'Thumb tacks', '', '11/10/2019'),
(118, '11/10/2019', '', 'Tower bolt', '', '11/10/2019'),
(119, '11/10/2019', '', 'Transparent fil for I.D', '', '11/10/2019'),
(120, '11/10/2019', '', 'Velom Long 120', '', '11/10/2019'),
(121, '11/10/2019', '', 'White Board', '', '11/10/2019'),
(122, '11/10/2019', '', 'Whiteboard marker', '', '11/10/2019'),
(123, '11/10/2019', '', 'Wrong Entry Duplication', '', '11/10/2019'),
(124, '11/10/2019', '', 'Plastic Folder Chairs (long)', '', '11/10/2019'),
(125, '11/10/2019', '', 'Folder Plastic Table', '', '11/10/2019'),
(126, '11/10/2019', '', 'Folder Plastic Table Long', '', '11/10/2019'),
(127, '11/10/2019', '', 'Hard Book Cover (returned)', '', '11/10/2019');

-- --------------------------------------------------------

--
-- Table structure for table `job_order_tbl`
--

CREATE TABLE `job_order_tbl` (
  `Date_jo` varchar(225) NOT NULL,
  `JOnum_jo` varchar(225) NOT NULL,
  `Company_jo` varchar(225) NOT NULL,
  `Billed_jo` varchar(225) NOT NULL,
  `Unit_jo` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_order_tbl`
--

INSERT INTO `job_order_tbl` (`Date_jo`, `JOnum_jo`, `Company_jo`, `Billed_jo`, `Unit_jo`) VALUES
('10/06/2019', 'JO 0001', 'Joel Electrician', 'Gary', 'Revo'),
('10/06/2019', 'JO 0002', 'Macoy', 'Ma\'am Riz', ' Adventure Blue'),
('10/06/2019', 'JO 0003', 'Jhong2x', 'Ma\'am Riz', 'FX White, Adventure Maroon'),
('10/06/2019', 'JO 0004', 'Edgar Welder', 'Cyril', 'FX White'),
('10/06/2019', 'JO 0005', 'May-may Motor Mechanic', 'Bautista', 'XRM'),
('10/06/2019', 'JO 0006', 'May-may Motor Mechanic', 'Mission', 'Bajaj 18'),
('10/06/2019', 'JO 0007', 'May-may Motor Mechanic', 'Ivan', 'Bajaj 16'),
('10/06/2019', 'JO 0008', 'May-may Motor Mechanic', 'Castro', 'Bajaj 8'),
('10/06/2019', 'JO 0009', 'May-may Motor Mechanic', 'Alim', 'XR Red'),
('10/06/2019', 'JO 0010', 'May-may Motor Mechanic', 'Gallobe', 'Bajaj 11'),
('10/06/2019', 'JO 0011', 'May-may Motor Mechanic', 'Oracion', 'Bajaj 9'),
('10/06/2019', 'JO 0012', 'May-may Motor Mechanic', 'Ernie', 'Raider'),
('10/06/2019', 'JO 0013', 'May-may Motor Mechanic', 'Baguio', 'Bajaj 15'),
('10/06/2019', 'JO 0014', 'May-may Motor Mechanic', 'Marnel', 'Bajaj 12'),
('10/06/2019', 'JO 0015', 'May-may Motor Mechanic', 'Dayem', 'Bajaj 13'),
('10/06/2019', 'JO 0016', 'May-may Motor Mechanic', 'Brylle', 'Bajaj 6'),
('10/09/2019', 'JO 0017', 'Edgar Welding Shop', 'Jhong2x', 'Adventure Blue'),
('10/09/2019', 'JO 0018', 'Nonoy Pintor', 'Jhong2x', 'Adventure Blue'),
('10/10/2019', 'JO 0019', 'Nonoy Talyer', 'Jhong2x', 'Adventure Blue'),
('10/15/2019', 'JO 0020', 'Bentong', 'Office', 'Adventure Blue/Eco'),
('10/21/2019', 'JO 0021', 'Ian Upholstery', 'Office', 'FX Red'),
('10/21/2019', 'JO 0022', 'Bentong', 'Office', 'FX Red'),
('10/30/2019', 'JO 0023', 'May-may Motor Mechanic', 'Office', 'Tricycle'),
('11/05/2019', 'JO 0024', 'May-may Motor Mechanic', 'Jhunell Oracion', 'Bajaj 9'),
('11/15/2019', 'JO 0025', 'May-may Motor Mechanic', 'Reymon Bayato', 'Bajaj 14'),
('11/05/2019', 'JO 0026', 'May-may Motor Mechanic', 'Marnel Montecalvo', 'Bajaj #12'),
('11/05/2019', 'JO 0027', 'May-may Motor Mechanic', 'Rolly Castro', 'Bajaj 8'),
('11/05/2019', 'JO 0028', 'May-may Motor Mechanic', 'Daniel Alim', 'XR'),
('11/05/2019', 'JO 0029', 'May-may Motor Mechanic', 'Felix Esguerra', 'Bajaj 7'),
('11/05/2019', 'JO 0030', 'May-may Motor Mechanic', 'Mark Montecalvo', 'CB-2'),
('11/05/2019', 'JO 0031', 'May-may Motor Mechanic', 'Brylle Jhun Tile-tile', 'CB 5'),
('11/06/2019', 'JO 0032', 'May-may Motor Mechanic', 'Tile-tile, Brylle', 'Bajaj #6'),
('__________', 'JO 0033', '_________________', '_________________', '_________________'),
('__________', 'JO 0034', '_________________', '_________________', '_________________'),
('__________', 'JO 0035', '_________________', '_________________', '_________________'),
('__________', 'JO 0036', '_________________', '_________________', '_________________'),
('__________', 'JO 0037', '_________________', '_________________', '_________________'),
('__________', 'JO 0038', '_________________', '_________________', '_________________'),
('__________', 'JO 0039', '_________________', '_________________', '_________________'),
('__________', 'JO 0040', '_________________', '_________________', '_________________');

-- --------------------------------------------------------

--
-- Table structure for table `log_db`
--

CREATE TABLE `log_db` (
  `acct_name` varchar(225) NOT NULL,
  `date_login` varchar(225) NOT NULL,
  `time_login` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log_db`
--

INSERT INTO `log_db` (`acct_name`, `date_login`, `time_login`) VALUES
('crispin uriarte', '11/12/2019', '3:53:43'),
('crispin uriarte', '11/12/2019', '4:04:09'),
('crispin uriarte', '11/12/2019', '4:10:24'),
('crispin uriarte', '11/12/2019', '4:15:45'),
('crispin uriarte', '11/13/2019', '8:04:44'),
('crispin uriarte', '11/13/2019', '8:11:31'),
('crispin uriarte', '11/13/2019', '8:15:40'),
('crispin uriarte', '11/13/2019', '8:17:52'),
('crispin uriarte', '11/13/2019', '8:20:03'),
('crispin uriarte', '11/13/2019', '8:26:53'),
('crispin uriarte', '11/13/2019', '8:28:09'),
('crispin uriarte', '11/13/2019', '8:35:46'),
('crispin uriarte', '11/13/2019', '8:40:58'),
('crispin uriarte', '11/13/2019', '10:50:42'),
('crispin uriarte', '11/13/2019', '10:55:46'),
('crispin uriarte', '11/13/2019', '11:22:37'),
('crispin uriarte', '11/15/2019', '10:05:51'),
('crispin uriarte', '11/15/2019', '10:44:17'),
('crispin uriarte', '11/15/2019', '10:44:49'),
('__________', '11/15/2019', '1:08:05'),
('__________', '11/15/2019', '1:08:07'),
('crispin uriarte', '11/15/2019', '1:08:10'),
('crispin uriarte', '11/15/2019', '1:16:45'),
('crispin uriarte', '11/15/2019', '1:17:38'),
('crispin uriarte', '11/15/2019', '1:19:22'),
('crispin uriarte', '11/15/2019', '1:20:43'),
('crispin uriarte', '11/15/2019', '1:34:16'),
('crispin uriarte', '11/15/2019', '1:35:17'),
('crispin uriarte', '11/15/2019', '2:17:39'),
('crispin uriarte', '11/15/2019', '3:53:12'),
('crispin uriarte', '11/15/2019', '4:12:05'),
('crispin uriarte', '11/15/2019', '4:16:56'),
('crispin uriarte', '11/15/2019', '4:27:02'),
('crispin uriarte', '11/16/2019', '4:49:27'),
('crispin uriarte', '11/16/2019', '5:29:01'),
('crispin uriarte', '11/16/2019', '5:31:53'),
('__________', '11/16/2019', '5:33:16'),
('crispin uriarte', '11/16/2019', '5:33:20'),
('crispin uriarte', '11/16/2019', '5:36:47'),
('crispin uriarte', '11/16/2019', '5:47:38'),
('crispin uriarte', '11/17/2019', '1:23:01'),
('crispin uriarte', '11/17/2019', '1:26:24'),
('crispin uriarte', '11/17/2019', '1:39:01'),
('crispin uriarte', '11/17/2019', '1:43:55'),
('crispin uriarte', '11/17/2019', '1:58:16'),
('crispin uriarte', '11/17/2019', '2:27:07'),
('crispin uriarte', '11/17/2019', '2:49:12'),
('crispin uriarte', '11/17/2019', '2:52:12'),
('crispin uriarte', '11/17/2019', '2:59:22'),
('crispin uriarte', '11/17/2019', '3:05:48'),
('crispin uriarte', '11/17/2019', '3:40:30'),
('crispin uriarte', '11/17/2019', '3:45:40'),
('crispin uriarte', '11/17/2019', '5:21:33'),
('crispin uriarte', '11/17/2019', '5:27:07'),
('crispin uriarte', '11/17/2019', '5:29:06'),
('crispin uriarte', '11/17/2019', '5:31:09'),
('crispin uriarte', '11/18/2019', '8:22:13'),
('crispin uriarte', '11/18/2019', '8:27:06'),
('crispin uriarte', '11/18/2019', '8:29:31'),
('crispin uriarte', '11/18/2019', '8:32:43'),
('crispin uriarte', '11/18/2019', '8:34:50'),
('crispin uriarte', '11/18/2019', '8:40:46'),
('crispin uriarte', '11/18/2019', '9:25:33'),
('crispin uriarte', '11/18/2019', '9:26:26'),
('crispin uriarte', '11/18/2019', '9:36:56'),
('crispin uriarte', '11/18/2019', '9:56:50'),
('crispin uriarte', '11/18/2019', '9:59:05'),
('crispin uriarte', '11/18/2019', '10:06:22'),
('crispin uriarte', '11/18/2019', '10:13:53'),
('crispin uriarte', '11/18/2019', '10:18:14'),
('crispin uriarte', '11/18/2019', '10:37:47'),
('crispin uriarte', '11/18/2019', '10:41:27'),
('crispin uriarte', '11/18/2019', '11:05:10'),
('crispin uriarte', '11/18/2019', '11:11:41'),
('crispin uriarte', '11/18/2019', '11:30:23'),
('crispin uriarte', '11/18/2019', '1:01:44'),
('crispin uriarte', '11/18/2019', '1:13:01'),
('crispin uriarte', '11/18/2019', '1:15:00'),
('crispin uriarte', '11/18/2019', '1:17:26'),
('crispin uriarte', '11/18/2019', '1:49:21'),
('crispin uriarte', '11/18/2019', '1:52:13'),
('crispin uriarte', '11/18/2019', '1:55:33'),
('crispin uriarte', '11/18/2019', '1:59:45'),
('crispin uriarte', '11/18/2019', '2:01:07'),
('crispin uriarte', '11/18/2019', '2:31:42'),
('__________', '11/18/2019', '4:05:27'),
('__________', '11/18/2019', '4:18:06'),
('__________', '11/18/2019', '4:18:10'),
('__________', '11/18/2019', '4:18:15'),
('__________', '11/18/2019', '4:18:19'),
('__________', '11/18/2019', '4:18:23'),
('__________', '11/18/2019', '4:28:30'),
('__________', '11/18/2019', '4:28:37'),
('__________', '11/18/2019', '4:30:04'),
('__________', '11/18/2019', '4:30:07'),
('__________', '11/18/2019', '4:31:41'),
('__________', '11/18/2019', '4:31:43'),
('__________', '11/18/2019', '4:37:33'),
('__________', '11/18/2019', '4:37:34'),
('crispin uriarte', '11/18/2019', '4:39:33'),
('crispin uriarte', '11/19/2019', '2:55:42'),
('crispin uriarte', '11/19/2019', '4:02:52'),
('crispin uriarte', '11/19/2019', '4:03:54'),
('crispin uriarte', '11/19/2019', '4:16:02'),
('crispin uriarte', '11/19/2019', '4:44:06'),
('crispin uriarte', '11/19/2019', '4:46:33'),
('crispin uriarte', '11/19/2019', '4:53:13'),
('crispin uriarte', '11/19/2019', '5:04:10'),
('crispin uriarte', '11/20/2019', '8:37:26'),
('__________', '11/20/2019', '9:20:03'),
('crispin uriarte', '11/20/2019', '9:20:07'),
('crispin uriarte', '11/20/2019', '9:58:37'),
('crispin uriarte', '11/20/2019', '10:02:39'),
('crispin uriarte', '11/20/2019', '10:09:04'),
('crispin uriarte', '11/20/2019', '10:15:24'),
('crispin uriarte', '11/20/2019', '10:36:28'),
('crispin uriarte', '11/20/2019', '10:45:21'),
('crispin uriarte', '11/20/2019', '11:52:10'),
('__________', '11/20/2019', '11:56:49'),
('crispin uriarte', '11/20/2019', '11:56:53'),
('crispin uriarte', '11/20/2019', '1:06:27'),
('crispin uriarte', '11/20/2019', '1:12:50'),
('crispin uriarte', '11/20/2019', '1:30:31'),
('crispin uriarte', '11/20/2019', '1:34:21'),
('crispin uriarte', '11/20/2019', '1:36:41'),
('crispin uriarte', '11/20/2019', '1:39:49'),
('crispin uriarte', '11/20/2019', '1:41:24'),
('crispin uriarte', '11/20/2019', '1:51:32'),
('crispin uriarte', '11/20/2019', '1:53:01'),
('crispin uriarte', '11/20/2019', '1:58:02'),
('crispin uriarte', '11/20/2019', '2:00:39'),
('crispin uriarte', '11/20/2019', '2:05:28'),
('crispin uriarte', '11/20/2019', '2:07:59'),
('crispin uriarte', '11/20/2019', '2:25:32'),
('crispin uriarte', '11/20/2019', '2:29:53'),
('crispin uriarte', '11/20/2019', '2:33:11'),
('crispin uriarte', '11/20/2019', '2:34:25'),
('crispin uriarte', '11/20/2019', '3:32:43'),
('crispin uriarte', '11/20/2019', '4:08:57'),
('crispin uriarte', '11/20/2019', '4:11:25'),
('crispin uriarte', '11/20/2019', '4:12:45'),
('crispin uriarte', '11/20/2019', '4:26:39'),
('crispin uriarte', '11/20/2019', '4:34:45'),
('crispin uriarte', '11/20/2019', '4:35:36'),
('crispin uriarte', '11/20/2019', '4:42:31'),
('crispin uriarte', '11/20/2019', '4:43:53'),
('crispin uriarte', '11/20/2019', '4:45:48'),
('crispin uriarte', '11/23/2019', '12:47:46'),
('crispin uriarte', '11/23/2019', '12:57:02'),
('crispin uriarte', '11/23/2019', '12:59:46'),
('crispin uriarte', '11/23/2019', '1:56:22'),
('crispin uriarte', '11/23/2019', '1:57:33'),
('crispin uriarte', '11/23/2019', '1:59:31'),
('crispin uriarte', '11/23/2019', '2:01:06'),
('crispin uriarte', '11/23/2019', '2:02:46'),
('crispin uriarte', '11/23/2019', '2:06:28'),
('crispin uriarte', '11/23/2019', '2:09:19'),
('crispin uriarte', '11/23/2019', '2:11:03'),
('crispin uriarte', '11/23/2019', '2:13:11'),
('crispin uriarte', '11/23/2019', '4:13:08'),
('crispin uriarte', '11/23/2019', '4:16:58'),
('crispin uriarte', '11/23/2019', '4:19:11'),
('crispin uriarte', '11/23/2019', '4:22:44'),
('crispin uriarte', '11/23/2019', '4:26:31'),
('__________', '11/25/2019', '8:27:55'),
('crispin uriarte', '11/25/2019', '8:27:58'),
('__________', '11/26/2019', '6:56:01'),
('crispin uriarte', '11/26/2019', '6:56:05'),
('crispin uriarte', '11/27/2019', '11:28:39'),
('crispin uriarte', '11/28/2019', '7:40:47'),
('__________', '12/02/2019', '11:06:26'),
('crispin uriarte', '12/02/2019', '11:06:34'),
('crispin uriarte', '12/03/2019', '5:55:33'),
('crispin uriarte', '12/06/2019', '2:19:49'),
('crispin uriarte', '12/06/2019', '7:48:01'),
('crispin uriarte', '12/09/2019', '10:41:14'),
('__________', '12/12/2019', '9:42:53'),
('crispin uriarte', '12/12/2019', '9:42:56'),
('crispin uriarte', '12/14/2019', '7:23:58'),
('crispin uriarte', '12/15/2019', '3:52:43'),
('__________', '01/12/2020', '7:08:31'),
('crispin uriarte', '01/12/2020', '7:08:42'),
('crispin uriarte', '02/03/2020', '12:11:10'),
('crispin uriarte', '02/07/2020', '10:41:06'),
('crispin uriarte', '02/07/2020', '10:45:10'),
('crispin uriarte', '02/15/2020', '11:43:21');

-- --------------------------------------------------------

--
-- Table structure for table `payroll_tbl`
--

CREATE TABLE `payroll_tbl` (
  `Salary_ID` int(11) NOT NULL,
  `Date_from` varchar(225) NOT NULL,
  `Date_to` varchar(225) NOT NULL,
  `Employee` varchar(225) NOT NULL,
  `Employee_ID` varchar(225) NOT NULL,
  `Position` varchar(225) NOT NULL,
  `Rate` varchar(225) NOT NULL,
  `Render` varchar(225) NOT NULL,
  `Basic` varchar(225) NOT NULL,
  `Over_time` varchar(225) NOT NULL,
  `OT_pay` varchar(225) NOT NULL,
  `Allowance` varchar(225) NOT NULL,
  `Additional` varchar(225) NOT NULL,
  `LHD` varchar(225) NOT NULL,
  `SHD` varchar(225) NOT NULL,
  `Under_time` varchar(225) NOT NULL,
  `UT_ded` varchar(225) NOT NULL,
  `Late` varchar(225) NOT NULL,
  `Late_ded` varchar(225) NOT NULL,
  `Other_ded` varchar(225) NOT NULL,
  `SSS` varchar(225) NOT NULL,
  `Philhealth` varchar(225) NOT NULL,
  `Pag_ibig` varchar(225) NOT NULL,
  `Other` varchar(225) NOT NULL,
  `Gross` varchar(225) NOT NULL,
  `Net` varchar(225) NOT NULL,
  `total_ded` varchar(225) NOT NULL,
  `status` varchar(225) NOT NULL,
  `date_hire` varchar(225) NOT NULL,
  `contact` varchar(225) NOT NULL,
  `atmacc` varchar(225) NOT NULL,
  `other_reason` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payroll_tbl`
--

INSERT INTO `payroll_tbl` (`Salary_ID`, `Date_from`, `Date_to`, `Employee`, `Employee_ID`, `Position`, `Rate`, `Render`, `Basic`, `Over_time`, `OT_pay`, `Allowance`, `Additional`, `LHD`, `SHD`, `Under_time`, `UT_ded`, `Late`, `Late_ded`, `Other_ded`, `SSS`, `Philhealth`, `Pag_ibig`, `Other`, `Gross`, `Net`, `total_ded`, `status`, `date_hire`, `contact`, `atmacc`, `other_reason`) VALUES
(5, '11/11/2019', '11/25/2019', 'Crispin Jose M. Uriarte', '00001', 'MIS Staff', '385', '12', '4620.0', '19', '914.375', '250.0', '0', '0', '115.5', '0', '0', '0', '0', '0', '100', '0', '0', '0', '6149.88', '5899.88', '250.0', 'Probationary', '2019-08-24', '09776794658', '1at', ''),
(6, '11/11/2019', '11/25/2019', 'Kathleen Grace Pauline Sibonga', '00014', 'Accounting Staff', '320', '13', '4160.0', '0', '0', '250.0', '0', '0', '0', '0', '0', '0', '0', '0', '120', '100', '100', '0', '4660.0', '4410.0', '250.0', 'Probationary', '2019-11-19', '54657567', '34534534', ''),
(7, '11/11/2019', '11/25/2019', 'Crispin Jose M. Uriarte', '00001', 'MIS Staff', '385', '12', '4620.0', '', '0', '250.0', '0', '0', '115.5', '0', '0', '0', '0', '0', '360', '130', '100', '0', '5235.5', '4395.5', '840.0', 'Probationary', '2019-08-24', '09776794658', '1at', ''),
(9, '11/11/2019', '11/25/2019', 'Crispin Jose M. Uriarte', '00001', 'MIS Staff', '385', '12', '4620.0', '0', '0', '250.0', '0', '0', '115.5', '0', '0', '0', '0', '0', '300', '0', '0', '0', '5235.5', '4985.5', '250.0', 'Probationary', '2019-08-24', '09776794658', '1at', ''),
(10, '11/11/2019', '11/25/2019', 'Nicole Pearl V. Mamingo', '00006', 'HR Assistant', '385', '13', '5005.0', '', '0', '250.0', '0', '0', '0', '0', '0', '0', '0', '0', '360', '120', '100', '0', '5505.0', '5255.0', '250.0', 'Probationary', '2019-11-19', '2565765', '096786787', ''),
(11, '11/11/2019', '11/25/2019', 'Jhonna Eusebio', '00011', 'Accounting Staff', '350.0', '13', '4550.0', '0', '0', '250.0', '0', '0', '0', '0', '0', '0', '0', '0', '400', '120', '100', '0', '5050.0', '4180.0', '870.0', 'Regular', '2019-11-28', '47474', '5464624', ''),
(12, '11/26/2019', '12/10/2019', 'Hicy D. Feliciano', '00012', 'Accounting Staff', '350.0', '13', '4550.0', '', '0', '250.0', '0', '0', '0', '0', '0', '0', '0', '0', '340', '120', '100', '0', '5050.0', '4240.0', '810.0', 'Regular', '2019-11-18', '637375647', '35435', ''),
(13, '12/11/2019', '12/25/2019', 'Kathleen Grace Pauline Sibonga', '00014', 'Accounting Staff', '320', '13', '4160.0', '0', '0', '250.0', '0', '0', '0', '0', '0', '0', '0', '0', '360', '120', '100', '0', '4660.0', '3830.0', '830.0', 'Probationary', '2019-11-19', '54657567', '34534534', ''),
(14, '11/11/2019', '11/25/2019', 'Alma Grace Aboga-a', '00004', 'HR Head', '450', '13', '5850.0', '19', '1068.75', '230.77', '0', '0', '0', '10', '562.5', '10', '9.38', '0', '110', '110', '110', '0', '7418.75', '6286.1', '1132.65', 'Regular', '2019-11-17', '143545', '5765767876', '');

-- --------------------------------------------------------

--
-- Table structure for table `ph_tbl`
--

CREATE TABLE `ph_tbl` (
  `ID` int(11) NOT NULL,
  `Employee` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Account` varchar(225) NOT NULL,
  `Remarks` varchar(225) NOT NULL,
  `EE` varchar(225) NOT NULL,
  `ER` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ph_tbl`
--

INSERT INTO `ph_tbl` (`ID`, `Employee`, `Date`, `Account`, `Remarks`, `EE`, `ER`) VALUES
(3, 'Nicole Pearl V. Mamingo', '11/11/2019', '97886756456', 'Paid11/20/2019', '120', '120'),
(4, 'Jhonna Eusebio', '11/11/2019', '75647646', 'Unpaid 11/12/2019', '120', '120'),
(5, 'Hicy D. Feliciano', '11/26/2019', '57567', 'Paid 11/21/2019', '120', '120'),
(6, 'Kathleen Grace Pauline Sibonga', '12/11/2019', '52676354', 'Unpaid 11/19/2019', '120', '120'),
(7, 'Alma Grace Aboga-a', '11/11/2019', '313325', 'Paid11/28/2019', '110', '110');

-- --------------------------------------------------------

--
-- Table structure for table `pi_tbl`
--

CREATE TABLE `pi_tbl` (
  `ID` int(11) NOT NULL,
  `Employee` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Account` varchar(225) NOT NULL,
  `Remarks` varchar(225) NOT NULL,
  `EE` varchar(225) NOT NULL,
  `ER` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pi_tbl`
--

INSERT INTO `pi_tbl` (`ID`, `Employee`, `Date`, `Account`, `Remarks`, `EE`, `ER`) VALUES
(5, 'Crispin Jose M. Uriarte', '11/11/2019', '1pi', 'Paid11/20/2019', '0', '0'),
(6, 'Nicole Pearl V. Mamingo', '11/11/2019', '0879786755', 'Paid11/20/2019', '100', '100'),
(7, 'Jhonna Eusebio', '11/11/2019', '54675467', 'Paid11/20/2019', '100', '100'),
(8, 'Hicy D. Feliciano', '11/26/2019', '43546357', 'Paid11/20/2019', '100', '100'),
(9, 'Kathleen Grace Pauline Sibonga', '12/11/2019', '35346576', 'Paid11/20/2019', '100', '100'),
(10, 'Alma Grace Aboga-a', '11/11/2019', '23423', 'Paid11/28/2019', '110', '110');

-- --------------------------------------------------------

--
-- Table structure for table `position_tbl`
--

CREATE TABLE `position_tbl` (
  `ID` int(225) NOT NULL,
  `Position` varchar(225) NOT NULL,
  `Rate` varchar(225) NOT NULL,
  `Bonus` varchar(225) NOT NULL,
  `Description` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Account` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `position_tbl`
--

INSERT INTO `position_tbl` (`ID`, `Position`, `Rate`, `Bonus`, `Description`, `Date`, `Account`) VALUES
(1, 'HR Head', '450', '500', 'Must be 1year in Company and know all company proccess', '11/08/2019', 'crispin uriarte'),
(2, 'HR Assistant', '385', '500', 'Must be a College Graduate related to Physchology, BSIE, or any related course', '11/08/2019', 'crispin uriarte'),
(3, 'CEO', '1000', '1000', 'Only person incharge of all business desicion', '11/08/2019', 'crispin uriarte'),
(4, 'General Manager', '850', '1000', 'Manage of business process', '11/08/2019', 'crispin uriarte'),
(5, 'Accounting Staff', '320', '500', 'Record all transaction', '11/08/2019', 'crispin uriarte'),
(6, 'MIS Staff', '385', '500', 'Computer Maintenance', '11/08/2019', 'crispin uriarte'),
(7, 'Book Encoder', '370', '500', 'Edit Book content', '11/08/2019', 'crispin uriarte');

-- --------------------------------------------------------

--
-- Table structure for table `pulloutlog`
--

CREATE TABLE `pulloutlog` (
  `ID` int(11) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL,
  `Employee` varchar(225) NOT NULL,
  `Item` varchar(225) NOT NULL,
  `Qty` varchar(225) NOT NULL,
  `Remarks` varchar(225) NOT NULL,
  `Approved` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pulloutlog`
--

INSERT INTO `pulloutlog` (`ID`, `Date`, `Time`, `Employee`, `Item`, `Qty`, `Remarks`, `Approved`) VALUES
(1, '11/15/2019', '1:18:01', 'Crispin Jose M. Uriarte', 'American Map', '1', '*', 'Alma Grace Aboga-a'),
(2, '11/15/2019', '1:19:49', 'Dave Alvarez', 'Backbone', '1', '*', 'Jessica Alvarez');

-- --------------------------------------------------------

--
-- Table structure for table `pullout_tbl`
--

CREATE TABLE `pullout_tbl` (
  `pullout_id` int(11) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Time` varchar(225) NOT NULL,
  `Request_by` varchar(225) NOT NULL,
  `Item` varchar(225) NOT NULL,
  `Qty` varchar(225) NOT NULL,
  `Remarks` varchar(225) NOT NULL,
  `Approved_by` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pullout_tbl`
--

INSERT INTO `pullout_tbl` (`pullout_id`, `Date`, `Time`, `Request_by`, `Item`, `Qty`, `Remarks`, `Approved_by`) VALUES
(1, '', '', '', '1/2 Lenghwise paper', '2', '', ''),
(3, '11/15/2019', '1:18:01', 'Crispin Jose M. Uriarte', 'American Map', '8.0', '*', 'Alma Grace Aboga-a'),
(4, '', '', '', 'American Paper Short', '2.0', '', ''),
(5, '11/15/2019', '1:19:49', 'Dave Alvarez', 'Backbone', '894.0', '*', 'Jessica Alvarez'),
(6, '', '', '', 'Ballpen (Black)', '3', '', ''),
(7, '', '', '', 'Ballpen (Red)', '1', '', ''),
(8, '', '', '', 'Ballpen (refill-black)', '17', '', ''),
(9, '', '', '', 'Ballpen (refill-red)', '3', '', ''),
(10, '', '', '', 'Binder clip (BIG)', '5', '', ''),
(11, '', '', '', 'Binder clip (MEDIUM)', '8', '', ''),
(12, '', '', '', 'Binder clip (SMALL)', '8', '', ''),
(13, '', '', '', 'Bond Paper (A4)', '4', '', ''),
(14, '', '', '', 'Bond Paper (LONG)', '3', '', ''),
(15, '', '', '', 'Bond Paper (Short)', '10', '', ''),
(16, '', '', '', 'Book Cover', '500', '', ''),
(17, '', '', '', 'Brother ink (black)', '3', '', ''),
(18, '', '', '', 'Brother ink (Cyan)', '3', '', ''),
(19, '', '', '', 'Brother ink (Magenta)', '2', '', ''),
(20, '', '', '', 'Brother ink (Yellow)', '3', '', ''),
(21, '', '', '', 'Brown Envelope (Long)', '10', '', ''),
(22, '', '', '', 'Brown Envelope (Short)', '5', '', ''),
(23, '', '', '', 'Brown Extended Folder long', '1', '', ''),
(25, '', '', '', 'Brown Folder Short', '7.0', '', ''),
(26, '', '', '', 'Carbon', '73', '', ''),
(27, '', '', '', 'Carbon Brush', '2', '', ''),
(28, '', '', '', 'Clear Book', '2', '', ''),
(29, '', '', '', 'Color Paper Short', '4', '', ''),
(30, '', '', '', 'Columnar', '4', '', ''),
(31, '', '', '', 'Correction Tape', '8', '', ''),
(32, '', '', '', 'Cutter', '5', '', ''),
(33, '', '', '', 'Cutter Blade', '8', '', ''),
(34, '', '', '', 'Date Stamp Big', '1', '', ''),
(35, '', '', '', 'Date Stamp Small', '1', '', ''),
(36, '', '', '', 'Delivery Receipt', '8', '', ''),
(37, '', '', '', 'Double Sided Tape', '0', '', ''),
(38, '', '', '', 'Duck Tape', '0', '', ''),
(39, '', '', '', 'Electrical Tape', '0', '', ''),
(40, '', '', '', 'Envelope (extended)', '0', '', ''),
(41, '', '', '', 'Envelope (LONG)', '67', '', ''),
(42, '', '', '', 'Epson ink (black)', '4', '', ''),
(43, '', '', '', 'Epson ink (cyan)', '3', '', ''),
(44, '', '', '', 'Epson ink (magenta)', '3', '', ''),
(45, '', '', '', 'Epson ink (yellow)', '3', '', ''),
(46, '', '', '', 'Expenses Form', '865', '', ''),
(47, '', '', '', 'fastener 4', '50', '', ''),
(48, '', '', '', 'fastener 6', '0', '', ''),
(49, '', '', '', 'fastener 8', '0', '', ''),
(50, '', '', '', 'fastener lock', '153', '', ''),
(51, '', '', '', 'fastener lock (plastic)', '26', '', ''),
(52, '', '', '', 'Flyleaf', '0', '', ''),
(53, '', '', '', 'Folder stick (long)', '3', '', ''),
(54, '', '', '', 'Folder stick (small)', '15', '', ''),
(55, '', '', '', 'Fuel float', '0', '', ''),
(56, '', '', '', 'Gel ink pen', '0', '', ''),
(57, '', '', '', 'Glue gun', '1', '', ''),
(58, '', '', '', 'Graphing paper', '14', '', ''),
(59, '', '', '', 'Gun Tacker medium', '1', '', ''),
(60, '', '', '', 'Gun Tacker small', '1', '', ''),
(61, '', '', '', 'Halogen bulb', '2', '', ''),
(62, '', '', '', 'Hook', '1', '', ''),
(63, '', '', '', 'HP ink (black)', '0', '', ''),
(64, '', '', '', 'HP ink (tri-color)', '0', '', ''),
(65, '', '', '', 'Laminating film', '0', '', ''),
(66, '', '', '', 'Lead full color rotating lamp', '1', '', ''),
(67, '', '', '', 'Ledger', '5', '', ''),
(68, '', '', '', 'Magazine', '33', '', ''),
(69, '', '', '', 'Manila Paper', '2', '', ''),
(70, '', '', '', 'Marker Blue', '1', '', ''),
(71, '', '', '', 'Marker Dark green', '3', '', ''),
(72, '', '', '', 'Marker pink', '4', '', ''),
(73, '', '', '', 'Marker violet', '5', '', ''),
(74, '', '', '', 'Marker yellow green', '3', '', ''),
(75, '', '', '', 'Nails small', '46', '', ''),
(76, '', '', '', 'News Print long', '42', '', ''),
(77, '', '', '', 'Notebook', '2', '', ''),
(78, '', '', '', 'Notebook (big)', '1', '', ''),
(79, '', '', '', 'Orange extended folder long', '1', '', ''),
(80, '', '', '', 'Packaging tape', '4', '', ''),
(81, '', '', '', 'Paper Tape', '15', '', ''),
(82, '', '', '', 'Paper Clip', '15', '', ''),
(83, '', '', '', 'Paste Board', '0', '', ''),
(84, '', '', '', 'Pencil', '4', '', ''),
(85, '', '', '', 'Pentelpen (blue)', '1', '', ''),
(86, '', '', '', 'Photo Glossy paper', '33', '', ''),
(87, '', '', '', 'Photo paper (matte)', '2', '', ''),
(88, '', '', '', 'Pilot marker blue (pentel pen)', '1', '', ''),
(89, '', '', '', 'Pilot refill ink', '2', '', ''),
(90, '', '', '', 'Plastic folder long', '5', '', ''),
(91, '', '', '', 'Plastic folder short', '0', '', ''),
(92, '', '', '', 'Protactor', '1', '', ''),
(93, '', '', '', 'PVC', '33', '', ''),
(94, '', '', '', 'Record Book', '1', '', ''),
(95, '', '', '', 'Rubber Band', '230', '', ''),
(96, '', '', '', 'Rubber Stamp small', '1', '', ''),
(97, '', '', '', 'Ruller', '1', '', ''),
(98, '', '', '', 'Scotch Tape', '3', '', ''),
(99, '', '', '', 'Screw Bolt', '47', '', ''),
(100, '', '', '', 'Sharpener', '1', '', ''),
(101, '', '', '', 'Specialty Board', '2', '', ''),
(102, '', '', '', 'Stabillo refill', '1', '', ''),
(103, '', '', '', 'Stabillo Eraser', '3', '', ''),
(104, '', '', '', 'Stamp Pad (black)', '1', '', ''),
(105, '', '', '', 'Stamp Pad (red)', '1', '', ''),
(106, '', '', '', 'Stamp Pad refill ink', '1', '', ''),
(107, '', '', '', 'Staple Wire (per box)', '0', '', ''),
(108, '', '', '', 'Staple Wire (Tailoring box)', '19', '', ''),
(109, '', '', '', 'Staple wire 10mm', '10', '', ''),
(110, '', '', '', 'Staple wire 15mm', '20', '', ''),
(111, '', '', '', 'Staple wire 17mm', '9', '', ''),
(112, '', '', '', 'Statement Envelope', '6', '', ''),
(113, '', '', '', 'Stretch Film', '2', '', ''),
(114, '', '', '', 'Tape (black)', '0', '', ''),
(115, '', '', '', 'Tape (red)', '1', '', ''),
(116, '', '', '', 'Tape dispenser roller', '1', '', ''),
(117, '', '', '', 'Thumb tacks', '45', '', ''),
(118, '', '', '', 'Tower bolt', '1', '', ''),
(119, '', '', '', 'Transparent fil for I.D', '35', '', ''),
(120, '', '', '', 'Velom Long 120', '34', '', ''),
(121, '', '', '', 'White Board', '1', '', ''),
(122, '', '', '', 'Whiteboard marker', '1', '', ''),
(123, '', '', '', 'Wrong Entry Duplication', '2', '', ''),
(124, '', '', '', 'Plastic Folder Chairs (long)', '11', '', ''),
(125, '', '', '', 'Folder Plastic Table', '1', '', ''),
(126, '', '', '', 'Folder Plastic Table Long', '6.0', '', ''),
(127, '', '', '', 'Hard Book Cover (returned)', '21', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `receipt_tbl`
--

CREATE TABLE `receipt_tbl` (
  `r_date` varchar(225) NOT NULL,
  `r_number` varchar(225) NOT NULL,
  `r_amount` varchar(225) NOT NULL,
  `r_description` varchar(225) NOT NULL,
  `r_name` varchar(225) NOT NULL,
  `r_unit` varchar(225) NOT NULL,
  `r_receive` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt_tbl`
--

INSERT INTO `receipt_tbl` (`r_date`, `r_number`, `r_amount`, `r_description`, `r_name`, `r_unit`, `r_receive`) VALUES
('2019-10-06', 'PR 0001', 'P 500', '', 'Gary', 'Revo', 'Joel Electrician'),
('2019-10-06', 'PR 0002', 'P 400', '', 'Ma\'am Riz', 'Adventure Blue', 'Macoy'),
('2019-10-08', 'PR 0004', 'P 300', '', 'Cyril', 'FX White', 'Edgar Welder'),
('2019-10-07', 'PR 0005', 'P 280', '', 'Bautista', 'XRM', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0006', 'P 250', '', 'Mission', 'Bajaj 18', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0007', 'P 610', '', 'Ivan', 'Bajaj 16', 'IvanMay-may Motor Mechanic'),
('2019-10-07', 'PR 0008', 'P 520', '', 'Castro', 'Bajaj 8', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0009', 'P 550', '', 'Alim', 'XR Red', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0010', 'P 460', '', 'Gallobe', 'Bajaj 11', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0011', 'P 210', '', 'Oracion', 'Bajaj 09', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0012', 'P 50', '', 'Ernie', 'Raider', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0013', 'P 50', '', 'Baguio', 'Bajaj 15', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0014', 'P 630', '', 'Marnel', 'Bajaj 12', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0015', 'P 560', '', 'Dayem', 'Bajaj 13', 'May-may Motor Mechanic'),
('2019-10-07', 'PR 0016', 'P 460', '', 'Tile-tile', 'Bajaj 6', 'May-may Motor Mechanic'),
('2019-10-09', 'PR 0017', 'P 1,500', '', 'Jhong2x', 'Adventure Blue', 'Edgar Welding Shop'),
('2019-12-09', 'PR 0018', 'P 1,000', '', 'Jhong2x', 'Adventure Blue', 'Nonoy Pintor'),
('2019-10-10', 'PR 0019', 'P 500', '', 'Jhong2x', 'Adventure Blue', 'Nonoy Talyer'),
('2019-10-15', 'PR 0020', 'P 1,000', 'power window & dashcam labor', 'Office', 'adventure blue & Eco sport', 'Bentong'),
('2019-10-21', 'PR 0021', 'P 2,800', '', 'Office', 'FX Red', 'Ian Upholstery'),
('2019-10-21', 'PR 0022', 'P 700', '', 'Office', 'FX Red', 'Bentong'),
('2019-10-30', 'PR 0023', 'P 300', '', 'Office', 'Tricycle', 'May-may Motor Mechanic'),
('2019-11-11', 'PR 0024', 'P 50', 'Labor', 'Jhunell Oracion', 'Bajaj 9', 'May-may Motor Mechanic'),
('2019-11-15', 'PR 0025', 'P 70', 'Labor', 'Reymon Bayato', 'Bajaj 14', 'May-may Motor Mechanic'),
('2019-11-05', 'PR 0026', 'P 80', 'Labor', 'Marnel Montecalvo', 'Bajaj 12', 'May-may Motor Mechanic'),
('2019-11-05', 'PR 0027', 'P 290', 'Labor', 'Rolly Castro', 'Bajaj 8', 'May-may Motor Mechanic'),
('2019-11-05', 'PR 0028', 'P 40', '', 'Daniel Alim', 'XR', 'May-may Motor Mechanic'),
('2019-11-05', 'PR 0029', 'P 410', 'Labor', 'Felix Esguerra', 'Bajaj 7', 'May-may Motor Mechanic'),
('2019-11-05', 'PR 0030', 'P 310', 'Labor', 'Mark Montecalvo', 'CB-2', 'May-may Motor Mechanic'),
('2019-11-05', 'PR 0031', 'P 310', '', 'Brylle Jhun Tile-tile', 'CB 5', 'May-may Motor Mechanic'),
('2019-11-06', 'PR 0032', 'P 3,300', 'Crank Shaft', 'may-may', 'Bajaj #6', 'may-may'),
('', 'PR 0033', '', '', '', '', ''),
('', 'PR 0034', '', '', '', '', ''),
('', 'PR 0035', '', '', '', '', ''),
('', 'PR 0036', '', '', '', '', ''),
('', 'PR 0037', '', '', '', '', ''),
('', 'PR 0038', '', '', '', '', ''),
('', 'PR 0039', '', '', '', '', ''),
('', 'PR 0040', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `sss_table`
--

CREATE TABLE `sss_table` (
  `ID` int(11) NOT NULL,
  `Employee` varchar(225) NOT NULL,
  `Date` varchar(225) NOT NULL,
  `Account` varchar(225) NOT NULL,
  `Remarks` varchar(225) NOT NULL,
  `EE` varchar(225) NOT NULL,
  `ER` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sss_table`
--

INSERT INTO `sss_table` (`ID`, `Employee`, `Date`, `Account`, `Remarks`, `EE`, `ER`) VALUES
(5, 'Crispin Jose M. Uriarte', '11/11/2019', '1sss', 'Paid 11/19/2019', '300', '120'),
(6, 'Nicole Pearl V. Mamingo', '11/11/2019', '324654765', 'Unpaid 11/26/2019', '360', '400'),
(7, 'Jhonna Eusebio', '11/11/2019', '63466768657', 'Paid 11/29/2019', '400', '500'),
(8, 'Hicy D. Feliciano', '11/26/2019', '5674567547', 'Paid 11/12/2019', '340', '420'),
(9, 'Kathleen Grace Pauline Sibonga', '12/11/2019', '53453265475', 'Unpaid 12/15/2019', '360', '500'),
(10, 'Alma Grace Aboga-a', '11/11/2019', '32143543', '****', '110', '110');

-- --------------------------------------------------------

--
-- Table structure for table `stockinout_tbl`
--

CREATE TABLE `stockinout_tbl` (
  `stock_id` int(11) NOT NULL,
  `date` varchar(225) NOT NULL,
  `time` varchar(225) NOT NULL,
  `item` varchar(225) NOT NULL,
  `qty` varchar(225) NOT NULL,
  `remark` varchar(225) NOT NULL,
  `acc` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stockinout_tbl`
--

INSERT INTO `stockinout_tbl` (`stock_id`, `date`, `time`, `item`, `qty`, `remark`, `acc`) VALUES
(1, '11/10/2019', '12:38:01', '1/2 Lenghwise paper', '2', '', 'crispin uriarte'),
(3, '11/10/2019', '12:38:21', 'American Map', '8.0', '', 'crispin uriarte'),
(4, '11/10/2019', '2:06:56', 'American Paper Short', '2.0', '', 'crispin uriarte'),
(5, '11/10/2019', '2:01:45', 'Backbone', '894.0', '', 'crispin uriarte'),
(6, '11/10/2019', '12:39:07', 'Ballpen (Black)', '3', '', 'crispin uriarte'),
(7, '11/10/2019', '12:39:18', 'Ballpen (Red)', '1', '', 'crispin uriarte'),
(8, '11/10/2019', '12:39:34', 'Ballpen (refill-black)', '17', '', 'crispin uriarte'),
(9, '11/10/2019', '12:39:55', 'Ballpen (refill-red)', '3', '', 'crispin uriarte'),
(10, '11/10/2019', '12:40:08', 'Binder clip (BIG)', '5', '', 'crispin uriarte'),
(11, '11/10/2019', '12:40:33', 'Binder clip (MEDIUM)', '8', '', 'crispin uriarte'),
(12, '11/10/2019', '12:40:45', 'Binder clip (SMALL)', '8', '', 'crispin uriarte'),
(13, '11/10/2019', '12:40:59', 'Bond Paper (A4)', '4', '', 'crispin uriarte'),
(14, '11/10/2019', '12:41:12', 'Bond Paper (LONG)', '3', '', 'crispin uriarte'),
(15, '11/10/2019', '12:41:24', 'Bond Paper (Short)', '10', '', 'crispin uriarte'),
(16, '11/10/2019', '12:41:43', 'Book Cover', '500', '', 'crispin uriarte'),
(17, '11/10/2019', '12:41:54', 'Brother ink (black)', '3', '', 'crispin uriarte'),
(18, '11/10/2019', '12:42:10', 'Brother ink (Cyan)', '3', '', 'crispin uriarte'),
(19, '11/10/2019', '12:42:38', 'Brother ink (Magenta)', '2', '', 'crispin uriarte'),
(20, '11/10/2019', '12:42:50', 'Brother ink (Yellow)', '3', '', 'crispin uriarte'),
(21, '11/10/2019', '12:43:13', 'Brown Envelope (Long)', '10', '', 'crispin uriarte'),
(22, '11/10/2019', '12:43:52', 'Brown Envelope (Short)', '5', '', 'crispin uriarte'),
(23, '11/10/2019', '12:44:08', 'Brown Extended Folder long', '1', '', 'crispin uriarte'),
(25, '11/10/2019', '12:45:45', 'Brown Folder Short', '7.0', '', 'crispin uriarte'),
(26, '11/10/2019', '12:46:25', 'Carbon', '73', '', 'crispin uriarte'),
(27, '11/10/2019', '12:46:41', 'Carbon Brush', '2', '', 'crispin uriarte'),
(28, '11/10/2019', '12:46:50', 'Clear Book', '2', '', 'crispin uriarte'),
(29, '11/10/2019', '12:47:03', 'Color Paper Short', '4', '', 'crispin uriarte'),
(30, '11/10/2019', '12:47:12', 'Columnar', '4', '', 'crispin uriarte'),
(31, '11/10/2019', '12:47:24', 'Correction Tape', '8', '', 'crispin uriarte'),
(32, '11/10/2019', '12:47:32', 'Cutter', '5', '', 'crispin uriarte'),
(33, '11/10/2019', '12:47:47', 'Cutter Blade', '8', '', 'crispin uriarte'),
(34, '11/10/2019', '12:47:57', 'Date Stamp Big', '1', '', 'crispin uriarte'),
(35, '11/10/2019', '12:48:13', 'Date Stamp Small', '1', '', 'crispin uriarte'),
(36, '11/10/2019', '12:48:24', 'Delivery Receipt', '8', '', 'crispin uriarte'),
(37, '11/10/2019', '12:48:34', 'Double Sided Tape', '0', '', 'crispin uriarte'),
(38, '11/10/2019', '12:48:54', 'Duck Tape', '0', '', 'crispin uriarte'),
(39, '11/10/2019', '12:49:01', 'Electrical Tape', '0', '', 'crispin uriarte'),
(40, '11/10/2019', '12:49:23', 'Envelope (extended)', '0', '', 'crispin uriarte'),
(41, '11/10/2019', '12:49:44', 'Envelope (LONG)', '67', '', 'crispin uriarte'),
(42, '11/10/2019', '12:50:02', 'Epson ink (black)', '4', '', 'crispin uriarte'),
(43, '11/10/2019', '12:50:26', 'Epson ink (cyan)', '3', '', 'crispin uriarte'),
(44, '11/10/2019', '12:51:16', 'Epson ink (magenta)', '3', '', 'crispin uriarte'),
(45, '11/10/2019', '12:51:36', 'Epson ink (yellow)', '3', '', 'crispin uriarte'),
(46, '11/10/2019', '12:51:49', 'Expenses Form', '865', '', 'crispin uriarte'),
(47, '11/10/2019', '12:51:59', 'fastener 4', '50', '', 'crispin uriarte'),
(48, '11/10/2019', '12:52:10', 'fastener 6', '0', '', 'crispin uriarte'),
(49, '11/10/2019', '12:52:14', 'fastener 8', '0', '', 'crispin uriarte'),
(50, '11/10/2019', '12:52:22', 'fastener lock', '153', '', 'crispin uriarte'),
(51, '11/10/2019', '12:52:35', 'fastener lock (plastic)', '26', '', 'crispin uriarte'),
(52, '11/10/2019', '12:52:51', 'Flyleaf', '0', '', 'crispin uriarte'),
(53, '11/10/2019', '12:53:01', 'Folder stick (long)', '3', '', 'crispin uriarte'),
(54, '11/10/2019', '12:53:20', 'Folder stick (small)', '15', '', 'crispin uriarte'),
(55, '11/10/2019', '12:53:28', 'Fuel float', '0', '', 'crispin uriarte'),
(56, '11/10/2019', '12:53:34', 'Gel ink pen', '0', '', 'crispin uriarte'),
(57, '11/10/2019', '12:53:41', 'Glue gun', '1', '', 'crispin uriarte'),
(58, '11/10/2019', '12:53:52', 'Graphing paper', '14', '', 'crispin uriarte'),
(59, '11/10/2019', '12:54:27', 'Gun Tacker medium', '1', '', 'crispin uriarte'),
(60, '11/10/2019', '12:54:32', 'Gun Tacker small', '1', '', 'crispin uriarte'),
(61, '11/10/2019', '12:54:44', 'Halogen bulb', '2', '', 'crispin uriarte'),
(62, '11/10/2019', '12:54:50', 'Hook', '1', '', 'crispin uriarte'),
(63, '11/10/2019', '12:55:03', 'HP ink (black)', '0', '', 'crispin uriarte'),
(64, '11/10/2019', '12:55:10', 'HP ink (tri-color)', '0', '', 'crispin uriarte'),
(65, '11/10/2019', '12:55:24', 'Laminating film', '0', '', 'crispin uriarte'),
(66, '11/10/2019', '12:55:37', 'Lead full color rotating lamp', '1', '', 'crispin uriarte'),
(67, '11/10/2019', '12:55:53', 'Ledger', '5', '', 'crispin uriarte'),
(68, '11/10/2019', '12:56:00', 'Magazine', '33', '', 'crispin uriarte'),
(69, '11/10/2019', '12:56:08', 'Manila Paper', '2', '', 'crispin uriarte'),
(70, '11/10/2019', '12:56:16', 'Marker Blue', '1', '', 'crispin uriarte'),
(71, '11/10/2019', '12:56:28', 'Marker Dark green', '3', '', 'crispin uriarte'),
(72, '11/10/2019', '12:56:36', 'Marker pink', '4', '', 'crispin uriarte'),
(73, '11/10/2019', '12:56:52', 'Marker violet', '5', '', 'crispin uriarte'),
(74, '11/10/2019', '12:57:05', 'Marker yellow green', '3', '', 'crispin uriarte'),
(75, '11/10/2019', '12:57:15', 'Nails small', '46', '', 'crispin uriarte'),
(76, '11/10/2019', '12:57:32', 'News Print long', '42', '', 'crispin uriarte'),
(77, '11/10/2019', '12:57:40', 'Notebook', '2', '', 'crispin uriarte'),
(78, '11/10/2019', '12:57:50', 'Notebook (big)', '1', '', 'crispin uriarte'),
(79, '11/10/2019', '12:58:04', 'Orange extended folder long', '1', '', 'crispin uriarte'),
(80, '11/10/2019', '12:58:17', 'Packaging tape', '4', '', 'crispin uriarte'),
(81, '11/10/2019', '12:58:34', 'Paper Tape', '15', '', 'crispin uriarte'),
(82, '11/10/2019', '12:59:52', 'Paper Clip', '15', '', 'crispin uriarte'),
(83, '11/10/2019', '12:59:58', 'Paste Board', '0', '', 'crispin uriarte'),
(84, '11/10/2019', '1:00:07', 'Pencil', '4', '', 'crispin uriarte'),
(85, '11/10/2019', '1:00:17', 'Pentelpen (blue)', '1', '', 'crispin uriarte'),
(86, '11/10/2019', '1:00:32', 'Photo Glossy paper', '33', '', 'crispin uriarte'),
(87, '11/10/2019', '1:00:52', 'Photo paper (matte)', '2', '', 'crispin uriarte'),
(88, '11/10/2019', '1:01:07', 'Pilot marker blue (pentel pen)', '1', '', 'crispin uriarte'),
(89, '11/10/2019', '1:01:16', 'Pilot refill ink', '2', '', 'crispin uriarte'),
(90, '11/10/2019', '1:01:25', 'Plastic folder long', '5', '', 'crispin uriarte'),
(91, '11/10/2019', '1:01:55', 'Plastic folder short', '0', '', 'crispin uriarte'),
(92, '11/10/2019', '1:02:02', 'Protactor', '1', '', 'crispin uriarte'),
(93, '11/10/2019', '1:02:08', 'PVC', '33', '', 'crispin uriarte'),
(94, '11/10/2019', '1:02:15', 'Record Book', '1', '', 'crispin uriarte'),
(95, '11/10/2019', '1:02:25', 'Rubber Band', '230', '', 'crispin uriarte'),
(96, '11/10/2019', '1:02:35', 'Rubber Stamp small', '1', '', 'crispin uriarte'),
(97, '11/10/2019', '1:02:40', 'Ruller', '1', '', 'crispin uriarte'),
(98, '11/10/2019', '1:02:50', 'Scotch Tape', '3', '', 'crispin uriarte'),
(99, '11/10/2019', '1:03:01', 'Screw Bolt', '47', '', 'crispin uriarte'),
(100, '11/10/2019', '1:03:06', 'Sharpener', '1', '', 'crispin uriarte'),
(101, '11/10/2019', '1:03:14', 'Specialty Board', '2', '', 'crispin uriarte'),
(102, '11/10/2019', '1:03:38', 'Stabillo refill', '1', '', 'crispin uriarte'),
(103, '11/10/2019', '1:03:50', 'Stabillo Eraser', '3', '', 'crispin uriarte'),
(104, '11/10/2019', '1:04:00', 'Stamp Pad (black)', '1', '', 'crispin uriarte'),
(105, '11/10/2019', '1:04:32', 'Stamp Pad (red)', '1', '', 'crispin uriarte'),
(106, '11/10/2019', '1:04:45', 'Stamp Pad refill ink', '1', '', 'crispin uriarte'),
(107, '11/10/2019', '1:04:56', 'Staple Wire (per box)', '0', '', 'crispin uriarte'),
(108, '11/10/2019', '1:05:13', 'Staple Wire (Tailoring box)', '19', '', 'crispin uriarte'),
(109, '11/10/2019', '1:05:27', 'Staple wire 10mm', '10', '', 'crispin uriarte'),
(110, '11/10/2019', '1:05:39', 'Staple wire 15mm', '20', '', 'crispin uriarte'),
(111, '11/10/2019', '1:05:47', 'Staple wire 17mm', '9', '', 'crispin uriarte'),
(112, '11/10/2019', '1:06:05', 'Statement Envelope', '6', '', 'crispin uriarte'),
(113, '11/10/2019', '1:06:17', 'Stretch Film', '2', '', 'crispin uriarte'),
(114, '11/10/2019', '1:06:27', 'Tape (black)', '0', '', 'crispin uriarte'),
(115, '11/10/2019', '1:06:33', 'Tape (red)', '1', '', 'crispin uriarte'),
(116, '11/10/2019', '1:07:02', 'Tape dispenser roller', '1', '', 'crispin uriarte'),
(117, '11/10/2019', '1:07:13', 'Thumb tacks', '45', '', 'crispin uriarte'),
(118, '11/10/2019', '1:07:19', 'Tower bolt', '1', '', 'crispin uriarte'),
(119, '11/10/2019', '1:07:33', 'Transparent fil for I.D', '35', '', 'crispin uriarte'),
(120, '11/10/2019', '1:07:50', 'Velom Long 120', '34', '', 'crispin uriarte'),
(121, '11/10/2019', '1:07:57', 'White Board', '1', '', 'crispin uriarte'),
(122, '11/10/2019', '1:08:05', 'Whiteboard marker', '1', '', 'crispin uriarte'),
(123, '11/10/2019', '1:08:33', 'Wrong Entry Duplication', '2', '', 'crispin uriarte'),
(124, '11/10/2019', '1:08:54', 'Plastic Folder Chairs (long)', '11', '', 'crispin uriarte'),
(125, '11/10/2019', '1:09:07', 'Folder Plastic Table', '1', '', 'crispin uriarte'),
(126, '11/10/2019', '1:10:06', 'Folder Plastic Table Long', '6.0', '', 'crispin uriarte'),
(127, '11/10/2019', '1:10:32', 'Hard Book Cover (returned)', '21', '', 'crispin uriarte');

-- --------------------------------------------------------

--
-- Table structure for table `user_trans_tbl`
--

CREATE TABLE `user_trans_tbl` (
  `Date_t` varchar(255) NOT NULL,
  `Time_t` varchar(255) NOT NULL,
  `User_t` varchar(255) NOT NULL,
  `Transaction_t` varchar(225) NOT NULL,
  `POnum_t` varchar(225) NOT NULL,
  `Data_t` varchar(225) NOT NULL,
  `Establishment_t` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_trans_tbl`
--

INSERT INTO `user_trans_tbl` (`Date_t`, `Time_t`, `User_t`, `Transaction_t`, `POnum_t`, `Data_t`, `Establishment_t`) VALUES
('11/13/2019', '8:53:28', 'crispin uriarte', 'Print', 'JO 0033', 'Job Order', 'None'),
('11/13/2019', '8:53:54', 'crispin uriarte', 'Print', 'JO 0034', 'Job Order', 'None'),
('11/13/2019', '8:54:12', 'crispin uriarte', 'Print', 'JO 0035', 'Job Order', 'None'),
('11/13/2019', '8:54:37', 'crispin uriarte', 'Print', 'JO 0036', 'Job Order', 'None'),
('11/13/2019', '8:55:04', 'crispin uriarte', 'Print', 'JO 0037', 'Job Order', 'None'),
('11/13/2019', '8:55:28', 'crispin uriarte', 'Print', 'JO 0038', 'Job Order', 'None'),
('11/13/2019', '8:55:55', 'crispin uriarte', 'Print', 'JO 0039', 'Job Order', 'None'),
('11/13/2019', '8:56:13', 'crispin uriarte', 'Print', 'JO 0040', 'Job Order', 'None'),
('11/13/2019', '8:56:42', 'crispin uriarte', 'Print', 'PR 0033', 'Receipt', 'None'),
('11/13/2019', '8:57:01', 'crispin uriarte', 'Print', 'PR 0034', 'Receipt', 'None'),
('11/13/2019', '8:57:16', 'crispin uriarte', 'Print', 'PR 0035', 'Receipt', 'None'),
('11/13/2019', '8:57:30', 'crispin uriarte', 'Print', 'PR 0036', 'Receipt', 'None'),
('11/13/2019', '8:57:45', 'crispin uriarte', 'Print', 'PR 0037', 'Receipt', 'None'),
('11/13/2019', '8:58:00', 'crispin uriarte', 'Print', 'PR 0038', 'Receipt', 'None'),
('11/13/2019', '8:58:13', 'crispin uriarte', 'Print', 'PR 0039', 'Receipt', 'None'),
('11/13/2019', '8:58:26', 'crispin uriarte', 'Print', 'PR 0040', 'Receipt', 'None'),
('11/15/2019', '1:09:52', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/15/2019', '1:18:01', 'crispin uriarte', 'Save', 'American Map', 'None', 'None'),
('11/15/2019', '1:19:49', 'crispin uriarte', 'Save', 'Backbone', 'None', 'None'),
('11/17/2019', '3:41:39', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/17/2019', '3:43:12', 'crispin uriarte', 'save', '00009', 'Salary', ''),
('11/20/2019', '9:21:31', 'crispin uriarte', 'Update', '00002', '', ''),
('11/20/2019', '9:22:41', 'crispin uriarte', 'Update', '00003', '', ''),
('11/20/2019', '9:22:47', 'crispin uriarte', 'Update', '00003', '', ''),
('11/20/2019', '9:23:02', 'crispin uriarte', 'Update', '00004', '', ''),
('11/20/2019', '9:23:17', 'crispin uriarte', 'Update', '00005', '', ''),
('11/20/2019', '9:23:33', 'crispin uriarte', 'Update', '00006', '', ''),
('11/20/2019', '9:23:54', 'crispin uriarte', 'Update', '00009', '', ''),
('11/20/2019', '9:24:10', 'crispin uriarte', 'Update', '00010', '', ''),
('11/20/2019', '9:24:27', 'crispin uriarte', 'Update', '00011', '', ''),
('11/20/2019', '9:24:45', 'crispin uriarte', 'Update', '00012', '', ''),
('11/20/2019', '9:24:49', 'crispin uriarte', 'Update', '00003', '', ''),
('11/20/2019', '9:25:02', 'crispin uriarte', 'Update', '00014', '', ''),
('11/20/2019', '9:25:18', 'crispin uriarte', 'Update', '00016', '', ''),
('11/20/2019', '9:59:29', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/20/2019', '10:06:53', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/20/2019', '10:10:13', 'crispin uriarte', 'save', '00014', 'Salary', ''),
('11/20/2019', '10:13:29', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/20/2019', '10:37:18', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/20/2019', '10:45:53', 'crispin uriarte', 'save', '00001', 'Salary', ''),
('11/20/2019', '11:56:11', 'crispin uriarte', 'Delete', 'Gel ink pen', 'None', 'None'),
('11/20/2019', '11:57:29', 'crispin uriarte', 'Delete', 'Brown Folder Long', 'None', 'None'),
('11/20/2019', '11:57:40', 'crispin uriarte', 'Delete', '1/4 sheet of paper', 'None', 'None'),
('11/20/2019', '1:09:51', 'crispin uriarte', 'save', '00006', 'Salary', ''),
('11/20/2019', '1:13:47', 'crispin uriarte', 'save', '00011', 'Salary', ''),
('11/20/2019', '1:15:26', 'crispin uriarte', 'save', '00012', 'Salary', ''),
('11/20/2019', '4:37:14', 'crispin uriarte', 'save', '00014', 'Salary', ''),
('11/23/2019', '12:53:33', 'crispin uriarte', 'Inactive Employee', '00001', '', ''),
('11/23/2019', '12:53:40', 'crispin uriarte', 'Re-active Employee', '00001', '', ''),
('11/23/2019', '12:53:53', 'crispin uriarte', 'Inactive Employee', '00001', '', ''),
('11/28/2019', '7:42:08', 'crispin uriarte', 'Update', '00002', '', ''),
('11/28/2019', '7:45:30', 'crispin uriarte', 'save', '00004', 'Salary', ''),
('12/09/2019', '10:42:01', 'crispin uriarte', 'Inactive Employee', '00014', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `word_tbl`
--

CREATE TABLE `word_tbl` (
  `ID` int(11) NOT NULL,
  `Word` varchar(225) NOT NULL,
  `Meaning` varchar(225) NOT NULL,
  `Spanish` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_tbl`
--
ALTER TABLE `account_tbl`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `employee_tbl`
--
ALTER TABLE `employee_tbl`
  ADD PRIMARY KEY (`ID_Number`);

--
-- Indexes for table `estab_tbl`
--
ALTER TABLE `estab_tbl`
  ADD PRIMARY KEY (`POnum`);

--
-- Indexes for table `info_estab_tbl`
--
ALTER TABLE `info_estab_tbl`
  ADD PRIMARY KEY (`e_establishment`);

--
-- Indexes for table `inv_entry_tbl`
--
ALTER TABLE `inv_entry_tbl`
  ADD PRIMARY KEY (`entry_id`);

--
-- Indexes for table `payroll_tbl`
--
ALTER TABLE `payroll_tbl`
  ADD PRIMARY KEY (`Salary_ID`);

--
-- Indexes for table `ph_tbl`
--
ALTER TABLE `ph_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pi_tbl`
--
ALTER TABLE `pi_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `position_tbl`
--
ALTER TABLE `position_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pulloutlog`
--
ALTER TABLE `pulloutlog`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pullout_tbl`
--
ALTER TABLE `pullout_tbl`
  ADD PRIMARY KEY (`pullout_id`);

--
-- Indexes for table `receipt_tbl`
--
ALTER TABLE `receipt_tbl`
  ADD PRIMARY KEY (`r_number`);

--
-- Indexes for table `sss_table`
--
ALTER TABLE `sss_table`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `stockinout_tbl`
--
ALTER TABLE `stockinout_tbl`
  ADD PRIMARY KEY (`stock_id`);

--
-- Indexes for table `word_tbl`
--
ALTER TABLE `word_tbl`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Word` (`Word`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inv_entry_tbl`
--
ALTER TABLE `inv_entry_tbl`
  MODIFY `entry_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- AUTO_INCREMENT for table `payroll_tbl`
--
ALTER TABLE `payroll_tbl`
  MODIFY `Salary_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `ph_tbl`
--
ALTER TABLE `ph_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pi_tbl`
--
ALTER TABLE `pi_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `position_tbl`
--
ALTER TABLE `position_tbl`
  MODIFY `ID` int(225) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pulloutlog`
--
ALTER TABLE `pulloutlog`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pullout_tbl`
--
ALTER TABLE `pullout_tbl`
  MODIFY `pullout_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- AUTO_INCREMENT for table `sss_table`
--
ALTER TABLE `sss_table`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `stockinout_tbl`
--
ALTER TABLE `stockinout_tbl`
  MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- AUTO_INCREMENT for table `word_tbl`
--
ALTER TABLE `word_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
