package lotto;

import java.util.List;
import lotto.EnumManagement.InputViewEnum;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final int lottoPurchase;
    private final int lottoCount;
    private List<Integer> lottoNumbers;
    private int bonusNumber;
    private final Exception exception = new Exception();
    final int LOTTO_PRICE = 1000;

    public InputView() {
        this.lottoPurchase = lottoPurchase();
        this.lottoCount = lottoPurchase / LOTTO_PRICE;
    }

    public int lottoPurchase() {
        while (true) {
            System.out.println(InputViewEnum.PURCHASE_AMOUNT.getMessage());
            String lottoPurchase = Console.readLine();
            try {
                return exception.validateLottoPurchase(lottoPurchase);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void bonusNumber() {
        while (true) {
            System.out.println(InputViewEnum.BONUS_NUMBER.getMessage());
            String bonusNumberInput = Console.readLine();
            try {
                this.bonusNumber = exception.validateBonusNumber(bonusNumberInput);
                exception.validateBonusNumber(this.bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void lottoNumbers() {
        while (true) {
            System.out.println(InputViewEnum.LOTTO_NUMBER.getMessage());
            String rawNumbers = Console.readLine();
            try{
                this.lottoNumbers = exception.parseLottoNumbers(rawNumbers);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
    }

    public void inputStart(OutputView outputView) {
        outputView.outputLottoNumbers();
        lottoNumbers();
        bonusNumber();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getLottoPurchase() {
        return lottoPurchase;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
