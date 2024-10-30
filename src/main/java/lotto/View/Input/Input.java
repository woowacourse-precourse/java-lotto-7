package lotto.View.Input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int InputPaymoney() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            int Paymoney = Integer.parseInt(Console.readLine());
            return MoneyValuation(Paymoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return InputPaymoney();
        }
    }

    public int MoneyValuation(int Paymoney) {
        if (Paymoney % 1000 == 0) {
            return Paymoney;
        } throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해주세요.");
    }

}
