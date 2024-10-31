package lotto.game;

import lotto.dto.LottoPrize;
import lotto.dto.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public LottoPrizeRecord checkLottos(WinningNumbers winningNumbers) {
        LottoPrizeRecord lottoPrizeRecord = new LottoPrizeRecord();
        for (Lotto lotto : lottos) {
            LottoPrize lottoPrize = lotto.decideLottoPrize(winningNumbers);
            lottoPrizeRecord.updateResult(lottoPrize);
        }
        return lottoPrizeRecord;
    }

    public int getSize() {
        return lottos.size();
    }
}

