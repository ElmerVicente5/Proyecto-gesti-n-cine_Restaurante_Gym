-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2022 a las 16:35:56
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `appcovid`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `id` int(11) NOT NULL,
  `nombreCliente` text NOT NULL,
  `dpiCliente` varchar(15) NOT NULL,
  `temperatura` float NOT NULL,
  `sala` tinyint(4) NOT NULL,
  `numAsiento` varchar(50) NOT NULL,
  `fechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`id`, `nombreCliente`, `dpiCliente`, `temperatura`, `sala`, `numAsiento`, `fechaHora`) VALUES
(1, 'elmer', '2890', 0, 1, ' 32', '2022-10-26 21:47:02'),
(2, 'jouse', '80562', 0, 2, ' 76', '2022-10-29 01:07:04'),
(3, 'francisco', '7890', 0, 4, ' 12', '2022-10-29 01:40:48'),
(4, 'rosa', '8790', 0, 2, ' 12', '2022-10-29 02:16:13'),
(5, 'Elmer Vicente', '83170', 0, 0, ' 52', '2022-10-29 06:43:41'),
(6, 'leopardo', '89630', 0, 0, ' 76', '2022-10-29 07:23:14'),
(7, 'jesica', '89763', 0, 0, ' 32', '2022-10-29 07:39:02'),
(8, 'JOSE', '259', 0, 0, ' 72', '2022-10-29 07:47:22'),
(9, 'aldo', '8960', 0, 2, ' 16', '2022-10-29 08:00:32'),
(10, 'saitama', '89630', 0, 2, ' 76', '2022-10-29 08:08:27'),
(11, 'stacy', '8790', 0, 1, ' 56', '2022-10-29 08:16:26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gimnasio`
--

CREATE TABLE `gimnasio` (
  `id` int(11) NOT NULL,
  `nombreCliente` text NOT NULL,
  `dpiCliente` text NOT NULL,
  `temperatura` float NOT NULL,
  `fechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gimnasio`
--

INSERT INTO `gimnasio` (`id`, `nombreCliente`, `dpiCliente`, `temperatura`, `fechaHora`) VALUES
(1, 'elmer', '8040', 36.5, '2022-10-29 01:20:12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE `restaurante` (
  `id` int(11) NOT NULL,
  `nombrecliente` text NOT NULL,
  `dpiCliente` varchar(15) NOT NULL,
  `temperatura` float(9,5) NOT NULL,
  `numMesa` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`id`, `nombrecliente`, `dpiCliente`, `temperatura`, `numMesa`, `fechaHora`) VALUES
(1, 'elmer', '3040', 38.60000, 2, '2022-10-27 22:25:41'),
(2, 'elmer', '2896', 37.00000, 2, '2022-10-28 14:56:00'),
(3, 'antoni', '8040', 37.00000, 2, '2022-10-28 17:22:19'),
(4, 'elmer', '9090', 38.00000, 4, '2022-10-28 17:25:10'),
(5, 'eee', '4060', 78.50000, 6, '2022-10-28 18:18:09'),
(6, 'ramiro', '8954780', 36.50000, 6, '2022-10-29 02:18:37'),
(7, 'estefany', '288483170', 36.50000, 8, '2022-10-29 02:19:25');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `gimnasio`
--
ALTER TABLE `gimnasio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cine`
--
ALTER TABLE `cine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `gimnasio`
--
ALTER TABLE `gimnasio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
