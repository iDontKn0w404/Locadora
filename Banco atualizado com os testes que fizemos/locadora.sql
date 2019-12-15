-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15-Dez-2019 às 17:14
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `locadora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluguel`
--

CREATE TABLE `aluguel` (
  `idaluguel` int(11) NOT NULL,
  `iddvd` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `hora_aluguel` varchar(10) NOT NULL,
  `data_aluguel` varchar(10) NOT NULL,
  `data_devolucao` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluguel`
--

INSERT INTO `aluguel` (`idaluguel`, `iddvd`, `idcliente`, `hora_aluguel`, `data_aluguel`, `data_devolucao`) VALUES
(1, 3, 1, '03:19', '14/12/2019', '20/12/2019'),
(2, 3, 2, '03:56', '14/12/2019', '30/12/2019'),
(3, 3, 2, '04:37', '14/12/2019', '21/12/2019'),
(5, 4, 2, '01:07', '15/12/2019', '21/12/2019'),
(6, 3, 1, '01:09', '15/12/2019', '31/12/2019'),
(7, 3, 1, '01:11', '15/12/2019', '31/12/2019');

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `nome`) VALUES
(1, 'Terror'),
(2, 'Ação'),
(3, 'Teste1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `classificacao`
--

CREATE TABLE `classificacao` (
  `idclassificacao` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `classificacao`
--

INSERT INTO `classificacao` (`idclassificacao`, `nome`, `preco`) VALUES
(1, 'Bronze', 15),
(2, 'Prata', 30),
(3, 'Ouro', 50),
(4, 'Teste1', 111.11);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `data_nasc` varchar(10) NOT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `telefone` varchar(20) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL,
  `cep` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nome`, `data_nasc`, `rg`, `cpf`, `email`, `telefone`, `bairro`, `rua`, `numero`, `cep`) VALUES
(1, 'QUALQUER', '45/36/4534', '12345678675345678865', '233.454.342-56', 'QUALQUER@QUALQUER.COM', '54666664565', 'JHVIYVYADIVLAV', '4564566', 5, '55612-651'),
(2, 'Melissa Alves Soarez', '19/06/2002', '13506978764534231436', '123.456.789-00', 'alveslissa@hotmail.com', '999999900909', 'Centro', 'Rua José Algusto', 5, '59920-000');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dvd`
--

CREATE TABLE `dvd` (
  `iddvd` int(11) NOT NULL,
  `idfilme` int(11) NOT NULL,
  `preco_compra` double DEFAULT NULL,
  `data_compra` varchar(10) DEFAULT NULL,
  `situacao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `dvd`
--

INSERT INTO `dvd` (`iddvd`, `idfilme`, `preco_compra`, `data_compra`, `situacao`) VALUES
(1, 2, 556, '04/08/2012', 'Indisponivel'),
(2, 2, 5589, '09/08/2007', 'Ausente'),
(3, 2, 566, '19/06/2018', 'Disponivel'),
(4, 2, 789, '19/08/2020', 'Disponivel');

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme`
--

CREATE TABLE `filme` (
  `idfilme` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `ano` int(11) DEFAULT NULL,
  `duracao` varchar(10) DEFAULT NULL,
  `idcategoria` int(11) NOT NULL,
  `idclassificacao` int(11) NOT NULL,
  `capa` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `filme`
--

INSERT INTO `filme` (`idfilme`, `titulo`, `ano`, `duracao`, `idcategoria`, `idclassificacao`, `capa`) VALUES
(2, 'NumSei', 2005, '02:34:54', 1, 2, 'delete.png'),
(3, 'Teste1', 2011, '11:11:11', 3, 4, '1.jpg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `nome`, `login`, `senha`) VALUES
(1, 'Administrador', 'qwe', '123');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD PRIMARY KEY (`idaluguel`),
  ADD KEY `idcliente` (`idcliente`),
  ADD KEY `iddvd` (`iddvd`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idcategoria`);

--
-- Índices para tabela `classificacao`
--
ALTER TABLE `classificacao`
  ADD PRIMARY KEY (`idclassificacao`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Índices para tabela `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`iddvd`),
  ADD KEY `idfilme` (`idfilme`);

--
-- Índices para tabela `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`idfilme`),
  ADD KEY `idcategoria` (`idcategoria`),
  ADD KEY `idclassificacao` (`idclassificacao`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluguel`
--
ALTER TABLE `aluguel`
  MODIFY `idaluguel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `classificacao`
--
ALTER TABLE `classificacao`
  MODIFY `idclassificacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `dvd`
--
ALTER TABLE `dvd`
  MODIFY `iddvd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `filme`
--
ALTER TABLE `filme`
  MODIFY `idfilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD CONSTRAINT `aluguel_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  ADD CONSTRAINT `aluguel_ibfk_2` FOREIGN KEY (`iddvd`) REFERENCES `dvd` (`iddvd`);

--
-- Limitadores para a tabela `dvd`
--
ALTER TABLE `dvd`
  ADD CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`idfilme`) REFERENCES `filme` (`idfilme`);

--
-- Limitadores para a tabela `filme`
--
ALTER TABLE `filme`
  ADD CONSTRAINT `filme_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`),
  ADD CONSTRAINT `filme_ibfk_2` FOREIGN KEY (`idclassificacao`) REFERENCES `classificacao` (`idclassificacao`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
