package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class ApplicationLauncher {
    public static void run(){
        InputHandler inputHandler = new InputHandler();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoWinningNumbers winningLotto = new LottoWinningNumbers();
        Lotto[] userLotto;

        String firstLine;
        String secondLine;
        String thirdLine;

        while(true){
            try {
                OutputHandler.print(OutputHandler.ENTER_PURCHASE_AMOUNT);
                firstLine = inputHandler.readline();

                userLotto = lottoGenerator.generate(firstLine);

                OutputHandler.printPurchasedQuantity(lottoGenerator);
                OutputHandler.printPurchasedLotto(lottoGenerator);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try {
                OutputHandler.print(OutputHandler.ENTER_WINNING_NUMBERS);
                secondLine = inputHandler.readline();
                winningLotto.setMainNumbers(secondLine);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while(true){
            try {
                OutputHandler.print(OutputHandler.ENTER_BONUS_NUMBER);
                thirdLine = inputHandler.readline();
                winningLotto.setBonusNumber(thirdLine);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        winningLotto.generate();

        LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
        lottoResultAnalyzer.analyze(userLotto, winningLotto);

        OutputHandler.printCompareResult(lottoResultAnalyzer);
        OutputHandler.printTotalYield(lottoResultAnalyzer, lottoGenerator);

        Console.close();
    }
}
