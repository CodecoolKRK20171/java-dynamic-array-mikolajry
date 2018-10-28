package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int index = 0;
    private int length;
    private int[] array;


    public DynamicIntArray(int size) {
        this.length = size;
        array = new int[size];
    }


    public DynamicIntArray() {
      this(10);
    }

    public void add(int element)
    {
        resize();
        array[index]=element;
        index++;
    }


    private void resize()
    {
        if(index == length)
        {
            increaseSize();
        }
        else if (index == (length / 4 - 1))
        {
            decreaseSize();
        }
    }

    private void increaseSize()
    {
        int[] tempArray = new int[2 * length];
        for (int i = 0; i < index; i++)
        {
            tempArray[i] = array[i];
        }
        array = tempArray;
        length = 2 * length;
    }

    private void decreaseSize()
    {
        int[] tempArray = new int[(length/4)];
        for (int i = 0 ; i < index; i++)
        {
            tempArray[i] = array[i];
        }
        array = tempArray;
        length = length/4;
    }

    public void insert(int i, int element)
    {
        if (i < index)
        {
            index++;
            for (int j = index; j > i; j--) {
                resize();
                array[j] = array[j - 1];
            }
            array[i] = element;
        }
        else
        {
            add(element);
        }
    }

    public int searchElement(int element)
    {
        for(int i = 0; i < index; i++)
        {
            if(array[i] == element)
            {
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Element not found : " + element);
    }

    public void remove(int i)
    {
        int indexToRemove = searchElement(i);
        if (indexToRemove >= 0)
        {
            removeElementAtIndex(indexToRemove);
        }
    }

    public void removeElementAtIndex(int i)
    {
        if (i < index)
        {
            for(int j = i; j < index; j++)
            {
                array[j] = array[j+1];
            }
            array[index--] = 0;
            resize();
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException("index " + i + " is greater than the size of array " + index);
        }
    }



    public String toString() {

        String result = "";
        for (int i = 0; i < index; i++) {
            result += " " + array[i] ;
        }

        return result;
    }
}
