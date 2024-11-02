package lotto.view;

import lotto.domain.CorrectDTO;
import lotto.domain.Lotto;
import lotto.domain.LottoDTO;
import lotto.domain.MoneyDTO;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    public void printMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketNumber(MoneyDTO moneyDTO) {
        System.out.println(moneyDTO.getTicketNumber() + "개를 구매했습니다.");
    }

    public void printLottos(LottoDTO lottoDTO) {
        for (Lotto list : lottoDTO.getLottos()) {
            System.out.println(list.getLotto().toString());
        }
    }

    public void printCorrect() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 "+rateOfReturn+"%입니다.");
    }

    //전체적으로 통계가 어떻게 나왔는지 출력
    //그런 출력들을 모아서 출력하게끔 하는 함수 생성

    public MoneyDTO getMoneyInput() {
        //제대로 된 값이 입력받을 때까지 반복
        while (true) {
            String input = readLine();
            try {
                validateInput(input);
                int money = parseInput(input);
                return new MoneyDTO(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getBonusInput(CorrectDTO correctDTO) {
        while (true) {
            String input = readLine();
            try {
                validateInput(input);
                int bonus = parseInput(input);
                correctDTO.setBonus(bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public void validateInput(String input) {
        // 입력값이 빈 문자열이거나 null인지 검증
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 빈 문자인지 확인해주세요.");
        }
    }


    //여기서도 제대로 된 값이 들어오지 않은 경우에 대한 예외처리를 진행해야 한다.
    public CorrectDTO getLottoNumberInput() {
        while (true) {
            String input = readLine();
            try {
                return validateAndParseLottoInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public CorrectDTO validateAndParseLottoInput(String input){
        validateInput(input);
        Lotto lotto = new Lotto(sliceToken(input));
        return new CorrectDTO(lotto);
    }

    private List<Integer> sliceToken(String input) {
        String[] tokens = input.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String token : tokens) {
            token = token.trim();
            lotto.add(parseInput(token));
        }
        return lotto;
    }


}

