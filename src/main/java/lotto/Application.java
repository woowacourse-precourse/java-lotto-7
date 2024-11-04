package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static Input input = new Input();
    static Output output = new Output();

    public static void main(String[] args) {

        int money = input.askPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> playerLottos = lottoMachine.purchaseLotto(money);
        output.printPurchaseLotto(playerLottos);

        //당첨 번호 입력
        List<Integer> winningNumbers = input.askWinningNumbers();
        int bonusNumber = input.askBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        Map<String, Integer> winningResult = winningLotto.getWinningResult(playerLottos);
        LottoStatistics lottoStatistics = new LottoStatistics();
        output.printWinningResult(winningResult, lottoStatistics.calculateYield(money, winningResult));
    }
}
