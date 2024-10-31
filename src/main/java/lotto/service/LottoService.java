package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.contants.value.LottoValue;
import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private List<Lotto> lottos;
    private WinningNumber winningNumber;


    public LottoService() {
        this.lottos = new ArrayList<>();
    }

    public void updateWinningNumber(List<Integer> numbers, int bonusNumber) {
        this.winningNumber = new WinningNumber(numbers, bonusNumber);
    }

    //구입한 금액에 맞게 로또 구입과 로또 번호 생성
    public void buyLotto(int payment) {
        int countLotto = payment / LottoValue.AMOUNT_UNIT;
        for (int i = 0; i < countLotto; i++) {
            lottos.add(createLotto());
        }
    }

    public Lotto createLotto() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randoms.sort(null);
        return new Lotto(randoms);
    }

    //구입한 로또 번호들과 당첨 로또 번호 매칭
    public void matchLottos() {
        for (Lotto lotto : lottos) {
            matchWinningNumbers(lotto);
        }
    }

    public void matchWinningNumbers(Lotto lotto) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        //로또 번호와 당첨 번호 교집합 리스트 구하기
        List<Integer> intersection = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .toList();

        boolean hasBonusNumber = false;
        if (intersection.size() == 5) {
            hasBonusNumber = matchBonusNumber(lottoNumbers);
        }
    }

    public boolean matchBonusNumber(List<Integer> lottoNumbers) {
        for (int num : lottoNumbers) {
            if (num == winningNumber.getBonusNumber()) {
                return true;
            }
        }
        return false;
    }

}
