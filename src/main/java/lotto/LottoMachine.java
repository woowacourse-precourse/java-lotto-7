package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import message.ErrorMessage;
import message.GameMessage;
import util.NumberValidate;

public class LottoMachine {

    static final String INPUT_SEPARATOR = ",";
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMachine() {
        this.winningNumbers = new ArrayList<>();
        bonusNumber = 0;
    }

    public void inputWinningNumbers() {
        String WinningNumbersinput;
        do {
            System.out.println(GameMessage.GET_WINNING_NUMBER_MESSAGE.getMessage());
            WinningNumbersinput = Console.readLine();
        } while (!validateWinningNumberInput(WinningNumbersinput));

        winningNumbers = Arrays.stream(WinningNumbersinput.split(INPUT_SEPARATOR, -1))
                .map(Integer::parseInt)
                .toList();
    }

    private boolean validateWinningNumberInput(String input) {
        Pattern pattern = Pattern.compile("[ ]*\\d+(?:[ ]*,[ ]*\\d+){5}");
        return pattern.matcher(input).matches();
    }

    public void inputBonusNumber() {
        String BonusNumberinput;
        do {
            System.out.println(GameMessage.GET_BONUS_NUMBER_MESSAGE.getMessage());
            BonusNumberinput = Console.readLine();
        } while (!validateBonusNumberInput(BonusNumberinput));

        bonusNumber = Integer.parseInt(BonusNumberinput);
    }

    private boolean validateBonusNumberInput(String inputBonusNumber) {
        if (!NumberValidate.isNumber(inputBonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_NUMBER.getMessage());
            return false;
        }
        if (!NumberValidate.isPositiveNumber(inputBonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
