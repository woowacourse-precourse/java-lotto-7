package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Optional;

public class LottoGame {
    public static void start() {
        String amountInput = InputHandler.handleAmountInput();

        int amount = Integer.parseInt(amountInput);
        int lottoCount = amount / 1000;
        Lotto[] lottoArray = issueLotto(lottoCount);
        List<Integer> winningLotto = InputHandler.handleWinningLottoInput();
        int bonusNumber = InputHandler.handleBonusNumberInput();
        WinnerResult winnerResult = new WinnerResult(amount);
        for (Lotto eachLotto : lottoArray) {
            Optional<Rank> rank = eachLotto.match(winningLotto, bonusNumber);
            if (rank.isEmpty()) {
                continue;
            }

            winnerResult.add(rank.get());
        }

        winnerResult.display();
    }

    private static Lotto[] issueLotto(int lottoCount) {
        Lotto[] lottoArray = new Lotto[lottoCount];
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomLottoNumbers);
            lottoArray[i] = lotto;
            lotto.display();
        }

        return lottoArray;
    }
}
