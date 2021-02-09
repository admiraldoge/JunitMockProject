package com.example.project.util;

public class ClientWrapper {
    private String customerData = "";
    private String vehicleData = "";
    private String appointmentData = "";
    public ClientWrapper() {
        customerData = System.getProperty("customer.data", customerData);
        vehicleData = System.getProperty("vehicle.data", vehicleData);
        appointmentData = System.getProperty("appointment.data", appointmentData);
    }

    public static final ClientWrapper newClient() {
        ClientWrapper clientWrapper = new ClientWrapper();
        System.out.println("CUSTOMER DATA: "+clientWrapper.customerData);
        return clientWrapper;
    }

    private void transformCustomerData() {

    }
}
