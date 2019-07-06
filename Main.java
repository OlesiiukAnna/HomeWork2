package org.anna.task_2;

public class Main {
    public static void main(String[] args) {
        IntList list = new IntArrayList();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println("" + list);

        System.out.println("should add new element by index: " + list.add(3, 333));
        System.out.println(list);

        list.clear();
        System.out.println("List size after clear(): " + list.size());

        for (int i = 1; i < 20; i++) {
            list.add(i);
        }
        System.out.println("New list: " + list);
        System.out.println("Get value index = 5: " + list.get(5));

        System.out.println("List IsEmpty(): " + list.isEmpty());

        System.out.println("List remove(0): " + list.remove(0));
        System.out.println(list);

        System.out.println("List set(index: 10, value: 10): " + list.set(10, 10));
        System.out.println(list);

        System.out.println("List removeByValue(10): " + list.removeByValue(10));
        System.out.println(list);

        System.out.println("Create subList(): " + list.subList(3, list.size() - 1));

    }

}

