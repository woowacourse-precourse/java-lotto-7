package lotto.view;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

public class LottoView {
    public void showPaymentRequestMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void showLottoAll(List<LottoDto> lottoDtoList) {
        lottoDtoList.forEach(this::showLotto);
    }

    private void showLotto(LottoDto lottoDto) {
        System.out.println("[" + lottoDto.toString() + "]");
    }

    public void showAnswerRequestMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showBonusNumberRequestMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(LottoResultDto result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            int count = result.getRankCounts().getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + " - " + count + "개");
        }
        System.out.println("총 수익률은 " + result.getReturnRate() + "%입니다.");
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }
}
