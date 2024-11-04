package lotto.handler.rank.validation;

import lotto.handler.rank.dto.WinningNumberDTO;
import lotto.handler.token.HandlerToken;
import lotto.handler.token.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AllNumberDuplicateValidatorTest {
    private AllNumberDuplicateValidator validator;
    private HandlerToken handlerToken;

    @BeforeEach
    void 검증객체_핸들러_토큰_초기화() {
        validator = new AllNumberDuplicateValidator();
        handlerToken = new HandlerToken();
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않을 경우 통과")
    void validate_보너스_번호와_당첨번호가_중복되지_않을_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "7");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertDoesNotThrow(() -> validator.validate(handlerToken));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void validate_보너스_번호와_당첨번호가_중복될_경우() {
        WinningNumberDTO winningNumberDTO = WinningNumberDTO.create("1,2,3,4,5,6", "6");
        handlerToken.addContent(TokenType.WINNING_NUMBER_DTO, winningNumberDTO);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(handlerToken));
    }
}