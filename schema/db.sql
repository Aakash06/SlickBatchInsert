# --- !Ups
CREATE TABLE `pin_code` (
  `id`                      BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `profile_id`              BIGINT,
  `snap3_receipt_id`        VARCHAR(254),
  `code`                    VARCHAR(254) NOT NULL,
  `used`                    BOOLEAN      NOT NULL,
  `created_date`            DATETIME
);

ALTER TABLE pin_code ADD CONSTRAINT profileId_fk FOREIGN KEY (profile_id) REFERENCES user_profile (id);
