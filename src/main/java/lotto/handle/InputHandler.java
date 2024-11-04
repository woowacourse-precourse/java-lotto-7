package lotto.handle;

import lotto.domain.core.Bonus;
import lotto.domain.core.Lotto;
import lotto.domain.core.PurchaseTotalPrice;
import lotto.dto.input.BonusNumberInput;
import lotto.dto.input.LottoNumbersInput;
import lotto.dto.input.PurchaseTotalPriceInput;
import lotto.utils.parser.BonusNumberInputParser;
import lotto.utils.parser.LottoNumbersInputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class InputHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public InputHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public PurchaseTotalPrice handlePurchaseTotalPrice() {
        while (true) {
            try {
                outputView.printPurchaseTotalPricePrompt();
                PurchaseTotalPriceInput input = inputView.readPurchaseTotalPrice();
                return PurchaseTotalPrice.from(input.input());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto handleLottoNumbers() {
        while (true) {
            try {
                outputView.printLottoNumbersInputPrompt();
                LottoNumbersInput input = inputView.readLottoNumbers();
                List<Integer> numbers = LottoNumbersInputParser.parse(input.input());
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Bonus handleBonusNumber(Lotto lotto) {
        while (true) {
            try {
                outputView.printBonusNumberInputPrompt();
                BonusNumberInput input = inputView.readBonusNumber();
                int bonusNumber = BonusNumberInputParser.parse(input.input());
                return new Bonus(bonusNumber, lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
