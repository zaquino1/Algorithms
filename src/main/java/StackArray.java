public class StackArray {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];
    StackArray() { top = -1; }
    boolean push(int x) {
        if (top >= (MAX - 1)) { System.out.println("Stack Overflow"); return false; }
        else { a[++top] = x; return true; }
    }
    int pop() {
        if (top < 0) { System.out.println("Stack Underflow"); return 0; }
        else { return a[top--]; }
    }
    public static void main(String args[]) {
        StackArray s = new StackArray();
        s.push(10); s.push(20); s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }
}
