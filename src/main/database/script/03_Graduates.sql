-- DB切り替え
\c hogedb

CREATE TABLE  hogeschema.graduates (
    name VARCHAR,
    income integer,
    PRIMARY KEY (name)
);

GRANT ALL PRIVILEGES ON hogeschema.graduates TO hoge;

INSERT INTO hogeschema.graduates VALUES('サンプソン', 400000);
INSERT INTO hogeschema.graduates VALUES('マイク', 30000);
INSERT INTO hogeschema.graduates VALUES('ホワイト', 20000);
INSERT INTO hogeschema.graduates VALUES('アーノルド', 20000);
INSERT INTO hogeschema.graduates VALUES('スミス', 20000);
INSERT INTO hogeschema.graduates VALUES('ロレンス', 15000);
INSERT INTO hogeschema.graduates VALUES('ハドソン', 15000);
INSERT INTO hogeschema.graduates VALUES('ケント', 10000);
INSERT INTO hogeschema.graduates VALUES('ベッカー', 10000);
INSERT INTO hogeschema.graduates VALUES('スコット', 10000);
