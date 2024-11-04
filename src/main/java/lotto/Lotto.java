package lotto;

import lotto.dto.request.LottoMatchRequest;
import lotto.dto.response.LottoMatchResponse;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다..");
        }
    }

    public void bonusNumberValidate(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 숫자는 중복될 수 없습니다.");
        }
    }

    public LottoMatchResponse matchNumberCount(LottoMatchRequest lottoResultRequest) {
        int matchCount = (int) lottoResultRequest.numbers().stream()
                .filter(numbers::contains)
                .count();

        boolean isBonusMatch = numbers.contains(lottoResultRequest.bonusNumber());

        return new LottoMatchResponse(matchCount, isBonusMatch);
    }
}
