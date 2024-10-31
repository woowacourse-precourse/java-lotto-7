package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.service.LottoService;
import lotto.validator.ControllerValidator;
import lotto.view.Request;
import lotto.view.Response;

public class LottoController {

    private final Request request = new Request();
    private final Response response = new Response();
    private final LottoService lottoService = new LottoService();
    private final ControllerValidator controllerValidator = new ControllerValidator();

    public void buyLotto() {
        String inputAmount;

        inputAmount = request.inputAmount();
        try {
            controllerValidator.amountIsNum(inputAmount);
            lottoService.buyLotto(Integer.parseInt(inputAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
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

    public void inputWinNum() {
        List<String> inputWinNum = List.of(request.inputWinNum().split(","));

        try {
            controllerValidator.winNumSize(inputWinNum);
            controllerValidator.winNumIsNum(inputWinNum);
            List<Integer> winNum = Stream.of(request.inputWinNum().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lottoService.inputWinNum(winNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinNum();
        }
    }

    public void inputBonusNum() {
        try {
            String inputBonusNum = request.inputBonusNum();
            controllerValidator.bonusNumIsNum(inputBonusNum);
            lottoService.inputBonusNum(Integer.parseInt(inputBonusNum));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNum();
        }
    }


    public void getLottosWin() {
        lottoService.checkLottosWin();
        response.outputLottosWin(lottoService.getLottosWin());
    }

    public void getWinnings() {
        response.outputLottosWinningRate(lottoService.getWinningsRate());
    }
}
