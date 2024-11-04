package lotto.view.input;

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
        List<Integer> lottoNumbers = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            String inputLottoNumbers = readInput();
            String[] parsedString = parseInputToArray(inputLottoNumbers);
            try {
                lottoNumbers = parsedLottoNumbers(parsedString);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumbers;
    }

    private String[] parseInputToArray(String inputLottoNumbers) {
        String[] parsedString = inputLottoNumbers.split(INPUT_DELIMITER_COMMA);
        trimFirstElement(parsedString);
        return parsedString;
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
        lottoNum = lottoNum.trim();
        validator.validate(lottoNum);
        return Integer.parseInt(lottoNum);
    }


    public Integer getLottoBonusNumber() {
        String inputLottoBonusNumber = readInput();
        try {
            validator.validate(inputLottoBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoBonusNumber();
        }

        return Integer.parseInt(inputLottoBonusNumber);
    }

    private void trimFirstElement(String[] parsedString) {
        for (int i = 0; i < parsedString.length; i++) {
            parsedString[i] = parsedString[i].trim();
        }
    }

}
