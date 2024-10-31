package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {
    public void printPurchasePriceRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", quantity);
    }

    public void printLottoNumbers(List<Lotto> lottoTickets) {
        String result = lottoTickets.stream()
                .map(Lotto::getNumbers)
                .map(List::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }
}
