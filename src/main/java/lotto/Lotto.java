package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ErrorMessages;

/**
 * 로또 클래스
 * 로또 번호 리스트를 저장하고 유효성 검증을 수행하는 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    /**
     * Lotto 생성자
     * 생성된 로또 번호 리스트를 초기화하여 유효성을 검증 후 오름차순으로 정렬하여 저장
     *
     * @param numbers 로또 번호 리스트 (중복되지 않는 6개의 번호)
     */
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    /**
     * 로또 번호 리스트의 유효성을 검증한다.
     * 번호의 개수가 6개인지, 중복이 없는지, 1~45 범위 내에 있는지를 확인한다.
     *
     * @param numbers 로또 번호 리스트
     * @throws IllegalArgumentException 유효하지 않은 번호가 포함된 경우
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_INVALID_COUNT.getMessage());
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessages. LOTTO_NUMBER_DUPLICATE.getMessage());
        }
        if (!isWithRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    /**
     * 번호 리스트에 중복이 있는지 확인
     *
     * @param numbers 로또 번호 리스트
     * @return 중복이 있는 경우 true, 없는 경우 false
     */
    private boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    /**
     * 번호 리스트가 1~45 범위 내에 있는지 확인
     *
     * @param numbers 로또 번호 리스트
     * @return 모든 번호가 범위 내에 있으면 true, 아니면 false
     */
    private boolean isWithRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    /**
     * 로또 번호 리스트를 반환
     *
     * @return 오름차순으로 정렬된 로또 번호 리스트
     */
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
