package lotto.view;

import static lotto.domain.PrizeCount.getPrizeCount;

public class OutputView {
    private static String PRINT_THIRD_PRIZE_MESSAGE = "3개 일치 (5,000원) ";
    private static String PRINT_FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) ";
    private static String PRINT_FIFTH_PRIZE_MESSAGE = "5개 일치 (1,500,000원) ";
    private static String PRINT_FIFTH_BONUS_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) ";
    private static String PRINT_SIXTH_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) ";
    private static String PRINT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다. ";
    private static String DASH = "- ";
    private static String COUNTMEESSAGE = "개";
    private static String PRINT_TOTAL_INVESTMENT = "총 수익률은 ";
    private static String PROFIT_RATE = "%.2f%% 입니다.";

    public static void getPrintTotalInvestment(double profit){
        String totalInvestmentMessage = PRINT_TOTAL_INVESTMENT + String.format(PROFIT_RATE, profit);
        System.out.println(totalInvestmentMessage);
    }


    public static void getPrintLottoCountMessage(Integer money) {
        System.out.println(money + PRINT_LOTTO_COUNT_MESSAGE);
    }

    public static void getPrintFifthPrizeMessage(Integer count) {
        System.out.println(PRINT_FIFTH_PRIZE_MESSAGE + DASH + count + COUNTMEESSAGE);
    }

    public static void getPrintFourthPrizeMessage(Integer count) {
        System.out.println(PRINT_FOURTH_PRIZE_MESSAGE+ DASH + count + COUNTMEESSAGE);
    }

    public static void getPrintThirdPrizeMessage(Integer count) {
        System.out.println(PRINT_THIRD_PRIZE_MESSAGE+ DASH + count + COUNTMEESSAGE);
    }

    public static void getPrintFifthBonusPrizeMessage(Integer count) {
        System.out.println(PRINT_FIFTH_BONUS_PRIZE_MESSAGE+ DASH + count + COUNTMEESSAGE);
    }

    public static void getPrintSixthPrizeMessage(Integer count) {
        System.out.println(PRINT_SIXTH_PRIZE_MESSAGE+ DASH + count + COUNTMEESSAGE);
    }

    public static void printPrizeMessage(){
        getPrintThirdPrizeMessage(getPrizeCount().getOrDefault(3,0));
        getPrintFourthPrizeMessage(getPrizeCount().getOrDefault(4,0));
        getPrintFifthPrizeMessage(getPrizeCount().getOrDefault(5,0));
        getPrintFifthBonusPrizeMessage(getPrizeCount().getOrDefault(7,0));
        getPrintSixthPrizeMessage(getPrizeCount().getOrDefault(6,0));
    }

    public static String getPrintLottoCountMessage() {
        return PRINT_LOTTO_COUNT_MESSAGE;
    }



}

