package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int ticketCount = calculateTicketCount(purchaseAmount);
        printTicketCount(ticketCount);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    private static int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

}
