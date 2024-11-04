package lotto.service;

import java.util.List;
import lotto.constant.LottoConfiguration;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.utility.CommonInputProcessor;

public class InputParsingService {

    public PurchasePrice parsePurchasePrice(String rawPurchasePrice) {
        rawPurchasePrice = CommonInputProcessor.removeSpace(rawPurchasePrice);
        int price = Integer.parseInt(rawPurchasePrice);
        return new PurchasePrice(price);
    }

    public Lotto parseWinningLotto(String rawWinningNumber) {
        rawWinningNumber = CommonInputProcessor.removeSpace(rawWinningNumber);
        List<String> separatedNumber = List.of(rawWinningNumber.split(LottoConfiguration.WINNING_NUMBER_DELIMITER));
        List<Integer> winningNumbers = separatedNumber.stream().map(Integer::parseInt).toList();
        return new Lotto(winningNumbers);
    }

    public BonusNumber parseBonusNumber(String rawBonusNumber, List<Integer> bannedNumbers) {
        rawBonusNumber = CommonInputProcessor.removeSpace(rawBonusNumber);
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        return new BonusNumber(bonusNumber, bannedNumbers);
    }
}
