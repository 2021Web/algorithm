#include <stdio.h>
#include <stdbool.h>

bool visited[9];
int graph[9][3] = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};
int queue[10];

// BFS 함수 정의
void bfs(int x)
{
    int front = 0, rear = 0, pop;
    // 현재 노드를 방문 처리
    visited[x] = true;
    queue[0] = x;
    rear++;

    // 현재 위치가 길이보다 작을 때 반복
    while (front < rear)
    {
        pop = queue[front];
        // 현재 위치의 원소 출력
        printf("%d ", pop);
        front++;

        // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for (int i = 0; i < sizeof(graph[x]) / sizeof(int); i++)
        {
            int node = graph[pop][i];
            if (!visited[node] && node != 0)
            {
                queue[rear] = node;
                rear++;
                visited[node] = true;
            }
        }
    }
}

int main(void)
{
    bfs(1);
    return 0;
}
