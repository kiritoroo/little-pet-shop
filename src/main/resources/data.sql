INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Polar', 'Polar habitat...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Desert', 'Desert habitat...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Wetlands', 'Wetlands habitat...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Savanna', 'Savanna habitat...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Woodland', 'Woodland habitat...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Rainforest', 'Rainforest habitat...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Ocean', 'Ocean habitat', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`habitats` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Coral Reef', 'Coral Reef habitat...', NOW(), NOW());


INSERT IGNORE INTO `little_pet_shop`.`pet_kinds` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Guinea Pig', 'Guinea Pig pet...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pet_kinds` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Hamster', 'Hamster pet...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pet_kinds` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Cat', 'Cat pet...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pet_kinds` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Dog', 'Dog pet...', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pet_kinds` (`title`, `description`, `created_at`, `updated_at`)
VALUES ('Rabit', 'Dog pet...', NOW(), NOW());


INSERT IGNORE INTO `little_pet_shop`.`pet_breeds` (`id_kind`, `title`, `description`, `origin`, `created_at`, `updated_at`)
VALUES ('1', 'Peruvian Guinea Pig', 'The smooth, straight fur can grow as long as 2 feet!', 'Peru', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('1', '1');
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('1', '2');
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('1', '3');

INSERT IGNORE INTO `little_pet_shop`.`pet_breeds` (`id_kind`, `title`, `description`, `origin`, `created_at`, `updated_at`)
VALUES ('1', 'Skinny Guinea Pig', 'The Skinny is part of the hairless guinea pigs', 'Canada', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('2', '4');
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('2', '5');

INSERT IGNORE INTO `little_pet_shop`.`pet_breeds` (`id_kind`, `title`, `description`, `origin`, `created_at`, `updated_at`)
VALUES ('1', 'Teddy Guinea Pig', 'Nicknamed after the famous stuffed animal...', 'United States', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('3', '4');
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('3', '5');

INSERT IGNORE INTO `little_pet_shop`.`pet_breeds` (`id_kind`, `title`, `description`, `origin`, `created_at`, `updated_at`)
VALUES ('1', 'Texel Guinea Pig', 'Texels are a rare cross breed between a Silkie and a Rex', 'England', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('4', '4');
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('4', '5');

INSERT IGNORE INTO `little_pet_shop`.`pet_breeds` (`id_kind`, `title`, `description`, `origin`, `created_at`, `updated_at`)
VALUES ('1', 'Coronet Guinea Pig', 'A Coronet can be identified by its flowing...', 'Himalaya', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('4', '4');
INSERT IGNORE INTO `little_pet_shop`.`breed_habitat` (`id_breed`, `id_habitat`) VALUES ('4', '5');


INSERT IGNORE INTO `little_pet_shop`.`pets` ( `name`, `age`, `color`, `gender`, `description`, `id_breed`, `created_at`, `updated_at`)
VALUES ('Teddy Short Hair Guinea Pig', '1', 'Socola', 'Male', '...', '3', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pictures` (`name`, `url`, `id_pet`) VALUES ('default_1.jpg', './statics/default_1.jpg', '1');

INSERT IGNORE INTO `little_pet_shop`.`pets` ( `name`, `age`, `color`, `gender`, `description`, `id_breed`, `created_at`, `updated_at`)
VALUES ('Texel Cute Guinea Pig', '1', 'White', 'Male', '...', '4', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pictures` (`name`, `url`, `id_pet`) VALUES ('default_2.jpg', './statics/default_2.jpg', '2');

INSERT IGNORE INTO `little_pet_shop`.`pets` ( `name`, `age`, `color`, `gender`, `description`, `id_breed`, `created_at`, `updated_at`)
VALUES ('Peruvian Short Hair Guinea Pig', '1', 'Red Brown', 'Female', '...', '1', NOW(), NOW());
INSERT IGNORE INTO `little_pet_shop`.`pictures` (`name`, `url`, `id_pet`) VALUES ('default_3.webp', './statics/default_3.webp', '3');