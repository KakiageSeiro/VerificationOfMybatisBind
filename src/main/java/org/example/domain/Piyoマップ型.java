package org.example.domain;

import java.util.Map;

public class Piyoマップ型 {
    Map<Hoge型, Piyo型> map;

    public Piyoマップ型(Map<Hoge型, Piyo型> map) {
        this.map = map;
    }

    public Piyo型 get(Hoge型 key){
        return map.get(key);
    }
}
