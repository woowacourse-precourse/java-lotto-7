package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class LottoNumberParser {

    public static final String REGEX_THAT_IGNORES_SPACES_BEFORE_AND_AFTER_COMMAS = "\\s*,\\s*";
    private static final int SPLIT_INCLUDE_EMPTY_STRINGS = -1;


    private final InputValidator inputValidator;


    public LottoNumberParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }


    public Lotto parse(String lottoNumbers) {
        String trimmedLottoNumbers = lottoNumbers.trim();
        inputValidator.checkIfEmpty(trimmedLottoNumbers);

        List<String> separatedLottoNumbers = Arrays.stream(
                        lottoNumbers.split(REGEX_THAT_IGNORES_SPACES_BEFORE_AND_AFTER_COMMAS, SPLIT_INCLUDE_EMPTY_STRINGS))
                .toList();

        inputValidator.validateOnlyDigit(separatedLottoNumbers);

        Lotto parsedLottoNumbers = parseInt(separatedLottoNumbers);

        inputValidator.checkValidRange(parsedLottoNumbers);

        return parsedLottoNumbers;

    }

    private Lotto parseInt(List<String> lottoNumbers) {
        try {
            List<Integer> lotto = lottoNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(lotto, inputValidator);
        } catch (NumberFormatException e) {
            throw new InputErrorException(ErrorType.NEED_INTEGER);
        }
    }


}
