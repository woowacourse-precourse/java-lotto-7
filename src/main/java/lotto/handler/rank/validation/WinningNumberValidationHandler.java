package lotto.handler.rank.validation;

import java.util.List;
import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class WinningNumberValidationHandler extends LottoHandler {
    private final WinningNumberValidatorFactory winningNumberValidatiorFactory;

    public WinningNumberValidationHandler(WinningNumberValidatorFactory winningNumberValidatiorFactory) {
        this.winningNumberValidatiorFactory = winningNumberValidatiorFactory;
    }

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        try {
            validateAll(getWinningNumberValidators(), handlerToken);
        } catch (IllegalArgumentException e) {
            handlerToken.addContent(TokenType.INVALID_INPUT_ERROR, null);
            System.out.println(DisplayFormat.ERROR.displayWithOneValue(e.getMessage()));
        } finally {
            checkInvalidInputAndRevert(handlerToken);
        }
        return handlerToken;
    }

    private void validateAll(List<WinningNumberValidator> winningNumberValidators, HandlerToken handlerToken) {
        for (WinningNumberValidator winningNumberValidator : winningNumberValidators) {
            winningNumberValidator.validate(handlerToken);
        }
    }

    private List<WinningNumberValidator> getWinningNumberValidators() {
        return winningNumberValidatiorFactory.create();
    }

    private void checkInvalidInputAndRevert(HandlerToken handlerToken) {
        if (handlerToken.hasInvalidInput()) {
            removeInputAndError(handlerToken);
            prevHandler.handle(handlerToken);
        }
    }

    private void removeInputAndError(HandlerToken handlerToken) {
        handlerToken.removeContent(TokenType.WINNING_NUMBER_DTO);
        handlerToken.removeContent(TokenType.INVALID_INPUT_ERROR);
    }

}
