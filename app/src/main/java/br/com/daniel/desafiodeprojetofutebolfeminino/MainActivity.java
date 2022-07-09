package br.com.daniel.desafiodeprojetofutebolfeminino;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.com.daniel.desafiodeprojetofutebolfeminino.databinding.ActivityMainBinding;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.Repository;
import br.com.daniel.desafiodeprojetofutebolfeminino.repository.local.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startRepository();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configAppBarNavigation();
    }

    private void startRepository() {
        Repository.initialize(this);
    }

    private void configAppBarNavigation() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_news, R.id.navigation_favorites)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}