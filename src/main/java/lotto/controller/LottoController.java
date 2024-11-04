package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.model.Pay;
import lotto.service.LottoService;
import lotto.service.PrintService;

public class LottoController {
    private static final int CALCULATE_UNIT = 1000;
    private Pay pay;
    private int amount = 0;
    private int bonusNumber = 0;
    private LottoGroup lottoGroup;
    private Lotto winnerLotto;
    private List<int[]> matchedList = new ArrayList<>();

    private final LottoService lottoService;
    private final PrintService printService;

    public LottoController(LottoService lottoService, PrintService printService) {
        this.lottoService = lottoService;
        this.printService = printService;
    }

    public void runLottoProgram() {
        // 구입 금액 입력
        payLotto();
        // 번호 생성 및 구매 번호 출력
        generateAndPrintLotto();
        // 당첨 번호 입력 및 출력
        generateAndPrintWinnerLotto();
        // 보너스 번호 입력
        generateAndPrintBonusNumber();
        // 당첨 통계 계산
        generateAndPrintStatistics();
    }

    private void payLotto() {
        pay = lottoService.payInput();
        amount = pay.getAmount();
        printService.printNoticeBuyAmount(amount);
    }

    private void generateAndPrintLotto() {
        lottoGroup = lottoService.generateLottoGroup(amount);
        printService.printLottoGroup(lottoGroup);
    }

    private void generateAndPrintWinnerLotto() {
        printService.printWinnerNumbersInfo();
        winnerLotto = lottoService.generateWinnerLotto();
        printService.printWinnerNumbers(winnerLotto);
    }

    private void generateAndPrintBonusNumber() {
        printService.printBonusNumbersInfo();
        bonusNumber = lottoService.validateBonusNumber(winnerLotto);
        printService.printBonusNumbers(bonusNumber);
    }

    private void generateAndPrintStatistics() {
        matchedList = lottoService.calculateMatched(lottoGroup, winnerLotto, bonusNumber);
        printService.printStatistics(matchedList, amount * CALCULATE_UNIT);
    }
}
