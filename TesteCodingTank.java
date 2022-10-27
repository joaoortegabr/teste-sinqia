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
		
		
		System.out.println("Quantos números você deseja calcular a média?");
		tamanhoDoArray = Integer.valueOf(sc.nextInt());
	
		
		while(numList.size() < tamanhoDoArray) {
			System.out.println("Digite o número: ");
			Double num = Double.parseDouble(sc.next());
			numList.add(num);
		}
		
		String tipoDeMedia = "";
		
		
		/* 
		 *  não consegui validar o texto ARITMETICA ou HARMONICA
		 *  provavelmente problema de acesso ao valor memória
		 */
		
		/*

		while (!tipoDeMedia.equalsIgnoreCase("A") || !tipoDeMedia.equalsIgnoreCase("H") || tipoDeMedia.isEmpty()) {
			tipoDeMedia = "";
			System.out.println("Você deseja a média ARITMETICA ou HARMONICA?");
			tipoDeMedia = sc.next();
		}
		
		*/
		
		System.out.println("Você deseja a média ARITMETICA ou HARMONICA?");
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
			System.out.println("Opção inválida");
		}

	
		
		sc.close();
		
		
		System.out.println("Os números digitados foram: " + numList);
		System.out.println("A média " + tipoDeMedia + " é " + df.format(media));
		
		
		

	}

}
