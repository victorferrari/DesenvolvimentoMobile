package com.example.victo.acorde.EducadoraFisica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

import com.example.victo.acorde.R;

public class EducadoraFisicaAdapter extends BaseAdapter implements Filterable {

    List<EducadoraFisica> educadoraFisicas;
    private List<EducadoraFisica> filterList;

    EducadoraFisicaFiltro filter;

    private final Context context;

    public EducadoraFisicaAdapter(Context context, List<EducadoraFisica> educadoraFisicas) {
        this.context = context;
        this.educadoraFisicas = educadoraFisicas;
        this.filterList=educadoraFisicas;
    }

    @Override
    public Filter getFilter() {

        if(filter==null)
        {
            filter=new EducadoraFisicaFiltro(filterList,this);
        }

        return filter;
    }

    @Override
    public int getCount() {
        return educadoraFisicas.size();
    }

    @Override
    public Object getItem(int position) {
        return educadoraFisicas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return educadoraFisicas.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        EducadoraFisica educadoraFisica = educadoraFisicas.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View tela = view;

        if(tela == null){
            tela = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView campoNome = tela.findViewById(R.id.item_nome);
        campoNome.setText(educadoraFisica.getNomeAssistido());

        return tela;
    }

}
