-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25-Abr-2019 às 18:41
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
(12, 'gbhfgh', 'Presidente'),
(14, 'João', 'Diretor de Esportes'),
(123, 'werfewr', 'Diretor de Esportes'),
(149, 'kkkk', 'Diretor Sociocultural'),
(156, 'dsfsdf', 'Diretor Sociocultural'),
(165, 'weskley', 'Orador'),
(168, 'weskley', 'Tesoureiro'),
(456, 'Stefany', 'Presidente'),
(567, 'Qualquer', 'Diretor Sociocultural');

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
(19, 14, 168);

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
(14, 'BILA'),
(15, 'STEFANY'),
(17, 'PSL');

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
-- Extraindo dados da tabela `votos`
--

INSERT INTO `votos` (`voto`, `candidato`, `numero_candidato`) VALUES
(1, 'Stefany', 456),
(2, 'Stefany', 456),
(3, 'Stefany', 456),
(4, 'Stefany', 456),
(5, 'João', 14),
(6, 'weskley', 168),
(7, 'Stefany', 456),
(8, 'Stefany', 456),
(9, 'Stefany', 456);

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
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `votos`
--
ALTER TABLE `votos`
  MODIFY `voto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
