
public class Pilha {
    private Pixel[] dados;
    private int topo;

    public Pilha(int capacidade) {
        dados = new Pixel[capacidade];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo < 0;
    }

    public void push(Pixel p) {
        dados[++topo] = p;
    }

    public Pixel pop() {
        if (isEmpty()) return null;
        return dados[topo--];
    }
}