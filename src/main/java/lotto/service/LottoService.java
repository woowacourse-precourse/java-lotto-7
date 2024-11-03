package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;            // 한 장당 로또 가격
    private static final int LOTTO_NUMBER_COUNT = 6;        // 로또 번호 개수
    private static final int LOTTO_NUMBER_MIN = 1;          // 로또 번호 최소값
    private static final int LOTTO_NUMBER_MAX = 45;         // 로또 번호 최대값

    // 로또 구매 시 티켓 생성
    public List<Lotto> purchaseLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount); // 구입 금액 유효성 검사
        int ticketCount = purchaseAmount / LOTTO_PRICE; // 구매할 로또 티켓 수 계산
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            // 범위 내 고유한 숫자 6개를 선택하여 로또 생성
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
            purchasedLottos.add(new Lotto(lottoNumbers));
        }

        return purchasedLottos;
    }

    // 구입 금액이 유효한지 검사
    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 당첨 결과 계산
    public LottoResult calculateResult(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult(); // 당첨 결과 객체 생성
        int bonusNumber = winningNumbers.getBonusNumber(); // 보너스 번호 추출
        List<Integer> winningNumbersList = winningNumbers.getWinningNumbers(); // 당첨 번호 리스트 추출

        for (Lotto purchasedLotto : purchasedLottos) {
            int matchCount = (int) purchasedLotto.getNumbers().stream()
                    .filter(winningNumbersList::contains)
                    .count(); // 당첨 번호와 일치하는 개수 계산

            boolean isBonusMatched = purchasedLotto.getNumbers().contains(bonusNumber); // 보너스 번호 일치 여부 확인
            Rank rank = Rank.of(matchCount, isBonusMatched); // 매칭 결과에 따른 순위 계산
            lottoResult.incrementRankCount(rank); // 결과에 맞는 순위 카운트 증가
        }

        return lottoResult;
    }

    // 수익률 계산
    public double calculateProfitRate(int purchaseAmount, int totalPrize) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
        double profitRate = (double) totalPrize / purchaseAmount * 100; // 수익률 계산
        return Math.round(profitRate * 100) / 100.0;  // 소수점 둘째 자리까지 반올림하여 반환
    }
}
