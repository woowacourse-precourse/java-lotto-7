package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int money = getPurchaseAmount();
        List<Lotto> lottos = buyLottos(money);
        WinNumber winNumber = inputWinNumbers();
        int bonusNumber = inputBonusNumber();

        checkAndPrintResults(lottos, winNumber, bonusNumber, money);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static List<Lotto> buyLottos(int money) {
        Buy buy = new Buy();
        int count = buy.countLotto(money);
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<Lotto> lottos = Lotto.generateLottos(count);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        return lottos;
    }

    private static WinNumber inputWinNumbers() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String inputWinNumbers = Console.readLine();
        WinNumber winNumber = new WinNumber();
        winNumber.inputWinNumber(inputWinNumbers);
        return winNumber;
    }

    private static int inputBonusNumber() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void checkAndPrintResults(List<Lotto> lottos, WinNumber winNumber, int bonusNumber, int money) {
        MatchNumber matchNumber = new MatchNumber(winNumber, bonusNumber);
        matchNumber.checkWinNumber(lottos);
        LottoResults results = new LottoResults(matchNumber.getPrizeCount(), matchNumber.getTotalPrize(), money);
        results.printResults();
    }
}
