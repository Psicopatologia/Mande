package Controller;

import Controller.Store;
import Controller.User;

public class Owner extends User {
    Store stores[];

    public Store[] getStores() {
        return stores;
    }

    public void addStore(Store s) {

    }

    public Store removeStore(Store s) {
        return s;
    }

    public Store updateStore(Store s) {
        return s;
    }
}
