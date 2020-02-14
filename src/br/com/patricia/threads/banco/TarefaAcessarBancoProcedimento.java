package br.com.patricia.threads.banco;

public class TarefaAcessarBancoProcedimento implements Runnable {
    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;

    public TarefaAcessarBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("peguei a conexao");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("começando a tx");
                tx.begin();
            }
        }
    }
}
