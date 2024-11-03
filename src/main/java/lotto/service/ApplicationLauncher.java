package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class ApplicationLauncher {
    public static void run(){
        InputHandler inputHandler = new InputHandler();

        while(true){
            try {
                OutputHandler.print(OutputHandler.ENTER_PURCHASE_AMOUNT);
                String firstLine = inputHandler.readline();

                LottoGenerator lottoGenerator = new LottoGenerator();
                Lotto[] userLotto = lottoGenerator.generate(firstLine);

                OutputHandler.printPurchasedQuantity(lottoGenerator);
                OutputHandler.printPurchasedLotto(lottoGenerator);

                OutputHandler.print(OutputHandler.ENTER_WINNING_NUMBERS);
                String secondLine = inputHandler.readline();

                OutputHandler.print(OutputHandler.ENTER_BONUS_NUMBER);
                String thirdLine = inputHandler.readline();

                LottoWinningNumbers winningLotto = new LottoWinningNumbers(secondLine, thirdLine);
                winningLotto.generate();

                LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
                lottoResultAnalyzer.analyze(userLotto, winningLotto);

                OutputHandler.printCompareResult(lottoResultAnalyzer);
                OutputHandler.printTotalYield(lottoResultAnalyzer, lottoGenerator);

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Console.close();
    }
}
