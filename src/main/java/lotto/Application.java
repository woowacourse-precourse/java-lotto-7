package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static Input input = new Input();
    static Output output = new Output();
    static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {

        List<Lotto> playerLottos = createPlayerLottos();
        output.printPurchaseLotto(playerLottos);

        //당첨 번호 입력
        List<Integer> winningNumbers = input.askWinningNumbers();
        int bonusNumber = input.askBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        Map<String, Integer> winningResult = winningLotto.getWinningResult(playerLottos);
        LottoStatistics lottoStatistics = new LottoStatistics();
        output.printWinningResult(winningResult, lottoStatistics.calculateYield(money, winningResult));
    }

    private static List<Lotto> createPlayerLottos() {
        while (true) {
            try {
                int money = input.askPurchaseAmount();
                return lottoMachine.purchaseLotto(money);
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }
}
