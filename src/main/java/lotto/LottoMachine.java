package lotto;

import lotto.function.purchase.LottoPurchase;
import lotto.function.winning.checker.LottoWinningDetailsChecker;
import lotto.function.winning.register.WinningLottoRegister;
import lotto.io.printer.error.ErrorPrinter;
import org.junit.jupiter.api.function.Executable;

public class LottoMachine {

    private final LottoPurchase lottoPurchase;
    private final WinningLottoRegister winningLottoRegister;
    private final LottoWinningDetailsChecker lottoWinningDetailsChecker;
    private final ErrorPrinter errorPrinter;

    public LottoMachine(
            LottoPurchase lottoPurchase,
            WinningLottoRegister winningLottoRegister,
            LottoWinningDetailsChecker lottoWinningDetailsChecker,
            ErrorPrinter errorPrinter
    ) {
        this.lottoPurchase = lottoPurchase;
        this.winningLottoRegister = winningLottoRegister;
        this.lottoWinningDetailsChecker = lottoWinningDetailsChecker;
        this.errorPrinter = errorPrinter;
    }

    public void run() {
        runUntilSuccess(lottoPurchase::run);
        runUntilSuccess(winningLottoRegister::run);
        runUntilSuccess(lottoWinningDetailsChecker::run);
    }

    private void runUntilSuccess(Executable executable) {
        while (true) {
            try {
                executable.execute();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                errorPrinter.printErrorMessage(illegalArgumentException);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

}
