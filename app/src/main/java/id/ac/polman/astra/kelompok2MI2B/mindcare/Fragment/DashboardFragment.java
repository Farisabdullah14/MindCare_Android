package id.ac.polman.astra.kelompok2MI2B.mindcare.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.ac.polman.astra.kelompok2MI2B.mindcare.R;
import id.ac.polman.astra.kelompok2MI2B.mindcare.databinding.ActivityMainBinding;

public class DashboardFragment extends Fragment {
    ActivityMainBinding binding;
    private boolean isMoodIconVisible = false;

    private ImageView selectedIcon;

    private FloatingActionButton fabButton;
    private BottomSheetDialog bottomSheetDialog;
    private LinearLayout moodIconLayout; // Tambahkan variabel ini
    public static DashboardFragment newInstance(){
        return new DashboardFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.jurnal:
                    replaceFragment(new JornalFragment());
                    break;
                case R.id.Statik:
                    replaceFragment(new StatistikFragment());
                    break;
                case R.id.akun:
                    replaceFragment(new ProfilFragment());
                    break;
            }
            return true;
        });

        // Mengambil referensi ke LinearLayout mood_icon
        moodIconLayout = view.findViewById(R.id.mood_icon);

        moodIconLayout.setVisibility(View.GONE);
        // Mengatur OnClickListener untuk button_emote
        binding.buttonEmote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Menampilkan atau menyembunyikan mood_icon tergantung dari keadaan sebelumnya
                if (isMoodIconVisible) {
                    fadeOutMoodIcon();
                    binding.icon1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showSelectedIcon(binding.icon1);
                        }
                    });
                } else {
                    fadeInMoodIcon();
                }
            }
        });
    }

    private void showSelectedIcon(ImageView icon) {
        // Clear the selection from the previous icon if any
        if (selectedIcon != null) {
            selectedIcon.setBackgroundResource(0);
        }

        // Set the background for the selected icon
        icon.setBackgroundResource(R.drawable.circle_background);

        // Store the selected icon for reference
        selectedIcon = icon;

        // Pass the selected icon to fragment_mood if it is visible
        Fragment fragment = getParentFragmentManager().findFragmentById(R.id.frame_layout);
        if (fragment instanceof MoodFragment && ((MoodFragment) fragment).isVisible()) {
            ((MoodFragment) fragment).showSelectedIcon(icon);
        }
    
    }

    private void fadeInMoodIcon() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        moodIconLayout.startAnimation(alphaAnimation);
        moodIconLayout.setVisibility(View.VISIBLE);
        isMoodIconVisible = true;
    }
    private void fadeOutMoodIcon() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        moodIconLayout.startAnimation(alphaAnimation);
        moodIconLayout.setVisibility(View.GONE);
        isMoodIconVisible = false;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


    // Fungsi replaceFragment() dan lainnya tetap sama seperti yang Anda miliki
    // ...
}
