package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 당첨을 판별하는 클래스
public class ValidateWinnings {
    // 상수필드
    private final List<Integer> winningNumbers;     // 사용자가 입력한 당첨번호
    private final int bonusNumber;                  // 사용자가 입력한 보너스번호
    private final int purchaseNumber;
    private int totalProfit;                        // 총 수익금
    private double profitRate;                      // 수익률

    // 등수별 당첨 개수를 저장할 Map
    private final Map<Rank, Integer> prizeCount = new HashMap<>();

    // 생성자
    public ValidateWinnings(List<Integer> winningNumbers, int bonusNumber, int purchaseNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.purchaseNumber = purchaseNumber;

        // 각 등수를 초기화
        for (Rank rank : Rank.values()) {
            prizeCount.put(rank, 0);
        }
    }

    // 당첨인지 검증
    public void calculateResults(List<LottoIssuanceService> mylottoList) {
        for (int i = 0; i < mylottoList.size(); i++) {
            LottoIssuanceService myLotto = mylottoList.get(i); // ArrayList에서 로또 객체 하나씩 가져오기
            List<Integer> lottoNumbers = myLotto.getLottoNumbers(); // 해당 로또 객체의 번호 리스트

            int matchCount = 0; // 일치하는 숫자의 개수
            boolean bonusMatch = false; // 일치하는 보너스의 개수

            // 당첨 번호와 비교하여 일치 개수 확인
            for (Integer number : lottoNumbers) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }

            // 보너스 번호와 일치하는지 확인
            if (lottoNumbers.contains(bonusNumber)) {
                bonusMatch = true;
            }

            // 등수 판별 및 카운트 증가
            Rank rank = Rank.findRank(matchCount, bonusMatch);
            if (rank != Rank.BOMB) {    // BOMB은 당첨이 아니므로 제외
                prizeCount.put(rank, prizeCount.get(rank) + 1);
            }
        }
        printResult();

        // 수익률 계산 및 출력
        calculateProfitRate();
        printProfitRate(profitRate);
    }

    // 등수별 결과 출력 메소드
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개%n", Rank.FIFTH.getPrize(), prizeCount.get(Rank.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개%n", Rank.FOURTH.getPrize(), prizeCount.get(Rank.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개%n", Rank.THIRD.getPrize(), prizeCount.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", Rank.SECOND.getPrize(), prizeCount.get(Rank.SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개%n", Rank.FIRST.getPrize(), prizeCount.get(Rank.FIRST));
    }

    // 수익률 계산 메소드
    private double calculateProfitRate() {
        totalProfit = 0;

        // 각 등수별 상금 합산
        for (Rank rank : Rank.values()) {
            int count = prizeCount.getOrDefault(rank, 0);
            int prize = rank.getPrize();
            totalProfit += count * prize;
        }

        // 구매한 금액 계산
        int purchaseAmount = purchaseNumber * 1000; // 로또 한 장당 1,000원

        // 수익률 계산: (총 상금 금액 / 구매한 금액) * 100
        // 구매 금액이 0이 아닐 때에만 수익률 계산
        if (purchaseAmount > 0) {
            profitRate = ((double) totalProfit / purchaseAmount) * 100;
        } else {
            profitRate = 0.0; // 구매 금액이 0이라면 수익률은 0으로 설정
        }

        // 소수점 아래 둘째 자리에서 반올림
        profitRate = Math.round(profitRate * 100.0) / 100.0;

        return profitRate;
    }

    // 수익률 출력 메소드
    private void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);
    }
}