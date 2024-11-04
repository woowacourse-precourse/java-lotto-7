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
        output.printWinningResult(winningResult, calculateYield(money, winningResult));
    }

    public static double calculateYield(int money, Map<String, Integer> winningResult) {
        long totalPrize =
                (winningResult.get("MATCH_3") * 5_000) +
                        (winningResult.get("MATCH_4") * 50_000) +
                        (winningResult.get("MATCH_5") * 1_500_000) +
                        (winningResult.get("MATCH_5_BONUS") * 30_000_000) +
                        (winningResult.get("MATCH_6") * 2_000_000_000L);
        return ((double) totalPrize / money) * 100;
    }
}
