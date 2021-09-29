package com.example.proyectoindividual.galeria;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoindividual.GalleryDialogFragment;
import com.example.proyectoindividual.R;
import com.example.proyectoindividual.bbdd.AppDatabase;
import com.example.proyectoindividual.bbdd.AppExecutorsGallery;
import com.example.proyectoindividual.bbdd.model.Imagen;
import com.example.proyectoindividual.galeria.adaptadores.GaleriaAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentGaleriaEntorno extends Fragment {

    private Context context;
    private RecyclerView imagenAdapter;
    private ArrayList<Imagen> arrayImagenes;
    private AppDatabase mDb;
    private GaleriaAdapter adapter;

    private GalleryDialogFragment dialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDb = AppDatabase.getInstance(context);

        View view = inflater.inflate(R.layout.fragment_galeria_entorno, container, false);
        adapter = new GaleriaAdapter(context);

        imagenAdapter = view.findViewById(R.id.rvEntorno);
        imagenAdapter.setHasFixedSize(true);
        imagenAdapter.setLayoutManager(new GridLayoutManager(context, 2));
        imagenAdapter.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagenAdapter = view.findViewById(R.id.rvEntorno);

        /*rellenarGaleriaEntorno();
        AppExecutorsGallery.getInstance().getDiskIP().execute(new Runnable() {
            @Override
            public void run() {
                for (Imagen imagen :
                        arrayImagenes) {
                    mDb.imagenDao().insertNewImage(imagen);
                }
            }
        });*/
        consultar();
    }

    @Override
    public void onResume() {
        super.onResume();
        consultar();
    }

    public void consultar() {
        mDb.imagenDao().loadEntornoImages().observe(getViewLifecycleOwner(), new Observer<List<Imagen>>() {
            @Override
            public void onChanged(List<Imagen> imagens) {
                adapter.setArrayImagen(imagens);

            }
        });

    }


    private void rellenarGaleriaEntorno() {
        arrayImagenes = new ArrayList();

        arrayImagenes.add(new Imagen("Entorno 1", "https://upload.wikimedia.org/wikipedia/commons/7/71/Bilbao_-_Universidad_de_Deusto_01.jpg", 2));
        arrayImagenes.add(new Imagen("Entorno 2", "https://cide.deusto.es/cs/Satellite?blobcol=urldata&blobheader=image%2Fjpeg&blobheadername1=Expires&blobheadername2=content-type&blobheadername3=MDT-Type&blobheadervalue1=Thu%2C+10+Dec+2020+16%3A00%3A00+GMT&blobheadervalue2=image%2Fjpeg&blobheadervalue3=abinary%3Bcharset%3DUTF-8&blobkey=id&blobtable=MungoBlobs&blobwhere=1344415960131&ssbinary=true", 2));
        arrayImagenes.add(new Imagen("Entorno 3", "https://static.pacelma.es/wp-content/uploads/2013/04/BIZ.002.001.png", 2));
    }

}