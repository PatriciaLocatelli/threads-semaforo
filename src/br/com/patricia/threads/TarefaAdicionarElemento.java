package br.com.patricia.threads;

import java.util.List;
import java.util.concurrent.Semaphore;

public class TarefaAdicionarElemento implements Runnable {

    private Lista lista;
    private int numeroDaThread;
    private Semaphore semaforo;

    public TarefaAdicionarElemento(Lista lista, int numeroDaThread, Semaphore semaforo) {
        this.lista = lista;
        this.numeroDaThread = numeroDaThread;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            lista.adicionaElementos("Thread " + numeroDaThread + " - " + i);
            try {
                Thread.sleep(1000);
                semaforo.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
            }
        }

    }
}
