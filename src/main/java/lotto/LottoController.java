package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.common.Validator;
import lotto.model.Lotto;
import lotto.model.LottoDrawMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final Validator validator;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController(InputView inputView, Validator validator, LottoService lottoService, OutputView outputView) {
        this.inputView = inputView;
        this.validator = validator;
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void drawLotto() {
        int price = getPriceFromUser();
        int quantity = validator.parseQuantity(price);
        inputView.printLottoQuantity(quantity);

        List<Lotto> lottos = generateLottoNumbers(quantity);
        List<Integer> winningNumbers = inputView.getWinningNumber();
        int bonusNumber = getBonusNumberFromUser();
        validator.isUniqueBonusNumber(winningNumbers, bonusNumber);

        LottoDrawMachine lottoDrawMachine = lottoService.makeLottoDrawMachine(lottos, winningNumbers, bonusNumber);
        lottoService.compareWinning(lottoDrawMachine);

        announceLottoResult(lottoDrawMachine);
    }

    private int getPriceFromUser() {
        String input = inputView.getPrice();
        int price = validator.isNumber(input);
        validator.validatePrice(price);
        return price;
    }

    private List<Lotto> generateLottoNumbers(int quantity) {
        List<Lotto> lottos = makeLottos(quantity);
        printLottos(lottos);
        return lottos;
    }

    private List<Lotto> makeLottos(int quantity) {
        return Stream.generate(lottoService::makeLotto)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    private void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::toLottoDTO)
                .map(lottoDTO -> lottoDTO.numbers().stream()
                        .sorted()
                        .toList())
                .forEach(inputView::printLottos);
    }

    private int getBonusNumberFromUser() {
        String input = inputView.getBonusNumber();
        int bonusNumber = validator.isNumber(input);
        validator.isNumberInRange(input);
        return bonusNumber;
    }

    private void announceLottoResult(LottoDrawMachine lottoDrawMachine) {
        outputView.printResultMessage();

        Map<Rank, Integer> winningResult = lottoService.getWinningResult(lottoDrawMachine);
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.NONE)) continue;
            String formattedPrice = rank.getFormattedPrice();
            outputView.printLottoPrize(rank.count(), rank.hasBonus(), formattedPrice, winningResult.getOrDefault(rank, 0));
        }
        Double earningsRate = lottoService.generateEarningsRate(lottoDrawMachine);
        outputView.printLottoRate(earningsRate);
    }
}
