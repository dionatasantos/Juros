package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do Contrato: ");
		System.out.print("Numero do Contrato: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy:): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do Contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);

		System.out.print("Entre com o numero de parcelas: ");
		int parcelas = sc.nextInt();
		
		
		ContractService contractService = new ContractService(null);
		
		contractService.processContract(obj, parcelas);
		
		System.out.printf("Parcelas: ");
		for (Installment installment :obj.getInstallments() ) {
			System.out.println(installment);
		}
		
		
		
		sc.close();		
	}

}
