//package lotto;
//
//import camp.nextstep.edu.missionutils.Console;
//import lotto.dto.InputDTO;
//import lotto.dto.Lotto;
//import lotto.exceptioin.InputException;
//import lotto.handler.InputHandler;
//import lotto.handler.OutputHandler;
//import lotto.service.LottoNumberService;
//import lotto.service.LottoResultService;
//
//import java.util.List;
//
//public class Application {
//    public static void main(String[] args) {
//        // TODO 프로그램 구현
//        OutputHandler outputHandler = new OutputHandler();
//        InputHandler inputHandler = new InputHandler();
//        LottoNumberService lottoNumberService = new LottoNumberService();
//        LottoResultService lottoResultService = new LottoResultService();
//        System.out.println("구입금액을 입력해 주세요.");
//        String money = Console.readLine();
//        int moneyValue = inputHandler.inputMoney();
//
//        System.out.println("당첨 번호를 입력해 주세요.");
//        String winningNumbers = Console.readLine();
//        List<Integer> winningNumbersValue = inputHandler.inputWinningNumbers(winningNumbers);
//
//        System.out.println("보너스 번호를 입력해 주세요.");
//        String bonusNumber = Console.readLine();
//        int bonusNumberValue = inputHandler.inputBonusNumber(bonusNumber);
//
//        List<Lotto> purchasedLottos = lottoNumberService.generateLottos(moneyValue);
//        outputHandler.printLottoNumbers(purchasedLottos);
//
//
//
//
//
//        InputDTO inputDTO = new InputDTO(winningNumbersValue, bonusNumberValue, moneyValue);
//
//        lottoResultService.calculateWinningsStatistics(inputDTO, purchasedLottos);
//        double profitRate = lottoNumberService.calculateProfitRate(inputDTO, purchasedLottos, moneyValue);
//        outputHandler.printProfitRate(profitRate);
//    }
//}
package lotto;

import lotto.dto.InputDTO;
import lotto.dto.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.service.LottoNumberService;
import lotto.service.LottoResultService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 핸들러 및 서비스 인스턴스 생성
        OutputHandler outputHandler = new OutputHandler();
        InputHandler inputHandler = new InputHandler();
        LottoNumberService lottoNumberService = new LottoNumberService();
        LottoResultService lottoResultService = new LottoResultService();

        int moneyValue = inputHandler.inputMoney();

        List<Lotto> purchasedLottos = lottoNumberService.generateLottos(moneyValue);
        outputHandler.printLottoNumbers(purchasedLottos);

        List<Integer> winningNumbersValue = inputHandler.inputWinningNumbers();

        int bonusNumberValue = inputHandler.inputBonusNumber();

        InputDTO inputDTO = new InputDTO(winningNumbersValue, bonusNumberValue, moneyValue);

        lottoResultService.calculateWinningsStatistics(inputDTO, purchasedLottos);
        double profitRate = lottoNumberService.calculateProfitRate(inputDTO, purchasedLottos, moneyValue);
        outputHandler.printProfitRate(profitRate);
    }
}
