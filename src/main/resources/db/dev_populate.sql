-- ----------------------------------------------------------------------------
-- Extension nécessaire
-- ----------------------------------------------------------------------------
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- ----------------------------------------------------------------------------
-- ARMEES
-- ----------------------------------------------------------------------------
INSERT INTO armee (id, libelle) VALUES
                                    (gen_random_uuid(), 'Armée de Terre'),
                                    (gen_random_uuid(), 'Armée de l’Air et de l''Espace'),
                                    (gen_random_uuid(), 'Marine Nationale'),
                                    (gen_random_uuid(), 'Comissariat');

-- ----------------------------------------------------------------------------
-- GRADE
-- ----------------------------------------------------------------------------

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Sergent', 'SGT', id, 'SOF1'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Sergent-Chef', 'SCH', id, 'SOF2'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Adjudant', 'ADJ', id, 'SOF3'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Adjudant-Chef', 'ADC', id, 'SOF4'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Major', 'MAJ', id, 'SOF5'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Aspirant', 'ASP', id, 'OF1'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire Asspirant', 'CASP', id, 'OF1'
FROM armee WHERE libelle = 'Comissariat';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Sous-Lieutenant', 'SLT', id, 'OF1'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire de 3ème classe', 'CR3', id, 'OF1'
FROM armee WHERE libelle = 'Comissariat';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Lieutenant', 'LTN', id, 'OF1'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire de 2ème classe', 'CR2', id, 'OF1'
FROM armee WHERE libelle = 'Comissariat';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Capitaine', 'CNE', id, 'OF2'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire de 1ème classe', 'CR1', id, 'OF2'
FROM armee WHERE libelle = 'Comissariat';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Commandant', 'CDT', id, 'OF3'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire principal', 'CRP', id, 'OF3'
FROM armee WHERE libelle = 'Comissariat';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Lieutenant-Colonel', 'LCL', id, 'OF4'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire en chef de 2ème classe', 'CRC2', id, 'OF4'
FROM armee WHERE libelle = 'Comissariat';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Colonel', 'COL', id, 'OF5'
FROM armee WHERE libelle = 'Armée de Terre';

INSERT INTO grade (id, libelle, libelle_court, armee_id, niveau)
SELECT gen_random_uuid(), 'Comissaire en chef de 1ère classe', 'CRC1', id, 'OF5'
FROM armee WHERE libelle = 'Comissariat';


-- ----------------------------------------------------------------------------
-- PERSONNEL
-- ----------------------------------------------------------------------------
INSERT INTO personnel (id, grade_id, nom, prenom)
SELECT gen_random_uuid(), g.id, 'Durand', 'Paul'
FROM grade g WHERE libelle_court = 'CR1';

INSERT INTO personnel (id, grade_id, nom, prenom)
SELECT gen_random_uuid(), g.id, 'Martin', 'Luc'
FROM grade g WHERE libelle_court = 'SGT';

INSERT INTO personnel (id, grade_id, nom, prenom)
SELECT gen_random_uuid(), g.id, 'Petit', 'Hugo'
FROM grade g WHERE libelle_court = 'ADJ';

INSERT INTO personnel (id, grade_id, nom, prenom)
SELECT gen_random_uuid(), g.id, 'Bernard', 'Julie'
FROM grade g WHERE libelle_court = 'CNE';

INSERT INTO personnel (id, grade_id, nom, prenom)
SELECT gen_random_uuid(), g.id, 'Lefevre', 'Olivier'
FROM grade g WHERE libelle_court = 'LTN';

-- ----------------------------------------------------------------------------
-- SEANCES
-- ----------------------------------------------------------------------------
INSERT INTO seance (id, perception_stande_at, nettoyage_on, note_service,
                    description, date_debut, date_fin)
VALUES
    (gen_random_uuid(), '2025-01-12', '2025-01-12 14:00+00', 'z://',
     'Séance tir FAMAS - BA 705', '2025-01-12 08:00', '2025-01-12 12:00'),

    (gen_random_uuid(), '2025-02-05', '2025-02-05 15:30+00', 'z://',
     'Séance tir pistolet - Ruchard', '2025-02-05 09:00', '2025-02-05 11:00'),

    (gen_random_uuid(), '2025-02-20', '2025-02-20 16:00+00', 'z://',
     'CCPS', '2025-02-20 13:00', '2025-02-20 17:30');

