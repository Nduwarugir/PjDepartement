
CREATE TABLE admin (
                         id_admin bigint(20) NOT NULL,
                         email varchar(255) DEFAULT NULL,
                         password varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE article (
                           id_article bigint(20) NOT NULL,
                           description varchar(255) DEFAULT NULL,
                           link varchar(255) DEFAULT NULL,
                           name_auteur varchar(100) DEFAULT NULL,
                           theme varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE emploi (
                          id_emploi bigint(20) NOT NULL,
                          description varchar(100) DEFAULT NULL,
                          domaine_requis varchar(50) DEFAULT NULL,
                          poste varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE encadrement (
                               id_encadrement bigint(20) NOT NULL,
                               enseignant_id bigint(20) DEFAULT NULL,
                               etudiant_id bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE enseignant (
                              competences varchar(255) NOT NULL,
                              grade varchar(7) NOT NULL,
                              matricule varchar(20) NOT NULL,
                              prenom varchar(100) DEFAULT NULL,
                              specialite varchar(7) NOT NULL,
                              id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE enseignant_articles (
                                       enseignant_id_user bigint(20) NOT NULL,
                                       articles_id_article bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE enseignant_encadrees (
                                        enseignant_id_user bigint(20) NOT NULL,
                                        encadrees_id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE enseignant_projects (
                                       enseignant_id_user bigint(20) NOT NULL,
                                       projects_id_projet bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE enseignant_recommandes (
                                          enseignant_id_user bigint(20) NOT NULL,
                                          recommandes_id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE entreprise (
                              contribute_number bigint(20) NOT NULL,
                              creation_date datetime NOT NULL,
                              location varchar(50) NOT NULL,
                              web_site varchar(100) DEFAULT NULL,
                              id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE entreprise_parraines (
                                        entreprise_id_user bigint(20) NOT NULL,
                                        parraines_id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE entreprise_stagiaires (
                                         entreprise_id_user bigint(20) NOT NULL,
                                         stagiaires_id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE etudiant (
                            competence varchar(255) DEFAULT NULL,
                            matricule varchar(20) NOT NULL,
                            niveau varchar(7) NOT NULL,
                            prenom varchar(100) DEFAULT NULL,
                            id_user bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE etudiant_articles (
                                     etudiant_id_user bigint(20) NOT NULL,
                                     articles_id_article bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE etudiant_projects (
                                     etudiant_id_user bigint(20) NOT NULL,
                                     projects_id_projet bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE projet (
                          id_projet bigint(20) NOT NULL,
                          description varchar(200) DEFAULT NULL,
                          theme varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE publication (
                               id_pub bigint(20) NOT NULL,
                               description varchar(255) DEFAULT NULL,
                               image varchar(255) DEFAULT NULL,
                               title varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE recommender (
                               id_recommendation bigint(20) NOT NULL,
                               descriptif varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE stage (
                         id_stage bigint(20) NOT NULL,
                         competences_attendues varchar(150) DEFAULT NULL,
                         description varchar(255) DEFAULT NULL,
                         image varchar(200) DEFAULT NULL,
                         periode varchar(50) DEFAULT NULL,
                         poste varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE user (
                        id_user bigint(20) NOT NULL,
                        mail varchar(100) NOT NULL,
                        nom varchar(100) NOT NULL,
                        num_tel bigint(20) NOT NULL,
                        password varchar(100) NOT NULL,
                        photo varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE admin
    ADD PRIMARY KEY (id_admin);

ALTER TABLE article
    ADD PRIMARY KEY (id_article);

ALTER TABLE emploi
    ADD PRIMARY KEY (id_emploi);

ALTER TABLE encadrement
    ADD PRIMARY KEY (id_encadrement),
    ADD KEY FKfxlwn52r0o23dh75yhpl6g0hn (enseignant_id),
    ADD KEY FK4y28n65d63cct0j0np7ll8l02 (etudiant_id);

ALTER TABLE enseignant
    ADD PRIMARY KEY (id_user);

ALTER TABLE enseignant_articles
    ADD UNIQUE KEY UK_gyolbt845tj8981yjlvr7qhp4 (articles_id_article),
    ADD KEY FKkw9qhqxj33q7j3hy8evdbi8gn (enseignant_id_user);

ALTER TABLE enseignant_encadrees
    ADD UNIQUE KEY UK_29bdj0jt94qdlyv453sebeqc3 (encadrees_id_user),
    ADD KEY FKbt615cn9nsujmmvxxdabnlmco (enseignant_id_user);

ALTER TABLE enseignant_projects
    ADD UNIQUE KEY UK_9i4hl4rwq3p6h4v3a596ald27 (projects_id_projet),
    ADD KEY FKr9ypxp9pu4et7m11gs5jgf9an (enseignant_id_user);

ALTER TABLE enseignant_recommandes
    ADD UNIQUE KEY UK_6ttuya8f50tqtly4b365coe31 (recommandes_id_user),
    ADD KEY FK8nb4wkgt2l60d6vemqighgbqr (enseignant_id_user);

ALTER TABLE entreprise
    ADD PRIMARY KEY (id_user);

ALTER TABLE entreprise_parraines
    ADD UNIQUE KEY UK_4iqxa7kbbnwdmtmu7qdjgb0wr (parraines_id_user),
    ADD KEY FKt8df5f3osesvto2qn2gn4v8n0 (entreprise_id_user);

ALTER TABLE entreprise_stagiaires
    ADD UNIQUE KEY UK_ghf2ryjfr7n32f3gu6h4x7qfn (stagiaires_id_user),
    ADD KEY FK6hoprgio4ivcqc9h47moip0u6 (entreprise_id_user);

ALTER TABLE etudiant
    ADD PRIMARY KEY (id_user);

ALTER TABLE etudiant_articles
    ADD UNIQUE KEY UK_b85k7oa6hu9rw1xk39yfy9rmn (articles_id_article),
    ADD KEY FK4i65h4i6ygm0nueod86osuxh0 (etudiant_id_user);

ALTER TABLE etudiant_projects
    ADD UNIQUE KEY UK_c6vxh7uujq4qdbcwo57jxg0np (projects_id_projet),
    ADD KEY FK8b15kjk3dfo7b98f8439eo6rb (etudiant_id_user);

ALTER TABLE projet
    ADD PRIMARY KEY (id_projet);

ALTER TABLE publication
    ADD PRIMARY KEY (id_pub);

ALTER TABLE recommender
    ADD PRIMARY KEY (id_recommendation);

ALTER TABLE stage
    ADD PRIMARY KEY (id_stage);

ALTER TABLE user
    ADD PRIMARY KEY (id_user);

ALTER TABLE admin
    MODIFY id_admin bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE article
    MODIFY id_article bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE emploi
    MODIFY id_emploi bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE encadrement
    MODIFY id_encadrement bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE projet
    MODIFY id_projet bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE publication
    MODIFY id_pub bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE recommender
    MODIFY id_recommendation bigint(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE stage
    MODIFY id_stage bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE user
    MODIFY id_user bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE encadrement
    ADD CONSTRAINT FK4y28n65d63cct0j0np7ll8l02 FOREIGN KEY (etudiant_id) REFERENCES etudiant (id_user),
    ADD CONSTRAINT FKfxlwn52r0o23dh75yhpl6g0hn FOREIGN KEY (enseignant_id) REFERENCES enseignant (id_user);

ALTER TABLE enseignant
    ADD CONSTRAINT FKm8ur50rnekjmd9jwohn0wyete FOREIGN KEY (id_user) REFERENCES user (id_user);

ALTER TABLE enseignant_articles
    ADD CONSTRAINT FKk53duk8a6qunaon9k2e0hrwgq FOREIGN KEY (articles_id_article) REFERENCES article (id_article),
    ADD CONSTRAINT FKkw9qhqxj33q7j3hy8evdbi8gn FOREIGN KEY (enseignant_id_user) REFERENCES enseignant (id_user);

ALTER TABLE enseignant_encadrees
    ADD CONSTRAINT FKbt615cn9nsujmmvxxdabnlmco FOREIGN KEY (enseignant_id_user) REFERENCES enseignant (id_user),
    ADD CONSTRAINT FKklfe8oktuphl301mthv0x61lu FOREIGN KEY (encadrees_id_user) REFERENCES etudiant (id_user);

ALTER TABLE enseignant_projects
    ADD CONSTRAINT FKgdiw4sfa9yvcbf0vcwemudenc FOREIGN KEY (projects_id_projet) REFERENCES projet (id_projet),
    ADD CONSTRAINT FKr9ypxp9pu4et7m11gs5jgf9an FOREIGN KEY (enseignant_id_user) REFERENCES enseignant (id_user);

ALTER TABLE enseignant_recommandes
    ADD CONSTRAINT FK8nb4wkgt2l60d6vemqighgbqr FOREIGN KEY (enseignant_id_user) REFERENCES enseignant (id_user),
    ADD CONSTRAINT FKtat9p8bbnoun2ex3d258p4t01 FOREIGN KEY (recommandes_id_user) REFERENCES etudiant (id_user);

ALTER TABLE entreprise
    ADD CONSTRAINT FKh4i0ug8buocxsdtxkqy88h477 FOREIGN KEY (id_user) REFERENCES user (id_user);

ALTER TABLE entreprise_parraines
    ADD CONSTRAINT FK2a7656e3ogghgfx3isw206cfh FOREIGN KEY (parraines_id_user) REFERENCES etudiant (id_user),
    ADD CONSTRAINT FKt8df5f3osesvto2qn2gn4v8n0 FOREIGN KEY (entreprise_id_user) REFERENCES entreprise (id_user);

ALTER TABLE entreprise_stagiaires
    ADD CONSTRAINT FK6hoprgio4ivcqc9h47moip0u6 FOREIGN KEY (entreprise_id_user) REFERENCES entreprise (id_user),
    ADD CONSTRAINT FKfbvk03m5ceu4ws5mv2i28etu FOREIGN KEY (stagiaires_id_user) REFERENCES etudiant (id_user);

ALTER TABLE etudiant
    ADD CONSTRAINT FKemy5a7hxr7ijstodh5s55ilvv FOREIGN KEY (id_user) REFERENCES user (id_user);

ALTER TABLE etudiant_articles
    ADD CONSTRAINT FK4i65h4i6ygm0nueod86osuxh0 FOREIGN KEY (etudiant_id_user) REFERENCES etudiant (id_user),
    ADD CONSTRAINT FK5veh6e660q8wva3pgcucg5m1m FOREIGN KEY (articles_id_article) REFERENCES article (id_article);

ALTER TABLE etudiant_projects
    ADD CONSTRAINT FK8b15kjk3dfo7b98f8439eo6rb FOREIGN KEY (etudiant_id_user) REFERENCES etudiant (id_user),
    ADD CONSTRAINT FKdhun0jmi5q2perlbv0wwj759i FOREIGN KEY (projects_id_projet) REFERENCES projet (id_projet);
COMMIT;

