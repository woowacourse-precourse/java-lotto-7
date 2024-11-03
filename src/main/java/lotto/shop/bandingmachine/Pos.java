package lotto.shop.bandingmachine;

import camp.nextstep.edu.missionutils.Console;
import lotto.MessageCenter;

public class Pos {

    Integer money;

    public Integer getMoney() {
        while(money == null) {
            String textWon = read();
            validateNumber(textWon);
            money = parse(textWon);
        }
        return money;
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
        if (textWon == null || textWon.isBlank()) {
            throwException();
        }
    }

    void validateCount(Integer parsedWon) {

        int divider = 1000;

        if (parsedWon % divider != 0) {
            throwException();
        }
    }

    void throwException() {
        throw new IllegalArgumentException(MessageCenter.ERROR_MONEY.get());
    }

}
