package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.dto.Lotto;
import lotto.utils.ErrorMessages;
import lotto.utils.LottoMessages;

public class InputOutputManager {
    public int receivePurchaseAmount(){
        askForPurchaseAmount();
        return receiveMoney();
    }
    private void askForPurchaseAmount() {
        System.out.println(LottoMessages.ENTER_PURCHASE_AMOUNT.getMessage());
    }

    private int receiveMoney() {
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            System.out.println(ErrorMessages.NUMERIC_INPUT_ONLY_MESSAGE.getMessage());
            receiveMoney();
        }
        return money;
    }

    public List<Integer> receiveWinningNumbers(){
        askForLottoNumbers();
        return extractNumbers(receiveLottoNumbers());
    }

    private void askForLottoNumbers() {
        System.out.println(LottoMessages.ENTER.getMessage()+
                LottoMessages.ENTER_WINNING_NUMBERS.getMessage());
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

    public int receiveBonusNumber(){
        askForBonusNumbers();
        return receiveBonusNumbers();
    }

    private void askForBonusNumbers() {
        System.out.println(LottoMessages.ENTER.getMessage()+
                LottoMessages.ENTER_BONUS_NUMBER.getMessage());
    }

    private int receiveBonusNumbers() {
        return Integer.parseInt(Console.readLine());
    }

    public void printLottoCount(int numberOfLotto) {
        String message = Stream.of(
                        LottoMessages.ENTER.getMessage(),
                        numberOfLotto,
                        LottoMessages.PURCHASED_LOTTO_COUNT.getMessage())
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println(message);
    }
    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
        }
    }
}
