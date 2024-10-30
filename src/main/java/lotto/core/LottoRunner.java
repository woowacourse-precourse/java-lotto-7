package lotto.core;

import camp.nextstep.edu.missionutils.Console;

public class LottoRunner {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final int MINIMUM_UNIT = 1000;

    private int payment;

    public void executeDraw() {
        int purchaseAmount = this.getPurchaseAmount();
    }


    /**
     * 로또 구매 수량
     */
    private int getPurchaseAmount() {
        while (true) {
            try {
                payment = Integer.parseInt(this.inputPayment());
                this.validatePayment(payment);
                return this.calculatePurchaseAmount(payment);
            } catch (NumberFormatException e) {
                System.out.println(ERROR_PREFIX + "숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    private String inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int calculatePurchaseAmount(int payment) {
        int amount = payment / MINIMUM_UNIT;
        System.out.printf("%d개를 구매했습니다.\n", amount);
        return amount;
    }

    private void validatePayment(int payment) {
        if (payment % MINIMUM_UNIT > 0) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
