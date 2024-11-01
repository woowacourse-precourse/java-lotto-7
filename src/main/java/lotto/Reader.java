package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Reader {
    public int readMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return readInt();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 로또 한 개의 가격 보다 큰 정수만 입력해야 합니다.");
                System.out.println("현재 로또 금액: " + LottoShop.PRICE + "원");
            }
        }
    }

    public List<Integer> readLottoNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return readIntStream();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자를 쉼표(,)로 구분해서 입력해야 합니다.");
            }
        }
    }

    public int readBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return readInt();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

    }

    private List<Integer> readIntStream() {
        try {
            String[] strings = readLine().split(",");
            return Arrays.stream(strings).map(Integer::parseInt).toList();
        } catch (NoSuchElementException | IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (SecurityException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
