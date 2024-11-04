package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String requestMessage;

    public InputView(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public void showRequestMessage() {
        System.out.printf(requestMessage);
    }

    public String getInput() {
        return Console.readLine();
    }
}
