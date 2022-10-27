import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TesteCodingTank {

	public static void main(String[] args) {


		Locale.setDefault(new Locale("en", "US"));
		DecimalFormat df = new DecimalFormat("#,###.00");
		Scanner sc = new Scanner(System.in);
		
		int tamanhoDoArray;
		List<Double> numList = new ArrayList<Double>();
		Double soma = 0.0;
		Double media = 0.0;
		
		
		System.out.println("Quantos n�meros voc� deseja calcular a m�dia?");
		tamanhoDoArray = Integer.valueOf(sc.nextInt());
	
		
		while(numList.size() < tamanhoDoArray) {
			System.out.println("Digite o n�mero: ");
			Double num = Double.parseDouble(sc.next());
			numList.add(num);
		}
		
		String tipoDeMedia = "";
		
		
		/* 
		 *  n�o consegui validar o texto ARITMETICA ou HARMONICA
		 *  provavelmente problema de acesso ao valor mem�ria
		 */
		
		/*

		while (!tipoDeMedia.equalsIgnoreCase("A") || !tipoDeMedia.equalsIgnoreCase("H") || tipoDeMedia.isEmpty()) {
			tipoDeMedia = "";
			System.out.println("Voc� deseja a m�dia ARITMETICA ou HARMONICA?");
			tipoDeMedia = sc.next();
		}
		
		*/
		
		System.out.println("Voc� deseja a m�dia ARITMETICA ou HARMONICA?");
		tipoDeMedia = sc.next().toUpperCase();

		
		if (tipoDeMedia.equals("ARITMETICA")) {
			for(Double x : numList) {
				soma += x;
			}
			media = (soma / tamanhoDoArray);
		} else if (tipoDeMedia.equals("HARMONICA")) {
			for(Double x : numList) {
				soma += 1/x;
			}
			media = (tamanhoDoArray / soma);
		} else {
			System.out.println("Op��o inv�lida");
		}

	
		
		sc.close();
		
		
		System.out.println("Os n�meros digitados foram: " + numList);
		System.out.println("A m�dia " + tipoDeMedia + " � " + df.format(media));
		
		
		

	}

}
