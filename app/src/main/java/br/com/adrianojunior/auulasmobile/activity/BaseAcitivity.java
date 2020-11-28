package br.com.adrianojunior.auulasmobile.activity;

import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import br.com.adrianojunior.auulasmobile.R;
import br.com.adrianojunior.auulasmobile.fragments.CalculadoraFrag;
import br.com.adrianojunior.auulasmobile.fragments.DatabaseFrag;
import br.com.adrianojunior.auulasmobile.fragments.MapsFragment;
import livroandroid.lib.activity.BaseActivity;

public class BaseAcitivity extends BaseActivity {

    private static final String TAG = "BaseActivity";

    protected DrawerLayout drawerLayout;


    // Configura a Toolbar
    protected void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    // Configura o Nav Drawer
    protected void setupNavDrawer() {
        // Drawer Layout
        final ActionBar actionBar = getSupportActionBar();
        // Ícone do menu do nav drawer
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null && drawerLayout != null) {

            // Trata o evento de clique no menu.
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            // Seleciona a linha

                            if (menuItem.isCheckable()) {

                                menuItem.setChecked(true);

                            } else {

                                menuItem.setChecked(false);

                            }
                            // Fecha o menu
                            drawerLayout.closeDrawers();
                            // Trata o evento do menu
                            onNavDrawerItemSelected(menuItem);
                            return true;
                        }
                    });
        }
    }

    private void onNavDrawerItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_maps:
                replaceFragment(new MapsFragment());
                getSupportActionBar().setTitle("Google Maps");
                break;
            case R.id.nav_calculadora:
                replaceFragment(new CalculadoraFrag());
                getSupportActionBar().setTitle("Calculadora");
                break;
            case R.id.nav_database:
                replaceFragment(new DatabaseFrag());
                getSupportActionBar().setTitle("SQLite");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Trata o clique no botão que abre o menu.
                if (drawerLayout != null) {
                    openDrawer();
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    // Abre o menu lateral
    protected void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    // Fecha o menu lateral
    protected void closeDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    // Adiciona o fragment no centro da tela
    protected void replaceFragment(Fragment frag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag, "TAG").commit();
    }
}
