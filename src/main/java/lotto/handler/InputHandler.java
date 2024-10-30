package lotto.handler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private int inputMoney;

    public void setInputMoney() {
        inputMoney = Integer.parseInt(Console.readLine());
    }

    public int getInputMoney() {
        return inputMoney;
    }
}
