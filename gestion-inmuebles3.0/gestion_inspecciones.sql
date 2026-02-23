-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2026 a las 16:10:11
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
-- Base de datos: `gestion_inspecciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `dni`, `email`, `nombre`) VALUES
(2, '12345678Z', 'carlos@email.com', 'Carlos Alcántara'),
(3, '12332165X', 'pablo_nuevo_email@gmail.com', 'Pablo Arnau'),
(4, '78945612A', 'pedrito@gmail.com', 'Pedrito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desperfecto`
--

CREATE TABLE `desperfecto` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `gravedad` varchar(255) DEFAULT NULL,
  `inmueble_id` bigint(20) DEFAULT NULL,
  `reporte_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `desperfecto`
--

INSERT INTO `desperfecto` (`id`, `descripcion`, `gravedad`, `inmueble_id`, `reporte_id`) VALUES
(1, 'Grieta fachada - AUMENTO DE TAMAÑO', 'CRÍTICA', 2, NULL),
(2, 'Goteras', 'Baja', 2, NULL),
(3, 'Grieta en la puerta', 'Media', 4, 5),
(4, 'Grieta en la pared', 'Alta', 4, 5),
(5, 'Grieta en el sotano', 'Alta', 4, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmueble`
--

CREATE TABLE `inmueble` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inmueble`
--

INSERT INTO `inmueble` (`id`, `ciudad`, `direccion`, `cliente_id`) VALUES
(2, 'Madrid', 'Av. Principal 10', 3),
(3, 'Valencia', 'Calle Antonio Gutierrez puerta 7', 3),
(4, 'San Sebastian', 'calle san sebastian 4', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inspeccion`
--

CREATE TABLE `inspeccion` (
  `id` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `inmueble_id` bigint(20) DEFAULT NULL,
  `inspector_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inspeccion`
--

INSERT INTO `inspeccion` (`id`, `estado`, `fecha`, `inmueble_id`, `inspector_id`) VALUES
(2, 'PENDIENTE', '2026-03-15 09:30:00.000000', 2, 3),
(4, 'PENDIENTE', '2026-03-15 10:30:00.000000', 4, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inspectors`
--

CREATE TABLE `inspectors` (
  `id` bigint(20) NOT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `numero_colegiado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inspectors`
--

INSERT INTO `inspectors` (`id`, `especialidad`, `nombre`, `numero_colegiado`) VALUES
(2, 'Diseños', 'Julio Perito2', NULL),
(3, 'Goteras', 'Pepe Inspector', '13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE `reporte` (
  `id` bigint(20) NOT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `observaciones_generales` varchar(255) DEFAULT NULL,
  `inspeccion_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reporte`
--

INSERT INTO `reporte` (`id`, `fecha_creacion`, `observaciones_generales`, `inspeccion_id`) VALUES
(3, '2026-02-22', 'ACTUALIZACIÓN: Se requiere apuntalamiento inmediato de la fachada norte por riesgo de desprendimiento.', 2),
(5, '2026-02-23', 'La inspeccion revela mucho daño en los cimientos de la casa por culpa de filtraciones de agua y generacion de grietas.', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKjlcg5nhnauli1hu4ojldsedaw` (`dni`);

--
-- Indices de la tabla `desperfecto`
--
ALTER TABLE `desperfecto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKktgjiobf8d1sqg7fpt4ld10fs` (`inmueble_id`),
  ADD KEY `FKaqs4rocepqxqyopgyha5s30dp` (`reporte_id`);

--
-- Indices de la tabla `inmueble`
--
ALTER TABLE `inmueble`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf2of3sgdgepujd82bpxnahq65` (`cliente_id`);

--
-- Indices de la tabla `inspeccion`
--
ALTER TABLE `inspeccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeo5yhp5b3d8tw1m119xiy4hvd` (`inmueble_id`),
  ADD KEY `FK6icga2842x8p3oboh9mu89csa` (`inspector_id`);

--
-- Indices de la tabla `inspectors`
--
ALTER TABLE `inspectors`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK99j3nt5ceg2x7wi803y7n239v` (`numero_colegiado`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKqql9tdkoh4wggnpfctba0037a` (`inspeccion_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `desperfecto`
--
ALTER TABLE `desperfecto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `inmueble`
--
ALTER TABLE `inmueble`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `inspeccion`
--
ALTER TABLE `inspeccion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `inspectors`
--
ALTER TABLE `inspectors`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `desperfecto`
--
ALTER TABLE `desperfecto`
  ADD CONSTRAINT `FKaqs4rocepqxqyopgyha5s30dp` FOREIGN KEY (`reporte_id`) REFERENCES `reporte` (`id`),
  ADD CONSTRAINT `FKktgjiobf8d1sqg7fpt4ld10fs` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`id`);

--
-- Filtros para la tabla `inmueble`
--
ALTER TABLE `inmueble`
  ADD CONSTRAINT `FKf2of3sgdgepujd82bpxnahq65` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `inspeccion`
--
ALTER TABLE `inspeccion`
  ADD CONSTRAINT `FK6icga2842x8p3oboh9mu89csa` FOREIGN KEY (`inspector_id`) REFERENCES `inspectors` (`id`),
  ADD CONSTRAINT `FKeo5yhp5b3d8tw1m119xiy4hvd` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`id`);

--
-- Filtros para la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD CONSTRAINT `FKpde6wm9o39o5bpqlhekv33kho` FOREIGN KEY (`inspeccion_id`) REFERENCES `inspeccion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
