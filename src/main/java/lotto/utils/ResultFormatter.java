package lotto.utils;

import lotto.constant.DrawType;
import lotto.model.dto.LottoGameResult;
import java.util.*;

public class ResultFormatter {

    private final static int MATCH_NUM_EDGE_CASE = 5;

    public static Map<DrawType, Integer> formatResult(Map<DrawType, Integer> drawResult) {
        List<Map.Entry<DrawType, Integer>> entryList = new ArrayList<>(drawResult.entrySet());

        entryList.sort(Comparator.comparingInt(entry -> getMatchNum(entry.getKey())));

        Map<DrawType, Integer> formattedResult = new LinkedHashMap<>();
        for (Map.Entry<DrawType, Integer> entry : entryList) {
            formattedResult.put(entry.getKey(), entry.getValue());
        }

        return formattedResult;
    }

    public static int getMatchNum(DrawType drawType) {
        try {
            return Integer.parseInt(drawType.getValue());
        } catch (NumberFormatException e) {
            return MATCH_NUM_EDGE_CASE;
        }
    }

    public static List<LottoGameResult> formatFinalResult(Map<DrawType, Integer> formattedFinalResult) {
        List<LottoGameResult> resultList = new ArrayList<>();
        for (Map.Entry<DrawType, Integer> entry : formattedFinalResult.entrySet()) {
            DrawType drawType = entry.getKey();
            int matchNum = getMatchNum(drawType);
            int matchPrize = drawType.getPrize();
            int matchCount = entry.getValue();
            resultList.add(new LottoGameResult(matchNum, matchPrize, matchCount));
        }
        return resultList;
    }
}
