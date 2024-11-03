package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private static final int LOTTO_SIZE = 6; // 로또 번호 개수
    private static final int MIN_NUMBER = 1; // 로또 번호 최소값
    private static final int MAX_NUMBER = 45; // 로또 번호 최대값

    private final List<Integer> numbers; // 로또 번호 리스트

    public Lotto(List<Integer> numbers) {
        validateLottoNum(numbers); // 로또 번호 검증
        this.numbers = new ArrayList<>(numbers); // 번호 리스트 복사
        Collections.sort(this.numbers); // 오름차순 정렬
    }

    public static List<Lotto> makeLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>(); // 로또 리스트 초기화
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateRandNum())); // 랜덤 번호로 로또 생성
        }
        return lottos; // 생성된 로또 리스트 반환
    }

    private static List<Integer> generateRandNum() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE); // 중복 없는 6개의 랜덤 번호 생성
    }

    public List<Integer> getNumbers() {
        return numbers; // 로또 번호 반환
    }

    private void validateLottoNum(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) { // 번호 개수 확인
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers); // 중복 확인
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 번호를 입력하세요.");
        }

        if (numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)) { // 번호 범위 확인
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }
    }
}
