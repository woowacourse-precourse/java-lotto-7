package io;

/**
 * print를 담당하는 클래스
 */
public class Print {
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_PRINT_MESSAGE = "개를 구매했습니다.";
    public static final String NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String RESULT = """
            당첨 통계
            ---
            3개 일치 (%s원) - %d개
            4개 일치 (%s원) - %d개
            5개 일치 (%s원) - %d개
            5개 일치, 보너스 볼 일치 (%s원) - %d개
            6개 일치 (%s원) - %d개
            총 수익률은 %.1f%%입니다.""";

    String message;

    private Print(String message) {
        this.message = message;
    }

    public static void print(String message) {
        Print print = new Print(message);
        System.out.println(print.message);
    }

}
