package util;

import validator.LottoValidator;

import java.util.List;

public class Parser {
    public static Integer parseCost(String cost) {
        LottoValidator.isNumber(cost);

        Integer parsedCost = Integer.parseInt(cost);

        LottoValidator.isDivisibleByThousand(parsedCost);

        return parsedCost;
    }

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        return LottoValidator.isParseableString(winningNumbers);
    }

    public static Integer parseBonusNumber(String bonusNumber) {
        LottoValidator.isNumber(bonusNumber);
        Integer parsedBonusNumber = Integer.parseInt(bonusNumber);
        LottoValidator.isInLottoRange(parsedBonusNumber);
        return parsedBonusNumber;
    }
}
