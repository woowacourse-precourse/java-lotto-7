package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = LottoGame.validatePurchaseAmount(input);

        List<Lotto> purchasedLottos = LottoGame.buyLottoTickets(amount);
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = LottoGame.getWinningNumbers(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = LottoGame.getBonusNumber(Console.readLine());

        Map<String, Integer> winnings = LottoGame.calculateWinnings(purchasedLottos, winningNumbers, bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        LottoGame.printStatistics(winnings, amount);
    }
}
