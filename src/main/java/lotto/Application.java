package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        // 1 . 구매 금액 입력 및 로또 수량 계산
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = LottoInput.getValidPurchasePrice();
        int lottoQuantity = purchasePrice / 1000;

        // 2 . 로또 번호 생성 및 저장
        List<Lotto> lottoRepository = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto);
            lottoRepository.add(new Lotto(lotto));
        }

        // 3 . 로또 번호 출력
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoRepository) {
            System.out.println(lotto.getNumbers());
        }

        // 4 . 당첨 & 보너스 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = LottoInput.getValidWinningNo();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = LottoInput.getValidBonus(winningNumber);

        // 5 . 당첨 통계 초기화
        Map<LottoRank, Integer> winningStatistics = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            winningStatistics.put(rank, 0);
        }

        // 6 . 당첨&보너스 번호 통계 비교 작업
        for (Lotto lotto : lottoRepository) {
            List<Integer> intersection = new ArrayList<>(winningNumber);
            intersection.retainAll(lotto.getNumbers());
            int count = intersection.size();
            boolean bonus = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.getLottoRank(count, bonus);
            if (rank != null) {
                winningStatistics.put(rank, winningStatistics.get(rank) + 1);
            }
        }

        // 7 . 통계 출력 및 수익률 계산 & 출력
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            int count = winningStatistics.get(rank);
            System.out.printf(rank.getPrintFormat() + "\n", rank.getMatchCount(), rank.getPrize(), count);
            totalPrize += count * rank.getPrize();
        }

        double grossMargin = (double) totalPrize / purchasePrice * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", grossMargin);
    }

}
