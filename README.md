# java-lotto-precourse

> 우아한테크코스 웹 백엔드 7기 프리코스 3주차

## 📚 목차
1. [💻 개발 환경](#-개발-환경)
2. [🎯 학습 목표](#-학습-목표)
    - [1️⃣ Java `Class`와 `Enum` 학습](#1-java-class와-enum-학습)
    - [2️⃣ Java에서 제공하는 API를 적극 활용](#2-java에서-제공하는-api를-적극-활용)
    - [3️⃣ 2주차 공통 피드백 반영](#3-2주차-공통-피드백-반영)
3. [📝 기능 요구 사항 분석](#-기능-요구-사항-분석)
    - [📄 기능 목록](#-기능-목록)
    - [✏ 기능 세부 사항](#-기능-세부-사항)
4. [📥 입출력 요구 사항](#-입출력-요구-사항)
5. [📊 디자인 및 흐름도](#-디자인-및-흐름도)

---

## 💻 개발 환경

| 항목             | 세부 사항              |
|------------------|------------------------|
| **IDE**          | IntelliJ               |
| **JDK**          | JDK 21                 |
| **Build Tool**   | Gradle                 |
| **Test**         | JUnit                  |
| **OS**           | Windows 10             |

---

## 🎯 학습 목표

### 1) Java `Class`와 `Enum` 학습
> Java의 `Class`와 `Enum`의 기본 개념을 이해하고, 실제 코드에서 적절하게 활용하는 것을 목표로 합니다.
- Java에서 객체지향 프로그래밍의 기본 단위인 클래스를 이해하고, 생성자, 메서드 등의 사용법 익히기
- Java Enum을 통해 상수 집합을 정의하는 방법을 학습하고, Enum을 사용하는 이유와 유용성 알아보기

### 2) Java에서 제공하는 API를 적극 활용
> 3주차 목표대로 코드의 Java에서 제공하는 API를 적극 활용하여 코드를 작성하겠습니다.
- `Java`에서 제공하는 `API`에 대한 기초적인 학습과 숙지하기
- 배열 대신 컬렉션(List, Set, Map 등)을 사용하여 데이터의 특징과 용도에 따라 컬렉션 선택하기


### 3) 2주차 공통 피드백 반영
- 하드 코딩을 피하고, 상수를 사용할 때는 `final` 키워드로 상수를 선언하기
- 구현 순서를 포함한 코딩 컨벤션을 준수하여 일관성 있는 코드 작성하기
- 테스트 작성의 중요성과 이유를 자신의 경험을 토대로 정리하기

---

## 📝 기능 요구 사항 분석

### 📄 기능 목록
- [x] 1) 로또 구입 금액 입력 및 처리
- [ ] 2) 구입 금액에 해당하는 만큼 로또 발행
- [ ] 3) 발행한 로또 수량 및 번호 출력
- [ ] 4) 당첨 번호와 보너스 번호 입력 및 처리
- [ ] 5) 로또 번호와 당첨 번호 비교
- [ ] 6) 당첨 기준에 따라 금액 계산
- [ ] 7) 당첨 내역 출력
- [ ] 8) 수익률 계산 및 출력

### ✏ 기능 세부 사항
> 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
> ```[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.```

#### 1) 로또 구입 금액 입력 및 처리
> 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- **기능 설명**: 사용자로부터 로또 구입 금액을 입력 받는다.
- **세부 사항**:
  - 구입 금액은 1,000원 단위로 입력 받는다.
- **예외 발생**:
  - 빈 값을 입력한 경우
  - 1,000원으로 나누어 떨어지지 않는 경우
   
#### 2) 구입 금액에 해당하는 만큼 로또 발행
> Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.

- **기능 설명**: 구입 금액에 해당하는 만큼 로또를 발행한다.
- **세부 사항**:
  - 1개의 로또를 발행할 때 1~45까지의 중복되지 않는 6개의 숫자를 뽑는다.
  - 위 과정을 구입 금액을 1,000으로 나눈 만큼 진행한다.
 
#### 3) 발행한 로또 수량 및 번호 출력
- **기능 설명**: 발행한 로또 수량 및 번호를 출력한다.
- **세부 사항**:
  - 로또 번호는 오름차순으로 정렬하여 보여준다.
 
```java
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

#### 4) 당첨 번호와 보너스 번호 입력 및 처리

- **기능 설명**: 사용자로부터 당첨 번호와 보너스 번호를 입력 받는다.
- **세부 사항**:
  - 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
  - 당첨 번호는 쉼표(,)를 기준으로 구분한다.
- **예외 발생**:
  - `,` 대신 다른 구분자를 사용할 경우
  - 빈 값을 입력한 경우
  - 숫자가 아닌 문자를 입력한 경우
 
#### 5) 로또 번호와 당첨 번호 비교

- **기능 설명**: 사용자가 구입한 로또 번호와 당첨 번호를 비교하여 일치하는 숫자 개수를 확인한다.
- **세부 사항**:
  - 각 로또 1장마다 당첨 번호와 일치하는 숫자 개수를 확인한다.
  - 위 과정을 진행할 때 보너스 번호 일치 여부도 확인한다.
 
#### 6) 당첨 기준에 따라 금액 계산
> **당첨 기준**
> - 1등: 6개 번호 일치 / 2,000,000,000원
> - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
> - 3등: 5개 번호 일치 / 1,500,000원
> - 4등: 4개 번호 일치 / 50,000원
> - 5등: 3개 번호 일치 / 5,000원

- **기능 설명**: 위 당첨 기준에 따라 수익을 계산한다.
- **세부 사항**:
  - 예를 들어 4개 번호가 일치할 경우, 4등으로 간주해 50,000원을 더한다.
 
#### 7) 당첨 내역 출력

- **기능 설명**: 5,6번에서 처리한 당첨 내역을 출력한다.
- **세부 사항**:
  - 아래 형식에 따라 출력한다.
 
```java
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

#### 8) 수익률 계산 및 출력
- **기능 설명**: 최종 수익에서 원래 구입 금액을 나눈 값을 바탕으로 수익률을 계산하고 출력한다.
- **세부 사항**:
  - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```java
총 수익률은 62.5%입니다.
```
---

## 📥 입출력 요구 사항

- **입력**  
  - 로또 구입 금액을 입력 받는다. 금액은 1,000원 단위로 나누어 떨어져야 하며, 그렇지 않은 경우 예외 처리를 한다.
  - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - 보너스 번호를 입력 받는다.
  
- **출력**  
  - 발행한 로또 수량과 각 로또 번호를 오름차순으로 정렬하여 출력한다.
  - 당첨 내역을 출력한다.
  - 수익률을 소수점 둘째 자리에서 반올림하여 출력한다.
  - 예외 상황 발생 시 “[ERROR]”로 시작하는 에러 문구를 출력한다.

- **실행 결과 예시**  
  ```
  구입금액을 입력해 주세요.
  8000

  8개를 구매했습니다.
  [8, 21, 23, 41, 42, 43] 
  [3, 5, 11, 16, 32, 38] 
  [7, 11, 16, 35, 36, 44] 
  [1, 8, 11, 31, 41, 42] 
  [13, 14, 16, 38, 42, 45] 
  [7, 11, 30, 40, 42, 43] 
  [2, 13, 22, 32, 38, 45] 
  [1, 3, 5, 14, 22, 45]

  당첨 번호를 입력해 주세요.
  1,2,3,4,5,6

  보너스 번호를 입력해 주세요.
  7

  당첨 통계
  ---
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  총 수익률은 62.5%입니다.
  ```

---

## 📊 디자인 및 흐름도

```plaintext
+------------------------+
|   로또 구입 금액 입력    |
+------------------------+
            |
            v
+-------------------------+
|   발행된 로또 번호 출력   |
+-------------------------+
            |
            v
+-------------------------+
|  당첨, 보너스 번호 입력   |
+-------------------------+
            |
            v
+---------------------------+
| 당첨 번호와 로또 번호 비교  |
+---------------------------+
            |
            v
+--------------------------+
|   당첨 내역 및 수익 계산   |
+--------------------------+
            |
            v
+--------------------------+
|  당첨 통계 및 수익률 출력  |
+--------------------------+
```
