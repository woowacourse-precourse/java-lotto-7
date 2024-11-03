package lotto.util;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoNumberParser {
    public static Lotto parseLotto(String command, String delimiter) {
        List<Integer> lottoNumbers = splitInteger(command, delimiter);
        return new Lotto(lottoNumbers);
    }

    private static List<Integer> splitInteger(String command, String delimiter) {
        String[] splitNumbers = command.split(delimiter);
        return Stream.of(splitNumbers)
                .map(String::trim)
                .map(LottoNumberParser::parseInteger)
                .sorted()
                .toList();
    }

    private static Integer parseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(ErrorMessages.INVALID_FORMAT);
        }
    }
}
