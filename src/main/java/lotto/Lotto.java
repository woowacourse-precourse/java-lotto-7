package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // 사용자 입력 로또번호
    private final List<Integer> lottoNumbers; // 당첨 로또 번호

    public Lotto(List<Integer> numbers) {
        validate(numbers); // 유저가 입력한 로또번호 유효성 검사
        this.numbers = numbers;
        this.lottoNumbers = lottoNumberGenerator(); // 로또 번호 생성

        System.out.println("발행한 로또번호: " + lottoNumbers);
    }

    // 로또 번호 개수 유효성 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호 생성
    private List<Integer> lottoNumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
