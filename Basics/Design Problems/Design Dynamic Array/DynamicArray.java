/**
 * Thought process:
 * - Initialize an array of an infinite size. Idea is to add/remove number of elements to/from the array
 * and request should be fulfiled.
 *
 *
 */

class DynamicArray{
    private int arr[];
    private int capacity;
    private int length;

    //constructor to initialize the dynamic array
    public DynamicArray(int capacity){
        this.capacity= capacity;
        this.length= 0;
        this.arr= new int[this.capacity];
    }

    //gets element from given index
    public int get(int index){
        return arr[index];
    }

    //adds element to given index
    public int add(int index, int element){
        if(length == capacity)  growSize();

        for(int i= length-1; i>=index; i--){
            arr[i+1]= arr[i];
        }
        arr[index]= element;
        length++;
        return arr[index];
    }

    //adds at the last index of arr.
    public int addLast(int element){
        if(length == capacity){
            growSize();
        }
        arr[length]= element;
        length++;
        return arr.length;
    }

    //removes the last element from arr.
    public int remove(int index){
        if(length > 0)  length--;
        return arr.length;
    }

    public int removeAt(int index){
        if(length > 0){
            for(int i=index; i<length-1; i++){
                arr[i]= arr[i+1];
            }
            arr[length-1]= 0;
            length--;
        }
        return arr.length;
    }

    private void growSize(){
        capacity *= 2;
        int newArr[]= new int[capacity];
        for(int i=0; i< newArr.length; i++){
            newArr[i]= arr[i];
        }
        arr= newArr;
    }

    public void shrinkSize(){
        if(length > 0){
            int newArr[] = new int[length];
            for(int i=0; i< length; i++){
                newArr[i]= arr[i];
            }
            capacity= length;
            arr= newArr;
        }
    }

    public int getSize(){
        return length;
    }

    public int getCapacity(){
        return capacity;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray= new DynamicArray(5);
        System.out.println(dynamicArray.getCapacity());
        System.out.println("Element at given index: " + dynamicArray.add(2,44));
        System.out.println(dynamicArray.getSize());
        for(int i=0; i< dynamicArray.capacity; i++){
            System.out.print(dynamicArray.arr[i] + " ");
        }
    }
}