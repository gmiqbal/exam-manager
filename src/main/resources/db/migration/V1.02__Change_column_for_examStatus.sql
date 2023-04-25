ALTER TABLE `exam`
    DROP COLUMN `status`,
    ADD COLUMN `status` ENUM('UPCOMING', 'ONGOING', 'DONE') NOT NULL AFTER `difficulty`;
