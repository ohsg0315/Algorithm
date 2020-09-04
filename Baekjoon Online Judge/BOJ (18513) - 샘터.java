import java.util.*;
import java.io.*;

public class Main { // start of class
    private static class Store { // start of class Store
        long now, weight; // 변수 선언

        public Store(long now, long weight) { // 생성자 선언
            this.now = now; // 입력
            this.weight = weight; // 입력
        } // 생성자 선언
    } // end of class

    public static void main(String[] args) throws IOException { // start of main
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader 선언
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " "); // StringTokenizer 선언
        long n, k, res = 0; // 변수 선언
        HashSet<Long> set = new HashSet<>(); // 이미 건설한 집 위치
        Queue<Store> qu = new LinkedList<>(); // 치킨집 돌리기용 큐

        n = Integer.parseInt(tokenizer.nextToken()); // 변수 입력
        k = Integer.parseInt(tokenizer.nextToken()); // 변수 입력
        tokenizer = new StringTokenizer(br.readLine()); // 변수 받기

        for (int i = 0; i < n; i++) { // start of for
            long now = Integer.parseInt(tokenizer.nextToken());
            qu.offer(new Store(now, 1)); // queue에 치킨집 넣기
            qu.offer(new Store(now, -1));
            set.add(now);
        } // end of for

        while (k > 0) { // start of while
            Store s = qu.poll(); // 큐에서 하나 뺌
            long next = s.now + s.weight; // 왼쪽방향 다음 집 위치

            if (set.add(next)) { // start of if
                k--; // 집 하나 건설
                if (s.weight > 0) {
                    qu.offer(new Store(s.now, s.weight + 1)); // 큐에 weight 증가하여 다시 넣기
                    res += s.weight; // 결과 증가
                } else {
                    qu.offer(new Store(s.now, s.weight - 1)); // 큐에 weight 증가하여 다시 넣기
                    res -= s.weight;
                }
            } // end of if
        } // end of while
        System.out.println(res); // 결과 출력
    } // end of main
} // end of class