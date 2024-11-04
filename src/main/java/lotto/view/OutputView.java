package lotto.view;

public class OutputView {
    private static String PRINT_FIFTH_PRIZE_MESSAGE = "3개 일치";
    private static String PRINT_FOURTH_PRIZE_MESSAGE = "4개 일치";
    private static String PRINT_THIRD_PRIZE_MESSAGE = "5개 일치";
    private static String PRINT_SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치";
    private static String PRINT_FIRST_PRIZE_MESSAGE = "6개 일치";
    private static String PRINT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static String DASH = "-";
    private static String COUNT = "개";

    public static void getDASH() {
        System.out.println(DASH);
    }

    public static void getCOUNT() {
        System.out.println(COUNT);
    }

    public static void getPrintLottoCountMessage(Integer money) {
        System.out.println(money + PRINT_LOTTO_COUNT_MESSAGE);
    }

    public static void getFifthPrizeMessage() {
        System.out.println(PRINT_FIFTH_PRIZE_MESSAGE);
    }

    public static void getFourthPrizeMessage() {
        System.out.println(PRINT_FOURTH_PRIZE_MESSAGE);
    }

    public static void getThirdPrizeMessage() {
        System.out.println(PRINT_THIRD_PRIZE_MESSAGE);
    }

    public static void getSecondPrizeMessage() {
        System.out.println(PRINT_SECOND_PRIZE_MESSAGE);
    }

    public static void getFirstPrizeMessage() {
        System.out.println(PRINT_FIRST_PRIZE_MESSAGE);
    }
}

