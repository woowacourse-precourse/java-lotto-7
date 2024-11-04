package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameValidator {

    public void validateAmount(int amount, int LOTTO_PRICE) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    public int readAmount(int LOTTO_PRICE) {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount, LOTTO_PRICE);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
