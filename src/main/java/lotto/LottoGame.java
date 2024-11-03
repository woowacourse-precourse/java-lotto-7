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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return creatLottoCost();
        }
    }

    private CorrectLotto createCorrectLotto() {
        try {
            List<Integer> numbers = LottoInput.inputCorrectNumbers().stream()
                    .map(Integer::parseInt)
                    .toList();
            Lotto lotto = new Lotto(numbers);

            int bonusNumber = Integer.parseInt(LottoInput.inputBonusNumber());

            return new CorrectLotto(lotto, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createCorrectLotto();
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
