package lotto.interaction.output.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import lotto.Lotto;
import lotto.LottoResult;

public class LottoStringView {
    private final static NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    public static String numberOfLotto(List<Lotto> lottoList) {
        return String.format("\n%d개를 구매했습니다.\n", lottoList.size());
    }

    public static String lottoNumberList(List<Integer> numberList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0 ; i < numberList.size(); i++) {
            sb.append(numberList.get(i));
            if (i != numberList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }

    public static String lottoResultEntry(Entry<LottoResult, Integer> resultEntry) {
        LottoResult result = resultEntry.getKey();
        int number = resultEntry.getValue();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", result.getMatch()));
        if (result.getBonusMatch()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%s원) - ", numberFormat.format(result.getWinningMoney())));
        sb.append(String.format("%d개\n", number));
        return sb.toString();
    }

    public static String rateOfReturn(double rate) {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("총 수익률은 %s%%입니다.\n", df.format(rate));
    }
}
