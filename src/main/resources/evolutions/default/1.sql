CREATE TABLE `pin_code` (
  `id`                      BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `profile_id`              BIGINT,
  `snap3_receipt_id`        VARCHAR(254),
  `code`                    VARCHAR(254) NOT NULL,
  `used`                    BOOLEAN      NOT NULL,
  `created_date`            DATETIME,
);

INSERT INTO pin_code(id, profile_id, snap3_receipt_id, code, used, created_date) values (1, NULL, NULL, 'pin', 0, NULL);

# --- !Downs
DROP TABLE entries;
