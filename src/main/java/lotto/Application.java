package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static Integer getLottoPrice() {
        Integer lottoPrice;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String lottoPriceString = Console.readLine();
            try {
                lottoPrice = Integer.parseInt(lottoPriceString);
                if (lottoPrice <= 0 || lottoPrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 형식이 잘못되었습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoPrice;
    }

    public static Lotto getWinningLotto() {
        Lotto winningLotto;
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winninglottoString = Console.readLine();
            try {
                winningLotto = new Lotto(Arrays
                        .stream(winninglottoString.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 형식이 잘못되었습니다.");
            } catch (NullPointerException e) {
                System.out.println("[ERROR] 입력 값이 null입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningLotto;
    }

    public static LottoBonusNumber getBonusNumber(Lotto winningLotto) {
        LottoBonusNumber bonusNumber;
        while (true) {
            System.out.println("보너스 볼을 입력해 주세요.");
            String bonusNumberString = Console.readLine();
            try {
                bonusNumber = new LottoBonusNumber(Integer.parseInt(bonusNumberString), winningLotto);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 형식이 잘못되었습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public static void main(String[] args) {
        Integer lottoCount = getLottoPrice() / 1000;

        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));

        List<Lotto> lottoList = new ArrayList<>();

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoCount);
        lottoNumberGenerator.generateLotto().forEach(lottoNumber -> {
            lottoList.add(new Lotto(lottoNumber));
            System.out.println(lottoNumber);
        });

        Lotto winningLotto = getWinningLotto();

        LottoBonusNumber bonusNumber = getBonusNumber(winningLotto);

        LottoManager lottoManager = new LottoManager(lottoList, winningLotto, bonusNumber);
        lottoManager.processResult();
        lottoManager.calculateProfitRate();
        lottoManager.printWinningStatistics();
    }
}
