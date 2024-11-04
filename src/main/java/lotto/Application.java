package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        int purchaseAmount = getPurchaseAmount();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.purchaseLottos(purchaseAmount);

        printLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        result.printResult();
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return LottoNumberValidator.validatePurchaseAmount(input);
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return LottoNumberValidator.validateWinningNumbers(input);
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return LottoNumberValidator.validateBonusNumber(input);
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}