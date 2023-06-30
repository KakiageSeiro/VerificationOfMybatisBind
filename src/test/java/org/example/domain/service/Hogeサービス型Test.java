package org.example.domain.service;

import org.example.VerificationOfMybatisBindApplication;
import org.example.domain.Hogeリスト型;
import org.example.domain.Hoge型;
import org.example.domain.Piyoマップ型;
import org.example.domain.Piyo型;
import org.example.domain.service.command.Hoge追加command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = VerificationOfMybatisBindApplication.class) // ここで指定したクラス配下がSpringのBeanの検索範囲になることに注意。
class Hogeサービス型Test {

    @Autowired
    Hogeサービス型 hogeサービス;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @Rollback
    @Transactional
    void 追加する() {
        Hoge型 testHoge1 = new Hoge型("testHoge1");
        Hoge型 testHoge2 = new Hoge型("testHoge2");
        Hoge型 testHoge3 = new Hoge型("testHoge3");

        List<Hoge型> list = new ArrayList<>();
        list.add(testHoge1);
        list.add(testHoge2);
        list.add(testHoge3);
        Hogeリスト型 hogeリスト = new Hogeリスト型(list);

        HashMap<Hoge型, Piyo型> map = new HashMap<>();
        map.put(testHoge1, new Piyo型("testPiyo1"));
        map.put(testHoge2, new Piyo型("testPiyo2"));
        map.put(testHoge3, new Piyo型("testPiyo3"));
        Piyoマップ型 piyoマップ = new Piyoマップ型(map);

        hogeサービス.追加する(new Hoge追加command(hogeリスト, piyoマップ));

        List<Map<String, Object>> hogepiyo一覧 = jdbcTemplate.queryForList(
                """
                        SELECT hoge_piyo.hoge, hoge_piyo.piyo
                        FROM "hogeschema"."hoge_piyo"
                        """
        );

        Assertions.assertEquals("testHoge1", hogepiyo一覧.get(3).get("hoge"));
        Assertions.assertEquals("testHoge2", hogepiyo一覧.get(4).get("hoge"));
        Assertions.assertEquals("testHoge3", hogepiyo一覧.get(5).get("hoge"));

        // 全てPiyo3になってしまっている。
        Assertions.assertEquals("testPiyo3", hogepiyo一覧.get(3).get("piyo"));
        Assertions.assertEquals("testPiyo3", hogepiyo一覧.get(4).get("piyo"));
        Assertions.assertEquals("testPiyo3", hogepiyo一覧.get(5).get("piyo"));
    }


    @Test
    @Rollback
    @Transactional
    void 追加する2() {
        Hoge型 testHoge1 = new Hoge型("testHoge1");
        Hoge型 testHoge2 = new Hoge型("testHoge2");
        Hoge型 testHoge3 = new Hoge型("testHoge3");

        List<Hoge型> list = new ArrayList<>();
        list.add(testHoge1);
        list.add(testHoge2);
        list.add(testHoge3);
        Hogeリスト型 hogeリスト = new Hogeリスト型(list);

        HashMap<Hoge型, Piyo型> map = new HashMap<>();
        map.put(testHoge1, new Piyo型("testPiyo1"));
        map.put(testHoge2, new Piyo型("testPiyo2"));
        map.put(testHoge3, new Piyo型("testPiyo3"));
        Piyoマップ型 piyoマップ = new Piyoマップ型(map);

        hogeサービス.追加する2(new Hoge追加command(hogeリスト, piyoマップ));

        List<Map<String, Object>> hogepiyo一覧 = jdbcTemplate.queryForList(
                """
                        SELECT hoge_piyo.hoge, hoge_piyo.piyo
                        FROM "hogeschema"."hoge_piyo"
                        """
        );

        Assertions.assertEquals("testHoge1", hogepiyo一覧.get(3).get("hoge"));
        Assertions.assertEquals("testHoge2", hogepiyo一覧.get(4).get("hoge"));
        Assertions.assertEquals("testHoge3", hogepiyo一覧.get(5).get("hoge"));

        // ちゃんとMapのkey,valueで対応した値が入っている
        Assertions.assertEquals("testPiyo1", hogepiyo一覧.get(3).get("piyo"));
        Assertions.assertEquals("testPiyo2", hogepiyo一覧.get(4).get("piyo"));
        Assertions.assertEquals("testPiyo3", hogepiyo一覧.get(5).get("piyo"));
    }

    @Test
    @Rollback
    @Transactional
    void 追加する2にSQLインジェクションしてみる() {
        Hoge型 testHoge1 = new Hoge型("testHoge1");
        Hoge型 testHoge2 = new Hoge型("testHoge2");
        Hoge型 testHoge3 = new Hoge型("testHoge3");

        List<Hoge型> list = new ArrayList<>();
        list.add(testHoge1);
        list.add(testHoge2);
        list.add(testHoge3);
        Hogeリスト型 hogeリスト = new Hogeリスト型(list);

        HashMap<Hoge型, Piyo型> map = new HashMap<>();
        map.put(testHoge1, new Piyo型("testPiyo1"));
        map.put(testHoge2, new Piyo型("testPiyo2"));
        map.put(testHoge3, new Piyo型("testPiyo3; DROP TABLE \"hogeschema\".\"hoge_piyo\";"));
        Piyoマップ型 piyoマップ = new Piyoマップ型(map);

        hogeサービス.追加する2(new Hoge追加command(hogeリスト, piyoマップ));

        // DROP TABLEされていないことを確認する
        List<Map<String, Object>> hogepiyo一覧 = jdbcTemplate.queryForList(
                """
                        SELECT hoge_piyo.hoge, hoge_piyo.piyo
                        FROM "hogeschema"."hoge_piyo"
                        """
        );

        Assertions.assertEquals("testHoge1", hogepiyo一覧.get(3).get("hoge"));
        Assertions.assertEquals("testHoge2", hogepiyo一覧.get(4).get("hoge"));
        Assertions.assertEquals("testHoge3", hogepiyo一覧.get(5).get("hoge"));

        // ちゃんとMapのkey,valueで対応した値が入っている
        Assertions.assertEquals("testPiyo1", hogepiyo一覧.get(3).get("piyo"));
        Assertions.assertEquals("testPiyo2", hogepiyo一覧.get(4).get("piyo"));
        Assertions.assertEquals("testPiyo3; DROP TABLE \"hogeschema\".\"hoge_piyo\";", hogepiyo一覧.get(5).get("piyo"));
    }
}