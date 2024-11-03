package lotto.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Extractor;

public class WinningNumbersExtractor implements Extractor<List<Integer>> {

    private static final String NAME_DELIMITER = ",";
    private static final String NUMBER_REGULAR_EXPRESSION = "\\d+";

    private List<String> rawNumbers;

    @Override
    public List<Integer> extract(String input) {
        validateInput(input);
        List<Integer> extractedWinningNumbers = new ArrayList<>();

        for (String rawNumber : rawNumbers) {
            extractedWinningNumbers.add(Integer.parseInt(rawNumber));
        }
        return extractedWinningNumbers;
    }

    @Override
    public void validateInput(String input) {
        checkNull(input);
        checkBlank(input);
        splitString(input);
        checkNotNumber();
        checkDuplicateNumber();
    }

    private void checkNotNumber() {
        for (String rawNumber : rawNumbers) {
            if (!rawNumber.matches(NUMBER_REGULAR_EXPRESSION)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 가능합니다.");
            }
        }
    }

    private void checkDuplicateNumber() {
        long distinctCount = rawNumbers.stream().distinct().count();
        if (distinctCount < rawNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void splitString(String input) {
        this.rawNumbers = new ArrayList<>();
        Collections.addAll(rawNumbers, input.split(NAME_DELIMITER));
    }
}
