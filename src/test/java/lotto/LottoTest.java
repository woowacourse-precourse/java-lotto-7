package lotto;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


// TODO: lottoNumberRangeTest, 파라미터 테스트로 만들어서 하나의 테스트로 통합도 가능하지 않을까? 더 안좋을라나?


class LottoTest {
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    // TODO: 로또 관련 테스트
    // 로또의 개수(6개가 아니면 예외)
    @DisplayName("로또 번호의 개수가 6개를 초과하면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수_초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수_미만() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //TODO: 각종 입력(로또번호, 보너스번호, 금액 등)이 공백일경우 추가하기

    // 로또의 범위(1-45 사이)
    // 로또 정수 이외의 값
    static Stream<List<Integer>> lottoNumberRangeTest() {
        return Stream.of(
                Arrays.asList(0,1,2,3,4,5),
                Arrays.asList(-1,1,2,3,4,5),
                Arrays.asList(1,2,3,4,5,50));
    }

    @DisplayName("로또 숫자의 범위가 잘못된 경우 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("lottoNumberRangeTest")
    void 로또_번호의_범위_테스트(List<Integer> testNumber) {
        assertThatThrownBy(() -> new Lotto(testNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 로또 번호 중복
    @DisplayName("로또 번호가 중복되면 예외가 발생한다.")
    @Test
    void 로또_번호의_중복_확인() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }



    // TODO: 수익률 계산
    // 수익률이 정상적으로 계산되는지
}
