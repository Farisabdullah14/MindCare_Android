package id.ac.polman.astra.kelompok2MI2B.mindcare.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import id.ac.polman.astra.kelompok2MI2B.mindcare.R;


import id.ac.polman.astra.kelompok2MI2B.mindcare.Service.response.PenggunaResponse;
import id.ac.polman.astra.kelompok2MI2B.mindcare.viewmodel.PenggunaDetailViewModel;

public class PenggunaFragmentLogin extends Fragment {

    private EditText mUsername;
    private EditText mPassword;
    private Button btnLogin;

    private PenggunaDetailViewModel mPenggunaDetailViewModel;
    private PenggunaDetailViewModel getPenggunaDetailViewModel(){
        if (mPenggunaDetailViewModel == null){
            mPenggunaDetailViewModel = new ViewModelProvider(this)
                    .get(PenggunaDetailViewModel.class);
        }
        return mPenggunaDetailViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPenggunaDetailViewModel = getPenggunaDetailViewModel();

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.login,container,false);

        mUsername = (EditText) view.findViewById(R.id.login_username);
        mPassword = (EditText) view.findViewById(R.id.login_password);


        btnLogin = view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test", "email "+mUsername.getText() + " dan password "+mPassword.getText());

                if (validasi(mUsername, mPassword)) {
                    mPenggunaDetailViewModel.login(mUsername.getText().toString(), mPassword.getText().toString()).observe(getViewLifecycleOwner(), new Observer<PenggunaResponse>() {
                        @Override
                        public void onChanged(PenggunaResponse penggunaResponse) {
                            if (penggunaResponse.getStatus()==200) {

                                Toast.makeText(getActivity(), "Login Berhasil", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(getActivity(), "You're Not Authenticated", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "Username atau Password harus diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public static PenggunaFragmentLogin newInstance(){
        return new PenggunaFragmentLogin();
    }


    private boolean validasi(EditText mEtUsername, EditText mEtPassword ){
        boolean valid = true  ;

        if (mEtUsername.getText().toString().length() == 0 ){
            mEtUsername.setError("REQUIRED");
            valid= false;
        }
        if (mEtPassword.getText().toString().length() == 0 ){
            mEtPassword.setError("REQUIRED");
            valid= false;
        }
        return valid;
    }
}
