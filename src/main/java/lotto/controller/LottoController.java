package lotto.controller;

import lotto.model.LottoModel;
import lotto.service.LottoService;
import lotto.validation.Validator;
import lotto.view.LottoView;

import java.util.*;

public class LottoController {
    private final LottoModel lottoModel;
    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController() {
        this.lottoModel = new LottoModel();
        this.lottoView = new LottoView();
        this.lottoService = new LottoService(lottoModel);
    }


    public void start() {
        int lottoCount = getLottoCount();
        lottoView.output.lottoCount(lottoCount);
        lottoService.generateLottos(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottoView.output.lottoNumber(lottoModel.getLottoNumbers(i));
        }
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);

        //당첨 로직 구현
        int[] ans = new int[5];
        for (int i = 0; i < lottoCount; i++) {
            lottoService.winningCount(winningNumber, i, ans, bonusNumber);
        }

        lottoView.output.winningResult(ans, lottoService.getRate(lottoCount, ans));
    }

    int getLottoCount() {
        while (true) {
            try {
                return Validator.validateLottoCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    List<Integer> getWinningNumber() {
        while (true) {
            try {
                String[] inputWinningNumber = lottoView.input.winningNumber().split(",");
                return Validator.validateWinningNumber(inputWinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                return Validator.validateBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
