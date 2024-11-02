package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String amountInput = InputHandler.handleAmountInput();

        int amount = Integer.parseInt(amountInput);
        int lottoCount = amount / 1000;

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = issueLotto();
            lottoList.add(lotto);
            lotto.display();
        }

        int[] winningLotto = InputHandler.handleWinningLottoInput();
        int bonusNumber = InputHandler.handleBonusNumberInput();
    }

    private static Lotto issueLotto() {
        List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomLottoNumbers);
    }
}
