package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final int COUNT_OF_LOTTO_NUMBER = 6;
    private final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String OUTPUT_MESSAGE = "%d개를 구매했습니다.\n";

    private final int purchasePrice;
    private final List<Lotto> lottoList;

    public LottoGenerator() {
        String inputValue = input();
        validate(inputValue);

        this.purchasePrice = parseData(inputValue);

        lottoList = new ArrayList<>();
        generateLottoList();
        printLottoList();
    }

    private String input() {
        System.out.println(INPUT_MESSAGE);
        return removeWhiteSpace(Console.readLine());
    }

    private String removeWhiteSpace(String inputValue) {
        return inputValue.trim();
    }

    private void validate(String inputValue) {
        isValidFormat(inputValue);
        isValidPrice(inputValue);
    }

    private void isValidFormat(String inputValue) {
        if (!inputValue.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상의 숫자 하나만 입력 할 수 있습니다.");
        }
    }

    private void isValidPrice(String inputValue){
        int inputPrice = valueInRange(inputValue);
        isMultipleOfAThousand(inputPrice);
    }

    private int valueInRange(String inputValue) {
        try{
            return parseData(inputValue);
        }catch (Exception e){
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 %d 범위를 벗어날 수 없습니다.", Integer.MAX_VALUE));
        }
    }

    private void isMultipleOfAThousand(int inputValue){
        if(inputValue == 0 || inputValue % 1000 > 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해주세요.");
        }
    }

    public List<Lotto> issueLottoList() {
        return lottoList;
    }

    private void generateLottoList() {
        for (int i = 0; i < calculateCountOfLotto(); i++) {
            lottoList.add(generateLottoNumber());
        }
    }

    private int calculateCountOfLotto() {
        return purchasePrice / 1000;
    }

    private Lotto generateLottoNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_LOTTO_NUMBER));
    }

    private int parseData(String inputValue) {
        return Integer.parseInt(inputValue);
    }

    private void printLottoList() {
        System.out.printf(OUTPUT_MESSAGE, lottoList.size());

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}