-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2019 at 04:37 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assurance`
--

-- --------------------------------------------------------

--
-- Table structure for table `agence`
--

CREATE TABLE `agence` (
  `id` int(11) NOT NULL,
  `compagnie_id` int(11) DEFAULT NULL,
  `zone` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` int(11) NOT NULL,
  `nbr_employer` int(11) NOT NULL,
  `fax` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `agence`
--

INSERT INTO `agence` (`id`, `compagnie_id`, `zone`, `telephone`, `nbr_employer`, `fax`) VALUES
(1, 5, 'Ariana', 123456, 12, 12345678),
(2, 5, 'borj sedria', 55486597, 5, 55486597),
(3, 5, 'tunis', 20461217, 20, 20461217),
(4, 5, 'borj cedria', 0, 5, 55486597);

-- --------------------------------------------------------

--
-- Table structure for table `avenant_police`
--

CREATE TABLE `avenant_police` (
  `id` int(10) UNSIGNED NOT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `object_id` int(10) UNSIGNED NOT NULL,
  `diffs` longtext COLLATE utf8_unicode_ci COMMENT '(DC2Type:json_array)',
  `blame_id` int(10) UNSIGNED DEFAULT NULL,
  `blame_user` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `avenant_police`
--

INSERT INTO `avenant_police` (`id`, `type`, `object_id`, `diffs`, `blame_id`, `blame_user`, `ip`, `created_at`) VALUES
(1, 'insert', 1, '{\"date_effet_police\":{\"old\":null,\"new\":\"2019-02-28 20:03:14\"},\"classe\":{\"old\":\"\",\"new\":\"8\"},\"coef_classe\":{\"old\":null,\"new\":0.7},\"codeAssure\":{\"old\":null,\"new\":{\"label\":\"assure_ariana\",\"class\":\"AppBundle\\\\Entity\\\\Assure\",\"table\":\"user\",\"id\":\"1\"}},\"agence\":{\"old\":null,\"new\":{\"label\":\"AppBundle\\\\Entity\\\\Agence#1\",\"class\":\"AppBundle\\\\Entity\\\\Agence\",\"table\":\"agence\",\"id\":\"1\"}}}', NULL, NULL, NULL, '2019-02-28 19:03:14'),
(2, 'insert', 2, '{\"date_effet_police\":{\"old\":null,\"new\":\"2019-02-28 20:03:14\"},\"classe\":{\"old\":\"\",\"new\":\"8\"},\"coef_classe\":{\"old\":null,\"new\":0.7},\"codeAssure\":{\"old\":null,\"new\":{\"label\":\"assure_maroc\",\"class\":\"AppBundle\\\\Entity\\\\Assure\",\"table\":\"user\",\"id\":\"2\"}},\"agence\":{\"old\":null,\"new\":{\"label\":\"AppBundle\\\\Entity\\\\Agence#1\",\"class\":\"AppBundle\\\\Entity\\\\Agence\",\"table\":\"agence\",\"id\":\"1\"}}}', NULL, NULL, NULL, '2019-02-28 19:03:14');

-- --------------------------------------------------------

--
-- Table structure for table `constat`
--

CREATE TABLE `constat` (
  `code_rec` int(11) NOT NULL,
  `Croquis` blob NOT NULL,
  `Matricule_autrui` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `courtier_compagnie`
--

CREATE TABLE `courtier_compagnie` (
  `compagnie_id` int(11) NOT NULL,
  `courtier_id` int(11) NOT NULL,
  `accept` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `courtier_compagnie`
--

INSERT INTO `courtier_compagnie` (`compagnie_id`, `courtier_id`, `accept`) VALUES
(5, 11, 1),
(5, 29, 1),
(28, 29, 1);

-- --------------------------------------------------------

--
-- Table structure for table `garantie_complementaire`
--

CREATE TABLE `garantie_complementaire` (
  `id` int(11) NOT NULL,
  `compagnie_id` int(11) DEFAULT NULL,
  `tarif_de_base` double DEFAULT NULL,
  `niv_franchise` double DEFAULT NULL,
  `prime_de_base` double DEFAULT NULL,
  `nom` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `surprime` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `garantie_complementaire`
--

INSERT INTO `garantie_complementaire` (`id`, `compagnie_id`, `tarif_de_base`, `niv_franchise`, `prime_de_base`, `nom`, `surprime`) VALUES
(1, 5, NULL, NULL, 15000, 'vol', 0.026),
(2, 5, NULL, NULL, 10000, 'Incendie', 0.045),
(3, 5, 30000, NULL, NULL, 'Defense', NULL),
(4, 5, 20, 5, 120, 'glass brisé', 2);

-- --------------------------------------------------------

--
-- Table structure for table `police`
--

CREATE TABLE `police` (
  `id` int(11) NOT NULL,
  `code_assure_id` int(11) DEFAULT NULL,
  `agence_id` int(11) DEFAULT NULL,
  `date_effet_police` datetime NOT NULL,
  `date_echeance` datetime DEFAULT NULL,
  `statut` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `classe` int(11) DEFAULT NULL,
  `coef_classe` double DEFAULT NULL,
  `nature` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usage_contrat` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `police`
--

INSERT INTO `police` (`id`, `code_assure_id`, `agence_id`, `date_effet_police`, `date_echeance`, `statut`, `montant`, `classe`, `coef_classe`, `nature`, `usage_contrat`) VALUES
(1, 1, 1, '2019-02-28 20:03:14', NULL, NULL, NULL, 8, 0.7, NULL, NULL),
(2, 2, 2, '2019-02-28 20:03:14', NULL, NULL, NULL, 8, 0.7, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `police_garantis`
--

CREATE TABLE `police_garantis` (
  `garantie_complementaire_id` int(11) NOT NULL,
  `police_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `primerc`
--

CREATE TABLE `primerc` (
  `id` int(11) NOT NULL,
  `puissance_fiscale` double NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `primerc`
--

INSERT INTO `primerc` (`id`, `puissance_fiscale`, `prix`) VALUES
(1, 2, 333564),
(3, 4, 126300),
(5, 6, 7896),
(6, 7, 280000),
(7, 8, 280000),
(9, 15, 4456),
(10, 1111, 1),
(11, 444, 4444),
(12, 88856, 5563),
(13, 19, 147896635),
(14, 98, 3215),
(16, 999999, 7),
(17, 888, 8),
(18, 777777, 7),
(19, 888899965, 5),
(20, 27, 556),
(21, 321, 321);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `code_rec` int(11) NOT NULL,
  `code_sinistre_id` int(11) DEFAULT NULL,
  `expert_id` int(11) DEFAULT NULL,
  `date_rec` date NOT NULL,
  `lieu_rec` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `objet_rec` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `commentaire_rec` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `titre_rap` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `detaille_rap` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_rap` date DEFAULT NULL,
  `temp_rap` time DEFAULT NULL,
  `dtype` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sinistre`
--

CREATE TABLE `sinistre` (
  `code` int(11) NOT NULL,
  `contrat_id` int(11) DEFAULT NULL,
  `chassis_number` varchar(17) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modele_id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reclamation_id` int(11) DEFAULT NULL,
  `date_declaration` datetime NOT NULL,
  `date_sinistre` datetime NOT NULL,
  `lieu_sinistre` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `dommage_corps` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cin_conducteur` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dommage_materiel` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `temoin`
--

CREATE TABLE `temoin` (
  `sinistre_id` int(11) DEFAULT NULL,
  `CinT` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `NomT` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PrenomT` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TelT` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `agence_id` int(11) DEFAULT NULL,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci COMMENT '(DC2Type:array)',
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cin` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nom` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `adresse` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `raison_social` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `responsable_societe` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tel` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Gender` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fax` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Profession` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `Date_enreg` datetime DEFAULT NULL,
  `nom_compagnie` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fixe` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `site` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lieu` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `commission` double DEFAULT NULL,
  `cin_exp` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nom_exp` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom_exp` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zone_exp` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel_exp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `agence_id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `type`, `cin`, `nom`, `prenom`, `telephone`, `adresse`, `raison_social`, `responsable_societe`, `Tel`, `Gender`, `Fax`, `Profession`, `birthdate`, `Date_enreg`, `nom_compagnie`, `fixe`, `site`, `lieu`, `commission`, `cin_exp`, `nom_exp`, `prenom_exp`, `zone_exp`, `tel_exp`) VALUES
(1, NULL, 'assure_ariana', 'assure_ariana', 'assure_ariana@assurance.tn', 'assure_ariana@assurance.tn', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', '2019-04-03 16:55:24', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_ASSURE\";}', 'assure', '11917217', 'Omrani', 'Mahmoud', NULL, NULL, NULL, NULL, '123456', NULL, '123456', 'Software Developer', NULL, '2019-02-28 20:03:14', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, NULL, 'assure_maroc', 'assure_maroc', 'assure_maroc@assurance.tn', 'assure_maroc@assurance.tn', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', '2019-02-28 20:23:57', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_ASSURE\";}', 'assure', '07477', 'pi', 'dev', NULL, NULL, NULL, NULL, '1234567', NULL, '1234567', 'Software Developer', NULL, '2019-02-28 20:03:14', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, NULL, 'expert_ariana', 'expert_ariana', 'expert_ariana@assurance.tn', 'expert_ariana@assurance.tn', 1, NULL, '$2y$13$YUaJl5d1qF8y4x3eEfgwxOTaQZF/FHyxjVcmXaG8BXNIYz727hkUi', '2019-04-29 16:41:41', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_EXPERT\";}', 'expert', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '09135478', '3ayédi', 'BahaEddine', 'Ariana', 12345678),
(5, NULL, 'gat.respo', 'gat.respo', 'gat@gmail.com', 'gat@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', '2019-03-31 13:45:18', NULL, NULL, 'a:1:{i:0;s:14:\"ROLE_COMPAGNIE\";}', 'compagnie', NULL, NULL, NULL, NULL, 'ben arous', NULL, NULL, '12345678', NULL, '12345678', NULL, NULL, NULL, 'GAT', '12345678', 'gat.tn', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 1, 'agent_GAT_Ariana', 'agent_gat_ariana', 'agent_GAT_Ariana@assurance.tn', 'agent_gat_ariana@assurance.tn', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, 'a:1:{i:0;s:18:\"ROLE_AGENT_GENERAL\";}', 'agent', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 2, 'agent__borjsedria', 'agent__borjsedria', 'agent__borjsedria@gmail.com', 'agent__borjsedria@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, 'a:1:{i:0;s:18:\"ROLE_AGENT_GENERAL\";}', 'agent', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 3, 'agent__tunis', 'agent__tunis', 'agent__tunis@gmail.com', 'agent__tunis@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', '2019-04-07 13:43:02', NULL, NULL, 'a:1:{i:0;s:18:\"ROLE_AGENT_GENERAL\";}', 'agent', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 1, 'expert', 'expert', 'ayadibaha51@gmail.com', 'gg@gmail.com', 0, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_EXPERT\";}', 'expert', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '88588888', 'expertMAH', 'exp', 'ariana', 20461217),
(11, 1, 'courtier', 'courtier', 'courtier@gmail.com', 'courtier@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, 'a:1:{i:0;s:13:\"ROLE_COURTIER\";}', 'courtier', '8888', 'testo', NULL, NULL, 'ariana', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ariana', 15000, NULL, NULL, NULL, NULL, NULL),
(12, 4, 'agent__borjcedria', 'agent__borjcedria', 'agent__borjcedria@gmail.com', 'agent__borjcedria@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, 'a:1:{i:0;s:18:\"ROLE_AGENT_GENERAL\";}', 'agent', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, NULL, 'lilo', 'lilo', 'lolo.com', 'lolo.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'courtier', NULL, 'lilo', NULL, NULL, 'lilo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(16, NULL, 'gfg', 'gfg', 'fgfg', 'fgfg', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'courtier', '111', 'fggg', NULL, NULL, 'gggf', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 111, NULL, NULL, NULL, NULL, NULL),
(18, NULL, 'mahmoud', 'mahmoud', 'mahmoud.omrani@esprit.tn', 'mahmoud.omrani@esprit.tn', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'courtier', '11111111', 'Omrnai ', 'Mahmoud', NULL, 'Ariana', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11111, NULL, NULL, NULL, NULL, NULL),
(27, NULL, 'fxjava', 'fxjava', 'fxjava', 'fxjava', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'compagnie', NULL, NULL, NULL, NULL, 'fxjava', NULL, NULL, '20461217', NULL, '12345678', NULL, NULL, NULL, 'fxjava', '12345678', 'fxjava.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(28, NULL, 'starAgent', 'starAgent', 'star@gmail.com', 'star@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'compagnie', NULL, NULL, NULL, NULL, 'TUNIS', NULL, NULL, '70730421', NULL, '88888888', NULL, NULL, NULL, 'STAR', '88888888', 'star.tn', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(29, NULL, 'omrani', 'omrani', 'mah@gmail.com', 'omranimahmoud@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'courtier', '01234567', 'Omrani', 'Mahmoud', NULL, 'ariana', NULL, NULL, '5555', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'tunis', 22220, NULL, NULL, NULL, NULL, NULL),
(30, NULL, 'testCourt', 'testCourt', 'testCourt@gmail.com', 'testCourt@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', NULL, NULL, NULL, NULL, 'courtier', '07477865', 'testCourt', NULL, NULL, 'Ariana', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123000, NULL, NULL, NULL, NULL, NULL),
(32, NULL, 'star', 'star', 'ggg', 'ggg', 1, NULL, '12345', NULL, NULL, NULL, NULL, 'compagnie', NULL, NULL, NULL, NULL, 'test', NULL, NULL, '71701808', NULL, '11111111', NULL, NULL, NULL, 'test', '11111111', 'star', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(33, NULL, 'admin', 'admin', 'admin@gmail.com', 'admin@gmail.com', 1, NULL, '827CCB0EEA8A706C4C34A16891F84E7B', '2019-05-01 13:39:51', NULL, NULL, 'a:1:{i:0;s:16:\"ROLE_SUPER_ADMIN\";}', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(34, NULL, 'api', 'api', 'api@gmail.com', 'api@gmail.com', 1, NULL, '$2y$13$YUaJl5d1qF8y4x3eEfgwxOTaQZF/FHyxjVcmXaG8BXNIYz727hkUi', '2019-04-28 19:07:35', NULL, NULL, 'a:1:{i:0;s:14:\"ROLE_COMPAGNIE\";}', 'compagnie', NULL, NULL, NULL, NULL, 'api', NULL, NULL, '55654332', NULL, '2235', NULL, NULL, NULL, 'api', '12345', 'api', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(35, NULL, 'testfinal', 'testfinal', 'mamado007@gmail.com', 'mamado007@gmail.com', 1, NULL, '12345', NULL, NULL, NULL, NULL, 'compagnie', NULL, NULL, NULL, NULL, 'aaa', NULL, NULL, NULL, NULL, '55555555', NULL, NULL, NULL, 'testfinal', '55555555', 'gg.com.tn', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vehicule`
--

CREATE TABLE `vehicule` (
  `chassis` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `modele` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ref_contrat_id` int(11) DEFAULT NULL,
  `prime_rc_id` int(11) DEFAULT NULL,
  `date_circule` datetime NOT NULL,
  `puissance` int(11) NOT NULL,
  `carburant` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_pneu` int(11) NOT NULL,
  `val_venale` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vehicule`
--

INSERT INTO `vehicule` (`chassis`, `modele`, `ref_contrat_id`, `prime_rc_id`, `date_circule`, `puissance`, `carburant`, `nombre_pneu`, `val_venale`) VALUES
('180TN3215', 'Peugeot', 1, 3, '2019-02-28 20:03:14', 4, 'Essence', 4, 20000),
('888TN9999', 'Peugeot', 2, 3, '2019-02-28 20:03:14', 4, 'diesel', 4, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_64C19AA952FBE437` (`compagnie_id`);

--
-- Indexes for table `avenant_police`
--
ALTER TABLE `avenant_police`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type_3536ba9a8069d977da63af55cdc9b976_idx` (`type`),
  ADD KEY `object_id_3536ba9a8069d977da63af55cdc9b976_idx` (`object_id`),
  ADD KEY `blame_id_3536ba9a8069d977da63af55cdc9b976_idx` (`blame_id`),
  ADD KEY `created_at_3536ba9a8069d977da63af55cdc9b976_idx` (`created_at`);

--
-- Indexes for table `constat`
--
ALTER TABLE `constat`
  ADD PRIMARY KEY (`code_rec`);

--
-- Indexes for table `courtier_compagnie`
--
ALTER TABLE `courtier_compagnie`
  ADD PRIMARY KEY (`compagnie_id`,`courtier_id`),
  ADD KEY `IDX_B4BA675752FBE437` (`compagnie_id`),
  ADD KEY `IDX_B4BA6757E82428FD` (`courtier_id`);

--
-- Indexes for table `garantie_complementaire`
--
ALTER TABLE `garantie_complementaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_62800D9252FBE437` (`compagnie_id`);

--
-- Indexes for table `police`
--
ALTER TABLE `police`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_E47C5959B30E917A` (`code_assure_id`),
  ADD KEY `IDX_E47C5959D725330D` (`agence_id`);

--
-- Indexes for table `police_garantis`
--
ALTER TABLE `police_garantis`
  ADD PRIMARY KEY (`garantie_complementaire_id`,`police_id`),
  ADD KEY `IDX_9902CA12C0C054A1` (`garantie_complementaire_id`),
  ADD KEY `IDX_9902CA1237E60BE1` (`police_id`);

--
-- Indexes for table `primerc`
--
ALTER TABLE `primerc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`code_rec`),
  ADD UNIQUE KEY `UNIQ_CE60640468288F6F` (`code_sinistre_id`),
  ADD KEY `IDX_CE606404C5568CE4` (`expert_id`);

--
-- Indexes for table `sinistre`
--
ALTER TABLE `sinistre`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UNIQ_F5AC7A672D6BA2D9` (`reclamation_id`),
  ADD KEY `IDX_F5AC7A671823061F` (`contrat_id`),
  ADD KEY `IDX_F5AC7A679C6E762DAC14B70A` (`chassis_number`,`modele_id`);

--
-- Indexes for table `temoin`
--
ALTER TABLE `temoin`
  ADD PRIMARY KEY (`CinT`),
  ADD KEY `IDX_E451293B216966DF` (`sinistre_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  ADD UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  ADD UNIQUE KEY `UNIQ_8D93D649C05FB297` (`confirmation_token`),
  ADD KEY `IDX_8D93D649D725330D` (`agence_id`),
  ADD KEY `INDEX_Reference_type` (`type`);

--
-- Indexes for table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`chassis`,`modele`),
  ADD KEY `IDX_292FFF1D1EE6E901` (`ref_contrat_id`),
  ADD KEY `IDX_292FFF1DCBE01A2F` (`prime_rc_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agence`
--
ALTER TABLE `agence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `avenant_police`
--
ALTER TABLE `avenant_police`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `garantie_complementaire`
--
ALTER TABLE `garantie_complementaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `police`
--
ALTER TABLE `police`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `primerc`
--
ALTER TABLE `primerc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `code_rec` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sinistre`
--
ALTER TABLE `sinistre`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agence`
--
ALTER TABLE `agence`
  ADD CONSTRAINT `FK_64C19AA952FBE437` FOREIGN KEY (`compagnie_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `constat`
--
ALTER TABLE `constat`
  ADD CONSTRAINT `FK_F96EDD988C25FD86` FOREIGN KEY (`code_rec`) REFERENCES `reclamation` (`code_rec`) ON DELETE CASCADE;

--
-- Constraints for table `courtier_compagnie`
--
ALTER TABLE `courtier_compagnie`
  ADD CONSTRAINT `FK_B4BA675752FBE437` FOREIGN KEY (`compagnie_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_B4BA6757E82428FD` FOREIGN KEY (`courtier_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `garantie_complementaire`
--
ALTER TABLE `garantie_complementaire`
  ADD CONSTRAINT `FK_62800D9252FBE437` FOREIGN KEY (`compagnie_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `fk_inv_product_id` FOREIGN KEY (`compagnie_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `police`
--
ALTER TABLE `police`
  ADD CONSTRAINT `FK_E47C5959B30E917A` FOREIGN KEY (`code_assure_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_E47C5959D725330D` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`);

--
-- Constraints for table `police_garantis`
--
ALTER TABLE `police_garantis`
  ADD CONSTRAINT `FK_9902CA1237E60BE1` FOREIGN KEY (`police_id`) REFERENCES `police` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_9902CA12C0C054A1` FOREIGN KEY (`garantie_complementaire_id`) REFERENCES `garantie_complementaire` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_CE60640468288F6F` FOREIGN KEY (`code_sinistre_id`) REFERENCES `sinistre` (`code`),
  ADD CONSTRAINT `FK_CE606404C5568CE4` FOREIGN KEY (`expert_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `sinistre`
--
ALTER TABLE `sinistre`
  ADD CONSTRAINT `FK_F5AC7A671823061F` FOREIGN KEY (`contrat_id`) REFERENCES `police` (`id`),
  ADD CONSTRAINT `FK_F5AC7A672D6BA2D9` FOREIGN KEY (`reclamation_id`) REFERENCES `reclamation` (`code_rec`),
  ADD CONSTRAINT `FK_F5AC7A679C6E762DAC14B70A` FOREIGN KEY (`chassis_number`,`modele_id`) REFERENCES `vehicule` (`chassis`, `modele`);

--
-- Constraints for table `temoin`
--
ALTER TABLE `temoin`
  ADD CONSTRAINT `FK_E451293B216966DF` FOREIGN KEY (`sinistre_id`) REFERENCES `sinistre` (`code`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_8D93D649D725330D` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`);

--
-- Constraints for table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `FK_292FFF1D1EE6E901` FOREIGN KEY (`ref_contrat_id`) REFERENCES `police` (`id`),
  ADD CONSTRAINT `FK_292FFF1DCBE01A2F` FOREIGN KEY (`prime_rc_id`) REFERENCES `primerc` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
