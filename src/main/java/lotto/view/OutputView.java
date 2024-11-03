package lotto.view;

import java.util.List;
import lotto.dto.LottoTicketsDto;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String NEW_LINE = "\n";

    public void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        StringBuilder result = new StringBuilder();
        result.append(String.format(PURCHASE_MESSAGE, lottoTicketsDto.purchaseCount()));

        for (List<Integer> numbers : lottoTicketsDto.lottoNumbers()) {
            result.append(numbers).append(NEW_LINE);
        }

        System.out.println(result);
    }
}
