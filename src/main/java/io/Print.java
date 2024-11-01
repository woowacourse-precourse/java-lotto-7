package io;

import java.util.List;

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

    public static String getStatistic(List<Integer> rank, int lottoNumber) {
        int gainedMoney = 0;
        for (int i = 0; i < rank.size(); i++) {
            gainedMoney += rank.get(i) * lotto.Lotto.value.get(i);
        }
        float rate = (float) gainedMoney / lottoNumber / lotto.Lotto.Price.PRICE * 100;

        List<String> valueWithComma = lotto.Lotto.valueWithComma;
        return RESULT.formatted(valueWithComma.get(4), rank.get(4), valueWithComma.get(3), rank.get(3),
                valueWithComma.get(2), rank.get(2), valueWithComma.get(1), rank.get(1), valueWithComma.get(0),
                rank.get(0), rate);
    }
}
