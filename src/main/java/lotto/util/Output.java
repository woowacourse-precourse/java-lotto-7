package lotto.util;

import lotto.model.Lotto;

import java.util.List;

public class Output {
    public static void printTicketNumber(int ticketNumber) {
        System.out.println("\n" + ticketNumber + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
        }

        System.out.println(stringBuilder);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
