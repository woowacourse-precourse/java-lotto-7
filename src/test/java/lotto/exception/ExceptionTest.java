package lotto.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("[EXCEPTION TEST]")
class ExceptionTest {

    private static final String EXPECT_ERROR_MESSAGE_HEADER = "[ERROR] ";

    @Test
    @DisplayName("LottoException 발생 시, 모두 IllegalArgumentException 타입이며 [ERROR] 헤더를 가진다.")
    void LottoException은_모두_IllegalException이며_올바른_에러_메시지를_반환한다() {
        // given
        List<LottoError> lottoErrors = Arrays.stream(LottoError.values())
                .collect(Collectors.toList());

        // when & then
        assertThat(lottoErrors)
                // IllegalArgumentException 타입 검사
                .map(LottoException::new).allMatch(exception ->exception instanceof IllegalArgumentException)
                // 에러 메시지 헤더 [ERROR] 검사
                .map(LottoException::getMessage).allMatch(message -> message.startsWith(EXPECT_ERROR_MESSAGE_HEADER));
    }

    @Test
    @DisplayName("MoneyException 발생 시, 모두 IllegalArgumentException 타입이며 [ERROR] 헤더를 가진다.")
    void MoneyException은_모두_IllegalException이며_올바른_에러_메시지를_반환한다() {
        // given
        List<MoneyError> moneyErrors = Arrays.stream(MoneyError.values())
                .collect(Collectors.toList());

        // when & then
        assertThat(moneyErrors)
                // IllegalArgumentException 타입 검사
                .map(MoneyException::new).allMatch(exception ->exception instanceof IllegalArgumentException)
                // 에러 메시지 헤더 [ERROR] 검사
                .map(MoneyException::getMessage).allMatch(message -> message.startsWith(EXPECT_ERROR_MESSAGE_HEADER));
    }

}