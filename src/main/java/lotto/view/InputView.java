package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        String readLine = Console.readLine();
        if (readLine.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.");
        }
        return readLine;
    }
}
