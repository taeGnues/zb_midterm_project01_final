### 요구사항

- ERD를 통한 데이터 설계 작성
- 서울시 공공와이파이 서비스 위치 정보    
[서울시 공공와이파이 서비스 위치 정보](https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do)

### 기능

- 공공 와이파이 정보 가져옴
- 내 위치 정보를 입력 시 가까운 위치에 있는 와이파이 정보 20개를 보여주는 기능.
- 내가 입력한 위치 정보에 대해서 조회하는 시점에 DB에 히스토리를 저장 및 보여주는 기능.
- DB는 SQLite

### 프로젝트 설정

| Application Server | Tomcat 8.5 |
| --- | --- |
| Language | Java |
| Build System | Gradle |
| JDK | JDK 1.8 |
| DB | SQLite |

- JSP를 사용했습니다.
