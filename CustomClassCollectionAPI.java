import java.util.*;
class CustomClassCollectionAPI{
    public static void main(String[] args) {
             

        java.util.List list = new java.util.ArrayList();
               list.add(new Computer("Dell","Blue",800,16));
         list.add(new Computer("Sony","Grey",524,16));
        
 
        // list.add(first);
        Scanner scan = new Scanner(System.in);

        int input;
        
        char c;
        while(true){
            System.out.println("\n1.Add a new Computer. ");
            System.out.println("2. Display all computers. ");
            System.out.println("3. Search for a computer . ");
            System.out.println("4. Delete a computer : By ID. ");
            System.out.println("5. Update Computer Details.");
            
            input = scan.nextInt();
            switch(input){
                case 1: Computer computer = new Computer();
                        System.out.println("Enter Brand Name: ");
                        computer.setBrand(scan.next());
                        System.out.println("Enter Product Color: ");
                        computer.setColor(scan.next());
                        System.out.println("Enter HDD Size: ");
                        computer.setHddSize(scan.nextInt());
                        System.out.println("Enter Ram Size: ");
                        computer.setRamSize(scan.nextInt());
                        computer.setId(++Computer.idcount);

                        list.add(computer);

                        break;

                case 2: 
                System.out.println("The computers are: " + list);
                        for(Object value : list){
                        System.out.println(value);
                        }
 
                        break;
                case 3: 
                System.out.println("Search By \t\na.Brand Name\nb.Color\nc.HDDSize\nd.RamSize\ne.ID.");
                        c = scan.next().charAt(0);
                        System.out.println("Enter search value: ");
                        search(c, scan.next(), list);
                        break;
                case 4:
                System.out.println("Enter the Id to delete: ");
                        delete(list, scan.next());
                        break;
                case 5: 
                String string;
                        System.out.println("Enter the id to search which computer, you are talking about: ");
                        string = scan.next();
                        if(isThere(list, string, 'e') == false)
                        {
                            System.out.println("Sorry this id is invalid,try again");
                            break;
                        }
                        System.out.println("what details you want to Update  \t\na.Brand Name\nb.Color\nc.HDDSize\nd.RamSize");
                        c = scan.next().charAt(0);
                        System.out.println("Enter the updated value: ");
                        update(list, string, c, scan.next());
                            
                        break;
                default: System.out.println("Bye Bye");
                        return;
                
            }

        }
    }
static void search(char a, String str, List list)
{
        for(Object value : list){

                        if(((Computer)value).equals(a, str))

                                System.out.println(value);
                        }


}

static boolean isThere(List list, String str, char a){
    for(Object value : list){

                        if(((Computer)value).equals(a, str))

                                return true;
                        }
return false;

}
static void delete(List list,String str){
    int c = 0;
    for(Object value : list){

                        if(((Computer)value).equals('e', str))
                        {    list.remove(c);
                            System.out.println("Deleted Successfully");
                            return;
                        
                        }
                        c++;
    }
System.out.println("Wrong ID");
}

static void update(List list,String Id,char a, String str){

                    for(Object value : list){

                        if(((Computer)value).equals('e',Id)){
                                if(a == 'a'){
                                                ((Computer)value).setBrand(str);
                                                System.out.println("updated Successfully");
                                                return;
                                            }
                                if(a == 'b')
                                {
                                                ((Computer)value).setColor(str);
                                                System.out.println("updated Successfully");
                                                return;
                                }
                                if(a == 'c')
                                {
                                                ((Computer)value).setHddSize(Integer.parseInt(str)); 
                                                System.out.println("updated Successfully");
                                                return;  
                                }
                                if(a == 'd')
                                {
                                            ((Computer)value).setRamSize(Integer.parseInt(str));
                                            System.out.println("updated Successfully");
                                            return;
                                }
                                else{
                                    System.out.println("Wrong type to update");
                                    return;
                                }



                        }

                                
                        }

}



}

 
 
class Computer{
    String brand, color;
    int hddSize, ramSize,id;
    static int idcount=0;
 
    Computer(String brand, String color, int hddSize, int ramSize){
        this.brand = brand;
        this.color = color;
        this.hddSize = hddSize;
        this.ramSize = ramSize;
    }
    Computer(){

    };
    public String getColor(){
        return this.color;
    }
 
    public String getBrand(){
        return this.brand;
    }
 
    public Integer getHddSize(){
        return this.hddSize;
    }
     
    public Integer getRamSize(){
        return this.ramSize;
    }
    public void setColor(String s){
        this.color=s;
    }
 
    public void setBrand(String s){
        this.brand=s;
    }
 
    public void setHddSize(int s){
        this.hddSize=s;
    }
     
    public void setRamSize(int s){
        this.ramSize=s;
    }
    public void setId(int s){
        this.id=s;
    }
    public Integer getId(){
        return this.id;
    }


    @Override
    public String toString(){
        return "Computer : (" +this.getId()+", "+ this.getBrand()
            + ", " + this.getColor()
            + ", " + this.getHddSize()
            + ", " + this.getRamSize()
            + ")";
    }
    public boolean equals(char a,String s)
    {
        if(a == 'a'){
                return this.getBrand().equalsIgnoreCase(s);
        }
        if(a == 'b')
        {
                return this.getColor().equalsIgnoreCase(s);
        }
        if(a == 'c')
        {
                return s.equals(this.getHddSize().toString());
        }
        if(a == 'd')
        {
                return s.equals(this.getRamSize().toString());
        }
        if(a == 'e'){
                return s.equals(this.getId().toString());
        }
        return false;
    }
 
}