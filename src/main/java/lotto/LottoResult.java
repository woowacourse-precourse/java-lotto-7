package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<Integer, Integer> prizeCount = new HashMap<>();

    //결과물 생성자 구현
    public LottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        checkPrizeCount();
        calculateResult();
    }

    //로또 당첨 금액 확인
    public void checkPrizeCount() {
        prizeCount.put(3, 0);
        prizeCount.put(4, 0);
        prizeCount.put(5, 0);
        prizeCount.put(6, 0);
        prizeCount.put(7, 0);
    }
    //당첨 결과 계산
    public void calculateResult() {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto);
            if (matchCount >= 3) {
                prizeCount.put(matchCount, prizeCount.get(matchCount) + 1);
            }else if(matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                prizeCount.put(7, prizeCount.get(7) + 1);
            }
        }
    }
    //구매한 로또 번호와 당첨번호 비교
    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    //결과 출력문
    public void printResult() {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeCount.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeCount.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeCount.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeCount.get(7));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeCount.get(6));
        // 수익률 계산 추가 가능
        double totalEarnings = calculateTotalEarnings();
        double investment = purchasedLottos.size() * 1000;
        double rateOfReturn = (totalEarnings / investment) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
    //수익률 계산 추가 기능
    public double calculateTotalEarnings() {
        return prizeCount.get(3) * 5000
                + prizeCount.get(4) * 50000
                + prizeCount.get(5) * 1500000
                + prizeCount.get(7) * 30000000
                + prizeCount.get(6) * 2000000000;
    }



}
