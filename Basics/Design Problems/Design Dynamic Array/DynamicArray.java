class DynamicArray{
    private int arr[];
    private int capacity;
    private int length;

    //constructor to initialize the dynamic array
    public DynamicArray(){
        capacity= 1;
        length= 0;
        arr= new int[1];
    }

    //gets element from given index
    public int get(int index){
        return arr[index];
    }

    //adds element to given index
    public void addAt(int index, int element){
        if(length == capacity)  growSize();

        for(int i= length-1; i>=index; i--){
            arr[i+1]= arr[i];
        }
        arr[index]= element;
        length++;
    }

    //adds at the last index of arr.
    public void addLast(int element){
        if(length == capacity){
            growSize();
        }
        arr[length]= element;
        length++;
    }

    //removes the last element from arr.
    public void removeLast(){
        if(length > 0)  length--;
    }

    //removes the last element from given index.
    public void removeAt(int index){
        if(length > 0){
            for(int i=index; i<length-1; i++){
                arr[i]= arr[i+1];
            }
            arr[length-1]= 0;
            length--;
        }
    }

    //increses the capacity of arr to double
    private void growSize(){
        capacity *= 2;
        int newArr[]= new int[capacity];
        for(int i=0; i< length; i++){
            newArr[i]= arr[i];
        }
        arr= newArr;
    }

    //decreases the capacity of the arr to the current length
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

    //get arr's current size till where it is filled
    public int getSize(){
        return length;
    }

    //get arr's current capapcity to add elements
    public int getCapacity(){
        return capacity;
    }

    public static void main(String[] args) throws Exception{
        DynamicArray dynamicArray= new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.addLast(7);

        System.out.println("Elements of array:");
        for(int i=0; i< dynamicArray.capacity; i++){
            System.out.print(dynamicArray.arr[i] + " ");
        }

        System.out.println("Size of the array: "+ dynamicArray.getCapacity());
        System.out.println("Number of element in the array: "+dynamicArray.getSize());

        dynamicArray.shrinkSize();
        System.out.println("Elements of array after shrinSize of array:");
        for(int i=0; i< dynamicArray.capacity; i++){
            System.out.print(dynamicArray.arr[i] + " ");
        }

        dynamicArray.addAt(1,23);
        System.out.println("Elements of array after adding at index 1:");
        for(int i=0; i< dynamicArray.capacity; i++){
            System.out.print(dynamicArray.arr[i] + " ");
        }

        dynamicArray.removeLast();
        System.out.println("Elements of array after removing the last element:");
        for(int i=0; i< dynamicArray.capacity; i++){
            System.out.print(dynamicArray.arr[i] + " ");
        }

        dynamicArray.removeAt(1);
        System.out.println("Elements of array after removing the element at index 1:");
        for(int i=0; i< dynamicArray.capacity; i++){
            System.out.print(dynamicArray.arr[i] + " ");
        }
    }
}