package lotto.view.input;

public class InputBonusNumberView extends InputView{
    public Integer getValue() {
        System.out.println(INPUT_MESSAGE);
        String bonusNumber = inputValue();
        validate(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private void validate(String s) {
        //숫자인지 검증
    }
}
