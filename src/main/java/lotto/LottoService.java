package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public LottoService() {
    }

    public Integer convertInputToCash(String input) {
        return Integer.parseInt(input);
    }

    public Integer convertInputToLottoAmount(String input) {
        Integer lottoAmount  = 0;

        while (true) {
            try {
            /*if (!LottoUtils.isNumber(input)) {
                System.out.println(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage());
                throw new IllegalArgumentException();
            }*/

                Integer cash = Integer.parseInt(input);

                if (cash % 1000 != 0) {
                    System.out.println(ErrorMessage.INVALID_CASH_MESSAGE.getMessage());
                    throw new IllegalArgumentException();
                }

                if (cash <= 0) {
                    System.out.println(ErrorMessage.NO_CASH_MESSAGE.getMessage());
                    throw new IllegalArgumentException();
                }

                lottoAmount = cash / 1000;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_MESSAGE.getMessage());
                input = Console.readLine();
            }
        }

        return lottoAmount;
    }

    public Lotto parseWinningNumber(String input) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] numbers = input.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        Lotto winningLotto = new Lotto(winningNumbers);

        return winningLotto;
    }

    public Integer parseBonusNumber(String input) {
        if (!LottoUtils.isNumber(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    public List<Lotto> getLotto(Integer lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);

            lottos.add(lotto);
        }

        return lottos;
    }

    public Boolean haveBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        Boolean haveBonusNumber = false;

        if (numbers.contains(bonusNumber)) {
            return true;
        }

        return haveBonusNumber;
    }
}
