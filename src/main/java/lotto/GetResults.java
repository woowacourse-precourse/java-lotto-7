package lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

public class GetResults {
    public static void printResults(List<List<Integer>> entryLists, List<Integer> lottoNumbers, int bonusNumber,
                                    int attempts, EnumMap<LottoResults, Integer> calculator) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < attempts; i++) {
            List<Integer> matchedNumbers = new ArrayList<>(entryLists.get(i));
            matchedNumbers.retainAll(lottoNumbers);
            checkNumbers(i, matchedNumbers, calculator, entryLists, bonusNumber);
        }
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        for (LottoResults result : LottoResults.values()) {
            String formattedPrize = formatter.format(result.getPrize());
            System.out.println(
                    result.getHowMany() + " (" + formattedPrize + "원) - " + calculator.get(result) + "개");
        }
    }

    public static void checkNumbers(int i, List<Integer> matchedNumbers,
                                    EnumMap<LottoResults, Integer> calculator,
                                    List<List<Integer>> entryLists, int bonusNumber) {
        if (matchedNumbers.size() == 3) {
            updateResults(calculator, LottoResults.THREE_MATCH);
        }
        if (matchedNumbers.size() == 4) {
            updateResults(calculator, LottoResults.FOUR_MATCH);
        }
        if (matchedNumbers.size() == 5) {
            checkBonus(i, entryLists, bonusNumber, calculator, matchedNumbers);
        }
        if (matchedNumbers.size() == 6) {
            updateResults(calculator, LottoResults.SIX_MATCH);
        }
    }

    public static void updateResults(EnumMap<LottoResults, Integer> calculator, LottoResults result) {
        calculator.put(result, calculator.get(result) + 1);
    }

    public static void checkBonus(int i, List<List<Integer>> entryLists, int bonusNumber,
                                  EnumMap<LottoResults, Integer> calculator, List<Integer> matchedNumbers) {
        if (matchedNumbers.size() == 5 && entryLists.get(i).contains(bonusNumber)) {
            updateResults(calculator, LottoResults.FIVE_BONUS_MATCH);
        }
        if (matchedNumbers.size() == 5 && !entryLists.get(i).contains(bonusNumber)) {
            updateResults(calculator, LottoResults.FIVE_MATCH);
        }
    }

    public static void printReturnRate(int betAmount, EnumMap<LottoResults, Integer> calculator) {
        int sum = 0;
        for (LottoResults result : LottoResults.values()) {
            sum += result.getPrize() * calculator.get(result);
        }
        double returnRate = (double) sum / betAmount * 100;
        returnRate = Math.round(returnRate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
