package com.mvvm.utils;

public class App {
    private static final App ourInstance = new App();






    public static App getInstance() {
        return ourInstance;
    }

    private App() {
    }
}
