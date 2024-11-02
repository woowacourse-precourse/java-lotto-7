package lotto.view;

import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.Set;
import lotto.model.draw.DrawResult;
import lotto.model.draw.Prize;
import lotto.model.lotto.LottoTicket;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoTicket(LottoTicket lottoTicket, int lottoAmount) {
        println();
        String lottoAmountHeader = String.format("%s개를 구매했습니다.", lottoAmount);
        System.out.println(lottoAmountHeader);
        System.out.println(lottoTicket);
    }

    public void printDrawResult(DrawResult drawResult) {
        println();
        System.out.println("당첨 통계\n---");
        Set<Entry<Prize, Integer>> entries = drawResult.getDrawResult().entrySet();
        for (Entry<Prize, Integer> entry : entries) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            if(prize.equals(Prize.BLANK)) {
                continue;
            }
            System.out.println(prize.getMessage() + " - " + count +"개");
        }
    }

    public void printProfitPercentage(double percentage) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");
        String formattedPercentage = decimalFormat.format(percentage);
        System.out.printf("총 수익률은 %s%%입니다.%n",formattedPercentage);
    }

    public void println() {
        System.out.println();
    }
}
