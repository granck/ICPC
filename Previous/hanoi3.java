import java.io.*;
import java.lang.*;
public class hanoi3 // iterative hanoi. corners : 0, 1 and 2. Discs 0,1, .. N-1
{
static public void main(String args[])
{
	 int N = 30; // number of discs
	 int nummoves,second=0,third,pos2,pos3,j,i = 1;
	 int [] locations = new int[N+2]; // remembers which corner each disc is on
	 for (j=0; j<N; j++) locations[i] = 0; // initially all are on 0
	 locations[N+1]=2; // 2 is destination
	 nummoves = 1;
	 for (i=1; i<=N; i++) nummoves*=2;
	 nummoves -= 1;
	 for (i=1; i<= nummoves; i++)
	 {
		 if (i%2==1)
	 	{
		 // odd numbered move - move disc 1
		 second = locations[1]; // remember where disc 1 moved from
		 locations[1] = (locations[1]+ 1) %3;
		 System.out.print("Move disc 1 to ");
		 System.out.println((char)('A'+locations[1]));
		 }
		 else
		 {
			 // even numbered move make only move possible not involving disc 1
			 third = 3 - second - locations[1];
			 // find smallest values on the other 2 corners
			 pos2 = N+1; for (j=N+1; j>=2; j--) if (locations[j]==second) pos2=j;
			 pos3 = N+1; for (j=N+1; j>=2; j--) if (locations[j]==third) pos3=j;
			 System.out.print("Move disc ");
			 // move smaller on top of larger
			 if (pos2<pos3)
			 {
			 System.out.print(pos2);
			 System.out.print(" to ");
			 System.out.println((char)('A'+third));
			 locations[pos2]=third;
			 }
			 else
			 {
			 System.out.print(pos3);
			 System.out.print(" to ");
			 System.out.println((char)('A'+second));
			 locations[pos3]=second;
			 }
	 	}
	 }
}} 
