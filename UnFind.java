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

int find(int[] parent,int i)
{
if(parent[i]==-1) return i;
return find(parent,parent[i]);
}

void union(int i,int j,int[] parent)
{
int fsParent=find(parent,i);
int secParent=find(parent,j);
parent[fsParent]=secParent;
}

boolean isCycle()
{
	System.out.println(V);
	int[] parent=new int[V];
	for(int i=0;i<V;i++)
		{parent[i]=-1;}

	for(int i=0;i<E;i++)
	{
		int fspar=find(parent,this.edges[i].src);
		int secPar=find(parent,this.edges[i].des);
		if(fspar==secPar) return true;

		union(fspar,secPar,parent);
	}
	return false;
}
}

	
class UnFind
{
static Scanner sc;
	public static void main(String[] args)
	{
		sc=new Scanner(System.in);
		int[] parent;
		int V=sc.nextInt();
		int E=sc.nextInt();
		Graph gs=new Graph(V,E);
		parent=new int[V];
		for(int i=0;i<V;i++)
		{
			parent[i]=-1;
		}
		for(int i=0;i<E;i++)
		{
			gs.edges[i].src=sc.nextInt();
			gs.edges[i].des=sc.nextInt();
		}
if(gs.isCycle()) System.out.println("YES");
else System.out.println("NO");
	}
}