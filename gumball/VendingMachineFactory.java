public class VendingMachineFactory {
    public VendingMachine getMachine(String machineModel, int size){
        if(machineModel == null){
            return null;
        }
        if(machineModel.equalsIgnoreCase("Model1")){
            return new GumballMachine(size);
        } else if(machineModel.equalsIgnoreCase("Model2")){
            return new GumballMachineModel2(size);
        } else if(machineModel.equalsIgnoreCase("Model3")){
            return new GumballMachineModel3(size);
        }
        return null;
    }
}
