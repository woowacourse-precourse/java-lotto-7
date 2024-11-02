package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class LottoPurchaseHandler {
    private static final int SINGLE_LOTTO_PRICE = 1000;

    public static int purchaseLotto() {
        printRequestingMoneyInput();

        String moneyInput = InputHandler.getUserInput();
        int lottoPurchaseCount = getLottoPurchaseCount(moneyInput);

        printConfirmPurchase(lottoPurchaseCount);

        return lottoPurchaseCount;
    }

    public static void getRandomLottoBundle(int lottoPurchaseCount, List<List<Integer>> randomLottoBundle) {
        for (int n = 0; n< lottoPurchaseCount; n++) {
            List<Integer> randomLotto = getOneRandomLotto();
            randomLotto.sort(Comparator.naturalOrder());
            randomLottoBundle.add(randomLotto);

            System.out.println(randomLotto);
        }
    }

    private static void printRequestingMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private static int getLottoPurchaseCount(String userInput) {
        int money = Validator.validateMoneyInput(userInput);
        return money / SINGLE_LOTTO_PRICE;
    }

    private static void printConfirmPurchase(int lottoPurchaseCount) {
        System.out.println("\n" + lottoPurchaseCount + "개를 구매했습니다.");
    }

    private static List<Integer> getOneRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
