package view;

import model.lotto.Lottos;

public class OutputView {

    private static final String PURCHASE_NOTICE = "%d개를 구매했습니다.";

    private final Writer writer;

    private OutputView(final Writer writer) {
        this.writer = writer;
    }

    public static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView(Writer.initiate());
    }

    public static OutputView getInstance() {
        return OutputViewHolder.INSTANCE;
    }

    public void displayLottos(final Lottos lottos, final int lottoCount) {
        String message = String.format(PURCHASE_NOTICE, lottoCount);

        writer.printLineBefore(message);
        writer.printSout(lottos.toString());
    }
}
