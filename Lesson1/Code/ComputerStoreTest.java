

public class ComputerStoreTest {

    public static void main(String[] args){

        ComputerStore computerStore = new ComputerStore();
        System.out.println(computerStore.getPrice("laptop"));
        System.out.println(computerStore.getPrice("pc"));
        System.out.println(computerStore.getPrice("tablet"));
    }
}

