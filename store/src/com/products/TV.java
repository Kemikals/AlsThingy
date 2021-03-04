package com.products;

public class TV extends Product{

    int screenSize ;
    String type;
    public static final int TV_FEATURES = 2;

    public TV(){
        super();
    }

    public TV(String name, String manufacture,int screenSize,String type) {
        super(name,manufacture);
        this.screenSize=screenSize;
        this.type=type;
    }
    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





    @Override
    public void print() {
    	System.out.println("**************************");
        super.print();
        System.out.println("screenSize : " + screenSize +"\nType : " + type );
        System.out.println("**************************");

    }

}
