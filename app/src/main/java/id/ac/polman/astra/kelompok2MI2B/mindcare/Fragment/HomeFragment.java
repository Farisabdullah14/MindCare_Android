package id.ac.polman.astra.kelompok2MI2B.mindcare.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import id.ac.polman.astra.kelompok2MI2B.mindcare.R;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout relativeLayout = view.findViewById(R.id.button_psikolog);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat instance dari AlamatPsikologFragment
                AlamatPsikologFragment alamatPsikologFragment = new AlamatPsikologFragment();

                // Memperoleh instance FragmentManager
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                // Membuat transaksi fragment
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Menggantikan fragment_home dengan AlamatPsikologFragment
                fragmentTransaction.replace(R.id.frame_layout, alamatPsikologFragment);

                // Menambahkan transaksi ke back stack agar dapat kembali ke fragment_home jika diperlukan
                fragmentTransaction.addToBackStack(null);

                // Melakukan commit transaksi
                fragmentTransaction.commit();
            }
        });

        return view;
    }
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
}