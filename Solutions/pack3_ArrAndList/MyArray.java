package Solutions.pack3_ArrAndList;

public class MyArray extends MyArrayBasic {
    
    public MyArray (int ... a){    
        int MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
        size=0;

        for (int i =0;i< MAX_SIZE;i++){
            data [i] = a[i];
            size++;
        }
    }
    public MyArray(){
        int MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
        size=0;
    }
    public MyArray(int capa){
        MAX_SIZE =capa;
        data = new int [MAX_SIZE];
    }
    public boolean isFull(){
        return size == MAX_SIZE;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public void add(int d){
        if (isFull()){
            expand();
        }
        data[size++] =d;
    }
    public void delete(int i){
        if(!isEmpty()){
            super.delete(i);
        }
    }
    private void  expand(){
        expandByK(2);
    
    }
    private void  expandByK(int k){
        MAX_SIZE =k*MAX_SIZE;
        int [] newData = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
