package lotto.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ErrorStatus;

public class Lottos {

    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buyLottos(Long money) {
        validateMoney(money);
        int numberOfLottos = (int) (money / 1000);
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void setWinningNumbers(List<Integer> numbers, Integer bonus) {
        validateWinningNumbers(numbers, bonus);
        this.winningNumbers = numbers;
        this.bonusNumber = bonus;
    }

    private void validateMoney(Long money) {
        // 구입 금액이 int 형을 초과하는 경우
        if (money > 2147483000) {
            throw new IllegalArgumentException(ErrorStatus.MONEY_OUT_OF_RANGE.getMessage());
        }

        // 로또 구입 금액이 1,000원 단위가 아닌 경우
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_MONEY_AMOUNT.getMessage());
        }
    }

    private void validateWinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        // 로또 개수 체크
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_COUNT_OF_LOTTO_NUMBERS.getMessage());
        }
    }
}