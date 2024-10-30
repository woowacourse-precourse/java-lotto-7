package lotto.application;

import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.WinNumbers;

public class LottoApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;
    private final Reader reader;
    private final Printer printer;

    public LottoApplication(MakeNumbersStrategy makeNumbersStrategy, Reader reader, Printer printer) {
        this.makeNumbersStrategy = makeNumbersStrategy;
        this.reader = reader;
        this.printer = printer;
    }

    public Lottos buyLottos(LottoQuantity lottoQuantity) {
        Lottos lottos = Lottos.from(lottoQuantity, makeNumbersStrategy);
        printer.printPurchaseResult(lottoQuantity.value(), lottos);
        return lottos;
    }

    public WinNumbers readAllWinNumbers() {
        WinNumbers winNumbersWithoutBonusNumber = readWinNumbers();
        return readBonusNumber(winNumbersWithoutBonusNumber);
    }

    private WinNumbers readWinNumbers() {
        printer.print("\n당첨 번호를 입력해 주세요.");
        String originWinNumbers = reader.read();
        try {
            return WinNumbers.winNumbersFrom(originWinNumbers);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readWinNumbers();
        }
    }

    private WinNumbers readBonusNumber(WinNumbers winNumbersWithOutBonusNumber) {
        printer.print("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = reader.read();
        try {
            return winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readBonusNumber(winNumbersWithOutBonusNumber);
        }
    }
}
