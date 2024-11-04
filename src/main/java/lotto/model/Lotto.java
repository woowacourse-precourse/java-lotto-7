package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private static final List<Rank> POINTTORANK = // 포인트를 순위와 연결시키기 위한 리스트
            List.of(Rank.NO_LUCK, Rank.NO_LUCK, Rank.NO_LUCK,
                    Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    /**
     * 로또 번호로 받은 것의 유효성 검사입니다.
     * 숫자가 6개가 아닌 경우
     * 숫자가 1~45사이에 있지 않은 경우
     * 숫자가 중복되는 경우
     *
     * @param numbers
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoException(ErrorMessage.NOT_SIX_NUM);
        } else if (!Validator.inRangeList(numbers)) {
            throw new LottoException(ErrorMessage.NOT_IN_RANGE);
        } else if (!Validator.isNotDistinct(numbers)) {
            throw new LottoException(ErrorMessage.EXIST_NUM);
        }
    }

    /**
     * 로또의 등수를 매기는 메서드
     *
     * @param winner 당첨 번호
     * @param bonus  보너스 번호
     * @return 순위
     */
    public Rank getRank(Lotto winner, int bonus) {
        int point = countMatch(winner.getNumbers());

        // 1등인 경우 1등에 맞춰주기 위해 1포인트 더해줌
        if (isFirst(point)) {
            point++;
        }
        // 2등인 경우 3등과 달라야하기 때문에 1포인트 더해줌
        if (isSecond(point, bonus)) {
            point++;
        }

        return POINTTORANK.get(point);
    }

    /**
     * 로또 번호 리스트와 파라미터의 리스트에 공통으로 있는 번호 카운트
     *
     * @param winner 당첨 번호 리스트
     * @return 당첨 번호 개수
     */
    private int countMatch(List<Integer> winner) {
        return (int) numbers.stream().filter(winner::contains).count();
    }

    /**
     * 1등 판별
     *
     * @param point 현재 포인트
     * @return 1등이면 true
     */
    private boolean isFirst(int point) {
        return point == NUMBER_COUNT;
    }

    /**
     * 2등 판별
     *
     * @param point 현재 포인트
     * @param bonus 보너스 번호
     * @return 2등이면 true
     */
    private boolean isSecond(int point, int bonus) {
        return point == NUMBER_COUNT - 1 && Validator.isContain(bonus, numbers);
    }

    /**
     * 로또 번호 리스트 가져오기
     *
     * @return 로또 번호 리스트
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}
