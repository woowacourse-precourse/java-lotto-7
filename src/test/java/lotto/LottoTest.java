package lotto;


import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    // 로또 번호 클래스 ( Lotto + LottoNumberValidator ) 검증 테스트
    @DisplayName("[LottoTest] 로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[LottoTest] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[LottoTest] 로또 번호가 1 과 45 사이의 숫자가 아닐 경우 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(List<Integer> lottoNumber){
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<Integer>> 로또_번호의_개수가_6개가_아니면_예외가_발생한다(){
        return Stream.of(
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)),
                new ArrayList<>(List.of(1, 2, 3, 4, 5)),
                new ArrayList<>(List.of(1, 2, 3, 4)),
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(1, 2)),
                new ArrayList<>(List.of(1)),
                new ArrayList<>()
        );
    }

    static Stream<List<Integer>> 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(){
        return Stream.of(
                new ArrayList<>(List.of(1, 1, 1, 1, 1, 1)),
                new ArrayList<>(List.of(1, 1, 1, 1, 1, 6)),
                new ArrayList<>(List.of(1, 1, 1, 1, 5, 6)),
                new ArrayList<>(List.of(1, 1, 1, 4, 5, 6)),
                new ArrayList<>(List.of(1, 1, 3, 4, 5, 6))
        );
    }

    static Stream<List<Integer>> 로또_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(){
        return Stream.of(
                new ArrayList<>(List.of(58, 1, 2, 3, 4, 5)),
                new ArrayList<>(List.of(999999, 999999, 11111, 333333, 5555555)),
                new ArrayList<>(List.of(0, 2, 3, 4, 5, 6)),
                new ArrayList<>(List.of(4, 3, 2, 1, 46)),
                new ArrayList<>(List.of(-1, -22, -3, -333333, -5555555, -6))
        );
    }
}
