package lotto;

import lotto.domain.*;
import lotto.parser.Parser;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoRankDeterminer;
import lotto.service.LottoStatisticsCalculator;
import lotto.validator.InputValidator;
import lotto.view.View;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        InputValidator inputValidator = new InputValidator();
        Parser parser = new Parser();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoFactory lottoFactory = new LottoFactory(lottoNumberGenerator);
        LottoMarket lottoMarket = new LottoMarket(lottoFactory);
        LottoRankDeterminer lottoRankDeterminer = new LottoRankDeterminer();
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator();

        String buyingAmount;
        long amount;
        List<Lotto> lottos;
        while (true) {
            try {
                buyingAmount = view.getInputAmount();
                inputValidator.validateInputAmount(buyingAmount);
                amount = parser.parseStringToLong(buyingAmount);
                lottos = lottoMarket.sellLottos(amount);
                view.printBuyingLottoCount(amount);
                view.printLottos(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String inputWinnerNumbers;
        List<Integer> winnerNumbers;
        while (true) {
            try {
                inputWinnerNumbers = view.getInputWinnerNumbers();
                inputValidator.validateInputNumbers(inputWinnerNumbers);
                winnerNumbers = parser.parseInputToNumbers(inputWinnerNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Lotto winnerLotto = new Lotto(winnerNumbers);

        String bonusNumber;
        int bonusNum;
        while (true) {
            try {
                bonusNumber = view.getInputBonusNumber();
                inputValidator.validateInputBonusNumber(winnerNumbers, bonusNumber);
                bonusNum = parser.parseStringToInt(bonusNumber);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        Map<Lotto, LottoRank> lottoRankResults = lottoRankDeterminer.determineLottoRanks(lottos, winnerLotto, bonusNum);
        LottoResult lottoResult = lottoStatisticsCalculator.calculateStatistic(lottoRankResults, amount);

        view.printLottoResults(lottoResult);
    }
}
