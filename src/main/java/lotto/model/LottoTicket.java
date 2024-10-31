package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;

    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }
}