package lotto.view;

import lotto.utils.validator.InputValidator;
import lotto.utils.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class ManagerInputView extends InputView {
    private static final String INPUT_DELIMITER_COMMA = ",";


    public Validator<String> validator;

    public ManagerInputView() {
        this.validator = new InputValidator();
    }

    public List<Integer> getLottoNumbers() {
        String inputLottoNumbers = readInput();
        String[] parsedString = inputLottoNumbers.split(INPUT_DELIMITER_COMMA);

        trimFirstElement(parsedString);

        return parsedLottoNumbers(parsedString);
    }

    private List<Integer> parsedLottoNumbers(String[] parsedString) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNum : parsedString) {
            Integer validatedNumber = convertLottoNum(lottoNum);
            lottoNumbers.add(validatedNumber);
        }
        return lottoNumbers;
    }

    private Integer convertLottoNum(String lottoNum) {

        if (!lottoNum.isEmpty() && Character.isWhitespace(lottoNum.charAt(lottoNum.length() - 1))) {
        throw new IllegalArgumentException("뒤쪽의 공백은 허용되지 않습니다.");
    }
        lottoNum = lottoNum.trim();
        validator.validate(lottoNum);
        return Integer.parseInt(lottoNum);
    }

    public Integer getLottoBonusNumber() {
        String inputLottoBonusNumber = readInput();
        validator.validate(inputLottoBonusNumber);

        return Integer.parseInt(inputLottoBonusNumber);
    }

    private void trimFirstElement(String[] parsedString) {
        for (int i = 0; i < parsedString.length; i++) {
            parsedString[i] = parsedString[i].trim();
        }
    }

}
