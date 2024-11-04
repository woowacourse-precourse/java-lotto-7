package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;


import java.util.*;

import static lotto.service.ValidationService.validatePurchaseAmount;

public class LottoService {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    // 로또 구매 메서드
    public void purchaseLottos(int amount) {
        // 검증 클래스에서 금액 검증 수행
        validatePurchaseAmount(amount);

        for (int i = 0; i < amount / 1000; i++) {
            purchasedLottos.add(createNewLotto());
        }
    }

    // 새로운 로또 생성
    public Lotto createNewLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    // 구매한 로또 목록 반환
    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    // 당첨 결과 계산
    public LottoResult calculateResult(WinningLotto winningLotto) {
        // 등급별 로또 수를 저장할 맵 초기화
        Map<Rank, Integer> results = new HashMap<>();

        // 구매한 로또 번호 목록을 반복
        for (Lotto lotto : purchasedLottos) {
            // 현재 로또의 당첨 등급 계산
            Rank rank = calculateRank(lotto, winningLotto);

            // 해당 등급의 로또 수를 업데이트
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        // 계산된 결과를 LottoResult 객체로 반환
        return new LottoResult(results);
    }

    // 당첨 등급 계산
    private Rank calculateRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.countMatchingNumbers(winningLotto.getNumbers());
        boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());

        // 매칭된 숫자 수와 보너스 번호 매칭 여부를 로그로 출력
        //System.out.println("매칭된 숫자 수: " + matchCount + ", 보너스 매칭 여부: " + matchBonus);

        try {
            return Rank.valueOf(matchCount, matchBonus);
        } catch (IllegalArgumentException e) {
            // 예외가 발생했을 경우 로깅하고 NONE 랭크를 반환
            System.err.println("로또 번호에 매칭결과와 다른 예외적인 상황이 발생했습니다: " + e.getMessage());
            return Rank.NONE; // 기본값으로 NONE 랭크 반환
        }
    }
}
