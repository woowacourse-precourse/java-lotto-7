package lotto.model.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("사용자의 로또를 관리하는 객체 테스트")
class LottosTest {

    @Test
    public void 로또_개수_입력시_지정된_개수_로또_생성() {
        // given
        int amount = 5;

        // when
        Lottos lottos = Lottos.from(amount);

        // then
        Assertions.assertThat(lottos.size()).isEqualTo(amount);
    }

    @RepeatedTest(5)
    public void 로또_생성시_중복_없는_로또_생성() {
        // given
        int amount = 10;

        // when
        Lottos lottos = Lottos.from(amount);

        // then
        Assertions.assertThat(lottos.getLottos()).allSatisfy(lotto -> {
            Assertions.assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
        });
    }

    @RepeatedTest(5)
    public void 로또_생성시_범위_안의_로또_생성() {
        // given
        int amount = 10;

        // when
        Lottos lottos = Lottos.from(amount);

        // then
        Assertions.assertThat(lottos.getLottos()).allSatisfy(lotto -> {
            Assertions
                    .assertThat(lotto.getNumbers())
                    .allMatch(number -> (1 <= number && number <= 45));
        });
    }

    @RepeatedTest(5)
    public void 생성된_로또_오름차순_확인() {
        // given
        int amount = 10;

        // when
        Lottos lottos = Lottos.from(amount);

        // then
        Assertions.assertThat(lottos.getLottos()).allSatisfy(lotto -> {
            Assertions
                    .assertThat(lotto.getNumbers())
                    .isSorted();
        });
    }
}
