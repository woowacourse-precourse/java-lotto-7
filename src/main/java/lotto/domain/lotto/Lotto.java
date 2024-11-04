package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoValidateUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String numbers) {
        this.numbers = splitToIntegerList(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> splitToIntegerList(String numbers) {
        List<Integer> splitNumbers = new ArrayList<>();

        for (String number : numbers.split(",")) {
            String cleanNumber = cleanString(number);
            if (cleanNumber.isBlank()) {
                continue;
            }
            Integer parsedNumber = safeParseInteger(cleanNumber);
            LottoValidateUtil.validateNumberExists(splitNumbers, parsedNumber);
            splitNumbers.add(parsedNumber);
        }
        LottoValidateUtil.validateLottoNumbersCount(splitNumbers);
        LottoValidateUtil.validateNumberRange(splitNumbers);

        return splitNumbers;
    }

    //공백을 없애주는 로직
    private String cleanString(String text) {
        if (text == null || text.isBlank()) {
            text = "";
        }
        String cleanText = text.replace(" ", "");

        return cleanText;
    }

    private Integer safeParseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }
}
