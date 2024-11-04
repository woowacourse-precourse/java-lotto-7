package lotto.lottoapp.model.value;

import java.util.List;
import java.util.stream.Stream;

public record LottoNumbers(List<LottoNumber> lottoNumbers) {

    public static final int SIZE_OF_NUMBERS = 6;

    public LottoNumbers {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("null을 지정할 수 없습니다.");
        }
        if (lottoNumbers.size() != SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException(String.format("정상적인 로또 번호의 개수는 %d입니다.", SIZE_OF_NUMBERS));
        }
        if (isNumbersDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }

        lottoNumbers = List.copyOf(lottoNumbers.stream()
                .sorted()
                .toList());
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList());
    }

    public boolean contains(LottoNumber otherNumber) {
        return lottoNumbers.contains(otherNumber);
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    private static boolean isNumbersDuplicated(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .distinct()
                .count();
    }

}
