package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class OutputView {

    // 로또 구입 수량 및 번호 출력
    public void printLottoNumbers(int purchaseCount, List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", purchaseCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 결과 출력
    public void printLottoResults(LottoResult lottoResult) {
        lottoResult.printResult(); // LottoResult의 printResult 메서드 호출
    }

    // 총 수익률 출력
    public void printTotalProfitRate(double totalProfitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }

    // 오류 메시지 출력
    public void displayError(String message) {
        System.out.println(message); // 오류 메시지를 출력
    }
}
