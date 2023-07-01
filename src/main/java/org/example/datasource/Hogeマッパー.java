package org.example.datasource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.datasource.dto.HogePiyoリスト型;
import org.example.domain.Hogeリスト型;
import org.example.domain.Piyoマップ型;

@Mapper
public interface Hogeマッパー {
    void テストinsert1(@Param("hogeリスト") Hogeリスト型 リスト, @Param("piyoマップ") Piyoマップ型 piyoMap);
    void テストinsert2(@Param("hogeリスト") Hogeリスト型 リスト, @Param("piyoマップ") Piyoマップ型 piyoMap);
    void テストinsert3(@Param("hogepiyoリスト") HogePiyoリスト型 リスト);
}
