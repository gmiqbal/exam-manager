ALTER TABLE `exam`
    DROP COLUMN `priority`,
    ADD COLUMN `difficulty` ENUM('EASY', 'MEDIUM', 'HARD') NOT NULL AFTER `description`;
