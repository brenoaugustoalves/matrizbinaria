import java.util.Stack;

public class MatrizBinaria {

    public int maiorAreaHistograma(int[] alturas) {
        Stack<Integer> pilha = new Stack<>();
        int maiorArea = 0;
        int[] alturaestendidas = new int[alturas.length + 1];
        System.arraycopy(alturas, 0, alturaestendidas, 0, alturas.length);

        for (int i = 0; i < alturaestendidas.length; i++) {
            while (!pilha.isEmpty() && alturaestendidas[i] < alturaestendidas[pilha.peek()]) {
                int altura = alturaestendidas[pilha.pop()];
                int largura = pilha.isEmpty() ? i : i - pilha.peek() - 1;
                maiorArea = Math.max(maiorArea, altura * largura);
            }
            pilha.push(i);
        }
        return maiorArea;
    }

    public int retanguloMaximo(char[][] matriz) {
        if (matriz.length == 0)
            return 0;
        int maiorArea = 0;
        int[] alturas = new int[matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == '1') {
                    alturas[j] += 1;
                } else {
                    alturas[j] = 0;
                }
            }
            maiorArea = Math.max(maiorArea, maiorAreaHistograma(alturas));
        }
        return maiorArea;
    }

    public static void main(String[] args) {
        MatrizBinaria retangulo = new MatrizBinaria();

        char[][] matriz = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("A maior área é: " + retangulo.retanguloMaximo(matriz));
    }
}
