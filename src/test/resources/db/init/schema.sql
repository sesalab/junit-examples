CREATE TABLE IF NOT EXISTS GREENPASS
(
    `qrCode`        varchar(100) NOT NULL,
    `nomeCompleto`  varchar(100) NOT NULL,
    `dataEmissione` timestamp    NOT NULL DEFAULT current_timestamp,
    PRIMARY KEY (`qrCode`)
);
CREATE TABLE IF NOT EXISTS SCAN
(
    `greenPass`    varchar(100) NOT NULL,
    `dataVerifica` timestamp    NOT NULL DEFAULT current_timestamp,
    `valido`       varchar(100) NOT NULL,
    PRIMARY KEY (`greenPass`, `dataVerifica`)
    --FOREIGN KEY (`greenPass`) REFERENCES GREEN_PASS (`qrCode`)
);