package lotto.service;

import static lotto.parser.InputParser.parseInteger;

import lotto.model.BonusNumber;

public class BonusNumberService {
    public BonusNumber getBonusNumber(String inputBonusNumber) {
        return new BonusNumber(parseInteger(inputBonusNumber));
    }
}
