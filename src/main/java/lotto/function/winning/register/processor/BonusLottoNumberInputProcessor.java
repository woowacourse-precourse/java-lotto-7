package lotto.function.winning.register.processor;

import lotto.domain.BonusLotto;
import lotto.io.input.Input;
import lotto.io.printer.prompt.PromptPrinter;

public class BonusLottoNumberInputProcessor {

    private final PromptPrinter promptPrinter;
    private final Input input;

    public BonusLottoNumberInputProcessor(PromptPrinter promptPrinter, Input input) {
        this.promptPrinter = promptPrinter;
        this.input = input;
    }

    public BonusLotto inputBonusLottoNumber() {
        promptPrinter.printInputLottoBonusNumber();
        return new BonusLotto(input.readLineToInteger());
    }

}
