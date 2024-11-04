package lotto;

import java.util.List;

public class OutputLottoResult {    // 로또 결과 출력
    public void printLottoInfo (int lottoCount, List<Lotto> purchasedLotto) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResults(int[] lottoResult, int totalPrize, int puchaseAmount) {
        System.out.println("당첨 내역 출력");
        printLottoResult("3개 일치 (5,000원)", lottoResult[4]);
        printLottoResult("4개 일치 (50,000원)", lottoResult[3]);
        printLottoResult("5개 일치 (1,500,000원)", lottoResult[2]);
        printLottoResult("5개 일치, 보너스 볼 일치 (30,000,000원)", lottoResult[1]);
        printLottoResult("6개 일치 (2,000,000,000원)", lottoResult[0]);
    }

    private void printLottoResult(String message, int count) {
        System.out.println(message + " - " + count + "개");
    }

    private double calculateRate(int totalPrize, int purchaseAmount) {
        return (double) totalPrize / purchaseAmount * 100;
    }
}
