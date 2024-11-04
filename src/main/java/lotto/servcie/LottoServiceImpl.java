package lotto.servcie;

import lotto.model.*;
import lotto.model.outcome.CountByPrizeGrade;
import lotto.model.outcome.LottoBenefitRate;
import lotto.model.outcome.LottoResult;
import lotto.model.condition.SpendingMoney;
import lotto.model.winlotto.WinLotto;
import lotto.repository.Repository;

/**
 * controller로부터 전달 받은 모델을 가지고 주요 결과를 만들어서
 * repository에 저장한다. controller로부터 요청을 받아서 repository에
 * 저장한 값을 불러와서 반환한다.
 */
public class LottoServiceImpl implements LottoService {
    
    private final Repository repository;
    
    public LottoServiceImpl(Repository repository) {
        this.repository = repository;
    }
    
    @Override
    public void buyLotto(SpendingMoney money) {
        BoughtLottos boughtLottos = BoughtLottos.getOfSpendingMoney(money);
        repository.saveLottos(boughtLottos);
    }
    
    @Override
    public BoughtLottos getLottos() {
        return repository.getLottos();
    }
    
    @Override
    public void createWinStatistics(BoughtLottos boughtLottos, WinLotto winLotto) {
        CountByPrizeGrade countByPrizeGrade =
                CountByPrizeGrade.getOfBoughtAndWinLotto(boughtLottos, winLotto);
        LottoBenefitRate rate =
                LottoBenefitRate.getOfCountByGradeAndSpendMoney(countByPrizeGrade,
                        boughtLottos.getSpendMoney());
        LottoResult result =
                LottoResult.getOfCountGradeAndBenefitRate(countByPrizeGrade, rate);
        repository.saveResult(result);
    }
    
    @Override
    public LottoResult getResult() {
        return repository.getResult();
    }

}
