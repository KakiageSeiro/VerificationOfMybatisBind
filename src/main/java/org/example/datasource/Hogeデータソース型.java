package org.example.datasource;

import org.example.domain.Hogeリスト型;
import org.example.domain.Piyoマップ型;
import org.example.domain.service.repository.Hogeリポジトリ;
import org.springframework.stereotype.Repository;

@Repository
public class Hogeデータソース型 implements Hogeリポジトリ {

    private final Hogeマッパー mapper;

    public Hogeデータソース型(Hogeマッパー mapper) {
        this.mapper = mapper;
    }

    @Override
    public void 追加する(Hogeリスト型 リスト, Piyoマップ型 piyoMap) {
        mapper.テストinsert1(リスト, piyoMap);
    }

    @Override
    public void 追加する2(Hogeリスト型 リスト, Piyoマップ型 piyoMap) {
        mapper.テストinsert2(リスト, piyoMap);
    }
}
