package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.Receipt;
import lotto.dto.ResultDto;
import lotto.utils.ErrorMessages;
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
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            System.out.println(ErrorMessages.NUMERIC_INPUT_ONLY_MESSAGE.getMessage());
            receiveMoney();
        }
        return money;
    }

    public LottoDto drawWinningNumbers(){
        askForLottoNumbers();
        List<Integer> numbers = extractNumbers(receiveLottoNumbers());

        askForBonusNumbers();
        LottoDto lottoDto = new LottoDto(numbers, receiveBonusNumbers());

        return lottoDto;
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
    private void askForBonusNumbers() {
        System.out.println(LottoMessages.ENTER.getMessage()+
                LottoMessages.ENTER_BONUS_NUMBER.getMessage());
    }

    private int receiveBonusNumbers() {
        return Integer.parseInt(Console.readLine());
    }
    private void receiveReceipt(Receipt receipt){
        this.purchaseReceipt = receipt;
    }

    private void receiveLottos(List<Lotto> lottos){
        this.purchasedLottos = lottos;
    }
    public void receiveResult(ResultDto resultDto){
        receiveReceipt(resultDto.getReceipt());
        receiveLottos(resultDto.getLottos());
    }

    public Receipt getReceipt() {
        return purchaseReceipt;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}