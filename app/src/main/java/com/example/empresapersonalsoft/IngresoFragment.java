package com.example.empresapersonalsoft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;



public class IngresoFragment extends Fragment implements
        Response.Listener<JSONObject>,Response.ErrorListener{

    EditText jetcorreo,jetclave;
    Button jbtingresar;
    TextView jtvregistrar;
    RequestQueue rq;
    JsonRequest jrq;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //return inf
        // +ter.inflate(R.layout.fragment_ingreso,container,false);
        //Asociar objetos
        View vista = inflater.inflate(R.layout.fragment_ingreso,container,false);
        jetcorreo = vista.findViewById(R.id.etcorreo);
        jetclave = vista.findViewById(R.id.etclave);
        jbtingresar = vista.findViewById(R.id.btingresar);
        jtvregistrar=vista.findViewById(R.id.tvregistrar);
        jbtingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar_sesion();
            }


        });
        jtvregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrarse();
            }

        });


        return vista;
    }

    private void iniciar_sesion() {
    }

    private void Registrarse(){
        Intent intregistrar=new Intent(getContext(),RegistrarseActivity.class);
        startActivity(intregistrar);

    }




    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "Usuario no encontrado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Usuario encontrado", Toast.LENGTH_SHORT).show();

    }
}