package com.devpatel.designpatterns.structural.decorator;

public class EncryptionDecorator implements DataSource {
    private final DataSource wrappee;
    private final byte key = 0x5A; // simple XOR key for demo only

    public EncryptionDecorator(DataSource ds) {
        this.wrappee = ds;
    }

    @Override
    public void writeData(String data) throws Exception {
        byte[] bytes = data.getBytes("UTF-8");
        for (int i = 0; i < bytes.length; i++) bytes[i] = (byte)(bytes[i] ^ key);
        wrappee.writeData(new String(bytes, "UTF-8"));
    }

    @Override
    public String readData() throws Exception {
        String enc = wrappee.readData();
        byte[] bytes = enc.getBytes("UTF-8");
        for (int i = 0; i < bytes.length; i++) bytes[i] = (byte)(bytes[i] ^ key);
        return new String(bytes, "UTF-8");
    }
}
