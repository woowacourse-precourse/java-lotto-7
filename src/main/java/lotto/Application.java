package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static Input input = new Input();
    static Output output = new Output();
    static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        LottoMoney lottoMoney = createLottoMoney();
        List<Lotto> playerLottos = lottoMachine.purchaseLotto(lottoMoney.getPurchaseCount());
        output.printPurchaseLotto(playerLottos);
        WinningLotto winningLotto = createWinningLotto();
        Map<LottoPrize, Integer> winningResult = winningLotto.getWinningResult(playerLottos);
        LottoStatistics lottoStatistics = new LottoStatistics();
        output.printWinningResult(winningResult, lottoStatistics.calculateYield(lottoMoney.getMoney(), winningResult));
    }

    private static LottoMoney createLottoMoney() {
        while (true) {
            try {
                int money = input.askPurchaseAmount();
                return new LottoMoney(money);
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    private static WinningLotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = input.askWinningNumbers();
                int bonusNumber = input.askBonusNumber();
                return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }
}
