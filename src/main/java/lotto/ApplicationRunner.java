package lotto;

import java.util.List;
import java.util.Objects;
import lotto.common.ApplicationConfigurer;
import lotto.common.Displayable;
import lotto.common.StringParser;
import lotto.common.SystemMessage;
import lotto.controller.DrawController;
import lotto.controller.PurchaseController;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLotto.WinningLottoBuilder;
import lotto.endpoint.AbstractIOHandler;


public class ApplicationRunner extends AbstractIOHandler {
    private static final String PURCHASE_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String DELIMITER = ",";

    private final DrawController drawController;
    private final PurchaseController purchaseController;

    public ApplicationRunner() {
        super(ApplicationConfigurer.getOutputView(), ApplicationConfigurer.getInputView());
        this.drawController = ApplicationConfigurer.getDrawController();
        this.purchaseController = ApplicationConfigurer.getPurchaseController();
    }

    public void run() {
        Lottos lottos = handleInput(SystemMessage.PRE_MONEY_INJECT, this::parsePurchaseAmount);
        outputView.printWithArgs(PURCHASE_QUANTITY_MESSAGE, lottos.getCount());
        outputView.printLine(lottos);

        WinningLottoBuilder builder = handleInput(SystemMessage.ENTER_WINNING_NUMBERS, this::setWinningNumbers);
        WinningLotto winningLotto =handleInput(SystemMessage.ENTER_BONUS_NUMBER, s -> setBonusNumber(s,builder));

        Displayable result = drawController.draw(lottos, winningLotto);
        outputView.printLine(result);
    }

    private Lottos parsePurchaseAmount(String input) {
        Integer amount = StringParser.toInteger(input);
        return purchaseController.purchaseLotto(amount);
    }

    private WinningLottoBuilder setWinningNumbers(String input) {
        List<Integer> winningNumbers = Objects.requireNonNull(StringParser.toNumericsSplitBy(input, DELIMITER));
        return WinningLotto.builder().winningNumbers(winningNumbers);
    }

    private WinningLotto setBonusNumber(String input, WinningLottoBuilder builder) {
        Integer bonusNumber = StringParser.toInteger(input);
        return builder.bonusNumber(bonusNumber).build();
    }
}
