package lotto;

import lotto.view.LottoInput;
import lotto.view.LottoOutput;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.RandomLottoGenerator.*;

public class LottoGame {

    public void run() {
        LottoCost lottoCost = creatLottoCost();

        int lottoCount = lottoCost.divideCostByUnit();
        List<Lotto> myLottos = createMyLottos(lottoCount);

        LottoOutput.outputLottoNumbers(lottoCost, myLottos);

        CorrectLotto correctLotto = createCorrectLotto();
        RankCalculator rankCalculator = calculateLottoRanks(myLottos, correctLotto);
        LottoOutput.outputRankResult(rankCalculator);
    }

    private LottoCost creatLottoCost() {
        try {
            String input = LottoInput.inputCost();
            return LottoCost.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return creatLottoCost();
        }
    }

    private CorrectLotto createCorrectLotto() {
        Lotto lotto = createCorrectNumbers();
        BonusNumber bonusNumber = createBonusNumber(lotto);

        return new CorrectLotto(lotto, bonusNumber);
    }

    private Lotto createCorrectNumbers() {
        try {
            return CorrectLotto.createCorrectNumber(LottoInput.inputCorrectNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCorrectNumbers();
        }
    }

    private BonusNumber createBonusNumber(Lotto lotto) {
        try {
            String input = LottoInput.inputBonusNumber();
            return BonusNumber.from(input, lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber(lotto);
        }
    }

    private List<Lotto> createMyLottos(int count) {
        List<Lotto> lottos = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateSixRandomNumber()));
        }

        return lottos;
    }

    private RankCalculator calculateLottoRanks(List<Lotto> lottos, CorrectLotto correctLotto) {
        List<Rank> ranks = lottos.stream()
                .map(correctLotto::match)
                .toList();
        return RankCalculator.from(ranks);
    }
}
