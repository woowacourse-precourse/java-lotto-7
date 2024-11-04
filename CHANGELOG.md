# Change Log

<br>
<br>

## v1.1 (2024.11.04)

> 주요 작업 : 리팩토링

- [e7e14c3] [style: 메소드 순선 변경](https://github.com/Gilbert9172/java-lotto-7/commit/e7e14c3)
- [1765cf4] [refactor: 순위를 계산하는 로직을 Lotto 도메인으로 위임](https://github.com/Gilbert9172/java-lotto-7/commit/1765cf4)
- [66dd280] [style: money#toString 메소드 수정](https://github.com/Gilbert9172/java-lotto-7/commit/66dd280)
- [9dc5fc0] [refactor: Java functional interface를 사용하여 입력 실패시 재 입력로직 템플릿화](https://github.com/Gilbert9172/java-lotto-7/commit/9dc5fc0)
- [d9fedc9] [refactor: Lotto에 종속되는 상수들의 위치 변경 및 예외 추가](https://github.com/Gilbert9172/java-lotto-7/commit/d9fedc9)
- [bdc6729] [refactor: EnumMap을 제대로 활용하기 위해 불필요한 sorting 작업 제거](https://github.com/Gilbert9172/java-lotto-7/commit/bdc6729)

<br>

## v1.0 (2024.11.03)

> 주요 작업 : 주요 기능 개발 및 로직 수정

- [f580c2a] [style: 메서드 파라미터에 final 키워드 누락된 부분 추가](https://github.com/Gilbert9172/java-lotto-7/commit/f580c2a)
- [7d330f6] [refactor: RankCondition이 None인 경우에는 결과를 업데이트 하지 않도록 수정](https://github.com/Gilbert9172/java-lotto-7/commit/7d330f6)
- [3bbd811] [refactor: 1회만 사용되는 private static 메서드 제거 및 기타 수정](https://github.com/Gilbert9172/java-lotto-7/commit/3bbd811)
- [4311443] [refactor: 잔돈 확인하는 로직을 static에서 non-static으로 수정](https://github.com/Gilbert9172/java-lotto-7/commit/4311443)
- [496986d] [fix: 로또 번호 40을 패턴에서 누락함](https://github.com/Gilbert9172/java-lotto-7/commit/496986d)
- [c44cdff] [feat: 보너스 번호 input 기능](https://github.com/Gilbert9172/java-lotto-7/commit/c44cdff)
- [4c7a074] [feat: 로또 당첨 번호 input 기능](https://github.com/Gilbert9172/java-lotto-7/commit/4c7a074)
- [d08b1c6] [feat: 구매 금액 input 기능](https://github.com/Gilbert9172/java-lotto-7/commit/d08b1c6)
- [ac95d5f] [refactor: RankCondition이 상금 금액를 관리하도록 구조 변경](https://github.com/Gilbert9172/java-lotto-7/commit/ac95d5f)
- [a0f070a] [feat: 입출력 기능 개발 (예외 처리 작업 포함되지 않음)](https://github.com/Gilbert9172/java-lotto-7/commit/a0f070a)
- [de451c2] [style: 2등 검사 여부를 담당하는 로직의 메서드명 개선](https://github.com/Gilbert9172/java-lotto-7/commit/de451c2)
- [989e539] [fix: 로또 번호 검증시 Null 체크](https://github.com/Gilbert9172/java-lotto-7/commit/989e539)
- [1b614cf] [feat: 회수율 계산 로직 개발](https://github.com/Gilbert9172/java-lotto-7/commit/1b614cf)
- [1faf143] [feat: 총 수익을 계산하는 서비스 로직 개발](https://github.com/Gilbert9172/java-lotto-7/commit/1faf143)
- [31b4f22] [feat: 로또번호 매칭 후 등수 매기는 기능](https://github.com/Gilbert9172/java-lotto-7/commit/31b4f22)
- [4d9e492] [feat: 로또 번호 자동생성 기능](https://github.com/Gilbert9172/java-lotto-7/commit/4d9e492)
