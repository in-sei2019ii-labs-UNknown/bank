#include <iostream>
#include <vector>
#include <queue>
#include <utility>
#include <cmath>
using namespace std;

int main()
{
    int N = 5;//numero de nodos+1
    int n= N-1;
    vector<pair<int,int> > adj[N];

    adj[1].push_back({2,5});
    adj[2].push_back({3,7});
    adj[2].push_back({4,6});
    adj[3].push_back({4,5});
    adj[4].push_back({1,2});

    priority_queue<pair<int,int> > q;

    int distance[N];
    bool processed[N];

    for (int i = 1; i <= n; i++) {
        distance[i] = 100000;
        processed[i] = false;
    }
    int ni,nf;
    cout<<"Nodo de inicio: ";
    cin>>ni;
    cout<<"Nodo final: ";
    cin>>nf;


    distance[ni] = 0;
    q.push({0,ni});
    while (!q.empty()) {
        int a = q.top().second; q.pop();
        if (processed[a]) continue;
        processed[a] = true;
        for (auto u : adj[a]) {
            int b = u.first, w = u.second;
            if (distance[a]+w < distance[b]) {
                distance[b] = distance[a]+w;
                q.push({-distance[b],b});
            }
        }
    }

   cout<<"la distancia al nodo "<<ni<<" es: "<< distance[nf];
    return 0;
}
