package lotto.view;

import static lotto.enums.ViewMessage.OUTPUT_LOTTO_COUNT;
import static lotto.enums.ViewMessage.OUTPUT_RESULT;
import static lotto.enums.ViewMessage.OUTPUT_YIELD;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.enums.Prize;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public void printLottos(Lottos lottos) {
        printLottoCount(lottos);
        printLottoNumbers(lottos);
    }

    private void printLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + OUTPUT_LOTTO_COUNT.getMessage());
    }

    private void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(new ArrayList<>(numbers));
        System.out.println(numbers);
    }

    public void printResults(Map<Prize, Integer> prizeCount, double yield) {
        printResultMessage();
        Arrays.stream(Prize.values())
                .sorted(Comparator.reverseOrder())
                .forEach(prize -> printPrizeResult(prize, prizeCount));
        printYield(yield);
    }

    private void printResultMessage() {
        System.out.println(OUTPUT_RESULT.getMessage());
    }

    private void printPrizeResult(Prize prize, Map<Prize, Integer> prizeCount) {
        String resultMessage = prize.getMatchCount() + "개 일치";
        if (prize.getRequiresBonus()) {
            resultMessage += ", 보너스 볼 일치";
        }
        resultMessage += " (" + formatCurrency(prize.getPrizeAmount()) + "원) - " + prizeCount.get(prize) + "개";
        System.out.println(resultMessage);
    }

    private String formatCurrency(int amount) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(amount);
    }

    private void printYield(double yield) {
        System.out.printf(OUTPUT_YIELD.getMessage() + "%.1f%%입니다.\n", yield);
    }

}
