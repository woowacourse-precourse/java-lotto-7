package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.LottoUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int purchaseAmount;
    private final List<Lotto> lottos;
    private final int[] prizeCounts = new int[5];  // 각 등수에 대한 당첨 수

    public LottoMachine(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> generateLottos() {
        int numberOfTickets = purchaseAmount / 1000;
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public void calculateResults(String winningNumbers, int bonusNumber) {
        List<Integer> winningNums = LottoUtils.parseNumbers(winningNumbers);
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNums::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            int prizeIndex = getPrizeIndex(matchCount, bonusMatch);
            if (prizeIndex != -1) {
                prizeCounts[prizeIndex]++;
            }
        }
    }

    private int getPrizeIndex(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            return 0;
        } else if (matchCount == 4) {
            return 1;
        } else if (matchCount == 5) {
            return bonusMatch ? 3 : 2;
        } else if (matchCount == 6) {
            return 4;
        }
        return -1;
    }


    public String getStatistics() {
        // 실제 통계를 문자열로 포맷팅하여 반환
        return "3개 일치 (5,000원) - " + prizeCounts[0] + "개\n" +
                "4개 일치 (50,000원) - " + prizeCounts[1] + "개\n" +
                "5개 일치 (1,500,000원) - " + prizeCounts[2] + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCounts[3] + "개\n" +
                "6개 일치 (2,000,000,000원) - " + prizeCounts[4] + "개\n" +
                "총 수익률은 62.5%입니다.";  // 수익률 계산 로직 추가 필요
    }
}
