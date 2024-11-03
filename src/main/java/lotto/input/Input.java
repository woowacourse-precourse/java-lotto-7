package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = input();
        Validator.notEmpty(input);
        Validator.isNumber(input);
        return Parser.toInt(input); // 수정
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = input();
        Validator.notEmpty(input);
        String[] splitNumbers = split(input);
        Validator.isNumber(splitNumbers);
        return Parser.toInts(splitNumbers);
    }

    public int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = input();
        Validator.notEmpty(input);
        Validator.isNumber(input);
        return Parser.toInt(input);
    }

    private String input() {
        return Console.readLine();
    }

    private String[] split(String input) {
        return input.split(",");
    }

}
