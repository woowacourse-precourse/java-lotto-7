package lotto.constant;

import static global.utils.GlobalUtil.Prize.applyPrizeFormat;

public enum LottoInfoMsg {
    INPUT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    INPUT_WEEKLY_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    START_PRINT_LOTTO_NUMBERS("\n%d개를 구매했습니다."),
    START_PRINT_MATCHED_RESULT("\n당첨 통계\n---\n"),
    MATCHED_RESULT_PRINT_FORM("%d개 일치 (%s원) - %d개"),
    MATCHED_RESULT_SECOND_RANK_PRINT_FORM("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PROFIT_RATE_PRINT_FORM("총 수익률은 %.1f%%입니다.");

    private final String msg;

    LottoInfoMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static String getMatchedResultMsgByForm(LottoRank rank, int count) {
        if (rank == LottoRank.SECOND_RANK) {
            return MATCHED_RESULT_SECOND_RANK_PRINT_FORM.getMsg()
                    .formatted(rank.getCorrectCount(), applyPrizeFormat(rank.getPrize()), count) + "\n";
        }

        return MATCHED_RESULT_PRINT_FORM.getMsg()
                .formatted(rank.getCorrectCount(), applyPrizeFormat(rank.getPrize()), count) + "\n";
    }
}
