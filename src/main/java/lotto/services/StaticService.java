package lotto.services;

import lotto.models.Bonus;
import lotto.models.IssueModel;
import lotto.models.Lotto;
import lotto.models.StaticModel;
import lotto.views.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StaticService {
    private final OutputView outputView;
    private final IssueModel issueModel;
    private final Lotto lottoModel;
    private final Bonus bonusModel;


    public StaticService(OutputView outputView, IssueModel issueModel, Lotto lottoModel, Bonus bonusModel) {
        this.outputView = outputView;
        this.issueModel = issueModel;
        this.lottoModel = lottoModel;
        this.bonusModel = bonusModel;
    }

    public void calculateStatic() {
        ArrayList<ArrayList<Integer>> allIssuedLottos = issueModel.getAllIssuedLottos();

        List<Integer> winningLottoNumbers = lottoModel.getLotto();
        int bonusNumber = bonusModel.getBonusNumber();

        StaticModel staticModel = new StaticModel(allIssuedLottos, winningLottoNumbers, bonusNumber);

        outputView.displayLottoStatic(staticModel.getPrizeStatic());
    }
}
