package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

/**
 * class: LottoMachine.
 *
 * 로또를 생성하는 기계를 의미하는 객체
 * @author JBumLee
 * @version 2024/11/04
 */
public class LottoMachine {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    /**
     * 유틸리티 클래스의 인스턴스화 방지
     */
    private LottoMachine() {
    }

    /**
     * 1부터 45까지의 숫자 중 6개를 랜덤하게 선택하여 로또를 생성합니다.
     * 선택된 숫자들은 오름차순으로 정렬됩니다.
     *
     * @return 생성된 로또 객체
     */
    public static Lotto generateLotto() {
        List<Integer> numbers = generateNumbers();
        sortNumbers(numbers);
        return new Lotto(numbers);
    }

    /**
     * 1부터 45까지의 숫자 중 중복없이 6개를 랜덤하게 선택합니다.
     *
     * @return 선택된 6개의 숫자 리스트
     */
    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_SIZE
        );
    }

    /**
     * 주어진 리스트의 숫자들을 오름차순으로 정렬합니다.
     *
     * @param numbers 정렬할 숫자들이 담긴 리스트
     */
    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}