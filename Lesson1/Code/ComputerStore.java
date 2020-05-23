
public class ComputerStore {

    private ComputerFactory computerFactory;

    public ComputerStore(){
        computerFactory = new ComputerFactory();
    }

    public int getPrice (String computerType){
        Computer computer = computerFactory.createComputer(computerType);
        return computer.getPrice();
    }

}

