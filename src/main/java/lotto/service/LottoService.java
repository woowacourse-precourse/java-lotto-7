package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    // 로또 구매 시 발행되는 로또 티켓 생성
    public List<Lotto> purchaseLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int ticketCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
            purchasedLottos.add(new Lotto(lottoNumbers));
        }

        return purchasedLottos;
    }

    // 구입 금액 유효성 검사
    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 당첨 결과 계산
    public LottoResult calculateResult(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        int bonusNumber = winningNumbers.getBonusNumber();
        List<Integer> winningNumbersList = winningNumbers.getWinningNumbers();

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = (int) purchasedLotto.getNumbers().stream()
                    .filter(winningNumbersList::contains)
                    .count();

            boolean isBonusMatched = purchasedLotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.of(matchCount, isBonusMatched);
            lottoResult.incrementRankCount(rank);
        }

        return lottoResult;
    }

    // 수익률 계산
    public double calculateProfitRate(int purchaseAmount, int totalPrize) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 100) / 100.0;  // 소수점 둘째 자리까지 반올림
    }

}
