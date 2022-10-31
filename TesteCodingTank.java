import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TesteCodingTank {

	public static void main(String[] args) {


		Locale.setDefault(new Locale("en", "US"));
		DecimalFormat df = new DecimalFormat("#,###.00");
		Scanner sc = new Scanner(System.in);
		
		int tamanhoDoArray = 0;
		List<Double> numList = new ArrayList<Double>();
		Double soma = 0.0;
		Double media = 0.0;
		Boolean flag = true;
		
		
		while(flag) {
			try {
				System.out.println("Quantos números você deseja usar para calcular a média?");
				tamanhoDoArray = Integer.parseInt(sc.nextLine());
				if (tamanhoDoArray > 0 ) {
					flag = false;	
				} else {
					System.out.println("O número deve ser maior do que zero.");
					
				}
				
			}
			catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Por favor, digite um número. " + e.getMessage());
			}
		}
		
		
		while(numList.size() < tamanhoDoArray) {
			try {
				System.out.println("Digite o número: ");
				Double num = Double.parseDouble(sc.next());
				numList.add(num);
			}
			catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Por favor, digite um número. " + e.getMessage());
			}
		}
		
		String tipoDeMedia = "";
		
		while (!tipoDeMedia.equalsIgnoreCase("ARITMETICA") && !tipoDeMedia.equalsIgnoreCase("HARMONICA")) {
			tipoDeMedia = "";
			System.out.println("Você deseja a média ARITMETICA ou HARMONICA?");
			tipoDeMedia = sc.next().toUpperCase();;
		}
		
		
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
		
		if(numList.contains(0.0) && tipoDeMedia.equals("HARMONICA")) {
			System.out.println("Um dos números informados foi 'zero'. Não é possível calcular desta forma.\nTente novamente.");
		} else {
			System.out.println("Os números digitados foram: " + numList);
			System.out.println("A média " + tipoDeMedia + " é " + df.format(media));
		
		}

	}

}
