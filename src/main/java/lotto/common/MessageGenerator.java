package lotto.common;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageGenerator {
    public static String inputCost = "구입금액을 입력해주세요.";
    public static String inputWinningNumber = "당첨 번호를 입력해 주세요.";
    public static String inputBonusNumber = "보너스 번호를 입력해 주세요.";

    public static List<String> lottoGenerateResult(List<Lotto> lots) {
        List<String> result = new ArrayList<>();
        result.add(lots.size() + "개를 구매했습니다.");
        for (Lotto lotto : lots) {
            result.add(lotto.toString());
        }
        return result;
    }

    public static List<String> generateDrawingResult(Map<LottoGrade, Integer> gradeMap) {
        List<String> result = new ArrayList<>();
        result.add("당첨 통계");
        result.add("---");
        for (LottoGrade lottoGrade : LottoGrade.values()) {
            int count = gradeMap.getOrDefault(lottoGrade, 0);
            if (lottoGrade.equals(LottoGrade.NONE)) continue;
            String message = generatedMessage(lottoGrade, count);
            result.add(message);
        }

        return result;
    }

    private static String generatedMessage(LottoGrade lottoGrade, int count) {
        return String.format("%s - %d개", lottoGrade.getMessage(), count);
    }

    public static String generateEarningRateMessage(Float earningRate) {
        return String.format("총 수익률은 %.1f%%입니다.", earningRate);
    }
}
