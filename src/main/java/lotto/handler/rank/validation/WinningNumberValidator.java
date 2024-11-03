package lotto.handler.rank.validation;

import java.util.Arrays;
import java.util.List;
import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import lotto.utility.Delimiter;

public interface WinningNumberValidator {
    void validate(HandlerToken handlerToken);

    default String getWinningNumbersToString(HandlerToken handlerToken) {
        WinningNumberDTO winningNumberDTO = handlerToken.getContent(TokenType.WINNING_NUMBER_DTO,
                WinningNumberDTO.class);
        return winningNumberDTO.getWinningNumbers();
    }

    default List<Integer> getWinningNumbersToList(HandlerToken handlerToken) {
        String rawWinningNumbers = getWinningNumbersToString(handlerToken);
        String[] winningNumbers = rawWinningNumbers.split(Delimiter.COMMA.getDelimiter());
        return Arrays.stream(winningNumbers).map(Integer::parseInt).toList();
    }

    default String getBonusNumberToString(HandlerToken handlerToken) {
        WinningNumberDTO winningNumberDTO = handlerToken.getContent(TokenType.WINNING_NUMBER_DTO,
                WinningNumberDTO.class);
        return winningNumberDTO.getBonusNumber();
    }

    default int getBonusNumberToInteger(HandlerToken handlerToken) {
        String rawBonusNumber = getBonusNumberToString(handlerToken);
        return Integer.parseInt(rawBonusNumber);
    }
}
