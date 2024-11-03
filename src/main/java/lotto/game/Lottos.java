package lotto.game;

import lotto.dto.LottoPrize;
import lotto.dto.Buyer;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public LottoPrizeRecord checkLottos(Buyer buyer) {
        LottoPrizeRecord lottoPrizeRecord = new LottoPrizeRecord();
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.decideLottoPrize(buyer);
            lottoPrizeRecord.updateResult(lottoPrize);
        }
        return lottoPrizeRecord;
    }

    public int getSize() {
        return lottos.size();
    }
}

