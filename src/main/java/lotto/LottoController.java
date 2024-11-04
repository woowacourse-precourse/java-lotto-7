package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class LottoController {
    public void run() {
        // 로또 구입 금액 입력 받기
        int inputCash = LottoView.getInputCash();

        // 1000 단위, 숫자 여부 검증 필요
        int lottoCount = inputCash / 1000;

        // 로또 생성 과정
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        // 발행한 로또 수량 및 번호 출력
        LottoView.printLottos(lottoCount, lottos);

        // 당첨 번호 입력 받기
        List<Integer> winningNumbers = LottoView.getWinningNumbers();

        // 보너스 번호 입력 받기
        Integer bonusNumber = LottoView.getBonusNumber();

        // 당첨 여부 확인
        Set<Integer> set1 = new HashSet<>(winningNumbers);

        // 등수 계산
        Map<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);
        int totalPrize = 0;

        // 각 등수의 개수를 0으로 초기화
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Set<Integer> set2 = new HashSet<>(lotto.getNumbers());
            boolean isBonusMatched = set2.contains(bonusNumber);
            set1.retainAll(set2);

            if (set1.size() == 6) {
                rankCount.put(LottoRank.FIRST, rankCount.get(LottoRank.FIRST) + 1);
                totalPrize += LottoRank.FIRST.getPrize();
            } else if (set1.size() == 5 && isBonusMatched) {
                rankCount.put(LottoRank.SECOND, rankCount.get(LottoRank.SECOND) + 1);
                totalPrize += LottoRank.SECOND.getPrize();
            } else if (set1.size() == 5) {
                rankCount.put(LottoRank.THIRD, rankCount.get(LottoRank.THIRD) + 1);
                totalPrize += LottoRank.THIRD.getPrize();
            } else if (set1.size() == 4) {
                rankCount.put(LottoRank.FOURTH, rankCount.get(LottoRank.FOURTH) + 1);
                totalPrize += LottoRank.FOURTH.getPrize();
            } else if (set1.size() == 3) {
                rankCount.put(LottoRank.FIFTH, rankCount.get(LottoRank.FIFTH) + 1);
                totalPrize += LottoRank.FIFTH.getPrize();
            }
            set1.addAll(winningNumbers);
        }

        // 당첨 내역 출력
        LottoView.printLottoResult(rankCount);

        // 수익률 계산 및 출력
        LottoView.printReturnRate(totalPrize, inputCash);
    }
}
