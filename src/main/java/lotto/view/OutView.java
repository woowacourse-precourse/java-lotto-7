package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.common.WinMoneyMessage;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.Winstatus;
import lotto.model.util.Mapping;

public class OutView {

    private final static String GENERATEDLOTTOMESSAGE = "개를 구매했습니다.";

    private final static List<String> numRightMessages =
            List.of(WinMoneyMessage.THREECOUNTKEY.getWinMoneyStr(),
                    WinMoneyMessage.FOURCOUNTKEY.getWinMoneyStr(),
                    WinMoneyMessage.FIVECOUNTKEY.getWinMoneyStr(),
                    WinMoneyMessage.FIVEANDBONUSKEY.getWinMoneyStr(),
                    WinMoneyMessage.SIXCOUNTKEY.getWinMoneyStr());

    public static void generatedLottoPrint(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + GENERATEDLOTTOMESSAGE);

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void winStatusPrint(Lottos lottos) {

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<String, Integer> status = lottos.getWinstatus().getStatus();

        for (String key : numRightMessages) {
            System.out.println(
                    toStringWinstatus(key,
                            Mapping.mappingKeyToMoneyString(key),
                            status.getOrDefault(key, 0)));
        }


    }

    public static void profitRatePrint(double profitRate) {
        System.out.println(toStringProfitRate(profitRate));
    }

    private static String toStringProfitRate(double profitRate) {
        return "총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.";
    }

    private static String toStringWinstatus(String numRightKey, String winMoney, int correctCount) {
        return numRightKey + " 일치 (" + winMoney + ") - " + correctCount + "개";
    }


}
