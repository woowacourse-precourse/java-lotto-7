package lotto.model;

import lotto.entity.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    // 로또 번호 생성 기능 ( LottoGenerator.java ) 테스트
    private final int UNIT_PRICE = 1000;

    @DisplayName("[LottoGeneratorTest] 구입 금액에 숫자 외의 문자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"asd", ",123", "12 12432", "@$%#!", "123@$12,./"})
    void 구입_금액에_숫자_외의_문자가_있으면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new LottoGenerator(new Price(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[LottoGeneratorTest] 음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000000", "-2147483648", "-3482739"})
    void 음수를_입력하면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new LottoGenerator(new Price(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[LottoGeneratorTest] 정수 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1231241242141", "999999999999999", "2147483648"})
    void 정수_범위를_벗어나면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new LottoGenerator(new Price(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[LottoGeneratorTest] 천 단위 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"10001", "25001", "2147483647", "0"})
    void 천_단위_숫자가_아니면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new LottoGenerator(new Price(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[LottoGeneratorTest] 정상 동작 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2147483000", "1000000", "55000"})
    void 정상_동작_테스트(String input){
        LottoGenerator lottoGenerator = new LottoGenerator(new Price(input));
        int validLottoListSize = Integer.parseInt(input) / UNIT_PRICE;

        assertThat(lottoGenerator.getLottoList().size()).isEqualTo(validLottoListSize);
    }
}
