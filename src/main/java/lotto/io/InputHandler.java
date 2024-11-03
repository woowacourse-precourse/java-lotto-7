package lotto.io;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public int getLottoPurchaseAmount() {
        String userInput = readLine();
        int purchaseAmount = parseStringToInt(userInput);
        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public Lotto getWinningNumbers() {
        String userInput = readLine();
        String[] splitedInput = splitInput(userInput);
        List<Integer> winningNumbers = convertToIntegerList(splitedInput);

        return new Lotto(winningNumbers);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
    }

    private String[] splitInput(String userInput) {
        return userInput.split(",");
    }

    private List<Integer> convertToIntegerList(String[] splitedInput) {
        return Arrays.stream(splitedInput)
                .map(this::parseStringToInt)
                .toList();
    }

    private int parseStringToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
