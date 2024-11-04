package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<Lotto> purchasedLottos = purchaseLottos();
            OutputView.printPurchaseCount(purchasedLottos.size());
            OutputView.printLottos(purchasedLottos);

            WinningNumber winningNumber = inputWinningNumbers();
            calculateAndPrintResult(purchasedLottos, winningNumber);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Lotto> purchaseLottos() {
        int amount = InputView.readPurchaseAmount();
        int count = amount / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static WinningNumber inputWinningNumbers() {
        Lotto winningLotto = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private static void calculateAndPrintResult(List<Lotto> lottos, WinningNumber winningNumber) {
        Result lottoResult = new Result(lottos, winningNumber);
        OutputView.printWinningStatistics(lottoResult);
    }
}