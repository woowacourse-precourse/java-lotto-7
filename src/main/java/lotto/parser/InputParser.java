package lotto.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static int parseLottoPrice(String lottoPrice) {
        return Integer.parseInt(lottoPrice);
    }

    public static List<String> parseLottoNumber(String lottoNumber) {
        return Arrays.asList(lottoNumber.split(","));
    }
}
