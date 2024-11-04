package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.lottoMachine.Lotto;

public class InputController {
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_PURCHASE_PRICE = 1_000;
    private static final int MAX_PURCHASE_PRICE = 2_147_483_000;

    public Integer getPurchaseNumber() {
        while(true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            try {
                return validatePurchaseNumberInput(input) / LOTTO_PRICE;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private Integer validatePurchaseNumberInput(String input) {
        int purchaseNumber;
        try {
            purchaseNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (purchaseNumber > MAX_PURCHASE_PRICE) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 이하여야 합니다.", MAX_PURCHASE_PRICE));
        }

        if(purchaseNumber < MIN_PURCHASE_PRICE) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 이상이어야 합니다.", MIN_PURCHASE_PRICE));
        }

        if(purchaseNumber % 1000 != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 단위어야 합니다.", LOTTO_PRICE));
        }

        return purchaseNumber;
    }

    public Lotto getLotto() {
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                return validateLottoInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private Lotto validateLottoInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for(String numberString : input.split(",")) {
                numbers.add(Integer.parseInt(numberString));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자어야합니다.");
        }

        return new Lotto(numbers);
    }

    public Integer getBonusNumber(Lotto lotto) {
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            try {
                return validateBonusNumberInput(input, lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private Integer validateBonusNumberInput(String input, Lotto lotto) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자여야합니다.");
        }

        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자여야합니다.");
        }

        if(lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }

        return bonusNumber;
    }
}
