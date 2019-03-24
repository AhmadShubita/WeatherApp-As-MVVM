package com.example.weather.view.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.weather.R;
import com.example.weather.data.model.Country;
import com.example.weather.databinding.ActivityMainBinding;
import com.example.weather.utils.ActivityUtils;
import com.example.weather.utils.AppConstant;
import com.example.weather.utils.DividerItemDecoration;
import com.example.weather.view.adapter.CountryAdapter;
import com.example.weather.view.callback.CountryClickCallback;
import com.example.weather.viewmodel.MainViewModel;
import java.util.List;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    private MainViewModel mainViewModel;

    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppConstant.userContext = getApplicationContext();
        setContentView(R.layout.activity_main);

        initDataBinding();

        initListCountry();

        observeViewModel();
    }

    private void initListCountry() {
        countryAdapter = new CountryAdapter(countryClickCallback);
        activityMainBinding.navLayout.countryList.setAdapter(countryAdapter);
        activityMainBinding.navLayout.setIsLoading(true);
        activityMainBinding.navLayout.setLifecycleOwner(this);
    }

    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel();
        activityMainBinding.setMainViewModel(mainViewModel);

        // set up Toolbar and drawer view to be connected with home menu button.
        setUpToolbar();
        setUpNavigationView();

    }

    private void observeViewModel() {
        // Update the list when the data changes
        this.mainViewModel.responseCountries().observe(this,
                new Observer<List<Country>>() {
            @Override
            public void onChanged(@Nullable List<Country> countries) {
                Log.e("Observer: -->","called");

                if(countries != null) {
                    if (countries.size() > 0) {
                        activityMainBinding.navLayout.setIsLoading(false);
                        countryAdapter.addItems(countries);
                        addCountryFragment(countries.get(0));
                    }
                }

            }
        });

        mainViewModel.getCountries();
    }

    private void addCountryFragment(Country country) {
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new CountryDetailFragment().newInstance(country), R.id.mainContainer, "CountryDetailsFragment");
    }

    private void setUpToolbar(){
        activityMainBinding.toolbar.setTitle("Country Weather");
        setSupportActionBar(activityMainBinding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable navIcon = getResources().getDrawable(R.drawable.ic_nav);
        activityMainBinding.toolbar.setNavigationIcon(navIcon);
        activityMainBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //set up drawer Listener
    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, activityMainBinding.drawer, activityMainBinding.toolbar, R.string.app_name,R.string.app_name) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };
        //Setting the actionbarToggle to drawer layout
        activityMainBinding.drawer.setDrawerListener(actionBarDrawerToggle);
        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    //callback for country item click
    private final CountryClickCallback countryClickCallback = new CountryClickCallback() {
        @Override
        public void onClick(Country country) {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new CountryDetailFragment().newInstance(country), R.id.mainContainer, "CountryDetailsFragment");
            activityMainBinding.drawer.closeDrawers();
        }
    };
}
