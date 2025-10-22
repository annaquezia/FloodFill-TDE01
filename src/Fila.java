
public class Fila {
    private Pixel[] dados;
    private int ini, fim, tamanho;

    public Fila(int capacidade) {
        dados = new Pixel[capacidade];
        ini = fim = tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void enqueue(Pixel p) {
        dados[fim] = p;
        fim = (fim + 1) % dados.length;
        tamanho++;
    }

    public Pixel dequeue() {
        if (isEmpty()) return null;
        Pixel p = dados[ini];
        ini = (ini + 1) % dados.length;
        tamanho--;
        return p;
    }
}