interface Animal
{ 
    // animals implement animals interface that allows 
    // them to run and make sounds adaptee interface 
    public void run(); 
    public void makeSound(); 
} 
  
class Lion implements Animal 
{ 
    // a concrete implementation of animal 
    public void run() 
    { 
        System.out.println("Running"); 
    } 
    public void makeSound() 
    { 
        System.out.println("Roar"); 
    } 
} 
  
interface ToyAnimal
{ 
    // target interface 
    // toy animals  dont  walk they just make sound 
 
    public void Roar(); 
} 
  
class PlasticToyLion implements ToyAnimal 
{ 
    public void Roar() 
    { 
        System.out.println("roar"); 
    } 
} 
  
class AnimalAdapter implements ToyAnimal 
{ 
    // You need to implement the interface your 
    // client expects to use. 
    Animal animal; 
    public AnimalAdapter(Animal animal) 
    { 
        
        this.animal = animal; 
    } 
  
    public void Roar() 
    { 
        // translate the methods appropriately 
        animal.makeSound(); 
    } 
} 
  
class AdapterPattern
{ 
    public static void main(String args[]) 
    { 
        Lion lion = new Lion(); 
        ToyAnimal toylion = new PlasticToyLion(); 
  
        // Wrap a animal in animal dapter so that it  
        // behaves like toy lion
        ToyAnimal animalAdapter = new AnimalAdapter(lion); 
  
        System.out.println("Lion..."); 
        lion.run(); 
        lion.makeSound(); 
  
        System.out.println("ToyLion..."); 
        toylion.Roar(); 
  
        //  lion behaving like toy lion 
        System.out.println("AnimalAdapter..."); 
        animalAdapter.Roar(); 
    } 
} 