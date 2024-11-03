package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.message.Messages.*;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getInput() {
        while (true) {
            try {
                return getPriceInput();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private int getPriceInput() {
        System.out.println(INPUT_PRICE);
        String str = Console.readLine();
        return inputValidator.validatePrice(str);
    }

    public List<Integer> getWinningNumbers() {
        while(true){
            try{
                List<String> winningNumbers = readWinningNumbers();
                return inputValidator.validateWinningNumbers(winningNumbers);
            }catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private List<String> readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        String input = Console.readLine();
        return Arrays.stream(input.split(",")).collect(Collectors.toList());

    }

    public int getBonusNumber() {
        while(true){
            try{
                String bonus = readBonusNumber();
                return inputValidator.validateBonusNumber(bonus);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

    }

    private String readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}


