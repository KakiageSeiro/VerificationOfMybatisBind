-- DB切り替え
\c hogedb

-- テーブル作成
CREATE TABLE  hogeschema.hoge_piyo (
    hoge TEXT,
    piyo TEXT,
    PRIMARY KEY (hoge, piyo)
);

-- 権限追加
GRANT ALL PRIVILEGES ON hogeschema.hoge_piyo TO hoge;

-- サンプルレコード作成
INSERT INTO hogeschema.hoge_piyo VALUES('hoge1', 'piyo1');
INSERT INTO hogeschema.hoge_piyo VALUES('hoge2', 'piyo2');
INSERT INTO hogeschema.hoge_piyo VALUES('hoge3', 'piyo3');
