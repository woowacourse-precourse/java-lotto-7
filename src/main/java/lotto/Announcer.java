package lotto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import message.GameMessage;

public class Announcer {

    private LinkedHashMap<LottoResult, Integer> winningResults;

    public Announcer(LinkedHashMap<LottoResult, Integer> winningResults) {
        this.winningResults = winningResults;
    }

    public void printResults() {
        for (LottoResult lottoResult : winningResults.keySet()) {
            if (lottoResult.getRankName().equals("NONE_RANK")) {
                continue;
            }
            int prizeNumber = lottoResult.getPrize();
            String subStringBonusNumber = " ";
            if (lottoResult.getRankName().equals("SECOND_PRIZE")) {
                subStringBonusNumber = ", 보너스 볼 일치 ";
            }
            String result = String.format("%d개 일치%s(%,d원) - %d개", lottoResult.getSameNumberCount(),
                    subStringBonusNumber, prizeNumber,
                    winningResults.get(lottoResult));
            System.out.println(result);
        }
    }

    public void printEarningRate(LottoHost lottoHost, String inputCash) {
        BigDecimal earningRate = lottoHost.calcEarningRate(inputCash);
        DecimalFormat df = new DecimalFormat("#,##0.0");
        String formattedEarningRate = df.format(earningRate);
        System.out.printf("%s %s%s\n", GameMessage.RESULT_RATE_MESSAGE_START.getMessage(), formattedEarningRate,
                GameMessage.RESULT_RATE_MESSAGE_END.getMessage());
    }
}
