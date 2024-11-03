package lotto;

import java.util.*;


public class Application {
    public static void main(String[] args) {
        // 1 . 구매 금액 입력 및 로또 수량 계산
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = LottoInput.getValidPurchasePrice();

        LottoManager manager = new LottoManager(purchasePrice);

        // 3 . 로또 번호 출력
        LottoPrint.purchaseNumber(manager.getLottoRepository().size(), manager.getLottoRepository());

        // 4 . 당첨 & 보너스 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = LottoInput.getValidWinningNo();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = LottoInput.getValidBonus(winningNumber);

        // 5 . 당첨 통계 초기화
        Map<LottoRank, Integer> winningStatistics = LottoRankInit.getLottoRank();

        // 6 . 당첨&보너스 번호 통계 비교 작업
        LottoProcess.extracted(manager, winningNumber, bonusNumber, winningStatistics);

        // 7 . 통계 출력 및 수익률 계산 & 출력
        LottoPrint.getTotalPrize(winningStatistics);

        LottoPrint.extracted(purchasePrice);
    }

}
