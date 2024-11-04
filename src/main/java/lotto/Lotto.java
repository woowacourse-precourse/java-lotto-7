package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final int FIRST_PRIZE = 2000_000_000; // 1등 당첨금
    private final int SECOND_PRIZE = 30_000_000; // 2등 당첨금
    private final int THIRD_PRIZE = 1_500_000; // 3등 당첨금
    private final int FOURTH_PRIZE = 50_000; // 4등 당첨금
    private final int FIFTH_PRIZE = 5_000; // 5등 당첨금

    private List<Integer> numbers; // 사용자 입력 로또번호
    private int bounsNumber; // 사용자 입력 보너스 번호

    private List<Integer> lottoNumbers; // 당첨 로또 번호
    private int lottoBonusNumber; // 당첨 보너스 번호
    private int reward; // 당첨금

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers); // 유저가 입력한 로또번호 유효성 검사
        this.numbers = numbers;
        this.bounsNumber = bonusNumber;

        lottoNumberGenerator(); // 로또 번호, 보너스번호 생성
        int matchCount = numbersMatcher(numbers, lottoNumbers); // 로또 번호 당첨개수
        boolean isBonusMatched = bonusNumberMatcher(bonusNumber); // 보너스 번호 당첨여부

        calculateReward(matchCount, isBonusMatched); // 당첨금 계산
    }

    // 로또 번호 개수 유효성 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호, 보너스 번호 생성
    private void lottoNumberGenerator() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        System.out.println("[result] 발행한 로또번호: " + lottoNumbers);

        lottoBonusNumber = Randoms.pickNumberInRange(1,45);
        System.out.println("[result] 발행한 보너스 번호: " + lottoNumbers);
    }

    // 로또번호 당첨여부 조회
    private int numbersMatcher(List<Integer> numbers, List<Integer> lottoNumbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }

        System.out.println("[result] 일치하는 번호의 개수: " + matchCount);
        return matchCount;
    }

    // 보너스번호 당첨여부 조회
    private boolean bonusNumberMatcher(int bonusNumber) {
        return bonusNumber == lottoBonusNumber;
    }

    // 등수별 상금
    private void calculateReward(int matchCount, boolean isBonusMatched){
        if (matchCount == 6) {
            reward = FIRST_PRIZE;
        } else if (matchCount == 5 && isBonusMatched) {
            reward = SECOND_PRIZE;
        } else if (matchCount == 5) {
            reward = THIRD_PRIZE;
        } else if (matchCount == 4) {
            reward = FOURTH_PRIZE;
        } else if (matchCount == 3) {
            reward = FIFTH_PRIZE;
        } else {
            reward = 0;
        }
    }

    // reward getter 메서드
    public int getReward() {
        return reward;
    }

}
