-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Jun-2019 às 20:06
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.2

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
  `funcao` varchar(25) NOT NULL
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
(159, 'João', 'Diretor de Marketing'),
(456, 'joão', 'Presidente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidatos_has_chapa`
--

CREATE TABLE `candidatos_has_chapa` (
  `codigo` int(11) NOT NULL,
  `chapa_numero` int(11) DEFAULT NULL,
  `candidato_numero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `candidatos_has_chapa`
--

INSERT INTO `candidatos_has_chapa` (`codigo`, `chapa_numero`, `candidato_numero`) VALUES
(1, 13, 13),
(2, 17, 17),
(3, 13, 15),
(4, 13, 1415),
(5, 56, 456),
(6, 17, 17),
(7, 17, 176),
(8, 17, 17),
(9, 17, 14),
(10, 17, 14),
(11, 17, 14),
(12, 17, 12),
(13, 17, 149),
(14, 17, 567),
(15, 15, 456),
(16, 14, 165),
(17, 14, 123),
(18, 14, 156),
(19, 14, 168),
(20, 40, 456),
(21, 40, 456),
(22, 40, 456),
(23, 40, 123),
(24, 40, 456),
(25, 40, 456),
(26, 40, 123),
(27, 2, 183),
(28, 3, 158),
(29, 75, 786),
(30, 25, 456),
(31, 25, 654),
(32, 78, 897),
(33, 13, 89),
(34, 77, 786),
(35, 77, 786),
(36, 77, 786),
(37, 77, 786),
(38, 77, 786),
(39, 77, 786),
(40, 77, 786),
(41, 77, 786),
(42, 77, 782),
(43, 85, 149),
(44, 10, 345),
(45, 2, 123),
(46, 2, 123),
(47, 2, 123),
(48, 2, 123),
(49, 2, 123),
(50, 2, 123),
(51, 2, 123),
(52, 2, 123),
(53, 2, 741),
(54, 13, 13),
(55, 75, 721),
(56, 12, 456),
(57, 12, 789),
(58, 12, 159),
(59, 45, 456);

-- --------------------------------------------------------

--
-- Estrutura da tabela `chapa`
--

CREATE TABLE `chapa` (
  `numero` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `TOTAL` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `chapa`
--

INSERT INTO `chapa` (`numero`, `nome`, `TOTAL`) VALUES
(1, 'NULO', 0),
(2, 'BRANCO', 0),
(11, 'UEP - UNIÃO ESTUDANTIL PROFISSIONAL', 0),
(21, 'F.A.C.E - FAZENDO ACONTECER COM EFICIÊNCIA', 0),
(34, 'EPRS - ESTUDANDES EM PROL DO SUCESSO', 0),
(81, 'ADE - ALIANÇA DEMOCRÁTICA ESTUDANTIL', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `votos`
--

CREATE TABLE `votos` (
  `voto` int(11) NOT NULL,
  `candidato` varchar(45) NOT NULL,
  `numero_candidato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Indexes for table `votos`
--
ALTER TABLE `votos`
  ADD PRIMARY KEY (`voto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidatos_has_chapa`
--
ALTER TABLE `candidatos_has_chapa`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `votos`
--
ALTER TABLE `votos`
  MODIFY `voto` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
