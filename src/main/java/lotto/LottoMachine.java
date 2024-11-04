package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.validate.BonusNumberValidate;
import lotto.validate.BuyLottoAmountValidate;
import lotto.validate.JackpotNumbersValidate;
import lotto.validate.LottoValidate;

import java.text.NumberFormat;
import java.util.*;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private int buyLottoAmount;

    public void run() {
        buyLottoAmount = inputLottoValueToInt("구입금액을 입력해 주세요.", new BuyLottoAmountValidate());
        List<Lotto> buyLottos = buyLotto(buyLottoAmount);

        List<Integer> jackpotLottoNumbers = inputJackpotLottoNumbers("\n당첨 번호를 입력해 주세요.", new JackpotNumbersValidate());

        int bonusNumber = inputLottoValueToInt("\n보너스 번호를 입력해 주세요.", new BonusNumberValidate(), jackpotLottoNumbers);

        try {
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        printJackpotStatistics(buyLottos, jackpotLottoNumbers, bonusNumber);
    }

    private void duplicateJackpotLotto(List<Integer> jackpotLottoNumbers, int bonusNumber) throws IllegalArgumentException {
        if(jackpotLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    private void printJackpotStatistics(List<Lotto> buyLottos, List<Integer> jackpotLottoNumbers, int bonusNumber) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        int totalJackPotAmount = 0;
        List<LottoResult> lottoResult = new ArrayList<>();


        for (Lotto buyLotto : buyLottos) {
            int jackpotCount =  0;
            boolean isBonus = false;
            List<Integer> numbers = buyLotto.getNumbers();
            for (Integer jackpotNumber : jackpotLottoNumbers) {
                if(numbers.contains(jackpotNumber)) {
                    jackpotCount++;
                }

                if(numbers.contains(bonusNumber)) {
                    isBonus = true;
                }
            }
            lottoResult.add(new LottoResult(jackpotCount, isBonus));
        }

        for(JackpotAmount jackpotAmount : JackpotAmount.values()) {

            int count = 0;

            for (LottoResult result : lottoResult) {
                if(result.getJackpotAmount() == jackpotAmount) {
                    if(result.getJackpotAmount() != null && result.getJackpotAmount().isBonus() == jackpotAmount.isBonus()) {
                        count++;
                    }
                }
            }

            totalJackPotAmount += count * jackpotAmount.getAmount();

            if(jackpotAmount.isBonus()) {
                System.out.println(jackpotAmount.getMatchNumberCount()+"개 일치, 보너스 볼 일치 (" + formatWithComma(jackpotAmount.getAmount()) + ") - " + count+"개");
            }
            if(!jackpotAmount.isBonus()) {
                System.out.println(jackpotAmount.getMatchNumberCount()+"개 일치 (" + formatWithComma(jackpotAmount.getAmount()) + ") - " + count+"개");
            }

        }

        printRateOfReturn(totalJackPotAmount);
    }

    private void printRateOfReturn(int totalJackPotAmount) {
        double rateOfReturn = (totalJackPotAmount / (double) buyLottoAmount) * 100;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static String formatWithComma(int number) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        return formatter.format(number) + "원";
    }

    private int inputLottoValueToInt(String inputMsg, LottoValidate lottoValidate) {
        int value;

        while (true) {
            try {
                System.out.println(inputMsg);
                value = stringToInt();

                lottoValidate.validate(value);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return value;
    }

    private int inputLottoValueToInt(String inputMsg, LottoValidate lottoValidate, List<Integer> numbers) {
        int value;

        while (true) {
            try {
                System.out.println(inputMsg);
                value = stringToInt();

                lottoValidate.validate(value);

                duplicateJackpotLotto(numbers, value);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return value;
    }

    private List<Integer> inputJackpotLottoNumbers(String inputMsg, JackpotNumbersValidate jackpotLottoValidate) {
        List<Integer> numbers;

        while (true) {
            try {
                System.out.println(inputMsg);
                numbers = stringToIntArray();

                if(numbers.size() != 6) {
                    throw new IllegalArgumentException("로또 당첨 번호의 숫자의 개수가 6이 아닙니다.\n");
                }

                jackpotLottoValidate.validate(numbers);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return numbers;
    }

    private List<Lotto> buyLotto(int purchaseAmount){
        int lottoTicketCount = buyLottoTicketCount(purchaseAmount);
        List<Lotto> buyLottos = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            buyLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        printBuyLotto(lottoTicketCount, buyLottos);



        return buyLottos;
    }

    private int buyLottoTicketCount(int purchaseAmount) {

        if(purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return purchaseAmount / LOTTO_PRICE;
    }
    private List<Integer> stringToIntArray() throws IllegalArgumentException {
        Set<Integer> numbers = new HashSet<>();
        try {
            String inputValue = Console.readLine();

            String[] split = inputValue.split(",");

            for (String s : split) {
                if(!numbers.add(Integer.parseInt(s))){
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.\n");
                }
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 숫자 형식입니다.\n");
        }

        return new ArrayList<>(numbers);
    }
    
    private int stringToInt() throws IllegalArgumentException {
        int value;

        try {
            value = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 숫자 형식입니다.\n");
        }

        return value;
    }

    private void printBuyLotto(int lottoTicketCount, List<Lotto> buyLottos) {
        System.out.println("\n"+lottoTicketCount + "개를 구매했습니다.");

        for (Lotto buyLotto : buyLottos) {
            System.out.println(buyLotto.getNumbers());
        }
    }
}
