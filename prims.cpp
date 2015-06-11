#include<iostream.h>
#include<conio.h>
#define size 100

class Graph
{
public:
	int cost[20][20],mincost,n;
	Graph()
	{
	   for(i=1;i<=10;i++)
		for(j=1;j<=10;j++)
			{
			cost[i][j]=-1;
			}
	    mincost=0;
	}
	void Prims();

};

int i,j,k;

void main()
{

Graph G;
int ch,c;
clrscr();

do
{
cout<<"\n Enter Total No Of House(s)";
cin>>G.n;
cout<<"\n Enter -1 (if edge doesnt exist)";
for(i=1;i<=G.n;i++)
  {
  for(j=i+1;j<=G.n;j++)
	{
	  cout<<" Enter cost between House No."<<i<<" and House No."<<j <<":";
	  cin>>c;
	  G.cost[i][j]=G.cost[j][i]=c;
	}
  }

cout<<"\nCost Matrix Is";
  for(i=1;i<=G.n;i++)
       {cout<<"\n";
       for(j=1;j<=G.n;j++)
	 cout<<"\t"<<G.cost[i][j];
       }

cout<<"\nPrims Method... Please enter any key:";
getch();
G.Prims();
cout<<"\nDo you want to return to Prims Calculations";
}while(getche()=='y');

getch();
}


void Graph::Prims()
{
int min,row,col,visit[20],path[20],z;
for(i=2;i<=n;i++)
	visit[i]=0;

visit[1]=1;
z=1;
path[z++]=1;
cout<<"\nInitial Cost Is "<<mincost;

for(k=1;k<=n-1;k++)
      {
	min=999;
	for(i=1;i<=n;i++)
	  {
	   for(j=1;j<=n;j++)
	       {
		if(visit[i]==1 && visit[j]==0)
		   {
		    if(cost[i][j]!=-1 && min>cost[i][j])
			{
			min=cost[i][j];
			row=i;
			col=j;

			}
		    }
		}
	    }
//	cout<<" \nMin"<<min;
	mincost=mincost+min;
	visit[col]=1;
	path[z++]=col;
	cost[row][col]=-1;
	cost[col][row]=-1;
       }
     cout<<"\nTotal Min Cost "<<mincost;
     cout<<"\nSelected  (Shortest) Path:\n";

	for(i=1;i<=n;i++)
		cout<<path[i]<<"=>";
}


