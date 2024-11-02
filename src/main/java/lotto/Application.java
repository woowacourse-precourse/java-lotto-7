package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String amountInput = InputHandler.handleAmountInput();

        int amount = Integer.parseInt(amountInput);
        int lottoCount = amount / 1000;
        Lotto[] lottoArray = issueLotto(lottoCount);
        List<Integer> winningLotto = InputHandler.handleWinningLottoInput();
        int bonusNumber = InputHandler.handleBonusNumberInput();

        for (Lotto eachLotto : lottoArray) {
            eachLotto.match(winningLotto);
        }
    }

    private static Lotto[] issueLotto(int lottoCount) {
        Lotto[] lottoArray = new Lotto[lottoCount];
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomLottoNumbers);
            lottoArray[i] = lotto;
            lotto.display();
        }

        return lottoArray;
    }
}
