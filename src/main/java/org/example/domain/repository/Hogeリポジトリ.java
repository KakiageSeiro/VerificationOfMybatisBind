package org.example.domain.repository;

import org.example.datasource.dto.HogePiyoリスト型;
import org.example.domain.Hogeリスト型;
import org.example.domain.Piyoマップ型;

public interface Hogeリポジトリ {
    void 追加する(Hogeリスト型 リスト, Piyoマップ型 piyoMap);
    void 追加する2(Hogeリスト型 リスト, Piyoマップ型 piyoMap);
    void 追加する3(HogePiyoリスト型 リスト);
}
