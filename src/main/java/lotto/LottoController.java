package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.common.Validator;
import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;
    private final Validator validator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, Validator validator, LottoService lottoService) {
        this.inputView = inputView;
        this.validator = validator;
        this.lottoService = lottoService;
    }

    public void getUserInput() {
        int price = getPrice();

        int quantity = validator.parseQuantity(price);
        inputView.printLottoQuantity(quantity);

        List<Lotto> lottos = makeLottos(quantity);
        printLottos(lottos);
    }

    private int getPrice() {
        String input = inputView.getPrice();
        int price = validator.isNumber(input);
        validator.validatePrice(price);
        inputView.printPrice(price);
        return price;
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
}
