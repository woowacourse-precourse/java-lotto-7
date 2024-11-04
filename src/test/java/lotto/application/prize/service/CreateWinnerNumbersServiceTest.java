package lotto.application.prize.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.application.prize.domain.WinnerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("CreateWinnerNumbersService 테스트")
class CreateWinnerNumbersServiceTest {

    private static List<List<Integer>> invalidSizeNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of()
        );
    }

    @DisplayName("당첨 번호 생성 성공")
    @Test
    void 당첨번호_생성_성공() {
        // given
        CreateWinnerNumbersService service = new CreateWinnerNumbersService();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        WinnerNumbers winnerNumbers = service.execute(numbers);

        // then
        assertThat(winnerNumbers.getLottoNumbers()).isEqualTo(numbers);
    }

    @DisplayName("6개가 아닌 당첨 번호로 생성시 실패")
    @ParameterizedTest
    @MethodSource("invalidSizeNumbers")
    void 잘못된_개수_당첨번호_생성실패(List<Integer> numbers) {
        // given
        CreateWinnerNumbersService service = new CreateWinnerNumbersService();

        // expect
        assertThatThrownBy(() -> service.execute(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }


    @DisplayName("범위를 벗어난 당첨 번호로 생성시 실패")
    @Test
    void 범위초과_당첨번호_생성실패() {
        // given
        CreateWinnerNumbersService service = new CreateWinnerNumbersService();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // expect
        assertThatThrownBy(() -> service.execute(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("중복된 당첨 번호로 생성시 실패")
    @Test
    void 중복_당첨번호_생성실패() {
        // given
        CreateWinnerNumbersService service = new CreateWinnerNumbersService();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // expect
        assertThatThrownBy(() -> service.execute(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

}
