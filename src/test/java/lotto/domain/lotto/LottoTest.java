package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.common.exception.DuplicateLottoNumberException;
import lotto.common.exception.InvalidLottoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("중복된 로또 번호로 로또 생성 시 예외를 발생하는 테스트")
    @ParameterizedTest
    @MethodSource("provideDuplicateLottoNumberTicket")
    void DuplicateLottoNumberExceptionTest(List<LottoNumber> lottoNumbers){
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(DuplicateLottoNumberException.class);
    }

    static Stream<Arguments> provideDuplicateLottoNumberTicket(){
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .toList();
        return Stream.of(
                Arguments.of(List.of(lottoNumbers.get(1), lottoNumbers.get(2), lottoNumbers.get(3), lottoNumbers.get(3), lottoNumbers.get(3), lottoNumbers.get(3))),
                Arguments.of(List.of(lottoNumbers.get(20), lottoNumbers.get(20), lottoNumbers.get(20), lottoNumbers.get(20), lottoNumbers.get(20), lottoNumbers.get(20))),
                Arguments.of(List.of(lottoNumbers.get(41), lottoNumbers.get(42), lottoNumbers.get(43), lottoNumbers.get(44), lottoNumbers.get(44), lottoNumbers.get(44)))
        );
    }

    @DisplayName("잘못된 개수의 로또 번호로 로또 생성 시 예외를 발생하는 테스트")
    @ParameterizedTest
    @MethodSource("provideOutOfRangeLottoSizeTicket")
    void OutOfRangeLottoSizeExceptionTest(List<LottoNumber> lottoNumbers){
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    static Stream<Arguments> provideOutOfRangeLottoSizeTicket(){
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .toList();
        return Stream.of(
                Arguments.of(List.of(lottoNumbers.get(1), lottoNumbers.get(2), lottoNumbers.get(3))),
                Arguments.of(List.of(lottoNumbers.get(20))),
                Arguments.of(List.of(lottoNumbers.get(40), lottoNumbers.get(41), lottoNumbers.get(42), lottoNumbers.get(43), lottoNumbers.get(44)))
        );
    }

}