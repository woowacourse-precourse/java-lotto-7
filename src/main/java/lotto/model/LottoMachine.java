package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final int MAX = 45;
    private final int MIN = 1;
    private final int COUNT = 6;
    private final int MAX_PRICE = 100_000;
    private final int PRICE = 1_000;

    private List<Lotto> lottos;
    private Lotto winner;
    private int bonus;

    public LottoMachine() {
        lottos = new ArrayList<>();
    }

    /**
     * 당첨 번호와 보너스 번호 넣기
     *
     * @param winner 당첨 번호
     * @param bonus  보너스 번호
     */
    public void init(List<Integer> winner, int bonus) {
        this.winner = new Lotto(winner);
        this.bonus = bonus;
        validateWinner(winner, bonus);
    }

    /**
     * 보너스 번호 유효성 검사
     *
     * @param winner 당첨 번호
     * @param bonus  보너스 번호
     */
    private void validateWinner(List<Integer> winner, int bonus) {
        if (!Validator.inRange(bonus)) {
            throw new LottoException(ErrorMessage.NOT_IN_RANGE);
        } else if (Validator.isContain(bonus, winner)) {
            throw new LottoException(ErrorMessage.EXIST_NUM);
        }
    }

    /**
     * 로또 구매
     *
     * @param money 로또를 구매할 돈
     */
    public void buyLotto(int money) {
        validatePrice(money);

        int lottoCount = money / PRICE;

        for (int i = 0; i < lottoCount; i++) {
            addLotto(generateNumber());
        }
    }

    /**
     * 금액 유효성 검사
     *
     * @param money
     */
    private void validatePrice(int money) {
        if (Validator.isOver(money, MAX_PRICE)) {
            throw new LottoException(ErrorMessage.ILLEGAL_GAMBLING);
        } else if (!Validator.isMulti(money, PRICE)) {
            throw new LottoException(ErrorMessage.UNDIVIDED_THOUSAND);
        }
    }

    /**
     * 1~45 숫자 중복없이 6개 생성
     *
     * @return 6개 숫자 리스트
     */
    private List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }

    /**
     * 로또 추가
     *
     * @param nums 추가시킬 로또 번호
     */
    private void addLotto(List<Integer> nums) {
        lottos.add(new Lotto(nums));
    }

    /**
     * 모든 로또 번호 반환
     *
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
     *
     * @return 로또 결과
     */
    public Result getResult() {
        Result result = new Result();

        initValidate();
        for (Lotto lotto : lottos) {
            result.add(lotto.getRank(winner, bonus));
        }

        return result;
    }

    /**
     * 당첨 번호, 보너스 번호, 로또가 설정되었는지 확인
     */
    private void initValidate() {
        if (lottos.isEmpty() || Objects.isNull(winner) || bonus == 0) {
            throw new LottoException(ErrorMessage.NOT_INIT_STATE);
        }
    }
}
