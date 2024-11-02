package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.dto.Lotto;
import lotto.dto.Receipt;
import lotto.utils.LottoMessages;

public class LottoBuyer {
    private Receipt purchaseReceipt;
    private List<Lotto> purchasedLottos;

    public int purchaseLotto(){
        askForPurchaseAmount();
        return receiveMoney();
    }
    private void askForPurchaseAmount() {
        System.out.println(LottoMessages.ENTER_PURCHASE_AMOUNT.getMessage());
    }

    private int receiveMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> drawWinningNumbers(){
        askForLottoNumbers();
        List<Integer> numbers = extractNumbers(receiveLottoNumbers());

        askForBonusNumbers();
        numbers.add(receiveBonusNumbers());

        return numbers;
    }
    private void askForLottoNumbers() {
        System.out.println(LottoMessages.ENTER_WINNING_NUMBERS.getMessage());
    }

    private String receiveLottoNumbers() {
        return Console.readLine();
    }

    private List<Integer> extractNumbers(String sentence){
        return Arrays.stream(sentence.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void askForBonusNumbers() {
        System.out.println(LottoMessages.ENTER_BONUS_NUMBER.getMessage());
    }

    private int receiveBonusNumbers() {
        return Integer.parseInt(Console.readLine());
    }
    public void receiveReceipt(Receipt receipt){
        this.purchaseReceipt = receipt;
    }

    public void receiveLottos(List<Lotto> lottos){
        this.purchasedLottos = lottos;
    }

    public Receipt getReceipt() {
        return purchaseReceipt;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}