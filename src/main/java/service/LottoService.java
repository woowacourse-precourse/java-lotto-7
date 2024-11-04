package service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import object.Lotto;

public class LottoService {

    public LottoService() {
    }

    
    public List<Lotto> makeRandomLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }

        return lottos;
    }


    private String getWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String[] splitWinNumbers(String winNumbers) {
        String[] splitWinNumbers = winNumbers.split(",");

        return splitWinNumbers;
    }

    private List<Integer> convertWinNumbers(String[] splitWinNumbers) {
        List<Integer> convertToInteger = new ArrayList<>();

        for (String splitWinNumber : splitWinNumbers) {
            convertToInteger.add(Integer.parseInt(splitWinNumber));
        }

        return convertToInteger;
    }

    public List<Integer> winNumbersInput() {
        return convertWinNumbers(splitWinNumbers(getWinNumbers()));
    }
}
