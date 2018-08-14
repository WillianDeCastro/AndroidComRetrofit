package com.example.oilha.restaurantes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ObterRestaurantes(final View view) {

        final Context ct = this;
        Call<ArrayList<Restaurants>> call = new RetrofitConfig().getCEPService().BuscarRestaurantes();

        call.enqueue(new Callback<ArrayList<Restaurants>>() {
            @Override
            public void onResponse(Call<ArrayList<Restaurants>> call, Response<ArrayList<Restaurants>> response) {
                ArrayList<Restaurants> rests = response.body();


                PopularLista(rests, ct);
            }

            private void PopularLista(ArrayList<Restaurants> rests, Context ctx) {

                //for (int i = 0; i < rests.size(); i++) {
                //     Toast.makeText(getApplicationContext(), "Estab " + rests.get(i).getName(), Toast.LENGTH_SHORT).show();
                //}
                try {

                    ArrayList<String> array_list = new ArrayList<String>();

                    for (int i = 0; i < rests.size(); i++) {
                        array_list.add(rests.get(i).getName());
                    }

                    ArrayAdapter adap = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, array_list);
                    ListView lista = (ListView) findViewById(R.id.minhaLista);
                    lista.setAdapter(adap);

                } catch (Exception ex) {
                    Log.e("ERRO LISTA", ex.getMessage().toString());
                }
            }


            @Override
            public void onFailure(Call<ArrayList<Restaurants>> call, Throwable t) {
                Log.e("RestauranteService   ", "Erro ao buscar o restaurante:" + t.getMessage());
            }

        });
    }
}
