package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final String AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1000(원) 단위의 숫자입니다. 예: 14000";
    public static final String LOTTO_NUMBER_RANGE_ERROR_MSG = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자입니다.";
    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottoBunch = new ArrayList<>();

    public int parseAmount(String input) {
        int amount = 0;

        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }

        if (amount < 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }

        return amount;
    }

    public int parseLottoNumber(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MSG);
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MSG);
        }

        return number;
    }

    public void issue(int amount) {
        for (int i = 0; i < amount / LOTTO_PRICE; i++) {
            lottoBunch.add(Lotto.issue());
        }
    }

    public List<Lotto> getLottoBunch() {
        return lottoBunch;
    }

    public void printLottoBunch() {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoBunch.size());
        for (Lotto lotto : lottoBunch) {
            lotto.print();
        }
    }
}
