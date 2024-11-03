package lotto;

import java.util.List;

/**
 * 로또 번호를 처리하는 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    /**
     * 당첨금 리스트
     */
    public static final List<Integer> PRIZE_MONEY = List.of(2000000000, 30000000, 1500000, 50000, 5000);

    public static final List<String> PRIZE_MONEY_WITH_COMMA = lotto.Lotto.PRIZE_MONEY.stream().map(lotto.Lotto::getNumberWithComma)
            .toList();

    /**
     * 예외처리 후 번호를 저장
     *
     * @param numbers 번호를 포함한 List
     */
    public Lotto(List<Integer> numbers) {
        exception.Handler.isValid(numbers);
        this.numbers = numbers;
    }

    /**
     * 보너스 번호와 로또 번호가 중복되면 예외 처리
     *
     * @param lotto       로또 번호
     * @param bonusNumber 보너스 번호 입력
     */
    static void checkBonusNumber(Lotto lotto, int bonusNumber) {
        for (int number : lotto.numbers) {
            if (bonusNumber == number) {
                exception.Handler.raiseException(number);
            }
        }
    }

    /**
     * 로또 리스트에서 각 로또의 번호를 출력
     *
     * @param lottos 로또 리스트
     */

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            io.Print.print(lotto.numbers.toString());
        }
    }

    /**
     * 로또 가격
     */
    public class Price {
        public final static int PRICE = 1000;
    }

    /**
     * 로또 등수
     */
    public enum Rank {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE
    }

    /**
     * 로또 등수를 반환
     *
     * @param lotto        체크할 로또
     * @param winningLotto 당첨 번호
     * @param bonusNumber  보너스 번호
     * @return 등수
     */
    public static Rank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int count = lotto.numbers.stream().filter(x -> winningLotto.numbers.contains(x)).toList().size();
        List<Rank> ranks = List.of(Rank.NONE, Rank.NONE, Rank.NONE, Rank.FIFTH, Rank.FOURTH, Rank.NONE, Rank.FIRST);
        if (count == 5 && lotto.numbers.contains(bonusNumber)) {
            return Rank.SECOND;
        }
        if (count == 5 && !lotto.numbers.contains(bonusNumber)) {
            return Rank.THIRD;
        }
        return ranks.get(count);
    }

    /**
     * 정수를 ,로 포맷한 문자열로 반환 (10000000 -> 10,000,000)
     *
     * @param number 반환할 정수
     * @return 반환된 문자열
     */
    public static String getNumberWithComma(int number) {
        return String.format("%,d", number);
    }
}