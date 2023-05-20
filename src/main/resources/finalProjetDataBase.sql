-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : sam. 20 mai 2023 à 14:27
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `finalProjetDataBase`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id_article` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name_auteur` varchar(100) DEFAULT NULL,
  `theme` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `description`, `link`, `name_auteur`, `theme`) VALUES
(1, 'This article will help you to be a better developer than before', 'senior.link-article.com', 'Link\'s', 'How to be a senior developer'),
(2, 'This article is the first step for your personal development', 'junior.link-article.com', 'Link\'s', 'How to be a junior developer'),
(3, 'This article will help you to be a front-end developer.', 'front-end.link-article.com', 'Link\'s', 'How to be a front-end developer');

-- --------------------------------------------------------

--
-- Structure de la table `emploi`
--

CREATE TABLE `emploi` (
  `id_emploi` bigint(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `domaine_requis` varchar(50) DEFAULT NULL,
  `poste` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `emploi`
--

INSERT INTO `emploi` (`id_emploi`, `description`, `domaine_requis`, `poste`) VALUES
(1, 'This is the description', 'This is an example of description', 'Chef projet');

-- --------------------------------------------------------

--
-- Structure de la table `encadrement`
--

CREATE TABLE `encadrement` (
  `id_encadrement` bigint(20) NOT NULL,
  `enseignant_id` bigint(20) DEFAULT NULL,
  `etudiant_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `competences` varchar(255) NOT NULL,
  `grade` varchar(7) NOT NULL,
  `matricule` varchar(20) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `specialite` varchar(7) NOT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant_articles`
--

CREATE TABLE `enseignant_articles` (
  `enseignant_id_user` bigint(20) NOT NULL,
  `articles_id_article` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant_encadrees`
--

CREATE TABLE `enseignant_encadrees` (
  `enseignant_id_user` bigint(20) NOT NULL,
  `encadrees_id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant_projects`
--

CREATE TABLE `enseignant_projects` (
  `enseignant_id_user` bigint(20) NOT NULL,
  `projects_id_projet` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant_recommandes`
--

CREATE TABLE `enseignant_recommandes` (
  `enseignant_id_user` bigint(20) NOT NULL,
  `recommandes_id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `contribute_number` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `location` varchar(50) NOT NULL,
  `web_site` varchar(100) DEFAULT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`contribute_number`, `creation_date`, `location`, `web_site`, `id_user`) VALUES
(83611033044055, '1979-09-19 00:00:00', 'Tokyo', 'www.nintendo.jp', 2),
(11022033044055, '2001-09-19 00:00:00', 'Elig-sono, Grand Moulin', 'l-enterprise.com', 3);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise_parraines`
--

CREATE TABLE `entreprise_parraines` (
  `entreprise_id_user` bigint(20) NOT NULL,
  `parraines_id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entreprise_stagiaires`
--

CREATE TABLE `entreprise_stagiaires` (
  `entreprise_id_user` bigint(20) NOT NULL,
  `stagiaires_id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `competence` varchar(255) DEFAULT NULL,
  `matricule` varchar(20) NOT NULL,
  `niveau` varchar(7) NOT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`competence`, `matricule`, `niveau`, `prenom`, `id_user`) VALUES
('Java', '20U2598', 'L3', 'Bruno', 1),
('Angular', '20V2255', 'L3', 'Rachel', 5);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_articles`
--

CREATE TABLE `etudiant_articles` (
  `etudiant_id_user` bigint(20) NOT NULL,
  `articles_id_article` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant_articles`
--

INSERT INTO `etudiant_articles` (`etudiant_id_user`, `articles_id_article`) VALUES
(1, 1),
(1, 2),
(1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_projects`
--

CREATE TABLE `etudiant_projects` (
  `etudiant_id_user` bigint(20) NOT NULL,
  `projects_id_projet` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant_projects`
--

INSERT INTO `etudiant_projects` (`etudiant_id_user`, `projects_id_projet`) VALUES
(1, 1),
(1, 2),
(1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE `projet` (
  `id_projet` bigint(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `theme` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `projet`
--

INSERT INTO `projet` (`id_projet`, `description`, `theme`) VALUES
(1, 'Annuaire des étudiants du département informatique.', 'INF3076'),
(2, 'ETL.', 'INF3086'),
(3, 'ELT.', 'INF3086');

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id_pub` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `recommender`
--

CREATE TABLE `recommender` (
  `id_recommendation` bigint(20) NOT NULL,
  `descriptif` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `stage`
--

CREATE TABLE `stage` (
  `id_stage` bigint(20) NOT NULL,
  `competences_attendues` varchar(150) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `periode` varchar(50) DEFAULT NULL,
  `poste` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `stage`
--

INSERT INTO `stage` (`id_stage`, `competences_attendues`, `description`, `image`, `periode`, `poste`) VALUES
(1, 'Java, Spring-boot, SCRUM Methodology', 'Nous recherchons un scrum master', '@Stage001', '10/05 - 10/08', 'Chef de projet');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` bigint(20) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `num_tel` bigint(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `photo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `mail`, `nom`, `num_tel`, `password`, `photo`) VALUES
(1, 'nduwarugirabruno@gmail.com', 'Nduwarugira', 695156866, '123Link\'s', '#TOF0001'),
(2, 'support@nintendo.jp', 'NINTENDO', 620175731, 'nintendo64', '#TOF0010'),
(3, 'nduwarugirabruno@gmail.com', 'L-ENTERPRISE', 695156866, '123Link\'s@gmail.com', '#TOF0001'),
(5, 'rachel.anaba@facsciences-uy1.cm', 'Anaba', 697867721, '123Rachel.com', '#TOF0002');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_article`);

--
-- Index pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD PRIMARY KEY (`id_emploi`);

--
-- Index pour la table `encadrement`
--
ALTER TABLE `encadrement`
  ADD PRIMARY KEY (`id_encadrement`),
  ADD KEY `FKfxlwn52r0o23dh75yhpl6g0hn` (`enseignant_id`),
  ADD KEY `FK4y28n65d63cct0j0np7ll8l02` (`etudiant_id`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `enseignant_articles`
--
ALTER TABLE `enseignant_articles`
  ADD UNIQUE KEY `UK_gyolbt845tj8981yjlvr7qhp4` (`articles_id_article`),
  ADD KEY `FKkw9qhqxj33q7j3hy8evdbi8gn` (`enseignant_id_user`);

--
-- Index pour la table `enseignant_encadrees`
--
ALTER TABLE `enseignant_encadrees`
  ADD UNIQUE KEY `UK_29bdj0jt94qdlyv453sebeqc3` (`encadrees_id_user`),
  ADD KEY `FKbt615cn9nsujmmvxxdabnlmco` (`enseignant_id_user`);

--
-- Index pour la table `enseignant_projects`
--
ALTER TABLE `enseignant_projects`
  ADD UNIQUE KEY `UK_9i4hl4rwq3p6h4v3a596ald27` (`projects_id_projet`),
  ADD KEY `FKr9ypxp9pu4et7m11gs5jgf9an` (`enseignant_id_user`);

--
-- Index pour la table `enseignant_recommandes`
--
ALTER TABLE `enseignant_recommandes`
  ADD UNIQUE KEY `UK_6ttuya8f50tqtly4b365coe31` (`recommandes_id_user`),
  ADD KEY `FK8nb4wkgt2l60d6vemqighgbqr` (`enseignant_id_user`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `entreprise_parraines`
--
ALTER TABLE `entreprise_parraines`
  ADD UNIQUE KEY `UK_4iqxa7kbbnwdmtmu7qdjgb0wr` (`parraines_id_user`),
  ADD KEY `FKt8df5f3osesvto2qn2gn4v8n0` (`entreprise_id_user`);

--
-- Index pour la table `entreprise_stagiaires`
--
ALTER TABLE `entreprise_stagiaires`
  ADD UNIQUE KEY `UK_ghf2ryjfr7n32f3gu6h4x7qfn` (`stagiaires_id_user`),
  ADD KEY `FK6hoprgio4ivcqc9h47moip0u6` (`entreprise_id_user`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `etudiant_articles`
--
ALTER TABLE `etudiant_articles`
  ADD UNIQUE KEY `UK_b85k7oa6hu9rw1xk39yfy9rmn` (`articles_id_article`),
  ADD KEY `FK4i65h4i6ygm0nueod86osuxh0` (`etudiant_id_user`);

--
-- Index pour la table `etudiant_projects`
--
ALTER TABLE `etudiant_projects`
  ADD UNIQUE KEY `UK_c6vxh7uujq4qdbcwo57jxg0np` (`projects_id_projet`),
  ADD KEY `FK8b15kjk3dfo7b98f8439eo6rb` (`etudiant_id_user`);

--
-- Index pour la table `projet`
--
ALTER TABLE `projet`
  ADD PRIMARY KEY (`id_projet`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id_pub`);

--
-- Index pour la table `recommender`
--
ALTER TABLE `recommender`
  ADD PRIMARY KEY (`id_recommendation`);

--
-- Index pour la table `stage`
--
ALTER TABLE `stage`
  ADD PRIMARY KEY (`id_stage`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id_article` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `emploi`
--
ALTER TABLE `emploi`
  MODIFY `id_emploi` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `encadrement`
--
ALTER TABLE `encadrement`
  MODIFY `id_encadrement` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `projet`
--
ALTER TABLE `projet`
  MODIFY `id_projet` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id_pub` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `recommender`
--
ALTER TABLE `recommender`
  MODIFY `id_recommendation` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `stage`
--
ALTER TABLE `stage`
  MODIFY `id_stage` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `encadrement`
--
ALTER TABLE `encadrement`
  ADD CONSTRAINT `FK4y28n65d63cct0j0np7ll8l02` FOREIGN KEY (`etudiant_id`) REFERENCES `etudiant` (`id_user`),
  ADD CONSTRAINT `FKfxlwn52r0o23dh75yhpl6g0hn` FOREIGN KEY (`enseignant_id`) REFERENCES `enseignant` (`id_user`);

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `FKm8ur50rnekjmd9jwohn0wyete` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `enseignant_articles`
--
ALTER TABLE `enseignant_articles`
  ADD CONSTRAINT `FKk53duk8a6qunaon9k2e0hrwgq` FOREIGN KEY (`articles_id_article`) REFERENCES `article` (`id_article`),
  ADD CONSTRAINT `FKkw9qhqxj33q7j3hy8evdbi8gn` FOREIGN KEY (`enseignant_id_user`) REFERENCES `enseignant` (`id_user`);

--
-- Contraintes pour la table `enseignant_encadrees`
--
ALTER TABLE `enseignant_encadrees`
  ADD CONSTRAINT `FKbt615cn9nsujmmvxxdabnlmco` FOREIGN KEY (`enseignant_id_user`) REFERENCES `enseignant` (`id_user`),
  ADD CONSTRAINT `FKklfe8oktuphl301mthv0x61lu` FOREIGN KEY (`encadrees_id_user`) REFERENCES `etudiant` (`id_user`);

--
-- Contraintes pour la table `enseignant_projects`
--
ALTER TABLE `enseignant_projects`
  ADD CONSTRAINT `FKgdiw4sfa9yvcbf0vcwemudenc` FOREIGN KEY (`projects_id_projet`) REFERENCES `projet` (`id_projet`),
  ADD CONSTRAINT `FKr9ypxp9pu4et7m11gs5jgf9an` FOREIGN KEY (`enseignant_id_user`) REFERENCES `enseignant` (`id_user`);

--
-- Contraintes pour la table `enseignant_recommandes`
--
ALTER TABLE `enseignant_recommandes`
  ADD CONSTRAINT `FK8nb4wkgt2l60d6vemqighgbqr` FOREIGN KEY (`enseignant_id_user`) REFERENCES `enseignant` (`id_user`),
  ADD CONSTRAINT `FKtat9p8bbnoun2ex3d258p4t01` FOREIGN KEY (`recommandes_id_user`) REFERENCES `etudiant` (`id_user`);

--
-- Contraintes pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `FKh4i0ug8buocxsdtxkqy88h477` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `entreprise_parraines`
--
ALTER TABLE `entreprise_parraines`
  ADD CONSTRAINT `FK2a7656e3ogghgfx3isw206cfh` FOREIGN KEY (`parraines_id_user`) REFERENCES `etudiant` (`id_user`),
  ADD CONSTRAINT `FKt8df5f3osesvto2qn2gn4v8n0` FOREIGN KEY (`entreprise_id_user`) REFERENCES `entreprise` (`id_user`);

--
-- Contraintes pour la table `entreprise_stagiaires`
--
ALTER TABLE `entreprise_stagiaires`
  ADD CONSTRAINT `FK6hoprgio4ivcqc9h47moip0u6` FOREIGN KEY (`entreprise_id_user`) REFERENCES `entreprise` (`id_user`),
  ADD CONSTRAINT `FKfbvk03m5ceu4ws5mv2i28etu` FOREIGN KEY (`stagiaires_id_user`) REFERENCES `etudiant` (`id_user`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FKemy5a7hxr7ijstodh5s55ilvv` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `etudiant_articles`
--
ALTER TABLE `etudiant_articles`
  ADD CONSTRAINT `FK4i65h4i6ygm0nueod86osuxh0` FOREIGN KEY (`etudiant_id_user`) REFERENCES `etudiant` (`id_user`),
  ADD CONSTRAINT `FK5veh6e660q8wva3pgcucg5m1m` FOREIGN KEY (`articles_id_article`) REFERENCES `article` (`id_article`);

--
-- Contraintes pour la table `etudiant_projects`
--
ALTER TABLE `etudiant_projects`
  ADD CONSTRAINT `FK8b15kjk3dfo7b98f8439eo6rb` FOREIGN KEY (`etudiant_id_user`) REFERENCES `etudiant` (`id_user`),
  ADD CONSTRAINT `FKdhun0jmi5q2perlbv0wwj759i` FOREIGN KEY (`projects_id_projet`) REFERENCES `projet` (`id_projet`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
