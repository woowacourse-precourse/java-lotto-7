package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }

    public List<Integer> getLottoNumbers (){
        return numbers;
    }

    public Boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int getSameCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateLottoCountSize(numbers);
        validateDuplication(numbers);
    }

    private void validateLottoCountSize(List<Integer> numbers) {
        if (isLottoCountSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers){
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    private boolean isLottoCountSize (List<Integer> numbers) {
        return numbers.size() != LottoPublisher.LOTTO_COUNT_SIZE;
    }

    private boolean isDuplication (List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
