package lotto.domain;

import lotto.io.Output;

public class WoowahanLottoCompany {
    private final LottoMachin lottoMachin;

    public WoowahanLottoCompany() {
        lottoMachin = LottoMachin.getMachine();
    }

    public void enterForLottoPurchase(Consumer consumer) {
        lottoMachin.sellTo(consumer);
        lottoMachin.printLottoInfo(consumer);
        inputWinningNumbersRetryTo(consumer);
        inputBonusNumbersRetryTo(consumer);
    }

    public void printLottoWinningResult(Consumer consumer) {
        lottoMachin.printLottoWinningResult(consumer);
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
