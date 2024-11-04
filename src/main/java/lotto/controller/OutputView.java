package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class OutputView {

    public static final String TICKET_COUNT = "개를 구매했습니다.";

    public void printTicketCount(int ticketCount){
        System.out.println(ticketCount+TICKET_COUNT);
    }
    public static void printSuccessResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }

}
