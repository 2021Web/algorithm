import java.io.*;
import java.util.*;

public class maze_bfs {

  public static int N, M;
  public static int[][] graph = new int[200][200];
  //이동할 네 가지 방향 정의 {상, 하, 좌 ,우}
  public static int dx[] = { -1, 1, 0, 0 };
  public static int dy[] = { 0, 0, -1, 1 };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // N, M 입력
    N = scanner.nextInt();
    M = scanner.nextInt();
    scanner.nextLine(); //버퍼 지우기
    // 2차원 배열의 정보 입력 받기
    for (int i = 0; i < N; i++) {
      String str = scanner.nextLine();
      for (int j = 0; j < M; j++) {
        graph[i][j] = str.charAt(j) - '0';
      }
    }
    scanner.close();
    System.out.println(bfs(0, 0));
  }

  // BFS로 특정 노드를 방문하고 상하좌우로 연결된 모든 노드들도 방문
  public static int bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));
    //큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      x = node.getX();
      y = node.getY();
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        //미로 범위를 벗어나면 무시
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        //한 번 왔던 위치면 무시 , 괴물이 있는 위치면 무시
        if (graph[nx][ny] == 1) {
          //   System.out.println("[" + nx + "," + ny + "]");
          graph[nx][ny] = graph[x][y] + 1;
          queue.add(new Node(nx, ny));
        }
      }
    }
    // 가장 오른쪽 아래까지의 최단 거리 반환
    return graph[N - 1][M - 1];
  }

  static class Node {

    private final int x;
    private final int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
