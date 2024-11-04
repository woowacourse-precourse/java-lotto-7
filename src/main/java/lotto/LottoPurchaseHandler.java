package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoPurchaseHandler {
    private static final int SINGLE_LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int NUMBERS_PER_LOTTO = 6;

    public static int getValidatedPaymentAmount(String moneyInput) {
        String money = moneyInput;

        while (true) {
            try {
                return Validator.validateMoneyInput(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
                money = InputHandler.getUserInput();
            }
        }
    }

    public static int getLottoPurchaseCount(int money) {
        return money / SINGLE_LOTTO_PRICE;
    }

    public static void getRandomLottoBundle(int lottoPurchaseCount,
                                            List<List<Integer>> randomLottoBundle) {
        printConfirmPurchase(lottoPurchaseCount);

        for (int n = 0; n< lottoPurchaseCount; n++) {
            List<Integer> randomLotto = new ArrayList<>(getOneRandomLotto());
            randomLotto.sort(Comparator.naturalOrder());
            randomLottoBundle.add(randomLotto);

            System.out.println(randomLotto);
        }

        System.out.println();
    }

    public static void printRequestingMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printConfirmPurchase(int lottoPurchaseCount) {
        System.out.println("\n" + lottoPurchaseCount + "개를 구매했습니다.");
    }

    private static List<Integer> getOneRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, NUMBERS_PER_LOTTO);
    }
}
