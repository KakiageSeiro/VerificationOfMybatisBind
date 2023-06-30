package org.example.domain;

import java.util.Iterator;
import java.util.List;

public class Hogeリスト型 implements Iterable<Hoge型>{
    List<Hoge型> list;

    public Hogeリスト型(List<Hoge型> list) {
        this.list = list;
    }

    @Override
    public Iterator<Hoge型> iterator() {
        return list.iterator();
    }
}
