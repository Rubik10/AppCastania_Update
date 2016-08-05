-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Servidor: localhost:8889
-- Tiempo de generación: 05-08-2016 a las 23:24:31
-- Versión del servidor: 5.5.42
-- Versión de PHP: 5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `productsAndroid`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HISTORICO`
--

CREATE TABLE `HISTORICO` (
  `ID` int(11) NOT NULL,
  `TITTLE` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `IMGURL` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `uds` int(4) NOT NULL,
  `precio` double(4,2) NOT NULL,
  `rating` double(2,1) NOT NULL,
  `FECHA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `HISTORICO`
--

INSERT INTO `HISTORICO` (`ID`, `TITTLE`, `IMGURL`, `uds`, `precio`, `rating`, `FECHA`) VALUES
(1, 'CDHYF - El Mundo de Hielo y Fuego', '/img/Books/MundoHieloFuego.jpg', 500, 46.00, 8.6, '2016-07-29 15:05:32'),
(79, 'Grand Theft Auto V', '/img/Games/gtaV.jpg', 200, 29.95, 9.9, '2016-08-05 15:58:53'),
(80, 'Grand Theft Auto V', '/img/Games/gtaV.jpg', 200, 29.95, 9.9, '2016-08-05 16:00:42'),
(83, 'CDHYF - El Mundo de Hielo y Fuego', '/img/Books/MundoHieloFuego.jpg', 500, 46.00, 8.6, '2016-08-05 16:14:25'),
(86, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 16:17:59'),
(87, 'New Old Songs', '/img/Music/newolds.jpg', 103, 17.95, 9.0, '2016-08-05 16:19:22'),
(88, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 16:50:55'),
(89, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 18:53:20'),
(90, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 18:55:30'),
(91, 'Metal Gear Solid V: The Phantom Pain', '/img/Games/mgsV.jpg', 3000, 26.95, 9.2, '2016-08-05 18:57:22'),
(92, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 18:59:02'),
(93, 'Chocolate Starfish and the Hot Dog Flavored Water', '/img/Music/hotdog.jpg', 320, 29.00, 9.9, '2016-08-05 19:01:27'),
(94, 'Chocolate Starfish and the Hot Dog Flavored Water', '/img/Music/hotdog.jpg', 320, 29.00, 9.9, '2016-08-05 19:02:19'),
(95, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 19:03:57'),
(96, 'The Last of Us [Remastered]', '/img/Games/lastofus.jpg', 200, 29.95, 9.9, '2016-08-05 19:04:37'),
(97, 'CDHYF I - Juego de Tronos [Lujo]', '/img/Books/JuegoTronos.jpg', 12000, 38.00, 8.9, '2016-08-05 19:09:00'),
(98, 'Chocolate Starfish and the Hot Dog Flavored Water', '/img/Music/hotdog.jpg', 320, 29.00, 9.9, '2016-08-05 19:09:19'),
(99, 'CDHYF - El Mundo de Hielo y Fuego', '/img/Books/MundoHieloFuego.jpg', 350, 36.00, 8.3, '2016-08-05 19:14:14'),
(100, 'Grand Theft Auto V', '/img/Games/gtaV.jpg', 725, 46.95, 9.8, '2016-08-05 19:36:28'),
(101, 'CDHYF I - Juego de Tronos [Lujo]', '/img/Books/JuegoTronos.jpg', 12000, 38.00, 8.9, '2016-08-05 19:37:32'),
(102, 'Grand Theft Auto V', '/img/Games/gtaV.jpg', 725, 46.95, 9.8, '2016-08-05 19:40:30'),
(103, 'CDHYF III - Tormentas de Espadas [Lujo]', '/img/Books/TormentaSpadas.jpg', 9500, 46.00, 9.8, '2016-08-05 20:38:14'),
(104, 'Suicide Squad', '/img/Films/ssquad.jpg', 100, 34.95, 7.5, '2016-08-05 20:57:20');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `HISTORICO`
--
ALTER TABLE `HISTORICO`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `HISTORICO`
--
ALTER TABLE `HISTORICO`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=105;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
