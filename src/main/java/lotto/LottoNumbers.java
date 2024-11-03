package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers from(String value) {
        String[] inputNumbers = value.split(",");

        Set<LottoNumber> winningNumbers = Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        return from(winningNumbers);
    }

    private static void validate(Set<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
    }

    private static void validateLottoNumberCount(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 6개의 정수여야 합니다.");
        }
    }

    public Set<LottoNumber> getValue() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
