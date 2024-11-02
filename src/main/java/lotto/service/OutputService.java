package lotto.service;

public class OutputService {
    public static final String ENTER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_OF_LOTTOES_MESSAGE = "개를 구매했습니다.";

    public void printAmountMessage() {
        System.out.println(ENTER_AMOUNT_MESSAGE);
    }

    public void printNumberOfLottoesMessage(int numberOfLottoes) {
        System.out.println("\n" + numberOfLottoes + NUMBER_OF_LOTTOES_MESSAGE);
    }
}
