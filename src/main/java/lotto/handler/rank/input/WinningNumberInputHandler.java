package lotto.handler.rank.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.display.DisplayFormat;
import lotto.handler.LottoHandler;
import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;

public class WinningNumberInputHandler extends LottoHandler {

    @Override
    protected HandlerToken process(HandlerToken handlerToken) {
        String winningNumbers = inputWinningNumbers();
        String bonusNumber = inputBonusNumber();

        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, WinningNumberDTO.create(winningNumbers, bonusNumber));

        return handlerToken;
    }

    private String inputWinningNumbers() {
        System.out.print(DisplayFormat.WINNING_NUMBER_INPUT.displayDefault());
        String winningNumbers = Console.readLine();
        System.out.print(DisplayFormat.GAP.displayDefault());
        return winningNumbers;
    }

    private String inputBonusNumber() {
        System.out.print(DisplayFormat.BONUS_NUMBER_INPUT.displayDefault());
        String bonusNumber = Console.readLine();
        System.out.print(DisplayFormat.GAP.displayDefault());
        return bonusNumber;
    }
}
