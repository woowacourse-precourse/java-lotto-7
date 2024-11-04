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
        Lotto lotto = createCorrectNumbers();
        int bonusNumber = createBonusNumber();

        try {
            return new CorrectLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createCorrectLotto();
        }
    }

    private Lotto createCorrectNumbers() {
        try {
            List<Integer> numbers = LottoInput.inputCorrectNumbers().stream()
                    .map(input -> {
                        try {
                            return Integer.parseInt(input);
                        } catch (Exception e) {
                            throw new IllegalArgumentException("[ERROR] 당첨번호는 1~45의 정수이어야 합니다.");
                        }
                    })
                    .toList();
            return new Lotto(numbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createCorrectNumbers();
        }
    }

    private int createBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(LottoInput.inputBonusNumber());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return createBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber();
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
