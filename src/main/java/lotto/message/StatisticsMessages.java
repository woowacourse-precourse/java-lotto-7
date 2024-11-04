package lotto.message;

public enum StatisticsMessages {
    STATISTICS_RESULT("""
            당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            총 수익률은 %.1f%%입니다.
            """),
    ;

    private String text;

    StatisticsMessages(String text) {
        this.text = text;
    }

    public String text(){
        return this.text;
    }
}
