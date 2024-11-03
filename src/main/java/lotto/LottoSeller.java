package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoSeller {

    public void run() {
        int pay = readPay();
        System.out.println();
    }

    private int readPay() {
        String input;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Console.readLine();
                validatePay(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    private void validatePay(String input) throws IllegalArgumentException {
        int pay;
        try {
            pay = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자여야 합니다.");
        }
        if (pay < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 양수여야 합니다.");
        }
        if (pay % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원을 단위로 입력해야 합니다.");
        }
    }
}
