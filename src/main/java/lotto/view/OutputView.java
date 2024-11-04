package lotto.view;

import lotto.dto.LottoResultDto;

import java.util.List;

public class OutputView {
    private static final String LINE_SEPARATOR = "\n";

    enum Description {
        ASK_PURCHASE_PRICE("구입금액을 입력해 주세요."),
        LOTTO_COUNT("개를 구매했습니다."),
        ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("\n당첨 통계\n---");
        private final String description;

        Description(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public void askPurchasePrice() {
        System.out.println(Description.ASK_PURCHASE_PRICE);
    }

    public void lottoCount(int lottoCount) {
        System.out.println(LINE_SEPARATOR + lottoCount + Description.LOTTO_COUNT);
    }

    public void lottoReceipt(String lottoReceipt) {
        System.out.println(lottoReceipt);
    }

    public void askWinningNumber() {
        System.out.println(Description.ASK_WINNING_NUMBER);
    }

    public void askBonusNumber() {
        System.out.println(LINE_SEPARATOR + Description.ASK_BONUS_NUMBER);
    }

    public void printResult(List<LottoResultDto> lottoResult, double returnResult) {
        System.out.println(Description.WINNING_STATISTICS);
        for (LottoResultDto result : lottoResult) {
            if (result.isBonusMatch()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", result.getMatchCount(), result.getMoney(), result.getWinnerCount());
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개\n", result.getMatchCount(), result.getMoney(), result.getWinnerCount());
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", returnResult);
    }
}
