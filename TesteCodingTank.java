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
				System.out.println("Quantos n�meros voc� deseja usar para calcular a m�dia?");
				tamanhoDoArray = Integer.parseInt(sc.nextLine());
				if (tamanhoDoArray > 0 ) {
					flag = false;	
				} else {
					System.out.println("O n�mero deve ser maior do que zero.");
					
				}
				
			}
			catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Por favor, digite um n�mero. " + e.getMessage());
			}
		}
		
		
		while(numList.size() < tamanhoDoArray) {
			try {
				System.out.println("Digite o n�mero: ");
				Double num = Double.parseDouble(sc.next());
				numList.add(num);
			}
			catch (NumberFormatException | InputMismatchException e) {
				System.out.println("Por favor, digite um n�mero. " + e.getMessage());
			}
		}
		
		String tipoDeMedia = "";
		
		while (!tipoDeMedia.equalsIgnoreCase("ARITMETICA") && !tipoDeMedia.equalsIgnoreCase("HARMONICA")) {
			tipoDeMedia = "";
			System.out.println("Voc� deseja a m�dia ARITMETICA ou HARMONICA?");
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
			System.out.println("Op��o inv�lida");
		}

	
		
		sc.close();
		
		if(numList.contains(0.0) && tipoDeMedia.equals("HARMONICA")) {
			System.out.println("Um dos n�meros informados foi 'zero'. N�o � poss�vel calcular desta forma.\nTente novamente.");
		} else {
			System.out.println("Os n�meros digitados foram: " + numList);
			System.out.println("A m�dia " + tipoDeMedia + " � " + df.format(media));
		
		}

	}

}
