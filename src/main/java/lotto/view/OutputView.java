package lotto.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class OutputView {
    public void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicket(LinkedHashMap<Integer, List<Integer>> lottoTicket) {
        System.out.println();
        for (Entry<Integer, List<Integer>> entry : lottoTicket.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
