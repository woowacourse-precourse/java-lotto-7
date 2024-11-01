package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호 생성기
     * 1~45 사이의 숫자 중에서 중복 없이 6개의 번호를 랜덤으로 선택하여 반환
     * @return 중복 없는 6개의 로또 번호 리스트
     */
    private List<Integer> generateLottoNumbers() {
        // Randoms.pickUniqueNumbersInRange()를 사용해 로또 번호 생성
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    /**
     * 로또 번호 유효성 검사
     * 번호의 개수가 6개인지 확인하고, 중복 여부를 검사
     * @param numbers 검사할 로또 번호 리스트
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers; // 생성된 로또 번호 반환
    }

    // TODO: 추가 기능 구현
}
