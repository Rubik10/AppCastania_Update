package com.rubik.appproductsvolley2.app.volley;

/**
 * Created by Rubik on 28/7/16.
 */
public class AppConfig_Server {

    public static final String PORT = "8888";
   // public static final String SERVER = "/Android/serverProducts";
   public static final String SERVER = "/Android/ProductsServer";
    public static final String URL_BASE = "http://172.20.10.2:" + PORT + SERVER;

    public static final String URL_JSON = "/products.json";

    public static final String URL_GET_HISTORY = "/getHistory.php";
    public static final String URL_PUT_HISTORY = "/insertHistory.php";
}
