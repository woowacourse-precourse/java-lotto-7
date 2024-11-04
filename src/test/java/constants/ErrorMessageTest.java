package constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ErrorMessageTest {

    @Test
    void 로또_번호는_6개여야_합니다() {
        assertThat(ErrorMessage.NOT_MATCH_LOTTO_SIZE).isEqualTo("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또_번호에_중복된_숫자가_존재합니다() {
        assertThat(ErrorMessage.EXISTS_DUPLICATE_NUMBER).isEqualTo("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
    }

    @Test
    void 구매_금액은_숫자로_입력해야_합니다() {
        assertThat(ErrorMessage.INVALID_PURCHASE_AMOUNT).isEqualTo("[ERROR] 구매 금액은 숫자로 입력해야 합니다.");
    }

    @Test
    void 구매_금액은_1000원_단위로_입력해야_합니다() {
        assertThat(ErrorMessage.UNDIVIDED_THOUSAND).isEqualTo("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.");
    }

    @Test
    void 로또_번호는_1에서_45_사이_숫자여야_합니다() {
        assertThat(ErrorMessage.INVALID_NUMBER_RANGE).isEqualTo("[ERROR] 로또 번호는 1에서 45 사이 숫자여야 합니다.");
    }

    @Test
    void 유효하지_않은_입력입니다() {
        assertThat(ErrorMessage.ENTERED_INVALID_NUMBER).isEqualTo("[ERROR] 유효하지 않은 입력입니다.");
    }

    @Test
    void 보너스_번호는_당첨_번호와_중복일_수_없습니다() {
        assertThat(ErrorMessage.DUPLICATE_BONUS_NUMBER).isEqualTo("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
    }
}