-- ----------------------------------------------------------------------------
-- ARMES
-- ----------------------------------------------------------------------------
INSERT INTO arme (id, nom, type) VALUES
                                     (gen_random_uuid(), 'FAMAS', 'Fusil'),
                                     (gen_random_uuid(), 'Glock 17 Gen 5', 'Pistolet'),
                                     (gen_random_uuid(), 'PAMAS G1', 'Pistolet'),
                                     (gen_random_uuid(), 'HK416-f', 'Fusil');

-- ----------------------------------------------------------------------------
-- QUALIFICATIONS
-- ----------------------------------------------------------------------------
INSERT INTO qualification (id, libelle, duree_validite) VALUES
                                                            (gen_random_uuid(), 'Alpha', null),
                                                            (gen_random_uuid(), 'CATi 2', 365),
                                                            (gen_random_uuid(), 'Bravo', 365),
                                                            (gen_random_uuid(), 'Garde', 365);

-- ----------------------------------------------------------------------------
-- PARTICIPATIONS
-- ----------------------------------------------------------------------------
INSERT INTO participation (id, seance_id, personnel_id)
SELECT gen_random_uuid(), s.id, p.id
FROM seance s, personnel p
WHERE s.description LIKE '%FAMAS%' AND p.nom = 'Durand'
LIMIT 1;

INSERT INTO participation (id, seance_id, personnel_id)
SELECT gen_random_uuid(), s.id, p.id
FROM seance s, personnel p
WHERE s.description LIKE '%FAMAS%' AND p.nom = 'Martin'
LIMIT 1;

INSERT INTO participation (id, seance_id, personnel_id)
SELECT gen_random_uuid(), s.id, p.id
FROM seance s, personnel p
WHERE s.description LIKE '%pistolet%' AND p.nom = 'Bernard'
LIMIT 1;

INSERT INTO participation (id, seance_id, personnel_id)
SELECT gen_random_uuid(), s.id, p.id
FROM seance s, personnel p
WHERE s.description LIKE '%CCPS%' AND p.nom = 'Petit'
LIMIT 1;

-- ----------------------------------------------------------------------------
-- PARTICIPATION_QUALIFICATION
-- ----------------------------------------------------------------------------
INSERT INTO participation_qualification
(id, participation_id, qualification_id, arme_id, is_validate, date)
SELECT gen_random_uuid(), part.id, q.id, a.id, TRUE, '2025-01-12'
FROM participation part
         JOIN qualification q ON q.libelle = 'CATi 2'
         JOIN arme a ON a.nom = 'FAMAS'
LIMIT 1;

INSERT INTO participation_qualification
(id, participation_id, qualification_id, arme_id, is_validate, date)
SELECT gen_random_uuid(), part.id, q.id, a.id, FALSE, '2025-01-12'
FROM participation part
         JOIN qualification q ON q.libelle = 'Bravo'
         JOIN arme a ON a.nom = 'Glock 17 Gen 5'
OFFSET 1 LIMIT 1;

INSERT INTO participation_qualification
(id, participation_id, qualification_id, arme_id, is_validate, date)
SELECT gen_random_uuid(), part.id, q.id, a.id, TRUE, '2025-02-05'
FROM participation part
         JOIN qualification q ON q.libelle = 'CATi 2'
         JOIN arme a ON a.nom = 'HK416-f'
OFFSET 2 LIMIT 1;

-- ----------------------------------------------------------------------------
-- TACHES
-- ----------------------------------------------------------------------------
INSERT INTO tache (id, seance_id, libelle, echeance_at, statut)
SELECT gen_random_uuid(), id, 'Préparer le stand', '2025-01-10', 'TERMINE'
FROM seance WHERE description LIKE '%FAMAS%' LIMIT 1;

INSERT INTO tache (id, seance_id, libelle, echeance_at, statut)
SELECT gen_random_uuid(), id, 'Nettoyer les armes', '2025-02-06', 'EN_COURS'
FROM seance WHERE description LIKE '%pistolet%' LIMIT 1;

INSERT INTO tache (id, seance_id, libelle, echeance_at, statut)
SELECT gen_random_uuid(), id, 'Rédiger la note', '2025-02-21', 'A_FAIRE'
FROM seance WHERE description LIKE '%CCPS%' LIMIT 1;
