package practise_3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //MapSemaphore
        MapSemaphore<Integer, String> ms = new MapSemaphore<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ms.put(i, "Value " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                ms.put(i, "Value " + i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Размер: " + ms.size());

        System.out.println("Содержимое:");
        for (MapSemaphore.Entry<Integer, String> entry : ms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        //SetLock
        SetLock<Integer> setLock = new SetLock<>();

        // Первый поток добавляет элементы в множество
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                setLock.add(i);
                System.out.println("Добавлено: " + i);
            }
        });

        // Второй поток удаляет элементы из множества
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                setLock.remove(i);
                System.out.println("Удалено: " + i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Печать содержимого множества после завершения работы потоков
        System.out.println("Содержимое: " + Arrays.toString(setLock.toArray()));
    }
}