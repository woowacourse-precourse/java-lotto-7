package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void showPurchasedLotteries(List<Lotto> all_lottos){
        System.out.println("\n" + all_lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto: all_lottos) {
            String output_one = lotto.getNumbers().stream()
                                                    .map(String::valueOf)
                                                    .collect(Collectors.joining(","));
            System.out.println("[" + output_one + "]");
        }
    }
}
