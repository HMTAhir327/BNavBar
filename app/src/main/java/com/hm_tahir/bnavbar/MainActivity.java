package com.hm_tahir.bnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hm_tahir.bnavbar.Fragments.gallery;
import com.hm_tahir.bnavbar.Fragments.wifi;

public class MainActivity extends AppCompatActivity {

    private gallery objectgalleryFragment;
    private wifi objectwifiFragment;

    private BottomNavigationView objectBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeObjects();
    }


    private void changeFragment(Fragment objectFragment)
    {
        try
        {
            FragmentTransaction objectTransaction=getSupportFragmentManager()
                    .beginTransaction();

            objectTransaction.replace(R.id.container,objectFragment).commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "changeFragment:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeObjects()
    {
        try
        {
            objectgalleryFragment=new gallery();
            objectwifiFragment=new wifi();

            objectBottomNavigationView=findViewById(R.id.BNV);
            changeFragment(objectgalleryFragment);

            objectBottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                            if(item.getItemId()==R.id.menu_home)
                            {
                                changeFragment(objectgalleryFragment);
                                return true;
                            }
                            else if(item.getItemId()==R.id.menu_search)
                            {
                                changeFragment(objectwifiFragment);
                                return true;
                            }
                            return false;
                        }
                    }
            );


        }
        catch (Exception e)
        {
            Toast.makeText(this, "initializeObjects:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
