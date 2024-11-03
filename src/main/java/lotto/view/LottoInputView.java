package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public int validateMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public int readMoney() {
        String input = Console.readLine();
        return validateMoney(input);
    }
}