package org.example.domain.service;

import org.example.datasource.dto.HogePiyoリスト型;
import org.example.datasource.dto.HogePiyo型;
import org.example.domain.Hoge型;
import org.example.domain.Piyo型;
import org.example.domain.service.command.Hoge追加command;
import org.example.domain.repository.Hogeリポジトリ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public void 追加する3(Hoge追加command command) {
        List<HogePiyo型> list = new ArrayList<>();
        for (Hoge型 hoge : command.hogeリスト()) {
            Piyo型 piyo = command.piyoマップ().get(hoge);
            list.add(new HogePiyo型(hoge, piyo));
        }

        hogeリポジトリ.追加する3(new HogePiyoリスト型(list));
    }
}
