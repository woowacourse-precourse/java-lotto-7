package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public int setInputMoney() {
        int inputMoney;
        return inputMoney = Integer.parseInt(Console.readLine());
    }

    public List<Integer> setInputLottoNumbers() {
        String inputString = Console.readLine();
        List<Integer> lottoWinnerNumbers = new ArrayList<>();
        String[] lottoNumbers = inputString.split(",");

        for (String number : lottoNumbers) {
            lottoWinnerNumbers.add(Integer.parseInt(number));
        }
        return lottoWinnerNumbers;
    }

    public int setBonusNumber() {
        int bonusNumber;
        return bonusNumber = Integer.parseInt(Console.readLine());
    }

}
