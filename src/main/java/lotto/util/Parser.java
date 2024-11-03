package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoNumberFormatException;
import lotto.exception.PriceNumberFormatException;

public class Parser {

    private Parser() {
    }

    public static List<Integer> parseLottoNumber(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(","))
                .map(Parser::parseLottoNumberInteger)
                .toList();
    }

    public static Integer parseLottoNumberInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new LottoNumberFormatException();
        }
    }

    public static int parsePriceInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new PriceNumberFormatException();
        }
    }
}
