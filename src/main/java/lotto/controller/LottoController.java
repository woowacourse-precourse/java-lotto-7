package lotto.controller;

import lotto.model.*;
import lotto.dto.BonusNumberDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.WinningLotteryDto;
import lotto.utils.LottoUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void start() {
        Purchase purchase = receiveValidPurchase();
        MyLottoInfo myLottoInfo = prepareLottoInfo(purchase);
        outputPurchaseInfo(purchase, myLottoInfo);
        WinningLotto winningLotto = receiveWinningLotto();
        Revenue revenue = calculateRevenue(myLottoInfo, winningLotto, purchase);
        outputLottoResult(myLottoInfo, revenue);
    }

    private MyLottoInfo prepareLottoInfo(Purchase purchase) {
        return MyLottoInfo.from(purchase.getPurchaseLottoCount());
    }

    private WinningLotto receiveWinningLotto() {
        WinningLotteryDto winningLotteryDto = receiveValidWinningLottery();
        while (true) {
            try {
                BonusNumberDto bonusNumberDto = receiveValidBonusNumber();
                return WinningLotto.from(winningLotteryDto, bonusNumberDto);
            } catch (IllegalArgumentException e) {
                OutputView.outputError(e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    private Revenue calculateRevenue(MyLottoInfo myLottoInfo, WinningLotto winningLotto, Purchase purchase) {
        List<Rank> ranks = myLottoInfo.getResultPerLotto(winningLotto);
        Revenue revenue = Revenue.from(ranks);
        revenue.updateRevenueRate(purchase.getPurchaseAmount());
        return revenue;
    }

    private Purchase receiveValidPurchase() {
        while (true) {
            try {
                String amountInput = InputView.inputPurchaseAmount();
                PurchaseAmountDto dto = PurchaseAmountDto.from(amountInput);
                return Purchase.from(dto);
            } catch (IllegalArgumentException e) {
                OutputView.outputError(e.getMessage());
            }
        }
    }

    private WinningLotteryDto receiveValidWinningLottery() {
        while (true) {
            try {
                String winningLotteryInput = InputView.inputWinningLottery();
                return WinningLotteryDto.from(winningLotteryInput);
            } catch (IllegalArgumentException e) {
                OutputView.outputError(e.getMessage());
            }
        }
    }

    private BonusNumberDto receiveValidBonusNumber() {
        while (true) {
            try {
                String bonusNumberInput = InputView.inputBonusNumber();
                return BonusNumberDto.from(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                OutputView.outputError(e.getMessage());
            }
        }
    }

    private void outputPurchaseInfo(Purchase purchase, MyLottoInfo myLottoInfo) {
        OutputView.outputLottoPurchaseAmount(purchase.getPurchaseLottoCount());
        OutputView.outputPurchaseLotto(myLottoInfo.getMyLotteries());
    }

    private void outputLottoResult(MyLottoInfo myLottoInfo, Revenue revenue) {
        OutputView.outputLottoResult(myLottoInfo.getMyResult());
        OutputView.outputRevenue(revenue.getRevenueRate());
    }
}
