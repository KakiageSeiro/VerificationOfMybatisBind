package org.example.domain;

import java.sql.PreparedStatement;
import java.util.Map;

public class Piyoマップ型 {
    Map<Hoge型, Piyo型> map;

    public Piyoマップ型(Map<Hoge型, Piyo型> map) {
        this.map = map;
    }

    public Piyo型 get(Hoge型 key){
        return map.get(key);
    }

    // 使われ方を指定するメソッドを生やすのは良くないとされるが、名称でプログラマーが気付いてくれることを期待する…
//    public Piyo型 getForMybatis(Hoge型 key){
//        PreparedStatement(map.get(key))
//        return ;
//    }
}
