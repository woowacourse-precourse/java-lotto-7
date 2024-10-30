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

    public String[] setInputLottoNumbers() {
        String inputString = Console.readLine();

        String[] lottoNumbers = inputString.split(",");

        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = lottoNumbers[i].trim();
        }

        return lottoNumbers;
    }
}
