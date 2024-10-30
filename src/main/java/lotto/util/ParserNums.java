package lotto.util;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserNums {

    public List<Integer> parsingWinningNums(String winningNumbers){
        List<Integer> winnigNums = new ArrayList<>();

        validate(winningNumbers);

        winnigNums.addAll(
                Arrays.stream(winningNumbers.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

        return winnigNums;
    }

    public void validate(String winnigNumbers){
        if(winnigNumbers.isEmpty()) throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        if(!winnigNumbers.matches("^(\\s*[0-9]+\\s*)(,\\s*[0-9]+\\s*)*$")) {throw new IllegalArgumentException(ErrorMessage.NOT_COMMA_PARSE.getMessage());}
    }
}
