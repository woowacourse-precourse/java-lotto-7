package lotto.util.generator;

import static lotto.value.LottoValue.END_NUMBER_INCLUSIVE;
import static lotto.value.LottoValue.NUMBER_COUNT;
import static lotto.value.LottoValue.START_NUMBER_INCLUSIVE;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class RandomLottoGenerator implements LottoGenerator {

    private final NumberGenerator numberGenerator;

    public RandomLottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto generate() {
        List<Integer> numbers = numberGenerator.generateUniqueNumbersInRange(
                START_NUMBER_INCLUSIVE.value(),
                END_NUMBER_INCLUSIVE.value(),
                NUMBER_COUNT.value());
        return new Lotto(numbers);
    }

    public List<Lotto> generateByCount(int count) {
        return Stream.generate(this::generate)
                .limit(count)
                .toList();
    }

}
