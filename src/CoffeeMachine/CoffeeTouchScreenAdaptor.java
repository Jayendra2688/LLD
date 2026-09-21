package CoffeeMachine;

public class CoffeeTouchScreenAdaptor implements CoffeeMachineInterface{
    private OldCoffeeMachine oldCoffeeMachine;
    
    CoffeeTouchScreenAdaptor(OldCoffeeMachine oldCoffeeMachine){
        this.oldCoffeeMachine = oldCoffeeMachine;
    }
    public void chooseFirstSelection(){
        oldCoffeeMachine.selectA();
    }
    public void chooseSecondSelection(){
        oldCoffeeMachine.selectB();
    }
}