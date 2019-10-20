#include <bits/stdc++.h>
using namespace std;
/* * * *   * * *   	* * * */
typedef long long ll;
typedef long double ld;
typedef pair<int, int> pii;
#define ms(a,v) memset(a,v,sizeof a)
/* * * *   * * *   	* * * */
/* *
 *
 * Author: Hamkor a.k.a. OakenSh1eld
 *
 * */
int main(){
	ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0); 
	int n; //Number of nodes;
	int m; //Number of edges;
	cin>>n>>m;
	vector<pair<int, pii>> edges; //Graph saved as an edge list
	vector<int> dis(n, 1000000000); //Vector of distances, initially all are INF
	int a; // Node a
	int b; //Node b
	int w; //weight
	for(int i=0; i<m; ++i){
		cin>>a>>b>>w;
		edges.push_back({w, {a, b}});
	}
	//Bellman_ford Algorithm;
	int x; cin>>x; //Source node;
	dis[x] = 0;
	for(int i=1; i<n; ++i){
		for(auto e: edges){
			w = e.first, a = e.second.first, b = e.second.second;
			dis[b] = min(dis[b], dis[a] + w);
		}
	}
	int y; cin>>y; //Objective node;
	cout<<dis[y];
	return 0;
}
