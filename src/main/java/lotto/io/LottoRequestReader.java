package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoRequestReader {
    private final static String COMMA = ",";

    public int getPurchaseMoney() {
        System.out.println(InputType.PURCHASE_MONEY.getMessage());
        int purchaseMoney = getIntInput();

        System.out.println();
        return purchaseMoney;
    }

    public List<Integer> getLottoNumbers() {
        System.out.println(InputType.LOTTO_NUMBERS.getMessage());
        String input = Console.readLine();
        String[] numbers = input.split(COMMA);

        System.out.println();
        return convertLottoStringToIntegers(numbers);
    }

    private List<Integer> convertLottoStringToIntegers(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String s : numbers) {
            int number;
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
            }
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }

    private int getIntInput() {
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        return num;
    }

    public int getBonusNumber() {
        System.out.println(InputType.BONUS_NUMBER.getMessage());
        int bonusNumber = getIntInput();

        System.out.println();
        return bonusNumber;
    }


    public enum InputType {
        PURCHASE_MONEY("구입 금액을 입력해 주세요."),
        LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        InputType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
