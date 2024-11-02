package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validate.Validator;

import java.util.List;

public class Lotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호로 받은 것의 유효성 검사입니다.
     * 숫자가 6개가 아닌 경우
     * 숫자가 1~45사이에 있지 않은 경우
     * 숫자가 중복되는 경우
     * @param numbers
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(ErrorMessage.NOT_SIX_NUM);
        } else if (!Validator.inRangeList(MIN, MAX, numbers)) {
            throw new LottoException(ErrorMessage.NOT_IN_RANGE);
        } else if (!Validator.isNotDistinct(numbers)) {
            throw new LottoException(ErrorMessage.EXIST_NUM);
        }
    }

    /**
     * 로또의 등수를 매기는 메서드
     * @param winner 당첨 번호
     * @param bonus 보너스 번호
     * @return 순위
     */
    public Rank getRank(List<Integer> winner, int bonus) {
        int winningNumCount = countCommon(winner);

        if (winningNumCount==6) {
            return Rank.FIRST;
        } else if (winningNumCount==5) {
            if (numbers.contains(bonus)) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        } else if (winningNumCount==4) {
            return Rank.FOURTH;
        } else if (winningNumCount==3) {
            return Rank.FIFTH;
        }
        return Rank.NO_LUCK;
    }

    /**
     * 로또 번호 리스트와 파라미터의 리스트에 공통으로 있는 번호 카운트
     * @param winner 당첨 번호 리스트
     * @return 당첨 번호 개수
     */
    private int countCommon(List<Integer> winner) {
        return (int) numbers.stream().filter(winner::contains).count();
    }
}
