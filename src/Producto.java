import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Producto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Producto producto1 = new Producto("ASD-43546778956789098765-6");
		ArrayList<String> lista1 = new ArrayList<String>();
		ArrayList<String> lista2 = new ArrayList<String>();
		lista1.add("AER-79578-9");
		lista1.add("QKR-88578-9");
		lista1.add("CDR-77598-9");
		lista1.add("AKR-88578-9");
		lista1.add("AMR-88578-9");
		lista1.add("WCR-57888-9");
		lista1.add("CKR-85788-9");
		lista2.add("AER-79578-8");
		lista2.add("QKR-88578-8");
		lista2.add("CDR-77598-8");
		lista2.add("AKF-88578-8");
		lista2.add("AMR-88578-9");
		lista2.add("WCR-57888-9");
		lista2.add("CKR-85788-9");
		System.out.println("PUNTO A: " + Producto.esPrioritario(producto1.codigo));
		System.out.println("PUNTO B: " + Producto.verificar(producto1.codigo));
		System.out.println("PUNTO C: " + Producto.ordenarLista(lista1));
		System.out.println("PUNTO D: " + Producto.unirLista(lista1, lista2));
		System.out.println("PUNTO E: " + Producto.filtrarLista(lista1, lista2));

	}

	private String codigo;

    public Producto() {
    }

    public Producto(String cod) {
        codigo = cod;

    }

    /**
     * Indica si el codigo recibido es prioritario
     * @param codigo
     * @return boolean
     */
    public static boolean esPrioritario(String codigo) {
        char cod = codigo.charAt(0);
        return cod == 'W' || cod == 'P';
    }

    /**
     * Indica si la sumatoria de los digitos del código geografico (o su recurrencia) es igual al digito verificador
     * @param codigo
     * @return boolean : true si es igual
     */
    public static boolean verificar(String codigo) {
        int a=codigo.indexOf("-");
        int b=codigo.indexOf("-",a+1);
        String crg = codigo.substring(a+1, b);
        int dv = Character.getNumericValue(codigo.charAt(codigo.length()-1));
        int sum = 0;
        do {
            if (crg.length() >= 2) {
                sum = 0;
            }
            for (int i = 0; i < crg.length(); i++) {
                int dig = Character.getNumericValue(crg.charAt(i));
                sum += dig;
            }
            crg = String.valueOf(sum);
        } while (sum >= 10);
        return sum == dv;
    }

    /**
     * Ordena una lista de String y por orden alfabetico
     * @param lista
     * @return ArrayList<String> de la lista ordenada
     */
    // ptoC
    public static ArrayList<String> ordenarLista(ArrayList<String> lista) {
        Collections.sort(lista);
        return lista;
    }

    /**
     * Toma dos listas y devuelve una lista con la union de ambas sin valores repetidos
     * @param l1
     * @param l2
     * @return ArrayList<String>
     */
    // ptoD
    public static ArrayList<String> unirLista(ArrayList<String> l1, ArrayList<String> l2) {
        ArrayList<String> l3 = new ArrayList<String>();
        ArrayList<String> union = new ArrayList<String>();
        l3.addAll(l1);
        l3.addAll(l2);
        union.addAll(l3.stream().distinct().collect(Collectors.toList()));
        return union;

    }

    /**
     * Toma dos listas y devuelve una lista con los elementos comunes a ambas listas
     * @param l1
     * @param l2
     * @return ArrayList<String>
     */
    // ptoE
    public static ArrayList<String> filtrarLista(ArrayList<String> l1, ArrayList<String> l2) {
        l1.retainAll(l2);
        return l1;
    }


}
