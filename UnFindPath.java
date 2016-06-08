import java.util.Scanner;

class Graph
{
	Edge edges[];
	int V,E;
	class Edge
	{
		int src,des;
	}

	Graph(int V,int E)
	{
		this.V=V;
		this.E=E;
		edges=new Edge[E];

		for(int i=0;i<E;i++)
		{
			edges[i]=new Edge();
		}
	}

int find(parent[] par,int i)
{
if(par[i].par==-1) return i;
int pr= find(par,par[i].par);
par[i].par=pr;
return pr;
}

void union(int i,int j,parent[] par)
{
int fsParent=find(par,i);
int secParent=find(par,j);
if(fsParent!=secParent)
{
if(par[fsParent].rank<=par[secParent].rank)
{	par[fsParent].par=secParent;par[secParent].rank++;}
else
{par[secParent].par=fsParent;par[fsParent].rank++;}


}

}

boolean isCycle(parent[] par)
{
	System.out.println(V);
	/*int[] parent=new int[V];
	for(int i=0;i<V;i++)
		{parent[i]=-1;}
*/
	for(int i=0;i<E;i++)
	{
		int fspar=find(par,this.edges[i].src);
		int secPar=find(par,this.edges[i].des);
		if(fspar==secPar) return true;

		union(fspar,secPar,par);
	}
	return false;
}
}

	class parent
	{
		int par;
		int rank;
		public parent(int par,int rank)
		{this.par=par;this.rank=rank;}
	}
class UnFindPath
{
static Scanner sc;
	public static void main(String[] args)
	{
		sc=new Scanner(System.in);
		parent[] par;
		int V=sc.nextInt();
		int E=sc.nextInt();
		Graph gs=new Graph(V,E);
		par=new parent[V];
		
		for(int i=0;i<V;i++)
		{
			par[i]=new parent(-1,0);
		}

		for(int i=0;i<E;i++)
		{
			gs.edges[i].src=sc.nextInt();
			gs.edges[i].des=sc.nextInt();
		}
		
		if(gs.isCycle(par)) System.out.println("YES");
		
		else System.out.println("NO");
	}
}