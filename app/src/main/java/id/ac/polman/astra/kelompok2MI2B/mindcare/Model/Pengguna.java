package id.ac.polman.astra.kelompok2MI2B.mindcare.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pengguna {
    @PrimaryKey
    @NonNull
    private int mId;
    private String mNIM;
    private String mNama;
    private String mUsername;
    private String mPassword;

    private String mAlamat;

    private String mJenisKelamin;

    private String status;


    public Pengguna() {

    }


    public Pengguna(int id, String NIM, String nama, String username, String password, String alamat, String jenisKelamin, String status) {
        mId = id;
        mNIM = NIM;
        mNama = nama;
        mUsername = username;
        mPassword = password;
        mAlamat = alamat;
        mJenisKelamin = jenisKelamin;
        this.status = status;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
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

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
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

    public String getJenisKelamin() {
        return mJenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        mJenisKelamin = jenisKelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
