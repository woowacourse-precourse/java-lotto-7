package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class LottoPurchaseHandler {
    private static final int SINGLE_LOTTO_PRICE = 1000;

    public static int getValidatedPaymentAmount() {
        printRequestingMoneyInput();

        String moneyInput = InputHandler.getUserInput();

        return Validator.validateMoneyInput(moneyInput);
    }

    public static int getLottoPurchaseCount(int money) {
        return money / SINGLE_LOTTO_PRICE;
    }

    public static void getRandomLottoBundle(int lottoPurchaseCount,
                                            List<List<Integer>> randomLottoBundle) {
        for (int n = 0; n< lottoPurchaseCount; n++) {
            List<Integer> randomLotto = getOneRandomLotto();
            randomLotto.sort(Comparator.naturalOrder());
            randomLottoBundle.add(randomLotto);

            System.out.println(randomLotto);
        }

        System.out.println();
    }

    private static void printRequestingMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printConfirmPurchase(int lottoPurchaseCount) {
        System.out.println("\n" + lottoPurchaseCount + "개를 구매했습니다.");
    }

    private static List<Integer> getOneRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
