package lotto.service;

import static lotto.domain.LottoInfo.PRICE_FOR_ONE;
import static lotto.utils.Utils.makeErrorMessage;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.Utils;
import lotto.validation.LottoValidator;

public class Parser {
    public static List<Integer> parseWinningNumbs(String inputWinningNumbs) {
        String[] winningNumbsStrs = inputWinningNumbs.split(",");
        for (String winningNumbsStr : winningNumbsStrs) {
            LottoValidator.validateEmptyString(winningNumbsStr);
        }
        LottoValidator.validateWinningNumbsSize(winningNumbsStrs);

        return  createWinningnumbs(winningNumbsStrs);
    }

    public static int parseBonusNum(String inputBonusNumber) {
        LottoValidator.validateEmptyString(inputBonusNumber);
        int bonusNumber = Utils.changeStringToNum(inputBonusNumber);

        LottoValidator.isLottoNumInRange(bonusNumber);

        return bonusNumber;
    }

    public static int parseMoney(String inputMoney) {
        LottoValidator.validateEmptyString(inputMoney);
        int money = Utils.changeStringToNum(inputMoney);
        if (money <= 0) {
            throw new IllegalArgumentException(makeErrorMessage("금액은 양수이어야 합니다."));
        }
        if (money % PRICE_FOR_ONE != 0) {
            throw new IllegalArgumentException(makeErrorMessage("1000단위로 입력해주세요."));
        }
        return money;
    }

    private static List<Integer> createWinningnumbs(String[] winningNumbsStrs) {
        List<Integer> winningNumbs = new ArrayList<>();
        for (String winningNumStr : winningNumbsStrs) {
            int winningNum = Utils.changeStringToNum(winningNumStr);
            LottoValidator.isLottoNumInRange(winningNum);
            winningNumbs.add(winningNum);
        }
        LottoValidator.hasDuplicates(winningNumbs);
        return winningNumbs;
    }
}
