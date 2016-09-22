-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-09-2016 a las 13:31:11
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`admin`@`localhost` PROCEDURE `createEjemplar`(IN `editorial` VARCHAR(50), IN `paginas` INT(10), OUT `codigo` INT(10))
BEGIN
INSERT INTO ejemplar (
    editorial,
    paginas)
VALUES (
    LOWER(editorial),
    paginas);
SET codigo = LAST_INSERT_ID();
END$$

CREATE DEFINER=`admin`@`localhost` PROCEDURE `createLibro`(IN `titulo` VARCHAR(50), IN `autor` VARCHAR(50), IN `isbn` VARCHAR(50), OUT `codigo` INT(10))
BEGIN
INSERT INTO libro (
    titulo,
    autor,
    isbn)
VALUES (
    LOWER(titulo),
    LOWER(autor),
    LOWER(isbn));
SET codigo = LAST_INSERT_ID();
END$$

CREATE DEFINER=`admin`@`localhost` PROCEDURE `createUsuario`(IN `nombre` VARCHAR(50), IN `apellidos` VARCHAR(50), IN `fNacimiento` DATE, IN `email` VARCHAR(50), OUT `codigo` INT(10))
BEGIN
INSERT INTO usuario (
    nombre,
    apellidos,
    fNacimiento,
    email)
VALUES (
    LOWER(nombre),
    LOWER(apellidos),
    fNacimiento,
    LOWER(email));
SET codigo = LAST_INSERT_ID();
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE IF NOT EXISTS `ejemplar` (
  `codigo` int(10) NOT NULL AUTO_INCREMENT,
  `codtitulo` int(10) NOT NULL,
  `codusuario` int(10) NOT NULL,
  `editorial` varchar(30) NOT NULL,
  `paginas` int(10) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codtitulo` (`codtitulo`),
  KEY `codusuario` (`codusuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`codigo`, `codtitulo`, `codusuario`, `editorial`, `paginas`) VALUES
(0, 0, 0, 'sin titulo', 0),
(1, 1, 0, 'dBolsillo', 309),
(2, 0, 0, 'anaya', 233);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `codigo` int(10) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) NOT NULL,
  `autor` varchar(30) NOT NULL,
  `isbn` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`codigo`, `titulo`, `autor`, `isbn`) VALUES
(0, 'Sin titulo', 'Anonimo', '00000-00000'),
(1, 'Fundacion', 'Issac Asimov', '2340-1452223-045');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `fnacimiento` date NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigo`, `nombre`, `apellidos`, `fnacimiento`, `email`) VALUES
(0, 'Sin nombre', 'Sin Apellidos', '1900-01-01', 'notengo@email.com'),
(1, 'Silvia', 'Alvarez', '1991-10-06', 'silvia.alvarez@gmail.com'),
(2, 'Javier', 'Paris', '1990-05-30', 'javier.paris@gmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
