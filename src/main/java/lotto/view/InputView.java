package lotto.view;

import lotto.model.Lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int readMoney() {
        String input = readLine();
        try {
            return convertInputToMoney(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorOfRequestMoney();
            return readMoney();
        }
    }

    private static int convertInputToMoney(String input) throws IllegalArgumentException {
        int money = Integer.parseInt(input);
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static Lotto readWinningNumbers() {
        String input = readLine();
        try {
            return convertInputToWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorOfRequestNumbers();
            return readWinningNumbers();
        }
    }

    private static Lotto convertInputToWinningNumbers(String input) throws IllegalArgumentException {
        String trimmedInput = input.replaceAll(" ", "");
        List<Integer> Numbers = new ArrayList<>();
        for (String rawNumber : trimmedInput.split(",")) {
            Numbers.add(Integer.parseInt(rawNumber));
        }
        return new Lotto(Numbers);
    }

    public static int readBonusNumber() {
        String input = readLine();
        try {
            return convertInputToNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorOfRequestNumber();
            return readBonusNumber();
        }
    }

    private static int convertInputToNumber(String input) throws IllegalArgumentException {
        return Integer.parseInt(input);
    }
}
