package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.converter.StringToIntegerConverter;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.dto.LottoNumberDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        Money purchaseAmount = getPurchaseAmount();

        List<Lotto> purchasedLotto = getLottoNumbers(purchaseAmount);
        List<LottoNumberDto> purchasedLottoNumberSets = getLottoNumberDtos(purchasedLotto);
        OutputView.printPurchaseLottoNumbers(purchasedLottoNumberSets);

        Lotto winningLotto = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();

    }

    private BonusNumber getBonusNumber() {
        OutputView.printBonusNumberInputMessage();
        String bonusNumber = InputView.inputBonusNumber();
        return BonusNumber.from(StringToIntegerConverter.convert(bonusNumber));
    }

    private Lotto getWinningNumber() {
        OutputView.printWinningNumberInputMessage();
        String winningNumberInput = InputView.inputWinningNumber();
        List<Integer> winningNumber = Arrays.stream(winningNumberInput.split(","))
                .map(StringToIntegerConverter::convert)
                .toList();
        return new Lotto(winningNumber);
    }

    private static List<LottoNumberDto> getLottoNumberDtos(List<Lotto> purchasedLotto) {
        return purchasedLotto.stream()
                .map(lotto -> new LottoNumberDto(lotto.getNumbers()))
                .toList();
    }

    private List<Lotto> getLottoNumbers(Money purchaseAmount) {
        return Stream.generate(lottoMachine::generateLotto)
                .limit(purchaseAmount.getPurchaseCount())
                .toList();
    }

    private Money getPurchaseAmount() {
        OutputView.printPurchaseAmountInputMessage();
        String purchaseAmountInput = InputView.inputPurchaseAmount();
        int purchaseAmount = StringToIntegerConverter.convert(purchaseAmountInput);
        return Money.from(purchaseAmount);
    }
}
