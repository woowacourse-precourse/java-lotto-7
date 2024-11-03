package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_UNIT = 1000;
    private static final int ZERO_AMOUNT = 0;
    private static final int NUMBER_OF_DRAWS = 6;

    private final List<Lotto> purChasedLotto = new ArrayList<>();

    public LottoShop(int amount) {
        int count = getLottoCount(amount);
        while (count != ZERO_AMOUNT) {
            Lotto lotto = new Lotto(drawNumberList());
            this.purChasedLotto.add(lotto);
            count--;
        }
    }

    public List<Lotto> getPurChasedLotto() {
        return purChasedLotto;
    }

    public static int validatePurchaseAmount(String input) {
        validateDigitsOnly(input);
        return validateUnit(input);
    }

    private static void validateDigitsOnly(String input) {
        if (containsNonDigit(input)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 숫자여야 합니다.");
        }
    }

    private static int validateUnit(String input) {
        int amount = Integer.parseInt(input);
        if (isInvalidAmountUnit(amount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        return amount;
    }

    private static boolean containsNonDigit(String input) {
        return input.chars().anyMatch(c -> !Character.isDigit(c));
    }

    private static boolean isInvalidAmountUnit(int amount) {
        return amount % LOTTO_UNIT != ZERO_AMOUNT || amount == ZERO_AMOUNT;
    }

    private List<Integer> drawNumberList() {
        return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MINIMUM_NUMBER, Lotto.LOTTO_MAXIMUM_NUMBER,
                NUMBER_OF_DRAWS);
    }

    private int getLottoCount(int amount) {
        return amount / LOTTO_UNIT;
    }

}
