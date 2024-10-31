package lotto;

import lotto.view.LottoInput;

import java.util.List;

public class LottoGame {

    public void run() {
        LottoCost lottoCost = creatLottoCost();
        CorrectLotto correctLotto = createCorrectLotto();

    }

    private LottoCost creatLottoCost() {
        try {
            int cost = LottoInput.inputCost();
            return new LottoCost(cost);
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
}
