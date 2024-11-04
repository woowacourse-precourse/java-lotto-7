package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLottoNumbers() {
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != new HashSet<>(numbers).size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가합니다.");
        }
        if(numbers.stream().anyMatch(number -> number > 45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45사이의 정수입니다.");
        }
    }

    public LottoResult getResult(int sameNumberCount, boolean hasBonus) {
        if (sameNumberCount == LottoResult.SECOND.getCount() & hasBonus){
            return LottoResult.SECOND;
        }
        for (LottoResult lottoResultValue : LottoResult.values()) {
            if (lottoResultValue.getCount().equals(sameNumberCount)){
                return lottoResultValue;
            }
        }
        return LottoResult.NONE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
