package hello.core.singleton;

public class SingletonService {

    // static 영역에 자기 자신을 생성해 놓는다.
    private static final SingletonService instance = new SingletonService();

    // 이 메서드를 통해서만 객체를 얻을 수 있음
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 객체 생성을 못하게 막아줌 -> new 연산자 사용 불가!
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
