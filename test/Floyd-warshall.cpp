#include <bits/stdc++.h>
/** I'm Klaus, Nicklaus ... npardoa@unal.edu.co
 
 * **/
using namespace std;
#define ms(a,v) memset(a,v,sizeof a)
#define ll long long
ll gcd(ll x, ll y){return (y ? gcd(y, x%y) : x); }
ll lcm(ll x, ll y){return x*(y/gcd(x,y));}
int oo = 1e9+7;
int main(){
	ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
	#ifdef LOCAL_JUDGE
		//freopen("in_out/in.txt", "rt", stdin);
		//freopen("int_out/out.txt", "wt", stdout);
	#endif
	int n, m; // number of nodes and number of edges
	cin>>n>>m;
	vector<vector<int>> adj(n+1,vector<int>(n+1,0));// adjacency matrix
	for(int i=0; i<m; i++){
		int u, v, w;
		cin>>u>>v>>w; // node u, node v and weigth between them
		adj[u][v] = w;
		adj[v][u] = w;
	}
	//Floy-Wharshall algorithm
	vector<vector<int>> dis(n+1, vector<int> (n+1));
	//initialize distance matrix
	for(int u=1; u<=n; u++){
		for(int v=1; v<=n; v++){
			if( u == v ) dis[u][v] = 0;
			else if(adj[u][v]) dis[u][v] = adj[u][v];
			else dis[u][v] = oo; // oo means infinite
		}
	}
	for(int k=1; k<=n; k++){
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);
			}
		}
	}
	int q; //queries
	cin>>q;
	while(q--){
		int u, v;
		cin>>u>>v;
		cout<<"From "<<u<<" to "<<v<<" : "<<dis[u][v]<<endl; // minimum distance between u and v
	}
 	return 0;
}
