package lotto.shop.bandingmachine;

import camp.nextstep.edu.missionutils.Console;
import lotto.MessageCenter;

public class Pos {

    Integer won;

    public Integer getMoney() {
        while(won == null) {
            String textWon = read();
            validateBlank(textWon);
            won = parse(textWon);
        }
        return won;
    }

    public Integer getCount(Integer wonInput) {

    }


    private String read() {
        return Console.readLine();
    }

    private Integer parse(String text) {
        String trimmedText = trim(text);
        won = validateNumber(trimmedText);
        return won;
    }

    private String trim(String text) {
        return text.trim();
    }

    Integer validateNumber(String trimmedText) {
        try {
            won = Integer.parseInt(trimmedText);
            validatePositive(won);
        } catch (IllegalArgumentException e) {
            throwException();
        }
        return won;
    }

    void validatePositive(Integer parsedNumber) {
        if (parsedNumber <= 0) {
            throwException();
        }
    }

    private void validateBlank(String textWon) {
        if (textWon == null || textWon.isBlank()) {
            throwException();
        }
    }

    void throwException() {
        throw new IllegalArgumentException(MessageCenter.ERROR_MONEY.get());
    }

}
