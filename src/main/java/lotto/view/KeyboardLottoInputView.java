package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardLottoInputView implements InputView<String> {

    @Override
    public String input(String inputMessage) {
        System.out.println(inputMessage);
        return Console.readLine();
    }
}
