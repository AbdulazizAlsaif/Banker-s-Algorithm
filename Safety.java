package banker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz Alsaif
 */
public class Safety {
    int nResource;
     int nProcsses;
    int[][] need;
        int[][] available;
         int[][] request;
         int requestP;
         int[][] allocationMatrix;
    public Safety(int[][] available,int[][] request ,int[][] need ,int requestP , int nProcsses,int[][] allocationMatrix){
        nResource=request[0].length;
        this.requestP=requestP;
        this.need=need;
       this.request=request;
        this.available=available;
         this.nProcsses=nProcsses;
         this.allocationMatrix=allocationMatrix;
        
    }
    public boolean resourceRequest(){
     for (int i = 0; i < nResource; i++) {
            int a=need[requestP][i];
            int b=request[0][i];
            int c=available[0][i];
            
            if(b>a||b>c)
                return false;
                else
            {
                available=subtract1D(available, available, request);
                allocationMatrix=add(allocationMatrix, allocationMatrix, request);
                need=subtract2D(need, need, request);
                if(saftey()==true){
                    System.out.println("THE REQUEST CAN BE GRANTED! ");
                }
                else System.out.println("THE REQUEST CAN'T BE GRANTED! ");
            }
     }      
                    
            return true;
        
    }
    
    public boolean saftey(){
        
        int[][]work=new int[available.length][available[0].length];
        for (int i = 0; i < available[0].length; i++) {
            work[0][i]=available[0][i];
        }
        boolean[][]finish=new boolean[nProcsses][nResource];
        for (int i = 0; i < nProcsses; i++) {
            for (int j = 0; j < nResource; j++) {
                finish[i][j]=false;
            }
        }
        for (int i = 0; i < nProcsses; i++) {
            for (int j = 0; j < nResource; j++) {
         int a=need[i][j]; 
            int c=work[0][j];
            if(a<=c&&finish[i][j]==false)
                for (int k = 0; k < nProcsses; k++) {
                    for (int l = 0; l < nResource; l++) {
                  
                        work[0][l]=work[0][l]+allocationMatrix[requestP][l];
                   finish[k][l]=true;
                    }
                }
            }
        }
       for (int k = 0; k < nResource; k++) {
                    for (int l = 0; l < nResource; l++){
                        if(finish[k][l]!=true)
                            return false;
                        return true;
                    }
                        }
         return true;
        ///
    }
    
    public void print(){
        
        if(saftey()==true)
            System.out.println("THE SYSTEM IS IN A SAFE STATE! ");
        
    }
    public void printA(){
        System.out.println("The Available Vector is..." );
        for (int i = 0; i < 2; i++) {
            System.out.print(available[0][i]-request[0][i]);
        }
            
        
    }
    
    
    public int[][] subtract1D(int[][] result,int[][] a, int[][] b) {
      int rows = result.length;
       int columns = result[0].length;
    
       for (int i = 0; i < columns; i++) {
               result[0][i] = a[0][i] - b[0][i];
       }
       return result;
    }
  
    public int[][] subtract2D(int[][] result,int[][] a, int[][] b) {
      int rows = result.length;
       int columns = result[0].length;
    
       for (int i = 0; i < columns; i++) {
               result[requestP][i] = a[requestP][i] - b[0][i];
       }
       return result;
    }
    public int[][] add(int[][] result,int[][] a, int[][] b) {
      int rows = result.length;
       int columns = result[0].length;
    
       for (int i = 0; i < columns; i++) {
               result[requestP][i] = a[requestP][i] + b[0][i];
       }
       return result;
    }
  
    
    
}
