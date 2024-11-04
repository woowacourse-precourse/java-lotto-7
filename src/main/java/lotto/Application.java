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


        String result = """
                
                당첨 통계
                ---
                3개 일치 (5,000원) - %s개
                4개 일치 (50,000원) - %s개
                5개 일치 (1,500,000원) - %s개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
                6개 일치 (2,000,000,000원) - %s개
                총 수익률은 %s%%입니다.
                """
                .formatted(
                        winningResult.get("MATCH_3"),
                        winningResult.get("MATCH_4"),
                        winningResult.get("MATCH_5"),
                        winningResult.get("MATCH_5_BONUS"),
                        winningResult.get("MATCH_6"),
                        calculateYield(money, winningResult)
                );
        System.out.println(result);
    }

    public static String calculateYield(int money, Map<String, Integer> winningResult) {
        long totalPrize =
                (winningResult.get("MATCH_3") * 5_000) +
                        (winningResult.get("MATCH_4") * 50_000) +
                        (winningResult.get("MATCH_5") * 1_500_000) +
                        (winningResult.get("MATCH_5_BONUS") * 30_000_000) +
                        (winningResult.get("MATCH_6") * 2_000_000_000L);


        return String.format("%.1f", ((double) totalPrize / money) * 100);
    }
}
