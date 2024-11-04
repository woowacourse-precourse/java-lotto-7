package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static lotto.common.LottoInfo.LOTTO_PRICE;

public class UserMoney {
    private int money;

    public UserMoney() {
        money = Integer.parseInt(inputUserMoney());
    }

    public int getMoney() {
        return money;
    }

    private String inputUserMoney() {
        String input;
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Console.readLine();
                isNumber(input);
                moneyValidate(Integer.parseInt(input));  // 001000 같은 것도 정상 처리되나?
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private void isNumber(String input) {
        if(!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    private void moneyValidate(int money) {
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액이 아닙니다.");
        }
    }
}
