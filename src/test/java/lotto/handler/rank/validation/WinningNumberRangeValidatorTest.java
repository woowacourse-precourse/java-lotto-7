package lotto.handler.rank.validation;

import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberRangeValidatorTest {
    private WinningNumberRangeValidator validator;
    private HandlerToken handlerToken;

    @BeforeEach
    void 검증객체_핸들러_토큰_초기화() {
        validator = new WinningNumberRangeValidator();
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("당첨 번호가 범위 내일 경우 통과")
    void validate_당첨_번호가_범위_내일_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "7");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("당첨 번호가 범위를 벗어날 경우 예외 발생")
    void validate_당첨_번호가_범위를_벗어날_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,49", "7");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(handlerToken));
    }
}