package lotto.io;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Ticket;

public abstract class Output {
    private static final String OUTPUT_TICKET_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String NOTICE_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_MATCH_BONUS_NUMBER_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String PRINT_MATCH_MASSAGE = "%d개 일치 (%,d원) - %d개%n";
    private static final String PRINT_PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다.%n";

    public static void lottos(List<Lotto> lottos) {
        System.out.println(lottos.size()  + OUTPUT_TICKET_AMOUNT_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void result(Ticket ticket) {
        System.out.println(NOTICE_MESSAGE);
        EnumMap<Prize, Integer> result = ticket.getResult();
        result.forEach((prize, integer) -> {
            if (prize == Prize.SECOND) {
                System.out.printf(PRINT_MATCH_BONUS_NUMBER_MESSAGE, prize.getMatchCount(), prize.getPrizeMoney(), integer);
            }

            if (prize != Prize.NONE && prize != Prize.SECOND) {
                System.out.printf(PRINT_MATCH_MASSAGE, prize.getMatchCount(), prize.getPrizeMoney(), integer);
            }
        });

        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        System.out.printf(PRINT_PROFIT_RATE_MESSAGE, formatter.format(ticket.getEarningRate()));
    }
}
