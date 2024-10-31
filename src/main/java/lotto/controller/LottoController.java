package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.service.LottoService;
import lotto.view.Request;
import lotto.view.Response;

public class LottoController {

    private final Request request = new Request();
    private final Response response = new Response();
    private final LottoService lottoService = new LottoService();

    public void buyLotto() {
        int amount;
        try {
            amount = Integer.parseInt(request.inputAmount());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 가능 합니다.");
        }

        lottoService.buyLotto(amount);
    }

    public void getLottos() {
        List<String> lottosNum = lottoService.getLottos().stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
                )
                .collect(Collectors.toList());

        response.outputLottos(lottosNum);
    }
}
