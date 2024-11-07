package lotto.message;

public enum OutputMessage {
    OUTPUT_BUY_LOTTOS("%d개를 구매했습니다."),
    OUTPUT_WINNING_STATISTIC_GUIDE("당첨 통계"),
    OUTPUT_DIVIDER_LINE("---"),
    OUTPUT_WINNING_STATISTIC("%d개 일치 (%,d원) - %d개"),
    OUTPUT_WINNING_STATISTIC_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    OUTPUT_RETURN_RATE("총 수익률은 %.1f%%입니다.");
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(message);
    }

    public String getFormatReturnRateMessage(double returnRate){
        return String.format(message, returnRate);
    }

    public String getFormatBuyLottosMessage(int formatInteger){
        return String.format(message, formatInteger);
    }

    public String getFormatWinningStatisticMessage(int correctCount, long prize, int winningCount){
        return String.format(message, correctCount, prize, winningCount);
    }

}
