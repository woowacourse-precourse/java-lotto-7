package lotto.view;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Rank;

public class OutputView {
    public static final String INPUT_AGAIN = "다시 입력해 주세요.";
    public static final String PURCHASED_TICKETS = "개를 구매했습니다.";
    public static final String COUNT = "개";
    public static final String TOTAL_PROFIT_RATE = "총 수익률은 %.1f%%입니다.%n";

    public static void printInputAgainPrompt() {
        System.out.println(INPUT_AGAIN);
    }

    public static void printPurchasedTicketCount(int amount) {
        System.out.println(amount + PURCHASED_TICKETS);
    }

    public static void printPurchasedLottoNumbers(ArrayList<List<Integer>> purchasedLottoNumbers) {
        for (List<Integer> purchasedLottoNumber : purchasedLottoNumbers) {
            System.out.println(purchasedLottoNumber);
        }
    }

    public static void printLottoResults(EnumMap<Rank, Integer> rankMap, double totalRate) {
        rankMap.forEach((rank, count) -> {
            String message = rank.getMessage();
            System.out.println(message + count + COUNT);
        });
        System.out.printf(TOTAL_PROFIT_RATE, totalRate);
    }

    public static void printErrorMessage(Exception e){
        System.out.println(e.getMessage());
    }
}
