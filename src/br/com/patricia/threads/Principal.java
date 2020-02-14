package br.com.patricia.threads;

import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Lista lista = new Lista();
        Semaphore semaforo = new Semaphore(10);
        for (int i = 0; i < 100; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i, semaforo)).start();
        }

        new Thread(new TarefaImprimir(lista)).start();

    }
}
