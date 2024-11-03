package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;
    private int bonusNum;

    public Lotto(List<Integer> numbers) {
        validateLottoNum(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers); // 입력된 리스트를 오름차순 정렬
    }

    // 입력한 금액만큼 로또 생성
    public static List<Lotto> makeLotto(int lottoCount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto(generateRandNum()));
        }
        return lotto;
    }

    // 로또 생성을 위한 랜덤 정수 6자리 생성
    private static List<Integer> generateRandNum() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
    }

    // 보너스번호 설정
    public void setBonusNum(int bonusNum) {
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    // 객체의 번호 반환
    public List<Integer> getNumbers() {
        return numbers;
    }

    // 객체의 보너스번호 반환
    public int getBonusNum() {
        return bonusNum;
    }

    // 당첨번호 입력 검증
    private void validateLottoNum(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 번호를 입력하세요.");
        }

        if (numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }
    }

    // 보너스 입력 검증
    private void validateBonusNum(int bonusNum) {
        if (bonusNum < MIN_NUMBER || bonusNum > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }

        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 번호를 입력하세요.");
        }
    }
}
