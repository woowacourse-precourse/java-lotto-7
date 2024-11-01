package lotto.view;

import lotto.dto.response.LottosResponse;

public class OutputView {

    private static final StringBuilder BUFFER = new StringBuilder();
    private static final String NEW_LINE = "\n";
    public static final String QUANTITY_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public void printPurchasedLottos(LottosResponse response) {
        addLottoQuantityToBuffer(response);
        addLottosToBuffer(response);
        bufferClear();
    }

    public void printError(String error) {
        System.out.println(error);
    }

    private void addLottosToBuffer(LottosResponse response) {
        response.lottos().forEach(lotto ->
                BUFFER.append(lotto.lotto())
                        .append(NEW_LINE));
    }

    private void addLottoQuantityToBuffer(LottosResponse response) {
        BUFFER.append(NEW_LINE)
                .append(response.quantity())
                .append(QUANTITY_OUTPUT_MESSAGE)
                .append(NEW_LINE);
    }

    private void bufferClear() {
        System.out.println(BUFFER);
        BUFFER.setLength(0);
    }
}
