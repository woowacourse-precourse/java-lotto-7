package lotto;

import lotto.model.Lotto;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @DisplayName("로또_번호의_개수가_6개가_넘어가면_예외가_발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또_번호가_1부터_45_사이가_아니면_예외가_발생한다.")
    @Test
    void 로또_번호가_1부터_45_사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 666)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*@DisplayName("로또 번호 리스트에 숫자가 아닌 문자가 포함되면 예외 발생")
    @Test
    void 로또번호에숫자가아닌문자가포함되면예외발생() {
        // 숫자가 아닌 문자가 포함된 리스트
        List<?> invalidNumbers = Arrays.asList(1, 2, 3, "a", 5, 6); // "a"는 숫자가 아님

        // 예외 발생 검증
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validateNumberIsNumeric(invalidNumbers);
        });
        assertEquals("[ERROR] 로또 번호는 숫자여야 합니다.", exception.getMessage());
    }*/

    @DisplayName("구입_금액이_1,000원_단위가_아닐_때_예외_발생")
    @Test
    void 구입_금액이_1_000원_단위가_아닐_때_예외_발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoValidator.validatePurchaseAmount(1500); // 1500원
        });
        assertEquals("[ERROR] 구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

    @DisplayName("올바른_로또번호_생성_테스트")
    @Test
    void 올바른_로또번호_생성_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6); // List<Integer> 타입으로 로또 번호 선언
        Lotto lotto = new Lotto(numbers); // Lotto 객체 생성 시 List<Integer> 전달
        assertEquals(numbers, lotto.getNumbers()); // 예상한 로또 번호가 그대로 생성되는지 확인
    }


    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
