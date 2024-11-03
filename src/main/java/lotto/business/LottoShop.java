package lotto.business;

import java.util.List;
import lotto.business.contract.ContractStrategy;
import lotto.business.issue.IssueStrategy;
import lotto.lotto.Lotto;

public class LottoShop {
    private final Money lottoPrice;
    private final ContractStrategy contractStrategy;
    private final IssueStrategy issueStrategy;

    public LottoShop(Money lottoPrice, ContractStrategy contractStrategy, IssueStrategy issueStrategy) {
        this.lottoPrice = lottoPrice;
        this.contractStrategy = contractStrategy;
        this.issueStrategy = issueStrategy;
    }

    public List<Lotto> sellLotto() {
        Money inputMoney = contractStrategy.sellLotto();
        int numOfLotto = inputMoney.divide(lottoPrice);
        List<Lotto> lotteriesBuy = issueStrategy.issueMany(numOfLotto);
        contractStrategy.printBill(lotteriesBuy);
        return lotteriesBuy;
    }
}
