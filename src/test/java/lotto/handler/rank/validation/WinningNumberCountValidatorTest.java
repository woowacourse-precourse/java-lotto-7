package lotto.handler.rank.validation;

import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberCountValidatorTest {
    private WinningNumberCountValidator validator;
    private HandlerToken handlerToken;

    @BeforeEach
    void 검증객체_핸들러_토큰_초기화() {
        validator = new WinningNumberCountValidator();
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("당첨 번호가 6개일 경우 통과")
    void validate_당첨_번호가_6개일_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "7");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외 발생")
    void validate_당첨_번호가_6개가_아닐_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6,7", "8");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(handlerToken));
    }
}