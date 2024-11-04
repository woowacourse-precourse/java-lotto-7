package lotto.domain;

import lotto.domain.errorMessage.ErrorMessage;
import lotto.io.Output;

public class WoowahanLottoCompany {
    private final LottoMachin lottoMachin;
    private boolean isUsed = false;

    public WoowahanLottoCompany() {
        lottoMachin = LottoMachin.getMachine();
    }

    public void enterForLottoPurchase(Consumer consumer) {
        startUseMachin(consumer);
        lottoMachin.sellTo(consumer);
        lottoMachin.printLottoInfo(consumer);
        inputWinningNumbersRetryTo(consumer);
        inputBonusNumbersRetryTo(consumer);
    }

    public void startUseMachin(Consumer consumer) {
        if (isMachinInUse()) {
            throw new IllegalArgumentException(ErrorMessage.NO_AVAILABLE_MACHIN.getErrorMessage());
        }
        startUsingMachin();
    }

    public void printLottoWinningResult(Consumer consumer) {
        lottoMachin.printLottoWinningResult(consumer);
        stopUsingMachin();
    }

    private void startUsingMachin() {
        this.isUsed = true;
    }

    private void stopUsingMachin() {
        this.isUsed = false;
    }

    private boolean isMachinInUse() {
        return isUsed;
    }

    private void inputWinningNumbersRetryTo(Consumer consumer) {
        while (true) {
            try {
                lottoMachin.inputWinningNumbersTo(consumer);
                break;
            } catch (IllegalArgumentException e) {
                Output.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumbersRetryTo(Consumer consumer) {
        while (true) {
            try {
                lottoMachin.inputBonusNumbersTo(consumer);
                break;
            } catch (IllegalArgumentException e) {
                Output.println(e.getMessage());
            }
        }
    }
}
