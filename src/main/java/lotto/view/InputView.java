package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BUDGET = "구입금액을 입력해 주세요.";

    public int readBudget(){
        System.out.println(INPUT_BUDGET);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
