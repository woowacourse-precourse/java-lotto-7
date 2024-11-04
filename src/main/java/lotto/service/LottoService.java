package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.service.ValidationService.validatePurchaseAmount;

public class LottoService {

    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public void purchaseLottos(int amount){
        // 검증 클래스에서 금액 검증 수행
        validatePurchaseAmount(amount);

        for (int i = 0; i < amount / 1000; i++) {
            purchasedLottos.add(createNewLotto());
        }
    }

    public Lotto createNewLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    public List<Lotto> getPurchasedLottos(){
        return purchasedLottos;
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        // 등급별 로또 수를 저장할 맵 초기화
        Map<Rank, Integer> results = new HashMap<>();

        // 구매한 로또 번호 목록을 반복
        for (Lotto lotto : purchasedLottos) {
            // 현재 로또의 당첨 등급 계산
            Rank rank = calculateRank(lotto, winningLotto);

            // 해당 등급의 로또 수를 업데이트
            // rank가 이미 results에 존재하면 해당 등급의 수를 1 증가시키고,
            // 존재하지 않으면 새로 1로 초기화
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        // 계산된 결과를 LottoResult 객체로 반환
        return new LottoResult(results);
    }
    private Rank calculateRank(Lotto lotto,WinningLotto winningLotto){
        int matchCount = lotto.countMatchingNumbers(winningLotto.getNumbers());
        boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());

        return Rank.valueOf(matchCount,matchBonus);

    }


}
