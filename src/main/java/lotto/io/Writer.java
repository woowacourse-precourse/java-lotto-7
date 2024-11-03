package lotto.io;

public class Writer {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    private static String constructMessageFrom(Prize prize) {
        if (prize.isBonusMatch()) {
            return String.format("%d개 일치, 보너스볼 일치 (%,d원)", prize.getMatchCount(), prize.getMoney());
        }

        return String.format("%d개 일치 (%,d원)", prize.getMatchCount(), prize.getMoney());
    }
}
