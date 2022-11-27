package org.example;

/*Основное задание
1. Создать три потока Т1, Т2 и Т3
Реализовать выполнение поток в последовательности Т3 -> Т2 -> Т1
(используя метод join)
Дополнительное задание
2. Напишите многопоточный ограниченный буфер с использованием
ReentrantLock.
3. Напишите многопоточный ограниченный буфер с использованием
synchronized*/

public class Task_one {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread(),"1");
        Thread t2 = new Thread(new MyThread(),"2");
        Thread t3 = new Thread(new MyThread(),"3");

        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
    }
    public static class MyThread implements Runnable{

        public  void run (){
            System.out.println("Начало работы потока №" + Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Закончил работу поток №" + Thread.currentThread().getName());
        }
    }
}