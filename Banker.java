
package banker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 
public class Banker {
static Scanner Sc;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File(args[0]);
        Sc = new Scanner(file);
       
        int nProcsses=Integer.parseInt(Sc.next());
        int nResource=Integer.parseInt(Sc.next());
        int[][] allocationMatrix= new int[nProcsses][nResource];
        int[][] maxMatrix= new int[nProcsses][nResource];
        int[][] needMatrix=new int[nProcsses][nResource];
        int[][] available=new int[1][nResource];
         int[][] request=new int[1][nResource];

         fillMatrix(allocationMatrix, nProcsses, nResource);
          fillMatrix(maxMatrix, nProcsses, nResource);
           subtract(needMatrix,maxMatrix,allocationMatrix);
            fillMatrix(available, 1, nResource);
        
         String a=Sc.next();
        
        char b=a.charAt(2);
        String z=String.valueOf(b);
        
        char m=a.charAt(0);
        String s=String.valueOf(m);
      int requestP=Integer.parseInt(s);//Request Proc number
      requestP=requestP+0;
      
      Safety safe=new Safety(available,request,needMatrix,requestP,nProcsses,allocationMatrix);
      
        
        request[0][0]=Integer.parseInt(z);
        request[0][1]=Integer.parseInt(Sc.next());
       request[0][2]=Integer.parseInt(Sc.next());
        request[0][3]=Integer.parseInt(Sc.next());
       
        
        //print 
        System.out.println("There are " + nProcsses + " processes in the system. ");
        System.out.println("There are " + nResource + " resource types.");
        System.out.println("The Allocation Matrix is .");
       
       printMatrix(allocationMatrix, nProcsses, nResource);
        System.out.println("");
      
        System.out.println("The Max Matrix is... ");
        printMatrix(maxMatrix, nProcsses, nResource);
        System.out.println("");
       
        System.out.println("The Need Matrix is.");
        printMatrix(needMatrix,nProcsses, nResource);
        System.out.println("");
        
        System.out.println("The Available Vector is... ");
        printMatrix(available,1, nResource);
        System.out.println("");
        
        System.out.println("");
        // banker algorithem
        safe.print();
        System.out.println("");
        System.out.println("The Request Vector is... " );
        printMatrix(request,1, nResource,a.substring(0, 2));
       
         
        System.out.println("");
        
        //request granted 
        System.out.println("");
        safe.resourceRequest();
       printMatrix(available, 1, nResource);
        System.out.println("");
        //avaliable after request
      //  safe.printA();
    }
    
    
    
    
    
    
    
    
    
    //subtact matricies
       public static int[][] subtract(int[][] result,int[][] a, int[][] b) {
      int rows = result.length;
       int columns = result[0].length;
    
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < columns; j++) {
               result[i][j] = a[i][j] - b[i][j];
           }
       }
       return result;
   }
    
    
    
    
    
    
    
    public static void fillMatrix(int[][] a,int nP,int nR){
         for (int i = 0; i < nP; i++) {
            for (int j = 0; j <nR; j++) {
               a[i][j]=Integer.parseInt(Sc.next());
                
            }
           
        }
    }
       public static void fillMatrix(int[][] a,int nP,int nR , int z){
         for (int i=z ; i < nP; i++) {
            for (int j = 0; j <nR; j++) {
               a[i][j]=Integer.parseInt(Sc.next());
                
            }
           
        }
    }
     public static void printMatrix(int[][] a,int nP,int nR){
         int z=65+nR;
    
         if (nP>1)   
              System.out.print ("  ");
         for (int i = 65; i <z; i++) {
             System.out.print((char)i );
         }
         System.out.println("");
        
        
         
         
         for (int i = 0; i < nP; i++) {
            if (i!=0)
            System.out.println("");
           if (nP>2) 
            System.out.print(i+":");
            for (int j = 0; j <nR; j++) {
               
                System.out.print(a[i][j]);
                
            }
        }
    }
     
    public static void printMatrix(int[][] a,int nP,int nR , String g){
         int z=65+nR;
        
     
              System.out.print ("  ");
         for (int i = 65; i <z; i++) {
             System.out.print((char)i );
         }
         System.out.println("");
        
        
         System.out.print(g);
         
         for (int i = 0; i < nP; i++) {
           
             if (i!=0)
            System.out.println("");
           if (nP>2) 
           System.out.print(i+":");
            for (int j = 0; j <nR; j++) {
               
                System.out.print(a[i][j]);
                
            }
        }
    }

}
