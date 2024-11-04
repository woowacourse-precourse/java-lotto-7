package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConstants;
import lotto.common.LottoValidateUtil;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.purchase.Purchase;
import lotto.domain.purchase.PurchaseDto;

public class LottoServiceImpl implements LottoService {
    private Purchase purchase;
    private Lotto winningLotto;

    @Override
    public void buyLotto(String amount) {
        int convertedAmount = convertStringToInt(amount);
        purchase = new Purchase(convertedAmount);
        List<Lotto> lottos = makeRandomLottos(purchase.getAmount());
        purchase.setLottos(lottos);
    }

    @Override
    public void assignWinningLotto(String numbers) {
        List<Integer> splitNumbers = splitStringToIntegerList(numbers);
        winningLotto = new Lotto(splitNumbers);
    }

    @Override
    public LottoDto getWinningLottoDto() {
        return new LottoDto(winningLotto.getNumbers());
    }

    @Override
    public PurchaseDto getPurchaseDto() {
        List<LottoDto> lottoDtos = convertLottosToLottoDtos(purchase.getLottos());
        return new PurchaseDto(purchase.getAmount(), lottoDtos);
    }

    private List<Lotto> makeRandomLottos(int amount) {
        List<Lotto> purchasedLottos = new ArrayList<>();

        int count = amount / LottoConstants.PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER, LottoConstants.NUMBERS_COUNT);
            purchasedLottos.add(new Lotto(numbers));
        }

        return purchasedLottos;
    }

    private List<LottoDto> convertLottosToLottoDtos(List<Lotto> lottos) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoDtos.add(new LottoDto(lotto.getNumbers()));
        }

        return lottoDtos;
    }

    private List<Integer> splitStringToIntegerList(String numbers) {
        List<Integer> splitNumbers = new ArrayList<>();

        for (String number : numbers.split(",")) {
            String cleanNumber = cleanString(number);
            if (cleanNumber.isBlank()) {
                continue;
            }
            Integer parsedNumber = safeParseInteger(cleanNumber);
            LottoValidateUtil.validateNumberExists(splitNumbers, parsedNumber);
            splitNumbers.add(parsedNumber);
        }

        return splitNumbers;
    }

    private int convertStringToInt(String number) {
        String cleanNumber = cleanString(number);
        return safeParseInteger(cleanNumber);
    }

    //문자열의 공백을 없애주는 로직
    private String cleanString(String text) {
        if (text == null || text.isBlank()) {
            text = "";
        }
        String cleanText = text.replace(" ", "");

        return cleanText;
    }

    private Integer safeParseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }
}