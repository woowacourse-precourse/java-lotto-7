package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoRequestReader {
    private final static int LOTTO_PRICE = 1000;
    private final static String COMMA = ",";
    public int getPurchaseMoney(){
        System.out.println(InputType.PURCHASE_MONEY.getMessage());
        int purchaseMoney = getPositiveIntInput();
        if(purchaseMoney < LOTTO_PRICE){
            throw new IllegalArgumentException(String.format("[ERROR] 로또 구입 금액은 %d원 이상이어야 합니다.", LOTTO_PRICE));
        }
        if(purchaseMoney % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }

        System.out.println();
        return purchaseMoney;
    }

    public List<Integer> getLottoNumbers(){
        System.out.println(InputType.LOTTO_NUMBERS.getMessage());
        String input = Console.readLine();
        String[] numbers = input.split(COMMA);
        if(numbers.length != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        System.out.println();
        return convertLottoStringToIntegers(numbers);
    }

    private List<Integer> convertLottoStringToIntegers(String[] numbers){
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            try {
                lottoNumbers.add(Integer.parseInt(numbers[i]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
        return lottoNumbers;
    }

    private int getPositiveIntInput(){
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if(num < 0){
            throw new IllegalArgumentException("[ERROR] 음수를 입력할 수 없습니다.");
        }
        return num;
    }

    public int getBonusNumber() {
        System.out.println(InputType.BONUS_NUMBER.getMessage());
        int bonusNumber = getPositiveIntInput();

        System.out.println();
        return bonusNumber;
    }


    public enum InputType {
        PURCHASE_MONEY("구입 금액을 입력해 주세요."),
        LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        InputType(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }
}
