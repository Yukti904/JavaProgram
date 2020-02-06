import java.util.*;

class Employee{
    String name;
    int age;
    static int count=0;
    Employee(String name, int age){
        this.name = name;
        this.age=age;
    }

 
 
    public String getName(){
        return this.name;
    }
    public Integer getAge(){
        return this.age;
    }
 
    public void setName(String s){
        this.name=s;
    }
    public void setAge(Integer s){
        this.age=s;
    }
    
    @Override
    public String toString(){
        return "Employee ( " + this.getName() + " , " + this.getAge() + ")";
    }
    

}
  
 
class SortByFirstName implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
            String string1[] = ((Employee)firstObj).getName().split(" ");
            String string1[] = ((Employee)secondObj).getName().split(" ");

        return string1[0].toLowerCase().compareTo(string2[0].toLowerCase());
    }
}
 
class SortByLastName implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        String string1[] = ((Employee)firstObj).getName().split(" ");
        String string2[] = ((Employee)secondObj).getName().split(" ");

        if(string1.length > 1 && string2.length > 1)
        return string1[1].toLowerCase().compareTo(string2[1].toLowerCase());
        
            if(string1.length > 1)
            return string1[1].toLowerCase().compareTo("");
            if(string2.length > 1)
            return "".compareTo(string2[1].toLowerCase());

            return "".compareTo("");
        
    }
}

 
class SortByAge implements java.util.Comparator{
    @Override
    public int compare(Object firstObj, Object secondObj){
        return ((Employee)firstObj).getAge().compareTo(((Employee)secondObj).getAge());
    }
}
 
 
class CustomSortByComparator{
    public static void main(String[] args) {
        java.util.List employeeList = new java.util.ArrayList();
 
         employeeList.add(new Employee("Sharma", 615));
        employeeList.add(new Employee("Rashmi", 3421));
        // employeeList.add(new Employee("Abhi", 3));
 
        // System.out.println("List before sorting : " + employeeList);
 
        // java.util.Collections.sort(employeeList, new SortByRegId());
 
        // System.out.println("List after sorting : " + employeeList);
            Scanner scan = new Scanner(System.in);
        char x;


        char ch;

            while(true){
            System.out.println("1.Do you want to add a new Employee ? ");
            System.out.println("2. Do you want to display all employee list ? ");
            System.out.println("3. Do you want to sort the  employee list  ? ");
            
            x=scan.next().charAt(0);
            
            switch(x){
                case '1': 
                    

                        while(true){
                        Employee emp = new Employee();
                        System.out.println("Enter Employee Name: ");
                        
                        scan.nextLine();
                        emp.setName(scan.nextLine());

                        System.out.println("Enter Employee Age: ");
                        emp.setAge(scan.nextInt());
                        
                        
                        System.out.println("Do you want to add more(Y/N)?");
                        ch = scan.next().charAt(0);
                        if(ch != 'y' && ch != 'Y')
                            break;

                    }

                        break;

                case '2':
                 System.out.println("The Employee's list is : " + employeeList);
                        for(Object value : employeeList){
                        System.out.println(value);
                        }
 
                        break;
                case '3': 
                System.out.println("Search By \t\na.First Name\nb.Last Name\nc.Age");
                        ch = scan.next().charAt(0);
                         if(ch =='a')   
                          {  java.util.Collections.sort(employeeList, new SortByFirstName());
                            System.out.println("After sorting by first name the list is : " + employeeList);
                            }
                            else if(ch == 'b')   
                          {  java.util.Collections.sort(employeeList, new SortByLastName());
                              System.out.println("After sorting by last name the list is : " + employeeList);
                            }
                            else if(ch == 'c')   
                          {  java.util.Collections.sort(employeeList, new SortByAge());
                            System.out.println("After sorting by age the list is : " + employeeList);
                            }
                            else{
                                System.out.println("Invalid input");
                            }
                        break;
                default:
                 System.out.println("--------");
                        return;
                
            }

        }
 
    }
}
 
 
