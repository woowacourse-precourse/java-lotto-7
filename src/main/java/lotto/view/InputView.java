package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.enums.ExceptionMessage.NOT_INT;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int readMoney(){
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        validateInt(money);
        return Integer.parseInt(money);
    }

    public List<Integer> readWinningNumber(){
        System.out.println();
        System.out.println(INPUT_LOTTO_NUMBER);
        String input = Console.readLine();

        String[] winningNumberInput = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();

        for (String winningNum : winningNumberInput) {
            validateInt(winningNum);
            winningNumber.add(Integer.parseInt(winningNum));
        }
        return winningNumber;
    }

    public int readBonusNum() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);

        String bonusNum = Console.readLine();

        validateInt(bonusNum);

        return Integer.parseInt(bonusNum);
    }
    private void validateInt(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(NOT_INT.getMessage());
        }
    }

}
