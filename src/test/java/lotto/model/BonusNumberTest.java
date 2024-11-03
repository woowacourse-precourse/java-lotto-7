package lotto.model;

import lotto.model.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호를 가지고 BonusNumber 객체를 생성할 수 있다.")
    void should_CreateBonusNumber_When_GivenNumber() {
        // given
        int number = 1;
        // when
        BonusNumber bonusNumber = new BonusNumber(number);
        // then
        Assertions.assertThat(bonusNumber).isNotNull();
    }

}