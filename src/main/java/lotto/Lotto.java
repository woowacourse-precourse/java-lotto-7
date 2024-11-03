package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNum;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers); // 입력된 리스트를 오름차순 정렬
        this.numbers = numbers;
    }

    // 입력한 금액만큼 로또 생성
    public static List<Lotto> makeLotto(int lottoCount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto(generateRandomNum()));
        }
        return lotto;
    }

    // 로또 생성을 위한 랜덤 정수 6자리 생성
    private static List<Integer> generateRandomNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 번호를 입력하세요.");
        }

        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }
    }

    // 보너스 입력 검증
    private void validateBonusNum(int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }

        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 번호를 입력하세요.");
        }
    }
}
