package id.ac.polman.astra.kelompok2MI2B.mindcare.Api;

import id.ac.polman.astra.kelompok2MI2B.mindcare.Service.PenggunaService;
import id.ac.polman.astra.kelompok2MI2B.mindcare.Service.RawService;

public class ApiUtils {

    //public static final String API_URL = "http://192.168.2.200.8080/";

    public static final String API_URL = "http://10.0.2.2:8080/";

    private ApiUtils(){

    }
    //login yang lama
    public static PenggunaService getPenggunaService(){
        return RetrofitClient.getClient(API_URL).create(PenggunaService.class);
    }

    //raw service login dengan api
    public static RawService getRawService(){
        return RetrofitClient.getClient(API_URL).create(RawService.class);
    }


}