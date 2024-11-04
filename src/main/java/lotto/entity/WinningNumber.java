package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.entity.WinningNumberValidator;

import java.util.ArrayList;
import java.util.List;

// 당첨 번호 엔티티 클래스
public class WinningNumber {
    private final Lotto value;
    private Validator validator;

    public WinningNumber(String inputValue) {
        initializeValidator(inputValue);
        validate();

        this.value = new Lotto(parseData(inputValue));
    }

    public Lotto getValue() {
        return value;
    }

    private void initializeValidator(String inputValue) {
        this.validator = new WinningNumberValidator(inputValue);
    }

    private void validate() {
        validator.validate();
    }

    private List<Integer> parseData(String inputValue) {
        List<Integer> lottoNumber = new ArrayList<>();

        for (String number : inputValue.split(",")) {
            lottoNumber.add(Integer.parseInt(number));
        }

        return lottoNumber;
    }
}
