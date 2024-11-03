package lotto.custom.service;

import static lotto.custom.constants.RegexConstants.CONSECUTIVE_COMMAS_REGEX;
import static lotto.custom.constants.RegexConstants.EMPTY_STRING;
import static lotto.custom.constants.RegexConstants.LEADING_TRAILING_COMMA_REGEX;
import static lotto.custom.constants.RegexConstants.SINGLE_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.custom.validator.InputValidator;

public class LottoDrawingService {
    private final InputValidator inputValidator;

    public LottoDrawingService() {
        this.inputValidator = new InputValidator();
    }

    public List<Integer> drawWinningNumbers(String input) {
        inputValidator.validateWinningNumbersInput(input);
        String filteredComma = cleanConsecutiveCommas(input);
        List<Integer> winningNumbers = trimWinningNumbers(splitStringByComma(filteredComma));
        inputValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public int drawBonusNumber(List<Integer> winningNumbers, String bonusNumberInput) {
        inputValidator.validateBonusNumberInput(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput.trim());
        inputValidator.validateBonusNumbers(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    public String cleanConsecutiveCommas(String input) {
        return input.replaceAll(CONSECUTIVE_COMMAS_REGEX, SINGLE_COMMA)
                .replaceAll(LEADING_TRAILING_COMMA_REGEX, EMPTY_STRING);
    }

    public List<String> splitStringByComma(String input) {
        return Arrays.asList(input.split(SINGLE_COMMA)); // 쉼표로 분리한 후 리스트로 반환
    }

    public List<Integer> trimWinningNumbers(List<String> input) {
        return input.stream() // 리스트를 스트림으로 변환
                .map(String::trim) // 각 문자열에 trim() 적용
                .filter(s -> !s.isEmpty()) // 빈 문자열 제외
                .map(Integer::parseInt) // 문자열을 정수로 변환
                .collect(Collectors.toList()); // 리스트로 수집
    }
}