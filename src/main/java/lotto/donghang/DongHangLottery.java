package lotto.donghang;

import lotto.AppConfig;
import lotto.winning.WinningController;
import lotto.winning.Rank;
import lotto.io.InputReader;
import lotto.io.OutputWriter;
import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.vendingmachine.Lotto;
import lotto.vendingmachine.VendingMachineController;
import lotto.vendingmachine.VendingMachineRepository;

import java.util.List;
import java.util.Map;

public class DongHangLottery {

    private static final AppConfig appConfig = new AppConfig();
    private static final InputReader inputReader = new InputReader();
    private static final OutputWriter outputWriter = new OutputWriter();

    public static void sellLotto() {
        VendingMachineController vendingMachineController = appConfig.vendingMachineController();
        while (true) {
            try {
                int money = inputReader.readPurchaseAmount();
                InputValidator.validatePurchaseAmount(money);
                vendingMachineController.generateLottoTickets(money / 1000);

                List<Lotto> lottos = vendingMachineController.getIssuedLottoTickets();
                outputWriter.write(lottos);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    public static void drawWinningLotteryNumbers() {
        WinningController winningController = appConfig.winningController();

        Lotto winningNumber = drawWinningNumbers();
        int bonus = drawBonusNumber(winningNumber.getNumbers());
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonus);

        winningController.checkResult(winningLotto);
        inputReader.close();
    }

    private static Lotto drawWinningNumbers() {
        while (true) {
            try {
                String input = inputReader.readWinningNumber();
                InputValidator.validateWinningNumber(input);
                List<Integer> winningNumber = InputParser.parseStringToInt(input);

                return new Lotto(winningNumber);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static int drawBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                int bonus = inputReader.readBonusNumber();
                InputValidator.validateBonusNumberRange(bonus);
                InputValidator.checkBonusNumberDuplicates(winningNumber, bonus);

                return bonus;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    public static void announceResult() {
        VendingMachineRepository vendingMachineRepository = appConfig.vendingMachineRepository();
        Map<Rank, Integer> lottoStatistics = vendingMachineRepository.getWinningStatistics();
        double earningsRate = vendingMachineRepository.getEarningRate();

        outputWriter.printStatistics(lottoStatistics, earningsRate);
    }

}
