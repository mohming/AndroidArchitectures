package com.example.android.androidarchitectures.MVC;

import com.example.android.androidarchitectures.Model.CountriesService;
import com.example.android.androidarchitectures.Model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesController {
    private MVCActivity view;
    private CountriesService service;

    /**
     * Constructor
     * @param view
     */
    public CountriesController(MVCActivity view) {
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }

    private void fetchCountries(){
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<String>();
                        for(Country country : value) {
                            countryNames.add(country.countryName);
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                    }
                });
    }

    public void onRefresh(){
        fetchCountries();
    }
}
