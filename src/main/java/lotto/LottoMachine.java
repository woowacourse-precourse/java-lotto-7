package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {

    public static int buy() {
        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());

                validateAmount(amount);
                return (amount / 1000);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자로만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0 || amount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }


}
