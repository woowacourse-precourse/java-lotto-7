package lotto.processor;

import lotto.view.InputView;

import java.util.Enumeration;
import java.util.List;

public class WinNumbersProcessor extends Processor<List<Integer>>{
    private static final String ERROR = "[ERROR] ";
    private static final String NOT_SIX_LENGTH = ERROR + "로또 번호는 6개 입력해야 합니다.";
    private static final String IS_DUPLICATE = ERROR + "중복된 번호는 입력할 수 없습니다.";
    private static final String NOT_IN_RANGE = ERROR + "로또 번호는 1 ~ 45 사이여야 합니다.";
    @Override
    protected List<Integer> getInput() {
        return InputView.getLotto();
    }

    @Override
    protected void validate(List<Integer> input) {
        validateLength(input);
        validateDuplicate(input);
        validateInRange(input);
    }

    private void validateInRange(List<Integer> numbers){
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)){
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }
    private void validateLength(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException(NOT_SIX_LENGTH);
        }
    }
    private void validateDuplicate(List<Integer> numbers){
        if (numbers.stream().distinct().count() != 6){
            throw new IllegalArgumentException(IS_DUPLICATE);
        }
    }
}
