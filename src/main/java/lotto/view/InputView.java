package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        String readLine = Console.readLine();
        if (readLine.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
        }
        return readLine;
    }
}
