-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2025 a las 03:31:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinaria_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dueno`
--

CREATE TABLE `dueno` (
  `id_dueno` int(11) NOT NULL,
  `rut` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dueno`
--

INSERT INTO `dueno` (`id_dueno`, `rut`, `nombre`, `telefono`, `direccion`) VALUES
(1, '19.176.632-6', 'matias posada', '978441549', 'dupliza 55'),
(2, '14.411.239-2', 'franca verreni quiroga', '996952443', 'duplñiza 55'),
(5, '141454564', 'javier menendez', '7897452142', 'asdasdasdad'),
(7, '1441123-3', 'franca verreni', '978441549', 'dupliza 55');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `motivo` varchar(150) NOT NULL,
  `diagnostico` varchar(200) NOT NULL,
  `tratamiento` varchar(200) NOT NULL,
  `id_mascota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`id_historial`, `fecha`, `motivo`, `diagnostico`, `tratamiento`, `id_mascota`) VALUES
(4, '1996-12-12', 'dolor de guata', 'domperamina', 'gastritits', 1),
(5, '2025-11-16', 'ala rota', 'yeso', 'fractura', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `id_mascota` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `especie` varchar(50) NOT NULL,
  `raza` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `id_dueno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id_mascota`, `nombre`, `especie`, `raza`, `edad`, `id_dueno`) VALUES
(1, 'freyja', 'gato', 'kiltra', 6, 1),
(2, 'pepe', 'loro', 'africano', 2, 7);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dueno`
--
ALTER TABLE `dueno`
  ADD PRIMARY KEY (`id_dueno`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id_historial`),
  ADD KEY `fk_historial_mascota` (`id_mascota`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id_mascota`),
  ADD KEY `fk_mascota_dueno` (`id_dueno`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dueno`
--
ALTER TABLE `dueno`
  MODIFY `id_dueno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `id_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id_mascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `fk_historial_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mascota` (`id_mascota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `fk_mascota_dueno` FOREIGN KEY (`id_dueno`) REFERENCES `dueno` (`id_dueno`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
