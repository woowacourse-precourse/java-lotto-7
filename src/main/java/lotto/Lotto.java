package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //유효성검사
    private void validate(List<Integer> numbers) {

        Set<Integer> uniqueNumbers = new HashSet<>();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45 사이여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
            }
        }
    }


    //로또 발행
    public static List<List<Integer>> createLottoTickets(int purchasePrice) {

        if (purchasePrice <= 0 || purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입단위는 1000원 입니다.");
        }
        int lottoCount = purchasePrice / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));            Collections.sort(lottoNumbers);
            lottoTickets.add(lottoNumbers);
            System.out.println(lottoNumbers);
        }

        return lottoTickets;

    }

    //당첨번호 리스트로 변환
    public static List<Integer> convertWinningNumbers(String inputWinningNumbers) {

        List<String> winningNumberArry = List.of(inputWinningNumbers.split(","));

        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : winningNumberArry) {
            winningNumbers.add(Integer.valueOf(number));

        }
        return winningNumbers;
    }

    //매칭카운트
    public static int countMatchingNumbers(List<Integer> ticket, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticket) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private Prize determinePrize(int matchCount, boolean hasBonus) {
        return Prize.getPrizeByMatch(matchCount, hasBonus);
    }

    // 당첨멘트 출력
    public void printWinningStatistics(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Prize, Integer> prizeCounts = new LinkedHashMap<>();

        // 모든 Prize 초기화 (기본값 0으로 설정)
        for (Prize prize : Prize.values()) {
            prizeCounts.put(prize, 0);
        }

        // 각 티켓의 당첨 등수 계산 및 카운트 증가
        for (List<Integer> ticket : lottoTickets) {
            int matchCount = countMatchingNumbers(ticket, winningNumbers);
            boolean hasBonus = ticket.contains(bonusNumber);

            // Prize enum을 사용하여 등수 판별
            Prize prize = Prize.getPrizeByMatch(matchCount, hasBonus);
            prizeCounts.put(prize, prizeCounts.get(prize) + 1);
        }

        // 당첨 통계 출력 (matchCount 기준 오름차순으로 정렬)
        System.out.println("\n당첨 통계\n---");
        prizeCounts.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey().getMatchCount()))  // matchCount 기준으로 오름차순 정렬
                .forEach(entry -> {
                    Prize prize = entry.getKey();
                    if (prize != Prize.NO_PRIZE) {  // "당첨 없음"은 출력하지 않음
                        System.out.printf("%s (%s원) - %d개\n", prize.getDescription(), String.format("%,d", prize.getPrizeAmount()), entry.getValue());
                    }
                });
    }

        //수익률계산
        public static double calculateYield(int purchasePrice, int totalPrize) {
            double yield = ((double) totalPrize / purchasePrice) * 100;
            return Math.round(yield * 10) / 10.0;  // 소수점 첫째 자리에서 반올림
        }

    // 전체 상금 계산 메서드
    public int calculateTotalPrize(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        int totalPrize = 0;

        for (List<Integer> ticket : lottoTickets) {
            int matchCount = countMatchingNumbers(ticket, winningNumbers);
            boolean hasBonus = ticket.contains(bonusNumber);
            Prize prize = determinePrize(matchCount, hasBonus);
            totalPrize += prize.getPrizeAmount();
        }
        return totalPrize;
    }
    }



