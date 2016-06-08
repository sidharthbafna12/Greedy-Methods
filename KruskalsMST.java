import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
class Graph
{
	Edge edges[];
	int V,E;
	class Edge
	{
		int src,des,value;
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
if(par[i].par==i) return i;
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

void display()
{
	System.out.println("MST Graph");
	for(int i=0;i<E;i++)
	{
		System.out.println(edges[i].src+" "+edges[i].des+" "+edges[i].value);
	}
}	

boolean isCycle(parent[] par)
{
	//System.out.println(V);
	/*int[] parent=new int[V];
	for(int i=0;i<V;i++)
		{parent[i]=-1;}
*/
	for(int i=0;i<E;i++)
	{
		//if(edges[i].src!=0 || edges[i].des!=0)
		{
		int fspar=find(par,this.edges[i].src);
		int secPar=find(par,this.edges[i].des);
		System.out.println(fspar+"     "+secPar+"Cords");
		if(fspar==secPar) return true;

		union(fspar,secPar,par);
	}}
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


class KruskalsMST
{static Scanner sc;
public static void main(String[] ar)
{
	sc=new Scanner(System.in);
		parent[] par;
		int V=sc.nextInt();
		int E=sc.nextInt();
		Graph gs=new Graph(V,E);
		try{
PriorityQueue ps=new PriorityQueue<Graph.Edge>(E,new Comparator<Graph.Edge>(){

	@Override
	public int compare(Graph.Edge o1,Graph.Edge o2)
	{
		if(o1.value<o2.value) return -1;
		else if(o1.value>o2.value) return 1;
		else return 0;
	}
});

		for(int i=0;i<E;i++)
		{	gs.edges[i].value=sc.nextInt();
			gs.edges[i].src=sc.nextInt();
			gs.edges[i].des=sc.nextInt();
			
			ps.add(gs.edges[i]);
		}

		Graph MSt=new Graph(V,V-1);
		parent[] pr=new parent[V];
		for(int i=0;i<V;i++)
		{
			pr[i]=new parent(i,0);
		}

		int count=0;
		for(int i=0;i<E;i++)
		{

			Graph.Edge es=(Graph.Edge)ps.poll();
	
			int x=MSt.find(pr,es.src);
			int y=MSt.find(pr,es.des);
			if(x!=y){
				
			
	
				MSt.edges[count].src=es.src;
				MSt.edges[count].des=es.des;
				MSt.edges[count].value=es.value;
			
				MSt.union(x,y,pr); 
				count++;
			

				if(count==V) break;
			
			}
		}
		MSt.display();
	
}catch(Exception e){System.out.println(e);}

}	
}