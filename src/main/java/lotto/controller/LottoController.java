package lotto.controller;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER_COUNT;
import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        int purchaseAmount = makeLottoPurchaseAmountRecursion();

        List<Lotto> autoLottos = makeAutoLottos(purchaseAmount);

        OutputView.outputAutoLottos(autoLottos);

        Lotto winningNumbers = makeWinningNumbersRecursion();
        WinningLotto winningLotto = addBonusNumbersToWinningNumbersRecursion(winningNumbers);

        WinningResult winningResult = makeLottoWinningResult(autoLottos, winningLotto);

        OutputView.outputWinningResult(winningResult, purchaseAmount);
    }

    private int makeLottoPurchaseAmountRecursion() {
        try {
            OutputView.requestInputPurchaseAmount();
            int purchaseAmount = InputView.inputLottoPurchaseAmount();
            return purchaseAmount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makeLottoPurchaseAmountRecursion();
        }
    }

    private Lotto makeWinningNumbersRecursion() {
        try {
            OutputView.requestInputWinningNumbers();
            Lotto winningNumbers = InputView.inputLottoWinningNumbers();
            return winningNumbers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makeWinningNumbersRecursion();
        }
    }

    private WinningLotto addBonusNumbersToWinningNumbersRecursion(Lotto winningNumbers) {
        try {
            OutputView.requestInputBounusNumber();
            Integer inputBonusNumber = InputView.inputBonusNumber();
            return new WinningLotto(winningNumbers, inputBonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return addBonusNumbersToWinningNumbersRecursion(winningNumbers);
        }
    }

    private List<Lotto> makeAutoLottos(int purchaseAmount) {
        int lottoCnt = purchaseAmount / 1000;
        List<Lotto> autoLottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            autoLottos.add(makeAutoLotto());
        }

        return autoLottos;
    }

    private Lotto makeAutoLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                        MAX_LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    private WinningResult makeLottoWinningResult(List<Lotto> lottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.calculateMatchCount(lotto);
            boolean isbonusMatch = winningLotto.isBonusMatch(lotto);
            LottoRank lottoRank = LottoRank.findRank(matchCount, isbonusMatch);

            winningResult.increaseRankScore(lottoRank);
        }

        return winningResult;
    }
}
