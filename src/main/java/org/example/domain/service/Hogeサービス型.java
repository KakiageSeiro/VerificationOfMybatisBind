package org.example.domain.service;

import org.example.datasource.Hogeデータソース型;
import org.example.domain.service.command.Hoge追加command;
import org.example.domain.service.repository.Hogeリポジトリ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Hogeサービス型 {
    @Autowired
    Hogeリポジトリ hogeリポジトリ;

    @Transactional
    public void 追加する(Hoge追加command command) {
        hogeリポジトリ.追加する(command.hogeリスト(), command.piyoマップ());
    }

    @Transactional
    public void 追加する2(Hoge追加command command) {
        hogeリポジトリ.追加する2(command.hogeリスト(), command.piyoマップ());
    }
}
