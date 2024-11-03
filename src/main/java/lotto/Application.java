package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        Integer totalPrice = Integer.parseInt(readLine());
        if(totalPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 정수를 입력해야 합니다.");
        }

        Integer totalLottoCount = totalPrice / 1000;
        List<List<Integer>> allLottos = new ArrayList<>();
        for(int i = 0; i < totalLottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            allLottos.add(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        String[] inputNumbers = input.split(",");

        Set<Integer> numbersInput = Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .filter(value -> {
                    if(value > 45 || value < 1) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
                    }
                    return true;
                })
                .collect(Collectors.toSet());

        if(numbersInput.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 1~45 사이의 6가지 수여야 합니다.");
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = readLine();
        Integer bonusNumber = Integer.parseInt(bonusNumberInput);
        if(bonusNumber > 45 || bonusNumber <1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
        if(numbersInput.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }


        List<Integer> winningHistoty = allLottos.stream()
                .map(lotto -> {
                    int correctCount = 0;
                    for(Integer value : lotto) {
                        if(numbersInput.contains(value)) {
                            correctCount++;
                        }
                    }
                    if (correctCount == 5) {
                        if (lotto.contains(bonusNumber)) {
                            correctCount = 7;
                        }
                    }
                    return  correctCount;
                })
                .toList();

        List<Integer> winningRanks = winningHistoty.stream()
                .map(wimCount -> {
                    if(wimCount == 6) {
                        return 1;
                    }

                    if(wimCount == 7) {
                        return 2;
                    }

                    if(wimCount == 5) {
                        return 3;
                    }

                    if(wimCount == 4) {
                        return 4;
                    }

                    if(wimCount == 3) {
                        return 5;
                    }

                    return 0;
                })
                .toList();

        Integer totalEarned = winningRanks.stream()
                .mapToInt(rank -> {
                    if(rank == 1) {
                        return 2000000000;
                    }

                    if(rank == 2) {
                        return 30000000;
                    }

                    if(rank == 3) {
                        return 1500000;
                    }

                    if(rank == 4) {
                        return 50000;
                    }

                    if(rank == 5) {
                        return 5000;
                    }

                    return 0;
                })
                .sum();

        double earnRate = ((double) totalEarned / totalPrice) * 10;
        Double roundedEarnRate = Math.round(earnRate * 100) / 100.0;

    }
}
