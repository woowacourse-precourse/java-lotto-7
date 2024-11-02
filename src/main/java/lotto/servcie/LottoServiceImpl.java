package lotto.servcie;

import lotto.model.*;
import lotto.model.outcome.CountByPrizeGrade;
import lotto.model.outcome.LottoBenefitRate;
import lotto.model.outcome.LottoResult;
import lotto.model.condition.SpendingMoney;
import lotto.model.winlotto.WinLotto;
import lotto.repository.Repository;

public class LottoServiceImpl implements LottoService {
    
    private final Repository repository;
    
    public LottoServiceImpl(Repository repository) {
        this.repository = repository;
    }
    
    @Override
    public void buyLotto(SpendingMoney money) {
        BoughtLottos boughtLottos = BoughtLottos.getInstance(money);
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
