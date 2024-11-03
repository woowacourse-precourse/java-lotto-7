package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoMember;
import lotto.utils.constants.LottoPrize;
import lotto.view.input.ManagerInputView;
import lotto.view.input.MemberInputView;
import lotto.view.output.OutputView;

import java.util.List;

public class LottoController {

    private final MemberInputView memberInputView;
    private final ManagerInputView managerInputView;
    private final OutputView outputView;

    public LottoController() {
        this.memberInputView = new MemberInputView();
        this.managerInputView = new ManagerInputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Integer price = getPriceFromUser();
        LottoManager lottoManager = new LottoManager(price);
        Integer purchasedLottoTotal = lottoManager.purchaseLotto();
        LottoMember lottoMember = createLottoMember(lottoManager);

        displayPurchaseInformation(purchasedLottoTotal, lottoMember);

        List<Integer> lottoNumbers = getWinningNumbersFromManager();
        Integer bonusNumber = getBonusNumberFromManager();
        while (!lottoManager.validateLotto(lottoNumbers, bonusNumber)) {
            lottoNumbers = getWinningNumbersFromManager();
            bonusNumber = getBonusNumberFromManager();
        }

        List<LottoPrize> resultPrize = lottoManager.isLottoResult(lottoNumbers, bonusNumber, lottoMember.getPurchasedLotto());
        displayResults(resultPrize, lottoManager, lottoMember);
    }

    private Integer getPriceFromUser() {
        outputView.printGetPrice();
        return memberInputView.getPrice();
    }

    private LottoMember createLottoMember(LottoManager lottoManager) {
        LottoMember lottoMember = new LottoMember();
        for (Lotto lotto : lottoManager.getPurchasedLotto()) {
            lottoMember.setPurchasedLotto(lotto);
        }
        return lottoMember;
    }

    private void displayPurchaseInformation(Integer purchasedLottoTotal, LottoMember lottoMember) {
        outputView.printPurchasedLottoCount(purchasedLottoTotal);
        outputView.printLottoPurchaseList(lottoMember.getPurchasedLotto());
    }

    private List<Integer> getWinningNumbersFromManager() {
        outputView.printLottoNumber();
        return managerInputView.getLottoNumbers();
    }

    private Integer getBonusNumberFromManager() {
        outputView.printLottoBonusNumber();
        return managerInputView.getLottoBonusNumber();
    }


    private void displayResults(List<LottoPrize> resultPrize, LottoManager lottoManager, LottoMember lottoMember) {
        lottoMember.setLottoResult(resultPrize);
        double resultProfitRate = lottoManager.resultProfitRate(lottoMember.getLottoResult());
        outputView.resultStatistics(resultPrize, resultProfitRate);
    }

}
