package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InputMessageTest {

    @Test
    void 구입금액_입력에_대한_메시지가_정확히_들어있는지_확인() {
        assertThat(InputMessage.INPUT_BUDGET.getMessage())
                .isEqualTo("구입금액을 입력해 주세요.");
    }

    @Test
    void 당첨번호_입력에_대한_메시지가_정확히_들어있는지_확인() {
        assertThat(InputMessage.INPUT_WINNING_NUMBERS.getMessage())
                .isEqualTo("\n당첨 번호를 입력해 주세요.");
    }

    @Test
    void 보너스번호_입력에_대한_메시지가_정확히_들어있는지_확인() {
        assertThat(InputMessage.INPUT_BONUS_NUMBER.getMessage())
                .isEqualTo("\n보너스 번호를 입력해 주세요.");
    }
}