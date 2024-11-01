package lotto.custom.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.custom.validator.InputValidator;

public class WinningNumberService {
    private final InputValidator inputValidator;
    private static final String COMMA = ",";

    public WinningNumberService() {
        this.inputValidator = new InputValidator();
    }

    public List<Integer> run(String input) {
        inputValidator.validateWinningNumbersInput(input);
        String filteredComma = cleanConsecutiveCommas(input);
        List<Integer> winningNumbers = trimWinningNumbers(splitByComma(filteredComma));
        inputValidator.validateLottoNumbers(winningNumbers);
        return winningNumbers;
    }

    public String cleanConsecutiveCommas(String input) {
        return input.replaceAll(",+", COMMA).replaceAll("^" + COMMA + "|" + COMMA + "$", "");
    }

    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(COMMA)); // 쉼표로 분리한 후 리스트로 반환
    }

    public List<Integer> trimWinningNumbers(List<String> input) {
        return input.stream() // 리스트를 스트림으로 변환
                .map(String::trim) // 각 문자열에 trim() 적용
                .filter(s -> !s.isEmpty()) // 빈 문자열 제외
                .map(Integer::parseInt) // 문자열을 정수로 변환
                .collect(Collectors.toList()); // 리스트로 수집
    }
}