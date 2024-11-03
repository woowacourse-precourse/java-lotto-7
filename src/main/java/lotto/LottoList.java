package lotto;

import java.util.List;

public class LottoList {
    List<Lotto> list;

    public LottoList(List<Lotto> lottoList) {
        this.list = lottoList;
    }

    public List<Lotto> getLottoList() {
        return list;
    }

    public int size() {
        return list.size();
    }
}
