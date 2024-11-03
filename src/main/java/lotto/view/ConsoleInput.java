package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInput {
    public BigDecimal readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        if (!amount.matches("^[1-9]\\d*$")) {
            throw new NumberFormatException("[ERROR] 구입 금액은 양수이어야 합니다.");
        }
        return new BigDecimal(amount);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        String[] stringNumbers = s.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }

    public int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요");
        String s = Console.readLine();
        return Integer.parseInt(s);
    }
}
