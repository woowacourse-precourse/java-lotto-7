package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String INPUT_PROMPT = "구입금액을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(INPUT_PROMPT);
        return Console.readLine();
    }
}
