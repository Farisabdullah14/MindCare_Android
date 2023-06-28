package id.ac.polman.astra.kelompok2MI2B.mindcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

/*import id.ac.polman.astra.kelompok2MI2B.mindcare.Fragment.HomeFragment;*/
import id.ac.polman.astra.kelompok2MI2B.mindcare.Fragment.LoginFragment;
import id.ac.polman.astra.kelompok2MI2B.mindcare.Fragment.RegisterFragment;
import id.ac.polman.astra.kelompok2MI2B.mindcare.repository.PenggunaRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kosong);

        PenggunaRepository.initialize(this);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_main_fragment_container);
        if(fragment == null){
            fragment = new LoginFragment().newInstance();
/*
            fragment = new RegisterFragment().newInstance();
*/

            fm.beginTransaction().replace(R.id.activity_main_fragment_container,fragment).commit();
        }


    }
}