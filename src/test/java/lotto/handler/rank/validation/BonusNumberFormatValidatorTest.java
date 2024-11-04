package lotto.handler.rank.validation;

import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberFormatValidatorTest {
    private BonusNumberFormatValidator validator;
    private HandlerToken handlerToken;

    @BeforeEach
    void 검증객체_핸들러_토큰_초기화() {
        validator = new BonusNumberFormatValidator();
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("보너스 번호가 올바른 형식일 경우 통과")
    void validate_보너스_번호가_올바른_형식일_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "7");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("보너스 번호가 잘못된 형식일 경우 예외 발생")
    void validate_보너스_번호가_잘못된_형식일_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "7a");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(handlerToken));
    }
}