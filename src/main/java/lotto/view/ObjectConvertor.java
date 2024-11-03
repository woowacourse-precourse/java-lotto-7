package lotto.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningResult;

public class ObjectConvertor {

    public static List<String> convertBuyingLottos(List<Lotto> buyingLottos) {
        return buyingLottos.stream()
                .map(lotto -> {
                    List<Integer> buyingNumbers = lotto.getNumbers();
                    return buyingNumbers.toString();
                })
                .toList();
    }

    public static List<String> convertWinningCount(WinningResult winningResult) {
        List<String> result = new ArrayList<>();
        Map<Prize, Integer> winning = winningResult.getWinning();

        for (Entry<Prize, Integer> entry : winning.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();

            String convertPrize = convertPrize(prize);

            result.add(String.format("%s - %d개", convertPrize, count));
        }

        return result;
    }

    private static String convertPrize(Prize prize) {
        int equalLottoCount = prize.getEqualLottoCount();
        boolean isMatchBonus = prize.isMatchBonus();

        if (isMatchBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", equalLottoCount, formatNumberWithCommas(prize));
        }
        return String.format("%d개 일치 (%s원)", equalLottoCount, formatNumberWithCommas(prize));
    }

    private static String formatNumberWithCommas(Prize prize) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

        return numberFormat.format(prize.getMoney());
    }
}
