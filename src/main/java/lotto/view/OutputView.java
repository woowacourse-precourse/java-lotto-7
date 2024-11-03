package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public void printPaymentRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningNumbersRequestMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberRequestMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    // TODO: 출력 메시지 정리 & 에러 메시지 정리
    public void printLottoDetails(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.represent());
        }
    }

    public void printWinningResults(List<Integer> results, String rate) {
        List<String> lines = Arrays.asList(
            String.format("3개 일치 (5,000원) - %d개", results.get(Rank.FIFTH.getIndex())),
            String.format("4개 일치 (50,000원) - %d개", results.get(Rank.FOURTH.getIndex())),
            String.format("5개 일치 (1,500,000원) - %d개", results.get(Rank.THIRD.getIndex())),
            String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", results.get(Rank.SECOND.getIndex())),
            String.format("6개 일치 (2,000,000,000원) - %d개", results.get(Rank.FIRST.getIndex())),
            String.format("총 수익률은 %s%%입니다.", rate)
        );

        System.out.println("당첨 통계");
        System.out.println("---");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
