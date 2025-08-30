package Casting_Lab;

import java.util.ArryList;

public class Main {
    public static void main(String[] args){
        // create an arrylist to hold device
    ArryList<NetworkDevice> deviceList  = new ArryList<>();

    // Create Object of router
    Router obj = new Router("Juniper", "192.168.10.1", 120);
    Router obj2 = new Router("Sophous", "20.20.20.20", 100);


    // Create Object of Switch
    Switch s1 = new Switch("CISCO", "192.168.10.2", 95);
    Switch s2 = new Switch("GRANDSTREAM", "192.168.100.2", 100);

    //store in arraylist
    deviceList.add(obj1);
    deviceList.add(obj2);
    deviceList.add(s1);
    deviceList.add(s2);


    // traversing in arrylist
    for(NetworkDevice n: deviceList){
        n.transmitData();
        
       // child specific method call garana downcast
       // this code is not used it will give error Router r = (Router) n; 
       if (n instanceof Router){
        Router r = (Router) n; // downcast for router
        r.configureRoutingTable();
       }else{
            Switch s = (Switch) n;  // Downcast for switch
            s.manageVLAN();


       }
    }


    }

}