package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.common.Validator;
import lotto.model.Lotto;
import lotto.model.LottoDrawMachine;
import lotto.model.LottoResult;
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
        int bonusNumber = getBonusNumber(winningNumbers);

        LottoDrawMachine lottoDrawMachine = lottoService.makeLottoDrawMachine(lottos, winningNumbers, bonusNumber);
        announceResults(lottoDrawMachine);
    }

    private int getPriceFromUser() {
        while (true) {
            String input = inputView.getPrice();
            try {
                int price = validator.isNumber(input);
                validator.validatePrice(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLottoNumbers(int quantity) {
        List<Lotto> lottos = makeLottos(quantity);
        printLottos(lottos);
        return lottos;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = inputView.getBonusNumber();
                int bonusNumber = validator.isNumber(input);
                validator.isNumberInRange(input);
                validator.isUniqueBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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

    private void announceResults(LottoDrawMachine lottoDrawMachine) {
        outputView.printResultMessage();
        LottoResult lottoResult = lottoService.getWinningResult(lottoDrawMachine);
        lottoResult.getRankCounts().forEach((rank, count) -> {
            String formattedPrice = rank.getFormattedPrice();
            outputView.printLottoPrize(rank.count(), rank.hasBonus(), formattedPrice, count);
        });
        double earningsRate = lottoService.generateEarningsRate(lottoResult, lottoDrawMachine);
        outputView.printLottoRate(earningsRate);
    }
}
