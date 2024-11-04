package lotto.service.domain.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> lottoticket;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoticket = makeLotto(numbers);
    }

    private Set<LottoNumber> makeLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateduplicate(numbers);
    }

    private void validateduplicate(List<Integer> numbers) {
        Long duplicateCount = numbers.stream()
                .distinct()
                .count();
        if (Long.compare(duplicateCount, numbers.size()) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 값이 있습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean checkBonusNumberDuplicate(LottoNumber bonusNumber) {
        return lottoticket.contains(bonusNumber);
    }

    public Set<LottoNumber> getLottoticket() {
        return lottoticket;
    }
}
