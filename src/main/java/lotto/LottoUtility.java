package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoUtility {
    public List<Integer> stringToWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하셔야 합니다.");
        }
        return numbers;
    }

    public String getWinningInfo(LottoWinningStandard standard, int matchedCount) {
        if(standard.equals(LottoWinningStandard.SECOND_PRIZE)) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchedCount + "개";
        }

        DecimalFormat formatter = new DecimalFormat("#,###");
        String prize = formatter.format(standard.getPrizeMoney());
        return standard.getMatchedNumberCount() + "개 일치 (" + prize + "원) - " + matchedCount + "개";
    }

    public static void printMessage(String message) {
    public void printMessage(String message) {
        System.out.println(message);
    }
}
