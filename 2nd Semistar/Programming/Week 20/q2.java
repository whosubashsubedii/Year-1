public abstract class NetworkDevice {
    // Attributes
    protected String deviceName;
    protected String ipAddress;
    protected int bandwidth;

    // Constructor
    public NetworkDevice(String deviceName, String ipAddress, int bandwidth) {
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
        this.bandwidth = bandwidth;
    }

    // Abstract method
    public abstract void transmitData();
}


// Child classs Router
class Router extends NetworkDevice{
    public Router(String d, String i, int b)
    super(d,i,b);
}


{
    @Override
    public void transmitData (){
        System.out.println("Router is routing ip packets");
    }
    public void RoutingTable(){
        System.out.println("Router manage routing Table");
    }
}


// Child classs Switch
class Switch extends NetworkDevice{
    public Switch(String d, String i, int b)
    super(d,i,b);

}
    
{
    @Override
    public void transmitData(){
        System.out.print("Switch is forwarding the frame");
    }
    public void manageVLAN(){
        System.out.print("Switch is managing Vlan");

    }
}
