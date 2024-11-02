package view;

import model.Money;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    private final Reader reader;
    private final Writer writer;

    private InputView(final Reader reader, final Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static class InputViewHolder {
        private static final InputView INSTANCE = new InputView(
                Reader.initiate(),
                Writer.initiate()
        );
    }

    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public Money readPurchaseAmount() {
        writer.printSout(ASK_PURCHASE_AMOUNT);
        String input = reader.readInput();
        return stringToMoney(input);
    }

    private Money stringToMoney(String input) {
        long purchaseAmount = Long.parseLong(input);
        return Money.from(purchaseAmount);
    }
}
