package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.UserInput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputController {
    private final UserInput userInput = new UserInput();

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

        for(String winningNum : unCheckWinningNumbers){
            checkCanInteger(winningNum);
        }

        List<Integer> winningNumbers = Collections.unmodifiableList
                (Arrays.stream(input.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        return winningNumbers;
    }


    public void purchaseAmountInput(){
        PurchaseAmount.getPurchaseAmount
                (checkCanInteger(userInput.promptPurchaseAmountInput()));
    }

    public void winningLottoInput(){
        WinningLotto.getWinningLotto
                (checkWinningNumber(userInput.promptWinningNumberInput()),
                        checkCanInteger(userInput.promptBonusNumberInput()));
    }
}
