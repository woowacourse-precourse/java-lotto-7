package lotto.view;

public class OutputView {

    private static final String LOTTO_RESUlT_HEADER = "\n당첨 통계]\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoResultHeader() {
        System.out.println(LOTTO_RESUlT_HEADER);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
    }
}
