package javatest;

/**
 *
 * @author JAVA M2
 */
public class CharList {

    private char[] list;
    private int size;
    private boolean firstTime = true;
    
    public CharList() {
        size = 1;
        list = new char[size];
    }
    
    public void add(char c) {
        if (firstTime) {
            list[0] = c;
            firstTime = false;
        } else {
            size++;
            char[] tmp = new char[size];
            int a = 0;
            while (a < list.length) {
                tmp[a] = list[a];
                a++;
            }
            tmp[a++] = c;
            list = tmp;
        }
    }
    
    public char get(int index) {
        if (index < size)
            return list[index];
        return ' ';
    }
    
    public char[] getArray() {
        return list;
    }
}
