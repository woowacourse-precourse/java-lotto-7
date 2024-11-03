package lotto.util;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.DelimiterPattern.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserNums {

    public List<Integer> parsingWinningNums(String winningNumbers){
        List<Integer> winningNums = new ArrayList<>();

        validate(winningNumbers);

        winningNums.addAll(
                Arrays.stream(winningNumbers.split(COMMA.getPattern()))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

        return winningNums;
    }

    private void validate(String winningNumbers){
        if(winningNumbers.isEmpty()) throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        if(!winningNumbers.matches(COMMA_SEPARATED_NUMERIC_LIST_REGEX.getPattern())) {throw new IllegalArgumentException(NOT_COMMA_PARSE.getMessage());}
    }
}
