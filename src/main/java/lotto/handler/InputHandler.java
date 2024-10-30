package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private int inputMoney;

    public void setInputMoney() {
        inputMoney = Integer.parseInt(Console.readLine());
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public List<Integer> setInputLottoNumbers() {
        String inputString = Console.readLine();
        List<Integer> lottoWinnerNumbers = new ArrayList<>();
        String[] lottoNumbers = inputString.split(",");

        for (String number : lottoNumbers) {
            lottoWinnerNumbers.add(Integer.parseInt(number.trim()));
        }
        return lottoWinnerNumbers;
    }

}
