package view;

import model.lotto.Lotto;
import model.money.Money;
import view.validator.InputValidatorFacade;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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
        try {
            writer.printSout(ASK_PURCHASE_AMOUNT);
            String input = reader.readInput();
            InputValidatorFacade.moneyValidators(input);
            return PreProcessor.stringToMoney(input);
        } catch (IllegalArgumentException e) {
            writer.printErrorMessage(e.getMessage());
            return readPurchaseAmount();
        }
    }

    public Lotto readWinningNumber() {
        try {
            writer.printSout(ASK_WINNING_NUMBER);
            String input = reader.readInput();
            InputValidatorFacade.winningNumValidators(input);
            return PreProcessor.stringToLotto(input);
        } catch (IllegalArgumentException e) {
            writer.printErrorMessage(e.getMessage());
            return readWinningNumber();
        }
    }

    public Integer readBonus() {
        writer.printSout(ASK_BONUS_NUMBER);
        String input = reader.readInput();
        return PreProcessor.stringToInteger(input);
    }
}
