package lotto.controller;

import lotto.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.UserInput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputController {
    private final UserInput userInput = new UserInput();

    public UserInputController() {
        PurchaseAmount.getPurchaseAmount
                (checkCanInteger(userInput.promptPurchaseAmountInput()));
        WinningLotto.getWinningLotto
                (checkWinningNumber(userInput.promptWinningNumberInput()),
                checkCanInteger(userInput.promptBonusNumberInput()));
    }

    private int checkCanInteger(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수값이 아닌 값이 들어왔습니다.");
        }
        return num;
    }

    private List<Integer> checkWinningNumber(String input){
        List<String> unCheckWinningNumbers = Arrays.stream(input.split(",")).toList();

        if(unCheckWinningNumbers.size() != Lotto.LOTTO_NUMBER_COUNT)
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 갯수는 6개이여야 합니다.");

        for(String winningNum : unCheckWinningNumbers){
            checkCanInteger(winningNum);
        }

        List<Integer> winningNumbers = Collections.unmodifiableList
                (Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        return winningNumbers;
    }


}
