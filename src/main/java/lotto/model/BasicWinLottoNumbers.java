package lotto.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BasicWinLottoNumbers {
    
    private static final String NUMBER_IN_RANGE = "([1-9]|[1-3][0-9]|4[0-5])";
    
    private static final String REGEX_FORMAT = "^(" + NUMBER_IN_RANGE + ",){5}" + NUMBER_IN_RANGE + "$";
    
    private static final Pattern PATTERN = Pattern.compile(REGEX_FORMAT);
    
    private final Set<Integer> numbers;
    
    public BasicWinLottoNumbers(String numbersToValidate) {
        validateFormat(numbersToValidate);
        String[] numbers = numbersToValidate.split(",");
        this.numbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());
    }
    
    private void validateFormat(String numbersToValidate) {
        Matcher matcher = PATTERN.matcher(numbersToValidate);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
    
    public boolean contains(int number) {
        return numbers.contains(number);
    }
    
    public Set<Integer> get() {
        return numbers;
    }
    
}
