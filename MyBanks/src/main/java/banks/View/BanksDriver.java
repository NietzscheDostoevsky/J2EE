package banks.View;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import banks.Controller.BanksController;
import banks.Model.Banks;

public class BanksDriver {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		BanksController controller = new BanksController();
		System.out.println("Welcome to the Banking DAtabase");
		do {
			System.out.println("1> Add Bank");
			System.out.println("2> Delete a Bank by its id");
			System.out.println("3> Find a bank by its id");
			System.out.println("4> Update a bank's name by its id");
			System.out.println("5> find all the banks in the database");
			System.out.println("6> exit the application");
			switch (sc.nextInt()) {
			case 1-> {
				Banks bank = new Banks();
				System.out.println("enter id");
				bank.setId(sc.nextInt());
				System.out.println("enter name");
				bank.setName(sc.next());

				controller.addBank(bank);
				System.out.println("Bank added");
			}
				
			case 2-> {
				System.out.println("enter id");
				boolean res = controller.deleteBankById(sc.nextInt());
				if (res)
					System.out.println("bank deleted");
				else
					System.out.println("id is not present");
			}
				
			case 3-> {
				System.out.println("enter id");
				Banks bank = controller.getBankById(sc.nextInt());
				if (bank.getId() != 0)
					System.out.println(bank);
				else 
					System.out.println("id is not present");
			}
				
			case 4-> {
				System.out.println("enter id");
				int id = sc.nextInt();
				System.out.println("enter new name for the bank");
				String newName = sc.next();
				boolean res = controller.updateBankById(id, newName);
				if (res) 
					System.out.println("Bank name updated");
				else 
					System.out.println("id is not present");
			}
				
			case 5-> {
				List<Banks> list = controller.getAll();
				for (Banks bank : list) {
					System.out.println(bank);
					System.out.println();
				}
			}
				
			case 6-> {
				controller.closeConnection();
				System.out.println("Your conection is closed");
				System.exit(0);
			}
				
			default-> 
			System.out.println("INVALID OPTION");
				
			}
			System.out.println("enter y/Y to continue");
		} while (sc.next().equalsIgnoreCase("y"));
		sc.close();

		System.out.println("Exiting the banking database");
	}

}
