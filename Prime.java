import java.util.*;
public class Prime{
    private static Scanner sc;

	public static void main(String args[]) {
 
            sc = new Scanner(System.in);
            int n =sc.nextInt();
            int i=3,j;
            boolean flag;
            if(n==1)
            {
                System.out.println("not exist");
                System.exit(0);
            }
            if(n==2||2<n)
            {
                System.out.println(2);
            
            }
            while(i<=n)
            {	flag=true;
                for (j=2;j<i;j++){
                    if(i%j==0){
                    flag=false;
                    break;
                    }
                } 
                if(flag){
                    System.out.println(i);
                }
                i++;
                
            }
    }
}

