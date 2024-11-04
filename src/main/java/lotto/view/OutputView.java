package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {

    public static void outputTicketCountAndLotteries(List<Lotto> lotteries) {
        int size = lotteries.size();
        System.out.println(size + "개를 구매했습니다.");
        lotteries.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .forEach(System.out::println);

    }
}
