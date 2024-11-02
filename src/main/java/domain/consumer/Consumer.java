package domain.consumer;

import domain.error.InputErrorMessage;
import domain.lotto.Lotto;
import domain.lotto.LottoMachin;
import domain.lotto.LottoPrice;
import domain.rank.MatchCount;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Consumer {
    private List<Lotto> purchasedLottos;
    private Lotto selectWinnerLotto;
    private int bonusNumber;

    public int getQuantityPurchaseLottoBy(int money) {
        return money / LottoPrice.LOTTO_PRICE.getPrice();
    }

    public void receiveLottoTicket(List<Lotto> generatedLotto) {
        this.purchasedLottos = generatedLotto;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void selectWinnerNumbers(Lotto selectedWinnersNumbers) {
        this.selectWinnerLotto = selectedWinnersNumbers;
    }

    public void selectBonusNumber(int bonusNumber) {
        validateBonusNumberNotInWinningNumbers(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean selectedWinnerNumberIsEqualsTo(Lotto expectedLotto) {
        return selectWinnerLotto
                .getNumbers()
                .equals(expectedLotto.getNumbers());
    }

    public boolean selectedBonusNumberIsEqualsTo(int expectedBonusNumber) {
        return bonusNumber == expectedBonusNumber;
    }

    public Map<MatchCount, Integer> getCheckLottoResultBy(LottoMachin lottoMachin) {
        Map<MatchCount, Integer> resultMatchCount = initLottoResult();
        for (Lotto purchasedLotto : this.purchasedLottos) {
            int matchCount =
                    lottoMachin.getMatchedLottoCount(purchasedLotto, this.selectWinnerLotto, this.bonusNumber);
            if (isWithinValidRange(matchCount)) {
                MatchCount convertMatchCount = MatchCount.from(matchCount);
                resultMatchCount.put(convertMatchCount, resultMatchCount.getOrDefault(convertMatchCount, 0) + 1);
            }
        }
        return resultMatchCount;
    }

    private Map<MatchCount, Integer> initLottoResult() {
        Map<MatchCount, Integer> resultMatchCount = new LinkedHashMap<>();
        for (MatchCount matchCount :MatchCount.values()) {
            resultMatchCount.put(matchCount, 0);
        }
        return resultMatchCount;
    }

    private boolean isWithinValidRange(int matchCount) {
        return matchCount >= 3 && matchCount <= 7;
    }

    private void validateBonusNumberNotInWinningNumbers(int bonusNumber) {
        if (selectWinnerLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(InputErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_NUMBERS.getErrorMessage());
        }
    }
}
