package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoPriceString = Console.readLine();
        Integer lottoPrice;

        try {
            lottoPrice = Integer.parseInt(lottoPriceString);
            if(lottoPrice <= 0 || lottoPrice%1000 != 0){
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        Integer lottoCount = lottoPrice / 1000;
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));

        List<Lotto> lottoList = new ArrayList<>();

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(lottoCount);
        lottoNumberGenerator.generateLotto().forEach(lottoNumber -> {
            lottoList.add(new Lotto(lottoNumber));
            System.out.println(lottoNumber);
        });

        System.out.println("당첨 번호를 입력해 주세요.");
        String winninglottoString = Console.readLine();
        Lotto winningLotto;

        try{
            winningLotto = new Lotto(Arrays
                    .stream(winninglottoString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberString = Console.readLine();
        Integer bonusNumber;

        try{
            bonusNumber = Integer.parseInt(bonusNumberString);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        LottoManager lottoManager = new LottoManager(lottoList, winningLotto, bonusNumber);
        lottoManager.processResult();
        lottoManager.calculateProfitRate();
        lottoManager.printWinningStatistics();
    }
}
