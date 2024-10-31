package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements Input {

    @Override
    public String inputUser() {
        return Console.readLine();
    }
}
