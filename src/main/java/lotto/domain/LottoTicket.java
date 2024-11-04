package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket() {
        this.lottoTicket = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoTicket.add(lotto);
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }

    public int getCount() {
        return lottoTicket.size();
    }
}