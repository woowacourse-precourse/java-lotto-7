package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator implements Validator<List<Integer>> {

    @Override
    public boolean validate(List<Integer> value) {
        if (value.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i) < 1 || value.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
            }
            if (i < value.size() - 1) {
                if (value.get(i) > value.get(i + 1)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 오름차순으로 정렬되어야 합니다.");
                }
            }
            numbers.add(value.get(i));
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        return true;
    }
}
