package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.enums.Error.INVALID_LOTTO_NUMBER;

public class Lotto {
    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(String value) {
        try{
            String[] inputNumbers = value.split(",");

            Set<LottoNumber> winningNumbers = Arrays.stream(inputNumbers)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .map(LottoNumber::valueOf)
                    .collect(Collectors.toSet());

            return from(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
    }

    private static void validateLottoNumberCount(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public Set<LottoNumber> getValue() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
