package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import util.NumberValidate;

public class Application {

    public static void main(String[] args) {
        LottoSeller lottoSeller;
        String inputCash;
        do {
            inputCash = getCashAmount();
        } while (!validateCashInput(inputCash));

        lottoSeller = new LottoSeller(Integer.parseInt(inputCash), Lotto.PRICE);
        List<Lotto> lottos = lottoSeller.sell();
        System.out.println(lottos.size() + GameMessage.GET_LOTTO_MESSAGE.getMessage());
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumber()));
        List<Integer> winningNumbers = getWinningNumbers();
        String inputBonusNumber;
        do {
            inputBonusNumber = getBonusNumber();
        } while (!validateBonusInput(inputBonusNumber, winningNumbers));
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        System.out.println();
        System.out.println(GameMessage.RESULT_AVERAGE_MESSAGE.getMessage());
        System.out.println(GameMessage.RESULT_HYPE_MESSAGE.getMessage());

        LottoHost lottoHost = new LottoHost(lottos);
        LinkedHashMap<LottoResult, Integer> winningResults = lottoHost.getWinningResults(winningNumbers, bonusNumber);
        printResults(winningResults);
        printEarningRate(lottoHost, inputCash);
    }

    private static String getCashAmount() {
        System.out.println(GameMessage.GET_INPUT_MESSAGE.getMessage());
        return Console.readLine();
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

    private static List<Integer> getWinningNumbers() {
        final String INPUT_SEPARATOR = ",";
        Pattern pattern = Pattern.compile("[ ]*\\d+(?:[ ]*,[ ]*\\d+){5}");

        String inputWinningNumbers;
        do {
            System.out.println(GameMessage.GET_WINNING_NUMBER_MESSAGE.getMessage());
            inputWinningNumbers = Console.readLine();
        } while (!pattern.matcher(inputWinningNumbers).matches());

        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(INPUT_SEPARATOR, -1))
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }

    private static String getBonusNumber() {
        System.out.println(GameMessage.GET_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }

    private static boolean validateBonusInput(String inputBonusNumber, List<Integer> winningNumbers) {
        if (!NumberValidate.isNumber(inputBonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_NUMBER.getMessage());
            return false;
        }
        if (!NumberValidate.isPositiveNumber(inputBonusNumber)) {
            System.out.println(ErrorMessage.WINNING_NUMBER_NOT_POSITIVE_NUMBER.getMessage());
            return false;
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private static void printResults(LinkedHashMap<LottoResult, Integer> winningResults) {
        for (LottoResult lottoResult : winningResults.keySet()) {
            if (lottoResult.getRankName().equals("NONE_RANK")) {
                continue;
            }
            int prizeNumber = lottoResult.getPrize();
            String subStringBonusNumber = " ";
            if (lottoResult.getRankName().equals("SECOND_PRIZE")) {
                subStringBonusNumber = ", 보너스 볼 일치";
            }
            String result = String.format("%d개 일치%s(%,d원) - %d개", lottoResult.getSameNumberCount(),
                    subStringBonusNumber, prizeNumber,
                    winningResults.get(lottoResult));
            System.out.println(result);

        }
    }

    private static void printEarningRate(LottoHost lottoHost, String inputCash) {
        float earningRate = lottoHost.calcEarningRate(inputCash);
        DecimalFormat df = new DecimalFormat("#,##0.0");
        String formattedEarningRate = df.format(earningRate);
        System.out.printf("%s %s %s\n", GameMessage.RESULT_RATE_MESSAGE_START.getMessage(), formattedEarningRate,
                GameMessage.RESULT_RATE_MESSAGE_END.getMessage());
    }
}