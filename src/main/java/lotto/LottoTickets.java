package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constant.Message.*;
import static constant.Message.INPUT_REQUEST_PURCHASE_AMOUNT;

public class LottoTickets {
    private static final int LOTTO_PRICE = 1000;
    ArrayList<Lotto> lottoTickets;

    public LottoTickets() {}

    // 테스트용 코드
    public LottoTickets(ArrayList<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void issue() {
        generateLottoTickets(getPurchaseAmount());
    }

    private int getPurchaseAmount() {
        while (true) {
            String purchaseAmountInput = getInputString(INPUT_REQUEST_PURCHASE_AMOUNT.getMessage());
            try {
                return getValidatedPurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getValidatedPurchaseAmount(String purchaseAmountInput) {
        validatePurchaseAmount(purchaseAmountInput);
        return Integer.parseInt(purchaseAmountInput);
    }

    public void validatePurchaseAmount(String purchaseAmountInput) {
        Validator.validateNumericString(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        Validator.validatePositiveNumber(purchaseAmount);
        Validator.validateThousandUnit(purchaseAmount);
    }

    private String getInputString(String message) {
        System.out.println("\n" + message);
        return Console.readLine();
    }

    public void generateLottoTickets(int purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        lottoTickets = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumbers);
            lottoTickets.add(new Lotto(lottoNumbers));
        }
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void print() {
        System.out.println("\n" + lottoTickets.size() + PRINT_LOTTO_TICKETS_SIZE.getMessage());
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public ArrayList<Lotto> getList() {
        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }
}
