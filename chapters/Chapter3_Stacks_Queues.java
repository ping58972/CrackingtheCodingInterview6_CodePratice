package chapters;

import CtCILibrary.*;
import java.io.*;
import java.util.*;

public class Chapter3_Stacks_Queues {
    public static void all(){
        // threeStacksInOneArray();
        // stackMin();
        // setOfStacks();
        // queueViaStacks();
        // sortStack();
        // AnimalSelter();
        
    }
    public static void AnimalSelter(){
        AnimalShelterQueue animalQ = new AnimalShelterQueue();
        animalQ.enqueue("Cat");
        animalQ.enqueue("Cat");
        animalQ.enqueue("Dog");
        animalQ.enqueue("Cat");
        animalQ.enqueue("Dog");
        animalQ.enqueue("Dog");
        animalQ.enqueue("Cat");
        animalQ.enqueue("Dog");
        animalQ.enqueue("Dog");
        animalQ.enqueue("Cat");
        Animal a = animalQ.dequeueAny();
        System.out.println(a);
        Animal d = animalQ.dequeueDog();
        System.out.println(d);
        Animal c = animalQ.dequeueCat();
        System.out.println(c);
        Animal a1 = animalQ.dequeueAny();
        System.out.println(a1);
        Animal d1 = animalQ.dequeueDog();
        System.out.println(d1);
    }
    public static void sortStack(){
        Stack<Integer> s = new Stack<Integer>();
                s.push(5);
        s.push(3);
        s.push(9);
        s.push(1);
        s.push(1);
        s.push(7);
        s.push(11);
        s.push(2);
        s.push(2);
        s.push(20);
        s.push(12);
        s.push(12);
        s.push(45);
        s.push(21);
        sortStack(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }

    }
    // This algorithm is 0 (N2 ) time and 0 (N) space.
    private static void sortStack(Stack<Integer> s){
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()){
            // Insert each element in s in sorted order into r.
            int tmp = s.pop();
            while(!r.isEmpty() && tmp < r.peek()){
                    s.push(r.pop());
            }
                r.push(tmp);
        }
        // Copy the elements from r back into s.
        while(!r.isEmpty()){
            s.push(r.pop());
        }
    }
    // public static void sortStack(){
    //     SortStack s = new SortStack();
    //     s.push(5);
    //     s.push(3);
    //     s.push(9);
    //     s.push(1);
    //     s.push(1);
    //     s.push(7);
    //     s.push(11);
    //     s.push(2);
    //     s.push(2);
    //     s.push(20);
    //     s.push(12);
    //     s.push(12);
    //     s.push(45);
    //     s.push(21);
    //     while(!s.isEmpty()){
    //         System.out.println(s.pop());
    //     }
    // }
    public static void queueViaStacks(){
        MyQueue<String> myQ = new MyQueue<String>();
        myQ.add("a"); 
        myQ.add("b"); 
        System.out.println(myQ.remove());
        myQ.add("c"); 
        myQ.add("d"); 
        myQ.add("e"); 
        myQ.add("f");
        System.out.println(myQ.remove()); 
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        myQ.add("g"); 
        myQ.add("h");
        // while(!myQ.isEmpty()){
        // System.out.println(myQ.remove());
        // }

    }
    public static void setOfStacks(){
        SetOfStacks<String> set = new SetOfStacks<String>(3);
        set.push("a");
        set.push("b");
        set.push("c");
        set.push("d");
        set.push("e");
        set.push("f");
        set.push("g");
        set.push("h");
        set.push("i");
        set.push("j");
        set.push("k");
        // System.out.println(set.peek());
        System.out.println(set.popAt(1));
        while(!set.isEmpty()){
            System.out.println(set.pop());
        }

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

// Qestion 3.6 Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
// out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
// or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
// that type). They cannot select which specific animal they would like. Create the data structures to
// maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
// and dequeueCat. You may use the built-in Linked List data structure.
class AnimalShelterQueue{
    private LinkedList<Animal> cats;
    private LinkedList<Animal> dogs;
    private int index;
    public AnimalShelterQueue(){
        cats = new LinkedList<Animal>();
        dogs = new LinkedList<Animal>();
        index = 0;
    }
    public void enqueue(String animal){ 
        if(animal.equals("Cat")){
            cats.add(new Animal(index, "Cat"));
        } else {
            dogs.add(new Animal(index, "Dog"));
        }
        index++;
    }
    public Animal dequeueCat(){
        if(cats.size() > 0){
            return cats.poll();
        } 
        return null;
    }
    public Animal dequeueDog(){
        if(dogs.size() > 0){
            return dogs.poll();
        } 
        return null;
    }
    public Animal dequeueAny(){
        if(dogs.size() == 0 ){ 
            return dequeueCat();
        } else if( cats.size() == 0){
            return dequeueDog();
        }
        Animal cat = cats.peek();
        Animal dog = dogs.peek();
        if(cat.number > dog.number){
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }
    
}
class Animal{
    String type;
    int number;
    public Animal(int num, String t){
        type = t;
        number = num;
    }
    @Override
    public String toString(){
        return "Type: "+ type + " Number: "+ number; 
    }
}


// Question 3.5 Sort Stack: Write a program to sort a stack such that the smallest items are on the top. 
// You can use an additional temporary stack, but you may not copy the elements into any other 
// data structure (such as an array). The stack supports the following operations: 
// push, pop, peek, and isEmpty.
class SortStack {
    private Stack<Integer> priStack1;
    private Stack<Integer> priStack2;
    private Stack<Integer> secStack1;
    private Stack<Integer> secStack2;
    private int secTop;
    private int secButton;
    public SortStack(){
        priStack1 = new Stack<Integer>();
        priStack2 = new Stack<Integer>();
        secStack1 = new Stack<Integer>();
        secStack2 = new Stack<Integer>();
    }
    public void push(int d){
        if(secStack1.isEmpty() && secStack2.isEmpty()){
            secStack1.push(d);
        } else {
            
            if(d > secStack1.peek()){
                secStack1.push(d);
            } else {
                priStack2.push(d);
            }

        }
    }
    public int pop(){
        if(priStack1.isEmpty() && priStack2.isEmpty() && secStack1.isEmpty() && secStack2.isEmpty()){
            return Integer.MAX_VALUE;
        }
        if(priStack1.isEmpty() && priStack2.isEmpty()){
            if(!secStack2.isEmpty()){
                return secStack2.pop();
            } 
            while(!secStack1.isEmpty()){
                secStack2.push(secStack1.pop());
            }
            return secStack2.pop();
        } else {
            if(!priStack2.isEmpty()){
                int m = priStack2.peek();
                
                if(secStack2.isEmpty()){
                    while(!secStack1.isEmpty()){
                        secStack2.push(secStack1.pop());
                    }
                }
                int secM = secStack2.peek();
                while(!priStack2.isEmpty()){
                    m = min(m,priStack2.peek());
                    priStack1.push(priStack2.pop());

                }
                if(m >= secM){
                    return secStack2.pop();
                } 
                while(!priStack1.isEmpty()){
                    if(m != priStack1.peek()){
                        priStack2.push(priStack1.pop());
                    } else {
                        
                        priStack1.pop();
                        break;
                    }
                }
                while(!priStack1.isEmpty()){
                    priStack2.push(priStack1.pop());
                }
                return m;
            } else{
                if (secStack2.isEmpty()){
                    while(!secStack1.isEmpty()){
                        secStack2.push(secStack1.pop());
                    }
                }
                return secStack2.pop();
            }
            
        }

    }
    private int min(int a, int b){
        return a < b ? a : b;
    }
    public boolean isEmpty(){
        return priStack2.isEmpty() && secStack2.isEmpty();
    }


}

// Qestion 3.4 Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
class MyQueue<T> {
    Stack<T> stack1;
    Stack<T> stack2;
    T data;
    public MyQueue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    public void add(T d){
        stack1.push(d);
    }
    public T remove(){
        if( stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public T peek(){
        if( stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

// Qestion 3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
// Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
class SetOfStacks<T> {
    private ArrayList<Stack<T>> stacks;
    private final int size;
    private int  i;
    private int index;
    public SetOfStacks(int size){
        stacks = new ArrayList<Stack<T>>();
        index = 0;
        Stack<T> temp = new Stack<T>();
        stacks.add(temp);
        i = 0;
        this.size = size;
    }
    public T popAt(int j){
        if(i <= 0){
            i = size;
            --index;
        }
        T d = stacks.get(j).pop();
        i--;
        return d;
    }
    public boolean isEmpty(){
        return index == 0 && stacks.get(index).isEmpty();
    }
    public void push(T d){
        // System.out.println("i: "+i);
        // System.out.println("index: "+index);
        if(i > size-1){
            addToNewStack();
        } else{
            stacks.get(index).push(d);
            i++;
        }
        
    }
    public T pop(){
        if(i<=0){
            // reduceBackStack();
            i = size;
            --index;
        }
        if(index <0) return null;
        System.out.println("index: "+index);
        System.out.println("i: "+i);
        T d = stacks.get(index).pop();
        i--;
        return d;
    }
    public T peek(){
        return stacks.get(index).peek();
    }

    public void addToNewStack(){
        // int newLength = stacks.size()*2;
        // ArrayList<Stack<T>> newStacks = new Stack<T>[newLength];
        // for(int j=0; j<stacks.length; j++){
        //     newStacks[j] = stacks[j];
        // }
        // stacks = newStacks;
        Stack<T> temp = new Stack<T>();
        stacks.add(temp);
        i =0;
        index++;
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


