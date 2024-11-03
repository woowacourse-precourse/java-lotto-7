package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lottos;
    private final Lotto winner;
    private final int bonus;

    LottoMachine(List<Integer> winner, int bonus) {
        this.winner = new Lotto(winner);
        this.lottos = new ArrayList<>();
        this.bonus = bonus;
        validate(winner, bonus);
    }

    /**
     * 보너스 번호 유효성 검사
     * @param winner 당첨 번호
     * @param bonus 보너스 번호
     */
    private void validate(List<Integer> winner, int bonus) {
        if (!Validator.inRange(bonus)) {
            throw new LottoException(ErrorMessage.NOT_IN_RANGE);
        } else if (!Validator.isNotContain(bonus, winner)) {
            throw new LottoException(ErrorMessage.EXIST_NUM);
        }
    }

    /**
     * 로또 추가
     * @param nums 추가시킬 로또 번호
     */
    public void addLotto(List<Integer> nums) {
        lottos.add(new Lotto(nums));
    }

    /**
     * 모든 로또 번호 반환
     * @return 로또 번호 2차원 리스트
     */
    public List<List<Integer>> getLottoNums() {
        List<List<Integer>> lottoNums = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoNums.add(lotto.getNumbers());
        }

        return lottoNums;
    }

    /**
     * 로또 결과 반환
     * @return 로또 결과
     */
    public Result getResult() {
        Result result = new Result();

        for (Lotto lotto : lottos) {
            result.add(lotto.getRank(winner, bonus));
        }

        return result;
    }
}
