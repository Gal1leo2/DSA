package Solutions.pack3_ArrAndList;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

public int getAt(int i){
    if(i<size)
    return -1;
    else return data[i];
}
public void setAt(int d,int i){
    if(i>size-1)
    data[i]=d;
}
public void add(int d){
    data[size]=d;
    size=size+1;
}
public void insert (int d , int i){
    int j;
    for(j=size;j>i;j--){
        data[j] = data[j-1];
    }
    data [i]= d;
    size++;
}
public int find (int d){
    int i=0;
    while(i<size){
        if (data[i]==d)
            return i;
        
    }
    return -1;
}
public int binarySearch(int d) {
    int a = 0, b=size-1;
    while(a<=b) {
    int m = (a+b)/2;
    if(data[m]==d) return m;
    if(d<data[m]) b = m-1;
    else a = m+1; 
    }
    return -1;
    }
public void delete(int index) {
    for(int i=index; i<size-1; i++) {
        data[i] = data[i+1];
    }
        size--;
    }
public MyArrayBasic (int ... a){    
    for (int i =0;i<this.MAX_SIZE;i++){
        data [i] = a[i];
        size++;
    }
    }
public MyArrayBasic(){}

public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    for(int i=0; i<size-1; i++) {
    sb.append(data[i]);
    sb.append(",");
    }
    if(size>0) sb.append(data[size-1]);
    sb.append("]");
    return sb.toString();
    }

    public MyArrayBasic (int a){
        data [0] = a;
    }
}
