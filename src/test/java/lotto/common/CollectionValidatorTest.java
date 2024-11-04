package lotto.common;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionValidatorTest {
    @Test
    @DisplayName("중복된 수 검증")
    void validateDuplicateNumberInCollection() {
        // given
        List<Integer> duplicatedArgs = List.of(1, 1);

        // when & then
        assertThatThrownBy(()->CollectionValidator.validateDuplicate(duplicatedArgs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재합니다.");
    }


    @Test
    @DisplayName("크기 검증")
    void validateSpecificSize() {
        // given
        List<Integer> args = List.of(1, 2);
        int expectedSize = 1;
        // when & then
        assertThatThrownBy(()->CollectionValidator.validateSize(args,expectedSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("크기가 적절하지 않습니다. 현재 크기: "+args.size());
    }
}
