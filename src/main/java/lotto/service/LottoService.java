package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.contants.value.LottoValue;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PrizeNumber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private List<Lotto> lottos;
    private final PrizeNumber prizeNumber;
    private final LottoResult lottoResult;


    public LottoService() {
        this.lottos = new ArrayList<>();
        this.prizeNumber = new PrizeNumber();
        this.lottoResult = new LottoResult();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult getLottoResult() {
        return this.lottoResult;
    }

    public int calculPayment(int payment) {
        return payment / LottoValue.PRICE_UNIT.getValue();
    }

    //구입한 금액에 맞게 로또 구입과 로또 번호 생성
    public void buyLotto(int countLotto) {
        for (int i = 0; i < countLotto; i++) {
            lottos.add(createLotto());
        }
    }

    public Lotto createLotto() {
        List<Integer> randoms = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(randoms);
        return new Lotto(randoms);
    }

    public void updateWinningNumber(List<Integer> numbers, int bonusNumber) {
        prizeNumber.updateNumbersAndBonusNumber(numbers, bonusNumber);
    }

    //구입한 로또 번호들과 당첨 로또 번호 매칭
    public void matchLottos() {
        for (Lotto lotto : lottos) {
            matchPrizeNumbers(lotto);
        }
    }

    public void matchPrizeNumbers(Lotto lotto) {
        List<Integer> prizeNumbers = prizeNumber.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        //로또 번호와 당첨 번호 교집합 리스트 구하기 - 로또 번호 보존을 위해 filter 사용
        List<Integer> intersection = lottoNumbers.stream()
                .filter(prizeNumbers::contains)
                .toList();

        matchRankAndUpdateRankSize(intersection, lottoNumbers);
    }

    public boolean matchBonusNumber(List<Integer> lottoNumbers) {
        for (int num : lottoNumbers) {
            if (num == prizeNumber.getBonusNumber()) {
                return true;
            }
        }
        return false;
    }

    public void matchRankAndUpdateRankSize(List<Integer> intersection, List<Integer> lottoNumbers) {
        int sameSize = intersection.size();
        if (sameSize == 6) {
            lottoResult.updateLottoRankSize(1);
        }
        if (sameSize == 5 && matchBonusNumber(lottoNumbers)) {
            lottoResult.updateLottoRankSize(2);
        }
        if (sameSize == 5 && !matchBonusNumber(lottoNumbers)) {
            lottoResult.updateLottoRankSize(3);
        }
        if (sameSize == 4) {
            lottoResult.updateLottoRankSize(4);
        }
        if (sameSize == 3) {
            lottoResult.updateLottoRankSize(5);
        }
    }

    public double calculRate(int payment) {
        int prizeMoney = lottoResult.calculPrizeMoney();
        double rate = (double) prizeMoney / payment * 100;
        return Math.round(rate * 100) / 100.0;
    }
}
