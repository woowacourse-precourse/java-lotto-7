package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoResult;

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
    public LottoResult calculateResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto, winningLotto);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            result.updateRank(matchCount, hasBonus);
        }

        return result;
    }

    // 두 로또 간 일치하는 번호 개수 계산
    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    // 수익률 계산
    public double calculateProfitRate(int purchaseAmount, int totalPrize) {
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 100) / 100.0;  // 소수점 둘째 자리까지 반올림
    }
}
