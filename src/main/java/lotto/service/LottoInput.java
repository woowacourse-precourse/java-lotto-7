package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.staticenum.ErrorStatic.*;
import static lotto.staticenum.LottoStatic.LOTTO_PRICE;

public class LottoInput {

    List<Integer> winningNumbers;

    public int inputMoneyLoop() {
        while (true) {
            try {
                return inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbersLoop() {
        while (true) {
            try {
                return inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumberLoop() {
        while (true) {
            try {
                return inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputMoney() {
        System.out.println("구입금액을 입력해주세요");
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_MONEY_TYPE_ERROR);
        }
        if (money < 0) {
            throw new IllegalArgumentException(MINUS_MONEY_ERROR);
        }
        if ((money % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(MONEY_ERROR);
        }
        return money;
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
        String[] split = Console.readLine().split(",");
        if (split.length != 6) throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        winningNumbers = new ArrayList<>(6);
        for (String number : split) {
            winningNumbers.add(numberParse(number));
        }
        return winningNumbers;
    }

    private int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        String bonusNumber = Console.readLine();
        int bonus = numberParse(bonusNumber);
        if (winningNumbers.contains(bonus)) throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        return bonus;
    }

    public int numberParse(String number) {
        int parseNumber;
        try {
            parseNumber = Integer.parseInt(number);
            if (parseNumber < 1 || parseNumber > 45)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_TYPE_ERROR);
        }
        return parseNumber;
    }


}
