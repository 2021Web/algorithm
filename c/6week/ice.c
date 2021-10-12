#include <stdio.h>
#include <stdbool.h>

int n, m;
int graph[1000][1000];

// DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
bool dfs(int x, int y)
{
    // 주어진 범위를 벗어나는 경우에는 즉시 종료
    if (x <= -1 || x >= n || y <= -1 || y >= m)
    {
        return false;
    }
    // 현재 노드를 아직 방문하지 않았다면
    if (graph[x][y] == 0)
    {
        // 해당 노드 방문 처리
        graph[x][y] = 1;
        // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
        return true;
    }
    return false;
}

int main()
{
    // N, M을 공백을 기준으로 구분하여 입력 받기
    scanf("%d", &n);
    scanf("%d", &m);
    char input[1000];

    // 2차원 리스트의 맵 정보 입력 받기
    for (int i = 0; i < n; i++)
    {
        // 2차원 리스트의 맵 정보 입력 받기
        scanf("%s", input);
        for (int j = 0; j < m; j++)
        {
            // 입력 값 숫자로 변환
            int num = input[j] - '0';
            graph[i][j] = num;
        }
    }
    // 모든 노드(위치)에 대하여 음료수 채우기
    int result = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            // 현재 위치에서 DFS 수행
            if (dfs(i, j))
            {
                result += 1;
            }
        }
    }
    printf("%d", result);

    return 0;
}