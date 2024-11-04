package view;

public enum ViewMessage {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
    OUTPUT_PURCHASE_LOTTO_AMOUNT("\n%d개를 구매했습니다.\n"),
    OUTPUT_WINNING_STATISTIC("\n당첨 통계\n---\n"),
    OUTPUT_FIFTH_STATISTIC("3개 일치 (5,000원) - %d개\n"),
    OUTPUT_FOURTH_STATISTIC("4개 일치 (50,000원) - %d개\n"),
    OUTPUT_THIRD_STATISTIC("5개 일치 (1,500,000원) - %d개\n"),
    OUTPUT_SECOND_STATISTIC("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    OUTPUT_FIRST_STATISTIC("6개 일치 (2,000,000,000원) - %d개\n"),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String msg;

    ViewMessage(String msg) {
        this.msg = msg;
    }

    public void print(Object... args) {
        System.out.printf(msg, args);
    }
}
