package lotto.view;

import static lotto.view.ViewConstant.DIVIDER;
import static lotto.view.ViewConstant.HOW_MANY_DID_YOU_PURCHASED;
import static lotto.view.ViewConstant.LOTTERY_RESULT;

import java.util.List;
import java.util.Set;

public class OutputView {

    public void printLottoResult(List<String> lottoResult, int lotteryCount) {
    public void printLottoResult(List<Set<Integer>> lottoResults, int lotteryCount) {
        System.out.printf(HOW_MANY_DID_YOU_PURCHASED.getMessage(), lotteryCount);

        StringBuilder stringBuilder = new StringBuilder();
        for(Set<Integer> lottoResult : lottoResults) {
            stringBuilder.append(toPrettyString(lottoResult));
        }

        System.out.println(stringBuilder);
    }

    private String toPrettyString(Set<Integer> lottoResult) {
        List<String> numbersToString = lottoResult.stream().map(Object::toString).toList();
        return "[" + String.join(", ", numbersToString) + "]" + "\n";
    }

    public void printWinningResult(String winningResult) {
        System.out.println(LOTTERY_RESULT.getMessage() + DIVIDER.getMessage());
        System.out.println(winningResult);
    }

    public void newLine() {
        System.out.println();
    }
}
