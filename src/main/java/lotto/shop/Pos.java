package lotto.shop;

import camp.nextstep.edu.missionutils.Console;
import lotto.MessageCenter;

public class Pos {

    Integer money;
    int divider = 1000;

    public Integer checkMoney() {
        while(money == null) {
            String textWon = read();
            validateNumber(textWon);
            money = parse(textWon);
        }
        return money;
    }

    public Integer checkCount(Integer money) {
        return money / divider;
    }

    private String read() {
        return Console.readLine();
    }

    private Integer parse(String textWon) {
        String trimmedWon = trim(textWon);
        return Integer.parseInt(trimmedWon);
    }

    private String trim(String text) {
        return text.trim();
    }

    void validateNumber(String textWon) {
        try{
        validateBlank(textWon);
        Integer parsedWon = parse(textWon);
        validatePositive(parsedWon);
        validateCount(parsedWon);
        } catch (IllegalArgumentException e) {
            throwException();
        }
    }

    void validatePositive(Integer parsedWon) {
        if (parsedWon <= 0) {
            throwException();
        }
    }

    private void validateBlank(String textWon) {
        if (textWon == null || textWon.isEmpty()) {
            throwException();
        }
    }

    void validateCount(Integer parsedWon) {
        if (parsedWon % divider != 0) {
            throwException();
        }
    }

    void throwException() {
        throw new IllegalArgumentException(MessageCenter.ERROR_MONEY.get());
    }

}
