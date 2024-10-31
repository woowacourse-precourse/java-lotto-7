package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static final String INPUT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    public static final String INPUT_AGAIN = "다시 입력해 주세요.";
    public static final String PURCHASED_TICKETS = "개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String COUNT = "개";

    public static final String MATCH_3_PRIZE = "3개 일치 (5,000원) - ";
    public static final String MATCH_4_PRIZE = "4개 일치 (50,000원) - ";
    public static final String MATCH_5_PRIZE = "5개 일치 (1,500,000원) - ";
    public static final String MATCH_5_BONUS_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String MATCH_6_PRIZE = "6개 일치 (2,000,000,000원) - ";
    public static final String TOTAL_PROFIT_RATE = "총 수익률은 %.1f%%입니다.%n";

    public static void printInputMoneyPrompt(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }
    public void printInputAgainPrompt(){
        System.out.println(INPUT_AGAIN);
    }
    public static void printPurchasedTicketCount(int amount){
        System.out.println(amount + PURCHASED_TICKETS);
    }
    public void printInputWinningNumbersPrompt(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }
    public void printInputBonusNumberPrompt(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
    public static void printPurchasedLottoNumbers(ArrayList<List<Integer>> purchasedLottoNumbers){
        for (List<Integer> purchasedLottoNumber : purchasedLottoNumbers) {
            System.out.println(purchasedLottoNumber);
        }
    }
    public static void printLottoResults(int[] rank, double totalRate){
        System.out.println(MATCH_3_PRIZE + rank[0] + COUNT);
        System.out.println(MATCH_4_PRIZE + rank[1] + COUNT);
        System.out.println(MATCH_5_PRIZE + rank[2] + COUNT);
        System.out.println(MATCH_5_BONUS_PRIZE + rank[3] + COUNT);
        System.out.println(MATCH_6_PRIZE + rank[4] + COUNT);
        System.out.printf(TOTAL_PROFIT_RATE, totalRate);
    }



}
