-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Abr-2019 às 03:12
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `urna`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidatofuncao`
--

CREATE TABLE `candidatofuncao` (
  `funcao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `candidatofuncao`
--

INSERT INTO `candidatofuncao` (`funcao`) VALUES
('Diretor de Esportes'),
('Diretor de Marketing'),
('Diretor Sociocultural'),
('Orador'),
('Presidente'),
('Secretário'),
('Tesoureiro'),
('Vice-Presidente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidatos`
--

CREATE TABLE `candidatos` (
  `numero` int(3) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `funcao` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `candidatos`
--

INSERT INTO `candidatos` (`numero`, `nome`, `funcao`) VALUES
(12, 'jota', 'Orador'),
(13, 'Lulinha', 'Presidente'),
(15, 'Jonh jhones', 'Diretor de Esportes'),
(17, 'Weskley', 'Presidente'),
(123, 'Junior', 'Vice presidente'),
(177, 'Tobias', 'Diretor de Marketing'),
(456, 'Ronaldo', 'Diretor Sociocultural'),
(1415, 'hfdg', 'Diretor de Marketing');

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidatos_has_chapa`
--

CREATE TABLE `candidatos_has_chapa` (
  `codigo` int(11) NOT NULL,
  `candidato_numero` int(11) DEFAULT NULL,
  `chapa_numero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `candidatos_has_chapa`
--

INSERT INTO `candidatos_has_chapa` (`codigo`, `candidato_numero`, `chapa_numero`) VALUES
(1, 13, 13),
(2, 13, 12),
(3, 123, 13),
(4, 17, 17),
(5, 17, 17),
(6, 177, 17);

-- --------------------------------------------------------

--
-- Estrutura da tabela `chapa`
--

CREATE TABLE `chapa` (
  `numero` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `chapa`
--

INSERT INTO `chapa` (`numero`, `nome`) VALUES
(17, 'PSL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidatofuncao`
--
ALTER TABLE `candidatofuncao`
  ADD PRIMARY KEY (`funcao`);

--
-- Indexes for table `candidatos`
--
ALTER TABLE `candidatos`
  ADD PRIMARY KEY (`numero`);

--
-- Indexes for table `candidatos_has_chapa`
--
ALTER TABLE `candidatos_has_chapa`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `chapa`
--
ALTER TABLE `chapa`
  ADD PRIMARY KEY (`numero`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidatos_has_chapa`
--
ALTER TABLE `candidatos_has_chapa`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
