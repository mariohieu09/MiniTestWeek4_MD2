import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBookManage apps = new PhoneBookManage();
        while (true){
            System.out.println("Choose: \n1.Display \n2.Insert new Phone \n3.Remove Phone \n4.Update Phone \n5.Search Phone \n6.Sort the list \n0.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Choose: \n1.Display the List \n2.Display the contact ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if(n == 1) {
                        apps.display();
                    }else{
                        System.out.println("Enter id: ");
                        int display_id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Type name: ");
                        String typeName = sc.nextLine();
                        Type type = new Type(display_id, typeName);
                        apps.display(type);
                    }
                    break;
                case 2:
                    System.out.println("Choose the insert method: \n1.Insert contact \n2.Insert new contact");
                    int insertChoice = sc.nextInt();
                    sc.nextLine();
                    if(insertChoice == 1) {
                        System.out.println("Enter contact name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter contact phone number: ");
                        String phone = sc.nextLine();
                        apps.insertPhone(name, phone);
                    }else if(insertChoice == 2){
                        System.out.println("Enter new name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter new number ");
                        String number = sc.nextLine();
                        System.out.println("Enter new id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new type name: ");
                        String typeName = sc.nextLine();
                        Contact contact = new Contact(name, number, new Type(id, typeName));
                        apps.insertPhone(contact);
                    }
                    break;
                case 3:
                    System.out.println("Enter contact name: ");
                    apps.removePhone(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Enter contact name: ");
                    String updateName = sc.nextLine();
                    System.out.println("Enter new number: ");
                    String updateNum = sc.nextLine();
                    apps.updatePhone(updateName, updateNum);
                    break;
                case 5:
                    System.out.println("Enter contact name: ");
                    apps.searchPhone(sc.nextLine());
                    break;
                case 6:
                    apps.sort();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
