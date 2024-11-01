package lotto.utils.validator;

public class WinningNumbersValidator implements Validator<String> {
    private final String DELIMITER = ",";
    private final Validator<String> positiveIntValidator;
    private final Validator<Integer> lottoNumberValidator;

    public WinningNumbersValidator(
            Validator<String> positiveIntValidator,
            Validator<Integer> lottoNumberValidator) {

        this.positiveIntValidator = positiveIntValidator;
        this.lottoNumberValidator = lottoNumberValidator;
    }

    @Override
    public void validate(String rawWinningNumbers) {
        validateNotEmpty(rawWinningNumbers);
        String[] rawWinningNumberList = rawWinningNumbers.split(DELIMITER);

        validateLottoFormat(rawWinningNumberList);
    }

    private void validateNotEmpty(String rawWinningNumbers) {
        if (rawWinningNumbers.isBlank()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }

    private void validateLottoFormat(String[] rawWinningNumberList) {
        for (String rawWinningNumber : rawWinningNumberList) {
            validateEachRawWinningNumber(rawWinningNumber);
        }

        if (rawWinningNumberList.length != 6) {
            throw new IllegalArgumentException("로또 번호는 총 여섯 개여야 합니다.");
        }
    }

    private void validateEachRawWinningNumber(String rawWinningNumber) {
        positiveIntValidator.validate(rawWinningNumber);

        int lottoNumber = Integer.parseInt(rawWinningNumber);
        lottoNumberValidator.validate(lottoNumber);
    }
}
