INSERT INTO article (id_article, description, link, name_auteur, theme) VALUES
                                                                                        (1, 'This article will help you to be a better developer than before', 'senior.link-article.com', 'Link\'s', 'How to be a senior developer'),
                                                                                        (2, 'This article is the first step for your personal development', 'junior.link-article.com', 'Link\'s', 'How to be a junior developer'),
                                                                                        (3, 'This article will help you to be a front-end developer.', 'front-end.link-article.com', 'Link\'s', 'How to be a front-end developer');

INSERT INTO emploi (id_emploi, description, domaine_requis, poste) VALUES
    (1, 'This is the description', 'This is an example of description', 'Chef projet');

INSERT INTO entreprise (contribute_number, creation_date, location, web_site, id_user) VALUES
                                                                                                       (83611033044055, '1979-09-19 00:00:00', 'Tokyo', 'www.nintendo.jp', 2),
                                                                                                       (11022033044055, '2001-09-19 00:00:00', 'Elig-sono, Grand Moulin', 'l-enterprise.com', 3);

INSERT INTO etudiant (competence, matricule, niveau, prenom, id_user) VALUES
                                                                                      ('Java', '20U2598', 'L3', 'Bruno', 1),
                                                                                      ('Angular', '20V2255', 'L3', 'Rachel', 5);

INSERT INTO etudiant_articles (etudiant_id_user, articles_id_article) VALUES
                                                                                (1, 1),
                                                                                (1, 2),
                                                                                (1, 3);

INSERT INTO etudiant_projects (etudiant_id_user, projects_id_projet) VALUES
                                                                               (1, 1),
                                                                               (1, 2),
                                                                               (1, 3);

INSERT INTO projet (id_projet, description, theme) VALUES
                                                               (1, 'Annuaire des étudiants du département informatique.', 'INF3076'),
                                                               (2, 'ETL.', 'INF3086'),
                                                               (3, 'ELT.', 'INF3086');

INSERT INTO stage (id_stage, competences_attendues, description, image, periode, poste) VALUES
    (1, 'Java, Spring-boot, SCRUM Methodology', 'Nous recherchons un scrum master', '@Stage001', '10/05 - 10/08', 'Chef de projet');

INSERT INTO user (id_user, mail, nom, num_tel, password, photo) VALUES
                                                                                  (1, 'nduwarugirabruno@gmail.com', 'Nduwarugira', 695156866, '123Link\'s', '#TOF0001'),
                                                                                  (2, 'support@nintendo.jp', 'NINTENDO', 620175731, 'nintendo64', '#TOF0010'),
                                                                                  (3, 'nduwarugirabruno@gmail.com', 'L-ENTERPRISE', 695156866, '123Link\'s@gmail.com', '#TOF0001'),
                                                                                  (5, 'rachel.anaba@facsciences-uy1.cm', 'Anaba', 697867721, '123Rachel.com', '#TOF0002');
