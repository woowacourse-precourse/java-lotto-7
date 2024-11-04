package lotto;

import java.util.List;
import lotto.enums.Prize;

/**
 * class: WinningLotto.
 *
 * 당첨 번호와 보너스 번호를 관리하는 클래스
 * @author JBum
 * @version 2024/11/04
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    /**
     * 당첨 번호와 보너스 번호로 당첨 로또를 생성한다.
     *
     * @param numbers 당첨 번호 리스트
     * @param bonusNumber 보너스 번호
     * @throws IllegalArgumentException 유효하지 않은 번호가 있는 경우
     * @throws IllegalArgumentException 보너스 번호가 당첨 번호와 중복되는 경우
     */
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    /**
     * 보너스 번호의 유효성을 검증한다.
     * 보너스 번호는 1-45 사이의 숫자여야 하고, 당첨 번호와 중복되지 않아야 한다.
     *
     * @param numbers 당첨 번호 리스트
     * @param bonusNumber 검증할 보너스 번호
     * @throws IllegalArgumentException 유효하지 않은 보너스 번호인 경우
     */
    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(numbers, bonusNumber);
    }

    /**
     * 보너스 번호가 1-45 사이의 숫자인지 검증한다.
     *
     * @param bonusNumber 검증할 보너스 번호
     * @throws IllegalArgumentException 범위를 벗어난 번호인 경우
     */
    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoMachine.MIN_LOTTO_NUMBER
                || bonusNumber > LottoMachine.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 보너스 번호가 당첨 번호와 중복되지 않는지 검증한다.
     *
     * @param numbers 당첨 번호 리스트
     * @param bonusNumber 검증할 보너스 번호
     * @throws IllegalArgumentException 당첨 번호와 중복되는 경우
     */
    private void validateBonusNumberDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    /**
     * 사용자의 로또와 당첨 번호를 비교하여 당첨 등수를 반환한다.
     *
     * @param userLotto 사용자의 로또
     * @return 당첨 등수
     */
    public Prize match(Lotto userLotto) {
        int matchCount = lotto.countMatchingNumbers(userLotto);
        boolean matchBonus = userLotto.hasNumber(bonusNumber);
        return Prize.valueOf(matchCount, matchBonus);
    }
}