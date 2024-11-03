package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.converter.IntegersToLottoNumbersConverter;
import lotto.converter.LottoNumbersConverter;
import lotto.converter.StringsToLottoNumbersConverter;
import lotto.settings.LottoSettings;
import lotto.util.StringUtil;

public class Lotto {
    private static final String DELIMITER = ",";

    private final Set<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = toSet(numbers);
        validateSize();
        validDuplicate(numbers);
    }

    private static Set<LottoNumber> toSet(List<LottoNumber> numbers) {
        return new HashSet<>(numbers);
    }

    private void validateSize() {
        if (numbers.size() != LottoSettings.SIZE.value()) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validDuplicate(List<LottoNumber> inputNumbers) {
        if (inputNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되어서는 안됩니다.");
        }
    }

    public Lotto(LottoNumbersConverter converter) {
        this(converter.convert());
    }

    public static Lotto fromString(String value) {
        return new Lotto(new StringsToLottoNumbersConverter(StringUtil.converList(value, DELIMITER)));
    }

    public static Lotto fromIntegers(List<Integer> value) {
        return new Lotto(new IntegersToLottoNumbersConverter(value));
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.numbers.stream().filter(this::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public List<Integer> toIntList() {
        return new ArrayList<>(intList());
    }

    private List<Integer> intList() {
        return this.numbers.stream().map(LottoNumber::value).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
