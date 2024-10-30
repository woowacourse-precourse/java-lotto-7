package lotto.impl;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.model.InputParser;

public class InputParserImpl implements InputParser {

    @Override
    public int parseMoney(String money) {
        int intinput;
        try {
            intinput = Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_INPUT.getMessage());
        }
        return intinput;
    }

    @Override
    public List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] inputLine = input.split(",");
            for (int i = 0; i < inputLine.length; i++) {
                numbers.add(Integer.parseInt(inputLine[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAM_INPUT.getMessage());
        }
        return numbers;
    }

    @Override
    public int parseBonus(String bonus) {
        int intBonus;
        try {
            intBonus = Integer.parseInt(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
        return intBonus;
    }

}