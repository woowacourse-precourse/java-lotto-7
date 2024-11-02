package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.common.WinMoneyMessage;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.Winstatus;

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
                            Winstatus.mappingKeyToMoneyString(key),
                            status.getOrDefault(key,0) ) );
        }


    }

    private static String toStringWinstatus(String numRightKey, String winMoney, int correctCount) {
        return numRightKey + " 일치 (" + winMoney + ") - " + correctCount + "개";
    }


}
