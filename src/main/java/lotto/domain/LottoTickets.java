package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }


    private static List<Lotto> generateLottoTickets(int count){
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.generateLotto();
            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }


}
