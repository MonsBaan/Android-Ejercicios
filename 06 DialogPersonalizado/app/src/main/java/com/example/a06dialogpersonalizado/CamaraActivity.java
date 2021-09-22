package com.example.a06dialogpersonalizado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CamaraActivity extends AppCompatActivity {
    private ImageView mPhotoImageView;
    private static final int REQUEST_CODE_TAKE_PHOTO = 0;
    private String mCurrentPhotoPath;
    private final String TAG = "almi";

    private List<String> imagenesList = new ArrayList<>();
    private Button btnSacarFoto;
    private Uri photoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        mPhotoImageView = findViewById(R.id.ivFoto);
        checkPermission();

        btnSacarFoto = findViewById(R.id.btnSacarFoto);

        btnSacarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
        cargarImagenes();
        GridView gvMiniaturas = findViewById(R.id.gvMiniaturas);
        FotosGridViewAdapter adapter = new FotosGridViewAdapter(this);
        gvMiniaturas.setAdapter(adapter);
    }

    private void cargarImagenes() {
        imagenesList.clear();
        File nuevaCarpeta = new File(getFilesDir(), "Galeria");
        if (!nuevaCarpeta.exists()) {
            Log.e("camara", "No se pudo cargar nada");

        } else {
            File[] fotos = nuevaCarpeta.listFiles();
            for (int i = 0; i < fotos.length; i++) {
                File foto = fotos[i];
                imagenesList.add(foto.getAbsolutePath());
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), photoUri);
                mPhotoImageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            String ruta = guardarFoto(byteArray);
            Toast.makeText(getApplicationContext(), "Foto cargada en " + ruta, Toast.LENGTH_SHORT).show();
        }
    }

    private String guardarFoto(byte[] byteArray) {
        String filename = "";
        File nuevaCarpeta = new File(getFilesDir(), "Galeria");
        if (!nuevaCarpeta.exists() && !nuevaCarpeta.mkdirs()) {
            Log.e("camara", "No se pudo crear la carpeta");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
            String date = dateFormat.format(new Date());
            String photoFile = "Picture_" + date + ".jpg";
            filename = nuevaCarpeta.getPath() + File.separator + photoFile;
            File pictureFile = new File(filename);

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(byteArray);
                fos.close();
                Toast.makeText(getApplicationContext(), "Imagen Creada", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cargarImagenes();
        GridView gvMiniaturas = findViewById(R.id.gvMiniaturas);
        FotosGridViewAdapter adapter = new FotosGridViewAdapter(this);
        gvMiniaturas.setAdapter(adapter);
        return filename;

    }

    private void abrirCamara() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException e) {

            }
            if (photoFile != null) {
                ContentValues values = new ContentValues();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
                String date = dateFormat.format(new Date());

                values.put(MediaStore.Images.Media.TITLE, "Picture" + date + ".jpg");
                values.put(MediaStore.Images.Media.DESCRIPTION, "Photo taked on " + System.currentTimeMillis());
                photoUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, REQUEST_CODE_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        return image;
    }


    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 226);
            }
        }

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            }
        }
    }


    public List<String> getImagenesList() {
        return imagenesList;
    }
}