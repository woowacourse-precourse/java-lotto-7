package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import message.ErrorMessage;
import message.GameMessage;
import util.NumberValidate;

public class Application {

    public static void main(String[] args) {
        int inputCash = getCashAmount();
        List<Lotto> lottos = buyLotto(inputCash);
        printLotto(lottos);
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.inputWinningNumbers();
        lottoMachine.inputBonusNumber();
        announceOfResults(lottos, inputCash, lottoMachine);
    }

    private static Integer getCashAmount() {
        String inputCash;
        do {
            System.out.println(GameMessage.GET_INPUT_MESSAGE.getMessage());
            inputCash = Console.readLine();
        } while (!validateCashInput(inputCash));
        return Integer.parseInt(inputCash);
    }

    private static boolean validateCashInput(String inputCash) {
        if (!NumberValidate.isNumber(inputCash)) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_INPUT_NOT_NUMBER.getMessage());
            return false;
        }
        if (!NumberValidate.isPositiveNumber(inputCash)) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }

        int cash = Integer.parseInt(inputCash);
        if (!NumberValidate.nothingLeftAfterDivideBy(cash, Lotto.PRICE)) {
            System.out.println(ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
            return false;
        }
        return true;
    }

    private static List<Lotto> buyLotto(int inputCash) {
        LottoSeller lottoSeller = new LottoSeller(inputCash, Lotto.PRICE);
        List<Lotto> lottos = lottoSeller.sell();
        return lottos;
    }

    private static void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + GameMessage.GET_LOTTO_MESSAGE.getMessage());
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumber()));
    }

    private static void announceOfResults(List<Lotto> lottos, int inputCash, LottoMachine lottoMachine) {
        System.out.println();
        System.out.println(GameMessage.RESULT_AVERAGE_MESSAGE.getMessage());
        System.out.println(GameMessage.RESULT_HYPE_MESSAGE.getMessage());

        LottoHost lottoHost = new LottoHost(lottos);
        checkWinning(lottoHost, lottoMachine);
        Announcer announcer = new Announcer(lottoHost.getWinningResults());
        announcer.printResults();
        announcer.printEarningRate(lottoHost, Integer.toString(inputCash));
    }

    private static void checkWinning(LottoHost lottoHost, LottoMachine lottoMachine) {
        lottoHost.getWinningResults(lottoMachine.getWinningNumbers(), lottoMachine.getBonusNumber());
    }
}
