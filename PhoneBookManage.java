import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBookManage extends Phone implements IPhone {
   Scanner sc = new Scanner(System.in);
   File book = new File("ContactBook");
  public  void insertPhone(String name, String phone) {
    ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(book);
    Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
    if(p != null){
      System.out.println("Do you want to keep the curren Type? \n1.Yes \n2.No");
      int n = sc.nextInt();
      sc.nextLine();
      if(n == 1){
        p.setPhoneNumber(phone);
          System.out.println("Success!");
      }else {
        System.out.println("Enter new id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter type name: ");
        String typeName = sc.nextLine();
        p.setPhoneNumber(phone);
        p.setType(new Type(id, typeName));
          System.out.println("Success!");
      }
    }else{
        System.out.println("Enter new id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name: ");
        String typeName = sc.nextLine();
        p = new Contact(name, phone, new Type(id, typeName));
        list.add(p);
    }
    WriteFile<Contact> wf = new WriteFile<>();
    wf.WriteFile(list,book);
  }
  public void searchPhone(String name){
    List<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
    Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
    if(p == null){
      System.out.println("Can't find the contact!");
    }else{
      System.out.println(p);
    }
  }
  @Override
  public void insertPhone(Contact contact){
    ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
    list.add(contact);
    WriteFile wf = new WriteFile();
    wf.WriteFile(list, book);
  }


  public void display() {
      ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
      list.forEach(System.out::println);
  }
  @Override
  public void sort() {
    ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
    List<Contact> sortedList =  list.stream().sorted(Comparator.comparing(Contact::getName)).collect(Collectors.toList());
    WriteFile wf = new WriteFile();
    wf.WriteFile((ArrayList)sortedList, book);
      System.out.println("Sort success!");
  }
   public void removePhone(String name){
       ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
       Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
       if(p != null) {
           list.remove(p);
           System.out.println("Remove success!");
       }else{
           System.out.println("Can't find the contact!");
       }
       WriteFile wf = new WriteFile();
       wf.WriteFile(list, book);
   }
   public void updatePhone(String name, String newPhone){
       ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
       Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
       if(p != null){
           p.setPhoneNumber(newPhone);
           System.out.println("Update success!");
       }else{
           System.out.println("Can't find the contact!");
       }
       WriteFile wf = new WriteFile();
       wf.WriteFile(list, book);
   }
    public void display(Type type) {
        ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("ContactBook"));
        Contact p = list.stream().filter(x -> x.getType().getId() == type.getId() && x.getType().getName().equals(type.getName())).findAny().orElse(null);
        if(p != null) {
            System.out.println(p);
        }else{
            System.out.println("Can't find the contact!");
        }
    }

}
