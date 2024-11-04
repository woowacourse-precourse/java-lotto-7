package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.service.LottoService;
import lotto.service.PrintService;
import lotto.service.ValidationService;

public class LottoController {
    private static final String MANUAL = "manual";
    private static final String WINNER = "winner";
    private static final int WINNER_UNIT = 1;
    private static final int CALCULATE_UNIT = 1000;

    private int pay = 0;
    private int amount = 0;
    private int manualAmount = 0;
    private int change = 0;
    private int bonusNumber = 0;
    private List<Set<Integer>> manualLottoList = new ArrayList<>();
    private List<Set<Integer>> autoLottoList = new ArrayList<>();
    private List<Set<Integer>> totalLottoList = new ArrayList<>();
    private List<Set<Integer>> winnerLotto = new ArrayList<>();
    private List<int[]> matchedList = new ArrayList<>();

    LottoService lottoService = LottoService.createLottoService();
    ValidationService validationService = ValidationService.createValidationService();
    PrintService printService = PrintService.createPrintService();


    public void runLottoProgram() {
        // 구입 금액 입력
        pay = validationService.validatePayInput();
        amount = lottoService.calculateAmount(pay);
        change = lottoService.calculateChange(pay);
        printService.printNoticeBuyAmount(amount, change);
        // 수동 구매 갯수 입력
        manualAmount = validationService.validateManualAmountIsInteger(amount);
        // 수동 번호 입력
        manualLottoList = lottoService.generateManualNumberSet(manualAmount, MANUAL);
        // 남은 갯수만큼 자동번호 생성
        autoLottoList = lottoService.generateAutoNumberSet(amount - manualLottoList.size());
        // 모든 로또 번호 목록 갱신
        totalLottoList = lottoService.getTotalLottoList(manualLottoList, autoLottoList);
        // 구매 번호 출력
        printService.printTotalLottoList(amount, autoLottoList, manualLottoList);
        // 당첨 번호 입력
        printService.printWinnerNumbersInfo();
        winnerLotto = lottoService.generateManualNumberSet(WINNER_UNIT, WINNER);
        // 당첨 번호 출력
        printService.printWinnerNumbers(winnerLotto);
        // 보너스 번호 입력
        printService.printBonusNumbersInfo();
        bonusNumber = validationService.validateBonusNumber(winnerLotto);
        // 당첨 통계 계산
        matchedList = lottoService.calculateMatched(totalLottoList, winnerLotto, bonusNumber);
        printService.printStatistics(matchedList, amount * CALCULATE_UNIT);
    }
}
