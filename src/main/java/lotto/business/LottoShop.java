package lotto.business;

import java.util.List;
import lotto.business.contract.ContractStrategy;
import lotto.business.draw.DrawStrategy;
import lotto.business.issue.IssueStrategy;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;

public class LottoShop {
    private final Money lottoPrice;
    private final ContractStrategy contractStrategy;
    private final IssueStrategy issueStrategy;
    private final DrawStrategy drawStrategy;

    public LottoShop(Money lottoPrice,
                     ContractStrategy contractStrategy, IssueStrategy issueStrategy, DrawStrategy drawStrategy) {
        this.lottoPrice = lottoPrice;
        this.contractStrategy = contractStrategy;
        this.issueStrategy = issueStrategy;
        this.drawStrategy = drawStrategy;
    }

    public List<Lotto> sellLotto() {
        Money inputMoney = contractStrategy.sellLotto();
        int numOfLotto = inputMoney.divide(lottoPrice);
        List<Lotto> lotteriesBuy = issueStrategy.issueMany(numOfLotto);
        contractStrategy.printBill(lotteriesBuy);
        return lotteriesBuy;
    }

    public LottoResult draw() {
        return drawStrategy.draw();
    }
}
