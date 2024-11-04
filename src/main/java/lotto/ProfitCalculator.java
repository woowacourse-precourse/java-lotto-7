package lotto;

public class ProfitCalculator {

    private static final int LOTTO_TICKET_PRICE = 1000;

    public static double calculateProfitRate(int totalWinningPrice, int lottoCount) {
        int lottoTotalPrice = lottoCount * LOTTO_TICKET_PRICE;
        if (lottoTotalPrice == 0) {
            return 0;
        }
        return Math.round((double) totalWinningPrice / lottoTotalPrice * 100 * 10) / 10.0;
    }

}
