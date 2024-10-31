package lotto.service;

import lotto.domain.Parser;

public class LottoService {
    public int parseStringToInt(String inputCost) {
        return Parser.parseStringToInt(inputCost);
    }
}
