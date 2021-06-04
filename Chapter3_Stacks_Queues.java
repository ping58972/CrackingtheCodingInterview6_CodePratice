public class Chapter3_Stacks_Queues {
    public static void all(){
        // threeStacksInOneArray();
        stackMin();
    }
    public static void stackMin(){
        StackMin stack_min = new StackMin();
        stack_min.push(4);
        stack_min.push(6);
        stack_min.push(3);
        stack_min.push(8);
        stack_min.push(2);
        stack_min.push(-1);
        stack_min.push(5);
        System.out.println(stack_min.min());
        // System.out.println(stack_min.peek());
        stack_min.pop();
        stack_min.pop();
        System.out.println(stack_min.min());
        stack_min.push(5);
        stack_min.push(1);
        stack_min.push(3);
        stack_min.push(7);
        stack_min.pop();
        stack_min.pop();
        System.out.println(stack_min.min());
      
        
        
    }
    
    ///////////
    public static void threeStacksInOneArray(){
        ThreeStacksInOneArray<String> tsioa = new ThreeStacksInOneArray<String>();
        tsioa.pushInOne("111a");
        tsioa.pushInTwo("222b");
        tsioa.pushInThree("333c");
        tsioa.pushInOne("111a");
        tsioa.pushInTwo("222b");
        tsioa.pushInThree("333c");
        tsioa.pushInOne("111a");
        tsioa.pushInTwo("222b");
        tsioa.pushInThree("333c");
        tsioa.pushInOne("111a");
        tsioa.pushInTwo("222b");
        tsioa.pushInThree("333c");
        while(!tsioa.isEmptyOne() && !tsioa.isEmptyTwo()&& !tsioa.isEmptyThree()){
            System.out.println(tsioa.popOne());
            System.out.println(tsioa.popTwo());
            System.out.println(tsioa.popThree());
        }
        // System.out.println(tsioa.peekTwo());
        // System.out.println(tsioa.peekThree());
    }
}

// Question 3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
// which returns the minimum element? Push, pop and min should all operate in 0(1) time.
class StackMin {
    private static class Stack{
        private int data;
        private Stack next;
        public Stack(int d){
            data = d;
        } 
    }
    private static class MinStack{
        private int data;
        private MinStack next;
        public MinStack(int d){
            data = d;
        } 
    }
    private Stack top;
    private MinStack minTop;
    public int pop(){
        if(top == null) return Integer.MAX_VALUE;
        int d = top.data;
        top = top.next;
        if(minTop.data == d){
            if(minTop == null) return Integer.MAX_VALUE;
            minTop = minTop.next;
        }
        return d;
    }
    public void push(int d){
        Stack t = new Stack(d);
        t.next = top;
        top = t;
        if (minTop == null){
            minTop = new MinStack(d);
        } else {
            if(d < minTop.data){
                MinStack m = new MinStack(d);
                m.next = minTop;
                minTop = m;
            }
        }
    }
    public int peek(){
        if(top == null) return Integer.MAX_VALUE;
        return top.data;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public int min(){
        if(minTop == null) return Integer.MAX_VALUE;
        return minTop.data;
    }
}

// Question 3.1 Three in One: Describe how you could use a single array to implement three stacks.
class ThreeStacksInOneArray<T> {
    Object [] arr;
    int one;
    int two;
    int three;
    public ThreeStacksInOneArray(){
        arr = new Object[9];
        one = 0;
        two = 0;
        three = 0;
    }

    public void pushInOne(T item){
        if(one*3 >= arr.length){
            increaseArrSize();
        }
        arr[one*3] = item;
        one++;
    }
    public void pushInTwo(T item){
        if((two*3+1) >= arr.length){
            increaseArrSize();
        }
        arr[(two*3+1)] = item;
        two++;
    }
    public void pushInThree(T item){
        if((three*3+2) >= arr.length){
            increaseArrSize();
        }
        arr[(three*3+2)] = item;
        three++;
    }
    public T popOne(){
        if(one <0 ) return null;
        
        T item = (T)arr[one*3];
        one--;
        if(one*3 < arr.length && (two*3 +1) < arr.length && (three*3 + 2) < arr.length){
            shrinkArrSize();
        }
        return item;
    }
    public T popTwo(){
        if(two <0) return null;
        
        T item = (T)arr[(two*3+1)];
        two--;
        if(one*3 < arr.length && (two*3 +1) < arr.length && (three*3 + 2) < arr.length){
            shrinkArrSize();
        }
        return item;
    }
    public T popThree(){
        if(three < 0) return null;
        
        T item = (T)arr[(three*3+2)];
        three--;
        if(one*3 < arr.length && (two*3 +1) < arr.length && (three*3 + 2) < arr.length){
            shrinkArrSize();
        }
        return item;
    }
    public T peekOne(){
        if(one < 0) return null;
        return (T)arr[one*3];
    }
    public T peekTwo(){
        if(two < 0) return null;
        return (T)arr[(two*3+1)];
    }
    public T peekThree(){
        if(three < 0) return null;
        return (T)arr[(three*3+2)];
    }
    public boolean isEmptyOne(){
        return one < 0;
    }
    public boolean isEmptyTwo(){
        return two < 0;
    }
    public boolean isEmptyThree(){
        return three < 0;
    }
    private void increaseArrSize(){
        int newSize = arr.length * 2;
        Object[] newArr = new Object[newSize];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    private void shrinkArrSize(){
        // int newSize = arr.length/2;
        // Object [] newArr = new Object[newSize];
        // for(int i=0; i<newSize; i++){
        //     newArr[i] = arr[i];
        // }
        // arr = newArr;
    }

}


