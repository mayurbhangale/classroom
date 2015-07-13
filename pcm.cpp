#include <iostream> 
#include <math.h> 
#include<bitset>

using namespace std;

class pcm{
    int amplitude, times, i ;
    float freq;
    int x[100], y[100];

public:

    pcm(){
        amplitude = 0;
        times =0;
        freq = 0;
    }

    void GetData(){
        cout<<"\nEnter 'amplitude': ";
        cin>>amplitude;
        cout<<"\nEnter 'frequency': ";
        cin>>freq;
        cout<<"\nEnter the no. of 'times' you want to run: ";
        cin>>times;
    }

    void Sampling(){
        for (i = 0; i < times; ++i)
        {
            x[i] = (amplitude*sin(2 * 22.0/7 * freq * i));
	    cout<<x[i]<<" ";
        }
	cout <<"hello";
    }
    void delta(){
	int b,size,q,p,n,k,t;

	cout<<"Enter No of bits : ";
	cin>>b;
	q=pow(2,b-1);
	size=amplitude/q;

	for(t=0;t<=times;t++){
	  if(x[t]>=0){
	      p=0;
	      n=size;
	       
		for(k=0;k<q;k++){
		     if(x[t]>=p && x[t]<=n){
			 y[t]=k+q;	
			 break;
		      }
			p=n;
			n=n+size;
		}

	}
		     else{
			p=-1;n=-size;
				for(k=0;k<q;k++){
					if(x[t]<=p&&x[t]>=n){
							 y[t]=q-k-1;
							 break;
					}
						p=n;
						n=n-size;
					}

			}
		cout<<" "<<y[t];
		
	}
     }	
	void convert(){
		cout<<endl;
		for(int t=0;t<=times;t++){
			cout<<" "<<bitset<3>(y[t]);
		}
	}


};

int main(int argc, char *argv[])
{
    cout<<" -- Pulse Code Mod -- ";
    pcm sig;
    sig.GetData();
    sig.Sampling();
    sig.delta();
    sig.convert();
    return 0;
}
