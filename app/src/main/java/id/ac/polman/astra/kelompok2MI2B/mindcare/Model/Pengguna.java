package id.ac.polman.astra.kelompok2MI2B.mindcare.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pengguna {
    @SerializedName("id_user")
    @Expose
    private int mid_user;

    @SerializedName("NIM")
    @Expose
    private String mNIM;

    @SerializedName("nama")
    @Expose
    private String mNama;

    @SerializedName("password")
    @Expose
    private String mPassword;

    @SerializedName("alamat")
    @Expose
    private String mAlamat;

    @SerializedName("jenis_kelamin")
    @Expose
    private String mjenis_kelamin;

    @SerializedName("status")
    @Expose
    private String status;


    public Pengguna() {

    }

    public Pengguna(int mid_user, String NIM, String nama, String password, String alamat, String mjenis_kelamin, String status) {
        this.mid_user = mid_user;
        mNIM = NIM;
        mNama = nama;
        mPassword = password;
        mAlamat = alamat;
        this.mjenis_kelamin = mjenis_kelamin;
        this.status = status;
    }

    public int getMid_user() {
        return mid_user;
    }

    public void setMid_user(int mid_user) {
        this.mid_user = mid_user;
    }

    public String getNIM() {
        return mNIM;
    }

    public void setNIM(String NIM) {
        mNIM = NIM;
    }

    public String getNama() {
        return mNama;
    }

    public void setNama(String nama) {
        mNama = nama;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getAlamat() {
        return mAlamat;
    }

    public void setAlamat(String alamat) {
        mAlamat = alamat;
    }

    public String getMjenis_kelamin() {
        return mjenis_kelamin;
    }

    public void setMjenis_kelamin(String mjenis_kelamin) {
        this.mjenis_kelamin = mjenis_kelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
