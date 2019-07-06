package org.anna.task_2;

public class Main {
    public static void main(String[] args) {
        IntList list = new IntArrayList();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list);

        System.out.println(list.add(3, 333));

        list.clear();
        System.out.println("size: " + list.size());

        for (int i = 1; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("get value index = 5: " + list.get(5));

        System.out.println(list.isEmpty());

        System.out.println(list.remove(0));

        System.out.println(list.set(10, 10));

        System.out.println(list.removeByValue(10));

        System.out.println(list.subList(3, list.size() - 1));

    }

}

