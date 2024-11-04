package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.validation.InputNumValidation;

public class Input {
    public static long inputNum() {
        String num;
        do {
            System.out.println("구매금액을 입력해 주세요.");
            num = Console.readLine();
        } while (!InputNumValidation.checkInputNum(num));
        return Long.parseLong(num);
    }
}