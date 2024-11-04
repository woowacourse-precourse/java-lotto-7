package lotto.service;

import java.util.List;

public class OutputService {
    public static final String ENTER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_OF_LOTTOES_MESSAGE = "개를 구매했습니다.";
    public static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public void printAmountMessage() {
        System.out.println(ENTER_AMOUNT_MESSAGE);
    }

    public void printIssuedLottoesMessage(int numberOfLottoes, List<List<Integer>> issuedLottoNumbers) {
        System.out.println("\n" + numberOfLottoes + NUMBER_OF_LOTTOES_MESSAGE);

        for (List<Integer> lottoNumbers : issuedLottoNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public void printWinningNumberMessage() {
        System.out.println("\n" + ENTER_WINNING_NUMBER_MESSAGE);
    }
}
