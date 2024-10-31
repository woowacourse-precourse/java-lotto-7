package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.Wallet;

public class OutputView {

    public static void money() {
        print("구입금액을 입력해 주세요.\n");
    }

    public static void buyLottoTickets(List<Lotto> lottos) {
        print(String.format("%d개를 구매했습니다.%n", lottos.size()));
        for (Lotto lotto : lottos) {
            print(String.format("[%s]%n", lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))));
        }
    }

    public static void winningNumbers() {
        print("\n당첨 번호를 입력해 주세요.\n");
    }

    public static void bonusNumber() {
        print("\n보너스 번호를 입력해 주세요.\n");
    }

    public static void result(Wallet wallet) {
        print("\n");
        for (int i = 5; i >= 1; i--) {
            print(String.format("%d개 일치 (%s원) - %d개%n", 6 - i, 3000, wallet.getRankCount(i)));
        }
        print(String.format("총 수익률은 %.1f%%입니다.", wallet.gain()));
    }

    private static void print(String content) {
        System.out.print(content);
    }
}
