package io.lotto;

import lotto.Lotto;
import user.User;
import lotto.type.WinType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutPutLottoHandler {

    private static final String OUTPUT_BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_RESULT_MESSAGE = "당첨 통계";

    public void showOutputBuyCountMessage(int count) {
        System.out.println();
        System.out.println(count + OUTPUT_BUY_COUNT_MESSAGE);
    }

    public List<String> showLottos(List<Lotto> lottos) {
        List<String> showLottos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            String lottoNumbers = lotto.getNumbers().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbers + "]");
            showLottos.add(lottoNumbers);
        }
        return showLottos;
    }

    public void showTotalResult(User user) {
        List<WinType> values = Arrays.stream(WinType.values())
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println();
        System.out.println(OUTPUT_RESULT_MESSAGE);
        System.out.println("---");
        for (WinType value : values) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(value.getDescription())
                    .append(" (").append(convertLottoWinningsToStringBy(value)).append("원) - ")
                    .append(user.getRecordWin().get(value)).append("개");
            System.out.println(stringBuilder);
        }
    }

    public String convertLottoWinningsToStringBy(WinType winType) {
        long lottoWinnings = winType.getLottoWinnings();
        return NumberFormat.getInstance().format(lottoWinnings);
    }

    public void showProfitRate(int price, long profit) {
        String profitRate = getProfitRate(price, profit);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ")
                .append(profitRate).append("%")
                .append("입니다.");
        System.out.println(stringBuilder);
    }

    public String getProfitRate(int price, long profit) {
        double num = (double) profit / price * 100.0;

        return new BigDecimal(num).setScale(1, RoundingMode.HALF_UP).toString();
    }
}
