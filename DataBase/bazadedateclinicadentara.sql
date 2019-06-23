-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2019 at 06:37 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bazadedateclinicadentara`
--

-- --------------------------------------------------------

--
-- Table structure for table `angajat`
--

CREATE TABLE `angajat` (
  `IdAngajat` int(11) NOT NULL,
  `Nume` varchar(50) NOT NULL,
  `Prenume` varchar(50) NOT NULL,
  `CNP` varchar(20) NOT NULL,
  `Sters` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angajat`
--

INSERT INTO `angajat` (`IdAngajat`, `Nume`, `Prenume`, `CNP`, `Sters`) VALUES
(1, 'Mihai', 'Diana', '2321321321', 0),
(2, 'Marinescu', 'Ioana', '24343432432', 0),
(3, 'Ramon', 'Ioana', '24343432432', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `cont`
--

CREATE TABLE `cont` (
  `IdCont` int(11) NOT NULL,
  `IdAngajat` int(11) NOT NULL,
  `IdRol` int(11) NOT NULL,
  `NumeUtilizator` varchar(50) NOT NULL,
  `Parola` varchar(50) NOT NULL,
  `Sters` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cont`
--

INSERT INTO `cont` (`IdCont`, `IdAngajat`, `IdRol`, `NumeUtilizator`, `Parola`, `Sters`) VALUES
(1, 1, 1, 'Diana', '1234', 0),
(2, 2, 2, 'Elena', '1234', 0),
(4, 2, 2, 'Ioana', '1234', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `interventie`
--

CREATE TABLE `interventie` (
  `IdInterventie` int(11) NOT NULL,
  `IdMedic` int(11) NOT NULL,
  `IdTipInterventie` int(11) NOT NULL,
  `IdPacient` int(11) NOT NULL,
  `DataInterventie` datetime NOT NULL,
  `IdPretInterventie` int(11) NOT NULL,
  `Sters` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pacient`
--

CREATE TABLE `pacient` (
  `IdPacient` int(11) NOT NULL,
  `IdAngajat` int(11) NOT NULL,
  `Nume` varchar(50) NOT NULL,
  `Prenume` varchar(50) NOT NULL,
  `CNP` varchar(20) NOT NULL,
  `Sters` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pacient`
--

INSERT INTO `pacient` (`IdPacient`, `IdAngajat`, `Nume`, `Prenume`, `CNP`, `Sters`) VALUES
(1, 2, 'Danescu', 'Mihai', '1234322343', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `preturi`
--

CREATE TABLE `preturi` (
  `IdPret` int(11) NOT NULL,
  `DataInceput` date NOT NULL,
  `DataSfarsit` date DEFAULT NULL,
  `IdTipInterventie` int(11) NOT NULL,
  `Pret` float NOT NULL,
  `Sters` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preturi`
--

INSERT INTO `preturi` (`IdPret`, `DataInceput`, `DataSfarsit`, `IdTipInterventie`, `Pret`, `Sters`) VALUES
(1, '2019-06-08', NULL, 1, 250, NULL),
(2, '2019-05-16', '2019-06-08', 1, 240, NULL),
(4, '2019-04-17', '2019-05-16', 1, 230, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `programare`
--

CREATE TABLE `programare` (
  `IdProgramare` int(11) NOT NULL,
  `IdMedic` int(11) NOT NULL,
  `IdPacient` int(11) NOT NULL,
  `Data` datetime NOT NULL,
  `Sters` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

CREATE TABLE `rol` (
  `IdRol` int(11) NOT NULL,
  `Denumire` varchar(50) NOT NULL,
  `Sters` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`IdRol`, `Denumire`, `Sters`) VALUES
(1, 'Administrator', 0),
(2, 'Medic', 0);

-- --------------------------------------------------------

--
-- Table structure for table `salariu`
--

CREATE TABLE `salariu` (
  `IdSalariu` int(11) NOT NULL,
  `IdAngajat` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Valoare` float NOT NULL,
  `Sters` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salariu`
--

INSERT INTO `salariu` (`IdSalariu`, `IdAngajat`, `Data`, `Valoare`, `Sters`) VALUES
(1, 1, '2019-06-15', 2500, 0),
(2, 1, '2019-05-15', 2500, 0),
(3, 1, '2019-04-15', 2400, 0),
(4, 1, '2019-03-15', 2400, 0),
(5, 1, '2019-02-15', 2600, 0),
(6, 1, '2019-01-15', 2600, 0),
(7, 1, '2018-12-15', 2200, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tipinterventie`
--

CREATE TABLE `tipinterventie` (
  `IdTipInterventie` int(11) NOT NULL,
  `Denumire` varchar(50) NOT NULL,
  `Sters` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipinterventie`
--

INSERT INTO `tipinterventie` (`IdTipInterventie`, `Denumire`, `Sters`) VALUES
(1, 'Plomba', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `angajat`
--
ALTER TABLE `angajat`
  ADD PRIMARY KEY (`IdAngajat`);

--
-- Indexes for table `cont`
--
ALTER TABLE `cont`
  ADD PRIMARY KEY (`IdCont`);

--
-- Indexes for table `interventie`
--
ALTER TABLE `interventie`
  ADD PRIMARY KEY (`IdInterventie`);

--
-- Indexes for table `pacient`
--
ALTER TABLE `pacient`
  ADD PRIMARY KEY (`IdPacient`);

--
-- Indexes for table `preturi`
--
ALTER TABLE `preturi`
  ADD PRIMARY KEY (`IdPret`);

--
-- Indexes for table `programare`
--
ALTER TABLE `programare`
  ADD PRIMARY KEY (`IdProgramare`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`IdRol`);

--
-- Indexes for table `salariu`
--
ALTER TABLE `salariu`
  ADD PRIMARY KEY (`IdSalariu`);

--
-- Indexes for table `tipinterventie`
--
ALTER TABLE `tipinterventie`
  ADD PRIMARY KEY (`IdTipInterventie`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angajat`
--
ALTER TABLE `angajat`
  MODIFY `IdAngajat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cont`
--
ALTER TABLE `cont`
  MODIFY `IdCont` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `interventie`
--
ALTER TABLE `interventie`
  MODIFY `IdInterventie` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pacient`
--
ALTER TABLE `pacient`
  MODIFY `IdPacient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `preturi`
--
ALTER TABLE `preturi`
  MODIFY `IdPret` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `programare`
--
ALTER TABLE `programare`
  MODIFY `IdProgramare` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
  MODIFY `IdRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `salariu`
--
ALTER TABLE `salariu`
  MODIFY `IdSalariu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tipinterventie`
--
ALTER TABLE `tipinterventie`
  MODIFY `IdTipInterventie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
