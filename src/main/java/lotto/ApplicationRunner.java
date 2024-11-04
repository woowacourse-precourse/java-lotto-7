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
import lotto.endpoint.AbstractIOHandler;


public class ApplicationRunner extends AbstractIOHandler {
    private final static String PURCHASE_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
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

        List<Integer> winningNumbers = handleInput(SystemMessage.ENTER_WINNING_NUMBERS, this::parseWinningNumbers);
        Integer bonusNumber = handleInput(SystemMessage.ENTER_BONUS_NUMBER, this::parseBonusNumber);

        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Displayable result = drawController.draw(lottos, winningLotto);
        outputView.printLine(result);
    }

    private Lottos parsePurchaseAmount(String input) {
        Integer amount = StringParser.toInteger(input);
        return purchaseController.purchaseLotto(amount);
    }

    private List<Integer> parseWinningNumbers(String input) {
        return Objects.requireNonNull(StringParser.toNumericsSplitBy(input, DELIMITER));
    }

    private Integer parseBonusNumber(String input) {
        return StringParser.toInteger(input);
    }
}
