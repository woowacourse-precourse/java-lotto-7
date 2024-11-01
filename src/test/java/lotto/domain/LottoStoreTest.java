package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoPaper;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    void 구매금액이_천원미만이면_예외를_발생시킨다() {
        LottoStore store = new LottoStore(new LottoNumberGeneratorFake());
        assertThatIllegalArgumentException().isThrownBy(() -> store.buy(new Won(999)));
    }

    @Test
    void 구매금액이_천원단위가_아니면_예외를_발생시킨다() {
        LottoStore store = new LottoStore(new LottoNumberGeneratorFake());
        assertThatIllegalArgumentException().isThrownBy(() -> store.buy(new Won(1001)));
    }

    @Test
    void 천원단위로_로또들을_발급한다() {
        int amount = 2000;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoStore store = new LottoStore(new LottoNumberGeneratorFake(numbers));

        LottoPaper lottoPaper = store.buy(new Won(amount));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount / 1000; i++) {
            lottos.add(Lotto.fromIntegers(numbers));
        }
        assertThat(lottoPaper).isEqualTo(new LottoPaper(new Won(amount), lottos));
    }


    private static class LottoNumberGeneratorFake implements LottoNumberGenerator {
        private static final List<Integer> DEFAULT_RESULT = List.of(1, 2, 3, 4, 5, 6);
        private final List<Integer> result;

        public LottoNumberGeneratorFake(List<Integer> result) {
            this.result = result;
        }

        public LottoNumberGeneratorFake() {
            this(DEFAULT_RESULT);
        }


        @Override
        public List<Integer> generate() {
            return result;
        }
    }
}
