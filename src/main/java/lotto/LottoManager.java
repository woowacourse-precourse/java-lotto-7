package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.LottoPrizeRankType;
import lotto.util.WinningLottoStore;

public class LottoManager {


    protected LottoManager() {
    }

    public Lotto drawLottoTicket() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public LottoPrizeRankType getLottoResults(final Lotto userLottoTicket) {
        final int hitCount = countMatchingWithWinningLotto(userLottoTicket);
        final boolean isBonusMatched = userLottoTicket.isContain(
                WinningLottoStore.getBonusNumber());
        return LottoPrizeRankType.findByMatchCountAndBonusMatch(hitCount, isBonusMatched);
    }

    private int countMatchingWithWinningLotto(final Lotto userLottoTicket) {
        return WinningLottoStore.getWinningLotto().countMatchingNumbers(userLottoTicket);
    }

    public int convertToLottoNumber(final String inputNumber) {
        validateIsLottoNumber(inputNumber);
        final int convertedNum = Integer.parseInt(inputNumber);
        validateRange(convertedNum);
        return convertedNum;
    }

    private void validateIsLottoNumber(final String inputNumber) {
        if (!inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    private void validateRange(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 숫자를 입력하세요");
        }
    }
}
