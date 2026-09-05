package entities;
import enums.GateType;

abstract public class Gate {
    private GateType gateType;

    public Gate(GateType gateType){
        this.gateType = gateType;
    }

    public GateType getGateType(){
        return gateType;
    }
}
