package lotto.processor;

import lotto.view.InputView;

import java.util.List;

public class BonusProcessor extends ParameterProcessor<Integer, List<Integer>>{
    private static final String ERROR = "[ERROR] ";
    private static final String BONUS_DUPLICATE = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String NOT_IN_RANGE = ERROR + "로또 번호는 1 ~ 45 사이여야 합니다.";
    public BonusProcessor(List<Integer> parameter) {
        super(parameter);
    }

    @Override
    protected Integer getInput() {
        return InputView.getBonusNumber();
    }

    @Override
    protected void validate(Integer input) {
        validateBonusDuplicate(input);
        validateInRange(input);
    }

    private void validateInRange(Integer input){
        if (input < 1 || input > 45){
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }
    private void validateBonusDuplicate(Integer input){
        if (parameter.contains(input)){
            throw new IllegalArgumentException(BONUS_DUPLICATE);
        }
    }


}
