package lotto.view;

import java.util.stream.Collectors;
import lotto.controller.response.LottoIssuingResponse;
import lotto.controller.response.LottoIssuingResponse.LottoDto;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_DELIMITER = ", ";

    public void printLottoTickets(LottoIssuingResponse response) {
        System.out.println();
        System.out.println(response.quantity() + PURCHASE_MESSAGE);
        response.lottoTickets().forEach(this::printAscLotto);
    }

    private void printAscLotto(LottoDto lotto) {
        System.out.print("[");

        String lottoResult = lotto.lotto().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER));

        System.out.print(lottoResult);
        System.out.println("]");
    }
}
