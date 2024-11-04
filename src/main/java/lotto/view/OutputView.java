package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private OutputView() {}

    public static void printPurchaseResult(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTickets().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getTickets()) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}
