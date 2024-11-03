package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class LottoNumberParser {

    public static final String WHITE_SPACE_REGEX = "\\s";
    public static final String EMPTY_STRING = "";

    public static final String REGEX_THAT_IGNORES_SPACES_BEFORE_AND_AFTER_COMMAS = "\\s*,\\s*";
    private static final int SPLIT_INCLUDE_EMPTY_STRINGS = -1;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;


    public LottoNumberParser() {
    }

    public Lotto parse(String lottoNumbers) {
        String trimmedLottoNumbers = lottoNumbers.trim();
        checkIfEmpty(trimmedLottoNumbers);

        List<String> separatedLottoNumbers = Arrays.stream(
                        lottoNumbers.split(REGEX_THAT_IGNORES_SPACES_BEFORE_AND_AFTER_COMMAS, SPLIT_INCLUDE_EMPTY_STRINGS))
                .toList();

        validateOnlyDigit(separatedLottoNumbers);

        Lotto parsedLottoNumbers = parseInt(separatedLottoNumbers);

        checkValidRange(parsedLottoNumbers);

        return parsedLottoNumbers;

    }

    private static void checkValidRange(Lotto parsedLottoNumbers) {
        parsedLottoNumbers.getLottoNumbers().forEach(lottoNumber -> {
            if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
        });
    }


    private void validateOnlyDigit(List<String> lottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> {
            checkIfEmpty(lottoNumber);
            checkIfDigit(lottoNumber);
        });
    }

    private void checkIfEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (input.replaceAll(WHITE_SPACE_REGEX, EMPTY_STRING).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIfDigit(String lottoNumber) {
        for (int i = 0; i < lottoNumber.length(); i++) {
            if (!Character.isDigit(lottoNumber.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private Lotto parseInt(List<String> lottoNumbers) {
        try {
            List<Integer> lotto = lottoNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(lotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
