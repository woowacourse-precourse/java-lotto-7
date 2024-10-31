package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printPurchaseLotteryTickets(List<Lotto> lotteryTickets) {
        System.out.printf("\n%d개를 구매했습니다.\n", lotteryTickets.size());
        printLotteryTickets(lotteryTickets);
    }

    private void printLotteryTickets(List<Lotto> lotteryTickets) {
        lotteryTickets.forEach(lotto ->
                System.out.println(formatLottoNumbers(lotto.getNumbers())));
    }


    private String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
