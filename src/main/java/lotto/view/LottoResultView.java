package lotto.view;

import java.util.Map;
import lotto.config.ConsoleMessage;
import lotto.dto.LottoResult;
import lotto.model.win.Prize;

public class LottoResultView extends View {

    private LottoResult result;

    public LottoResultView(LottoResult result) {
        this.result = result;
    }

    @Override
    protected void printMessage() {
        System.out.println();
        System.out.println(ConsoleMessage.STATISTICS_HEAD);
        System.out.println(ConsoleMessage.STATISTICS_LINE);
    }

    @Override
    protected String doRendering() {
        Map<Prize, Long> prizeTable = result.prizeTable();

        for (Prize prize : Prize.values()) {
            if (prize == Prize.NOTHING) {
                continue;
            }

            long prizeCount = prizeTable.getOrDefault(prize, 0L);
            String output = String.format(prize.outputFormat, prize.correct, prize.money, prizeCount);
            System.out.println(output);
        }

        double profitRate = (result.rate());
        String output = String.format(ConsoleMessage.RATE, profitRate);
        System.out.println(output);

        return "";
    }
}
