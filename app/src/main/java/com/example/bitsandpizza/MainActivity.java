package com.example.bitsandpizza;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bitsandpizza.fragments.PastaFragment;
import com.example.bitsandpizza.fragments.PizzaFragment;
import com.example.bitsandpizza.fragments.StoreFragment;
import com.example.bitsandpizza.fragments.TopFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addToolBarPrincipal();
        addViewPager();
        addTabLayout();
    }

    private void addTabLayout() {
        //añadimos el tabLayoutr a la activity
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    private void addToolBarPrincipal() {
        //añadimos el Toolbar a la activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void addViewPager() {
        //añadimos adaptador view pager
        SectionPagerAdapter pagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
    }

    //crea las opciones del menu
    public boolean onCreateOptionsMenu(Menu menu){
        //añadimos el menu
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //añadimos el boton menu item share
        MenuItem menuItemShare = menu.findItem(R.id.action_share);
        //le damos la propiedad de compartir
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItemShare);
        //accion del item del menu para compartir con otras aplicaciones
        setShareActionIntent("Want to join me for pizaa");

        return super.onCreateOptionsMenu(menu);
    }


    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order: //si pulsamos en el +
                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(@NonNull FragmentManager fm){
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //el fragment que va a mostrar
            switch (position){
                case 0:
                    return new TopFragment();
                case 1:
                    return new PizzaFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new StoreFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            //numero de paginas que va a mostrar
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //para cuando hagamos click en los titulos
            switch (position){
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.pizza_tab);
                case 2:
                    return getResources().getText(R.string.pasta_tab);
                case 3:
                    return getResources().getText(R.string.store_tab);
            }
            return null;
        }
    }
}