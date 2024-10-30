package lotto.application;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;
import lotto.domain.WinNumbers;

public class LottoApplication {

    public static Lottos buyLottos(LottoQuantity lottoQuantity, MakeNumbersStrategy makeNumbersStrategy,
                                   Printer printer) {
        Lottos lottos = Lottos.from(lottoQuantity, makeNumbersStrategy);
        printer.printPurchaseResult(lottoQuantity.value(), lottos);
        return lottos;
    }

    public static WinNumbers readAllWinNumbers(Printer printer, Reader reader) {
        WinNumbers winNumbersWithoutBonusNumber = readWinNumbers(printer, reader);
        return readBonusNumber(winNumbersWithoutBonusNumber, printer, reader);
    }

    private static WinNumbers readWinNumbers(Printer printer, Reader reader) {
        printer.print("\n당첨 번호를 입력해 주세요.");
        String originWinNumbers = reader.read();
        try {
            return WinNumbers.winNumbersFrom(originWinNumbers);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readWinNumbers(printer, reader);
        }
    }

    private static WinNumbers readBonusNumber(WinNumbers winNumbersWithOutBonusNumber, Printer printer, Reader reader) {
        printer.print("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = reader.read();
        try {
            return winNumbersWithOutBonusNumber.bonusNumberFrom(bonusNumber);
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readBonusNumber(winNumbersWithOutBonusNumber, printer, reader);
        }
    }

    public static PrizeNumber findWinningLottos(WinNumbers winNumbers, Lottos lottos) {
        PrizeNumber prizeNumber = new PrizeNumber();
        List<Lotto> allLotto = lottos.value();
        for (Lotto lotto : allLotto) {
            prizeNumber.countMatchNumber(lotto.getNumbers(), winNumbers);
        }
        return prizeNumber;
    }
}
