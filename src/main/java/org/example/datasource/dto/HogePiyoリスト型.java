package org.example.datasource.dto;

import java.util.Iterator;
import java.util.List;

public class HogePiyoリスト型 implements Iterable<HogePiyo型>{
    List<HogePiyo型> list;

    public HogePiyoリスト型(List<HogePiyo型> list) {
        this.list = list;
    }

    @Override
    public Iterator<HogePiyo型> iterator() {
        return list.iterator();
    }
}
