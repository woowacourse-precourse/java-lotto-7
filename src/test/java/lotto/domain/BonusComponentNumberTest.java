package lotto.domain;

import lotto.constants.string.InputError;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class BonusComponentNumberTest {

    static Lotto lotto;

    @BeforeAll
    static void setUp() {
        lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
    }

    @ParameterizedTest
    @DisplayName("BonusComponent는 당첨 로또에 있는 번호를 입력하면 에러가 난다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testBonusComponentValidateion(int bonusInput) {

        assertThatThrownBy(() -> {
            new BonusComponentNumber(lotto, new ComponentNumber(bonusInput));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.DUPLICATE_BONUS_NUMBER.getInstance());

    }


}
