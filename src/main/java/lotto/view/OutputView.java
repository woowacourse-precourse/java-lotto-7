package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public void printPublishedLotteries(List<Lotto> lotteries) {
        System.out.println("\n" + lotteries.size() + "개를 구매했습니다.");

        for (Lotto lotto : lotteries) {
            printEachNumber(lotto);
        }
    }

    private void printEachNumber(Lotto lotto) {
        List<Integer> sortedLotto = lotto.getSortedLotto();
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Integer integer : sortedLotto) {
            joiner.add(integer.toString());
        }

        System.out.println(joiner);
    }
}
