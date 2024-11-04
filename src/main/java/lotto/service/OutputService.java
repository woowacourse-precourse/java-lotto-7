package lotto.service;

import java.util.HashMap;
import java.util.List;

public class OutputService {
    public static final String ENTER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_OF_LOTTOES_MESSAGE = "개를 구매했습니다.";
    public static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNINGSTATISTICS_MESSAGE = "당첨 통계\n---";
    public static final String MATCHINGNUM_3 = "3개 일치 (5,000원) - ";
    public static final String MATCHINGNUM_4 = "4개 일치 (50,000원) - ";
    public static final String MATCHINGNUM_5 = "5개 일치 (1,500,000원) - ";
    public static final String MATCHINGNUM_5_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String MATCHINGNUM_6 = "6개 일치 (2,000,000,000원) - ";

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

    public void printBonusNumberMessage() {
        System.out.println("\n" + ENTER_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage(HashMap<String, Integer> matchingNumbers) {
        System.out.println("\n" + WINNINGSTATISTICS_MESSAGE);
        System.out.println(MATCHINGNUM_3 + matchingNumbers.get("3"));
        System.out.println(MATCHINGNUM_4 + matchingNumbers.get("4"));
        System.out.println(MATCHINGNUM_5 + matchingNumbers.get("5"));
        System.out.println(MATCHINGNUM_5_BONUS + matchingNumbers.get("5,bonus"));
        System.out.println(MATCHINGNUM_6 + matchingNumbers.get("6"));
    }
}
