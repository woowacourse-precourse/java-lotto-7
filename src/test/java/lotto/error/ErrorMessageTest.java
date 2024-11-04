package lotto.error;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {

    @Test
    @DisplayName("로또 번호 개수 오류 메시지가 올바르게 포맷되어 반환된다")
    void 로또_번호_개수_오류_메시지가_올바르게_포맷되어_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo(
                String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LottoConstants.LOTTO_NUMBER_COUNT.getValue()));
    }

    @Test
    @DisplayName("로또 번호 중복 오류 메시지가 올바르게 반환된다")
    void 로또_번호_중복_오류_메시지가_올바르게_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.DUPLICATED_LOTTO_NUMBER;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호 범위 오류 메시지가 올바르게 포맷되어 반환된다")
    void 로또_번호_범위_오류_메시지가_올바르게_포맷되어_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo(String.format("[ERROR] 로또 번호는 %d부터 %d 사이여야 합니다.",
                LottoConstants.LOTTO_MIN_NUMBER.getValue(), LottoConstants.LOTTO_MAX_NUMBER.getValue()));
    }

    @Test
    @DisplayName("구입 금액 최소 단위 오류 메시지가 올바르게 포맷되어 반환된다")
    void 구입_금액_최소_단위_오류_메시지가_올바르게_포맷되어_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.AMOUNT_TOO_LOW;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo(
                String.format("[ERROR] 구입 금액은 최소 %d원 이상이어야 합니다.", LottoConstants.LOTTO_PRICE.getValue()));
    }

    @Test
    @DisplayName("구입 금액 단위 오류 메시지가 올바르게 포맷되어 반환된다")
    void 구입_금액_단위_오류_메시지가_올바르게_포맷되어_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_AMOUNT_UNIT;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo(
                String.format("[ERROR] 구입 금액은 %d원 단위여야 합니다.", LottoConstants.LOTTO_PRICE.getValue()));
    }

    @Test
    @DisplayName("구입 금액 형식 오류 메시지가 올바르게 반환된다")
    void 구입_금액_형식_오류_메시지가_올바르게_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_AMOUNT_FORMAT;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 구입 금액은 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("당첨 번호 형식 오류 메시지가 올바르게 반환된다")
    void 당첨_번호_형식_오류_메시지가_올바르게_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 당첨 번호는 숫자와 쉼표, 공백만 포함할 수 있습니다.");
    }

    @Test
    @DisplayName("보너스 번호 형식 오류 메시지가 올바르게 반환된다")
    void 보너스_번호_형식_오류_메시지가_올바르게_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호 중복 오류 메시지가 올바르게 반환된다")
    void 보너스_번호_중복_오류_메시지가_올바르게_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.DUPLICATED_BONUS_NUMBER;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("최대 재시도 횟수 초과 오류 메시지가 올바르게 반환된다")
    void 최대_재시도_횟수_초과_오류_메시지가_올바르게_반환된다() {
        // given
        ErrorMessage errorMessage = ErrorMessage.EXCEEDED_MAXIMUM_RETRY_ATTEMPTS;

        // when
        String message = errorMessage.getMessage();

        // then
        assertThat(message).isEqualTo("[ERROR] 최대 재시도 횟수를 초과했습니다.");
    }
}
