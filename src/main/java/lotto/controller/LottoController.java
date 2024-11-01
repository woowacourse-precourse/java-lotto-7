package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.Lottos;
import lotto.service.LottoService;
import lotto.service.WinService;
import lotto.validator.AmountValidator;
import lotto.validator.BonusNumValidator;
import lotto.validator.WinNumValidator;
import lotto.view.Request;
import lotto.view.Response;

public class LottoController {

    private final Request request = new Request();
    private final Response response = new Response();
    private final LottoService lottoService;
    private final WinService winService;

    public LottoController() {
        Lottos lottos = new Lottos();
        this.lottoService = new LottoService(lottos);
        this.winService = new WinService(lottos);
    }

    public void buyLotto() {
        String inputAmount;

        inputAmount = request.inputAmount();
        try {
            AmountValidator.amountIsNum(inputAmount);
            lottoService.buyLotto(Integer.parseInt(inputAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
    }

    public void getLottos() {
        List<String> lottosNum = new ArrayList<>();
        for (List<Integer> num : lottoService.getLottosNum()) {
            String joinNum = num.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            lottosNum.add(joinNum);
        }

        response.outputLottos(lottosNum);
    }

    public void inputWinNum() {
        List<String> inputWinNum = List.of(request.inputWinNum().split(","));

        try {
            WinNumValidator.winNumSize(inputWinNum);
            WinNumValidator.winNumIsNum(inputWinNum);
            List<Integer> winNum = inputWinNum.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            winService.inputWinNum(winNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinNum();
        }
    }

    public void inputBonusNum() {
        try {
            String inputBonusNum = request.inputBonusNum();
            BonusNumValidator.bonusNumIsNum(inputBonusNum);
            winService.inputBonusNum(Integer.parseInt(inputBonusNum));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNum();
        }
    }


    public void getLottosWin() {
        winService.checkLottosWin();
        response.outputLottosWin(winService.getLottosWin());
    }

    public void getWinnings() {
        response.outputLottosWinningRate(winService.getWinningsRate());
    }
}
