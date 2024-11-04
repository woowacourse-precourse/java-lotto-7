package lotto.service;

import lotto.data.Lotto;
import lotto.constants.Value;
import lotto.data.Database;
import lotto.data.Result;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class LottoMachine {

    private final Database database;

    public LottoMachine() {
        database = new Database();
    }

    public void buyLotto(Long money) {
        Long lottoCount = money / Value.lottoPrice;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = pickUniqueNumbersInRange(Value.lottoStartNumber, Value.lottoEndNumber, Value.lottoNumberCount);
            database.purchaseLottoList.add(new Lotto(lottoNumber));
        }
    }

    public List<Lotto> getPurchasedLotto() {
        return database.purchaseLottoList;
    }

    public void calculateResult(List<Integer> winningNumber, Integer bonusNumber) {
        Result result = database.result;
        for (Lotto lotto : database.purchaseLottoList) {
            long overLab = lotto.getNumbers().stream()
                    .filter(winningNumber::contains)
                    .count();
            addCount(result, overLab, lotto.getNumbers().contains(bonusNumber));
        }
    }

    public void addCount(Result result, long overLab, Boolean bonus) {
        if (overLab == 6) {
            result.addSixNumberMatch();
        } else if (overLab == 5 && bonus) {
            result.addBonusNumberMatch();
        } else if (overLab == 5) {
            result.addFiveNumberMatch();
        } else if (overLab == 4) {
            result.addFourNumberMatch();
        } else if (overLab == 3) {
            result.addThreeNumberMatch();
        }
    }

    public Result getResult() {
        return database.result;
    }

    public Long getPurchaseMoney() {
        return database.purchaseLottoList.size() * Value.lottoPrice;
    }
}
