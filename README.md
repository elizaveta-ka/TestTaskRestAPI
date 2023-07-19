# TestTaskRestAPI
# MySQL + JWT Auth + Swagger + REST API

INSERT INTO roles (id, name)
VALUES (1, "ROLE_ADMIN"),
       (2, "ROLE_USER");
       
INSERT INTO users (id, email, password, username)
VALUES   (1, "admin@gmail.com", "$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu", "admin"),
         (2, "andr@gmail.com", "$2a$10$yR0H9ZUjIAlXueqh8bgB1OngY/F/9GT3NlUiK2ugmfEce6.ysXlSu", "andrew"),
         (3, "ol@gmail.com", "$2a$10$TH5PzmIfJT.KmdP0yyDa9uc.FGGMiY2zfryZszsL/ILq9h7cWFs3.", "olya"),
         (4, "liza@gmail.com", "$2a$10$2M7ltMXyOCaTZ7bjLCWtfeIbf5lVBaSMYYHOCqGAPJ7cKff7pH7Nq", "liza"),
         (5, "masha@gmail.com", "$2a$10$MZ0eWuhoDnaM6dE.5TyC5Ozg57ggLJELEhTs0lKnj4QzlX/UvO6t6", "mas");
         
INSERT INTO users_roles (role_id, user_id)
VALUES (1, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5);
       
INSERT INTO history_message (message_id, date_time, recipient_id, sender_id, status, text)
VALUES (2, "2023-05-29 18:27:14", 5, 1, null, "hello"),
       (3, "2023-05-29 18:33:20", 1, 4, null, "hi"),
       (4, "2023-05-29 19:00:28", 1, 4, null, "how a you"),
       (5, "2023-05-29 18:25:14", 5, 1, null, "hello"),
       (6, "2023-05-29 18:43:20", 1, 3, null, "hi"),
       (7, "2023-05-29 14:00:28", 2, 1, null, "hello"),
       (8, "2023-05-29 18:25:14", 4, 1, null, "fine"),
       (9, "2023-05-29 18:43:20", 1, 2, null, "hi"),
       (10, "2023-05-29 14:00:28", 2, 3, null, "hello");
       
INSERT INTO posts (id, image, text, title, user_id, date_post)
VALUES (1, 'image', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 'Lorem ipsum', 1, '2023-05-28 19:26:10.677254'),
       (2, 'image', 'Suspendisse ac ipsum eget nibh volutpat tincidunt', 'Suspendisse ac', 1, '2023-05-29 11:20:10.677254'),
       (3, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-25 15:20:10.677254'),
       (4, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 2, '2023-05-23 12:25:10.677254'),
       (5, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 3, '2023-05-23 10:20:10.677254'),
       (6, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 4, '2023-05-17 17:20:10.677254'),
       (7, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 5, '2023-05-18 12:50:10.677254'),
       (8, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-16 10:20:10.677254'),
       (9, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 2, '2023-05-16 10:29:10.677254'),
       (10, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 3, '2023-05-19 18:20:10.677254'),
       (11, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 4, '2023-05-19 18:35:10.677254'),
       (12, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-26 20:30:10.677254'),
       (13, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-26 20:35:10.677254'),
       (14, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 5, '2023-05-20 10:15:10.677254'),
       (15, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-19 10:12:10.677254'),
       (16, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 2, '2023-05-18 15:19:10.677254'),
       (17, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 5, '2023-05-20 13:35:10.677254'),
       (18, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-22 12:45:10.677254'),
       (19, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 2, '2023-05-16 17:49:10.677254'),
       (20, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 3, '2023-05-25 11:20:10.677254'),
       (21, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 4, '2023-05-23 14:35:10.677254'),
       (22, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-23 15:45:10.677254'),
       (23, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-26 15:27:10.677254'),
       (24, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 5, '2023-05-24 13:15:10.677254'),
       (25, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 1, '2023-05-28 11:28:10.677254'),
       (26, 'image', 'Donec auctor lorem et congue pretium', 'Donec auctor', 2, '2023-05-23 17:20:10.677254');
