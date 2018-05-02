package com.iicsdms.tris.iicsdms2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.util.regex.Pattern;

/**
 * Created by Tris on 24/03/2018.
 */

public class ViewFileActivity extends AppCompatActivity {

    private static final String TAG = "test";
    private WebView webView;
    private ImageView imageView;
    private PDFView pdfView;
    String link;
    String id, fileThread, fileName, type, fileType;
    String [] fileNameCheck;
    String fnc;

    String file;
    String table;

    byte[] data1;

//    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        link = getString(R.string.doc_view_url);
        fileName = getIntent().getStringExtra("fileFileName");
        fileType = getIntent().getStringExtra("fileType");
        fileThread = getIntent().getStringExtra("fileThread");
        id = getIntent().getStringExtra("fileDocId");

        fileNameCheck = fileName.split(Pattern.quote("."));
        fnc = fileNameCheck[1];

//        String title = getIntent().getStringExtra("fileFileName");
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle(title);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);


        RetrieveData retrieveData = new RetrieveData(getApplicationContext());
        data1 = retrieveData.getFileDocumentData(link, fileType, id, fileThread);

        if(fnc.equals("pdf"))
        {
            setContentView(R.layout.activity_file_view_pdf);

            pdfView = (PDFView) findViewById(R.id.pdf);
            pdfView.fromBytes(data1)
                    .defaultPage(0)
                    .enableAntialiasing(true)
                    .enableSwipe(true)
                    .pageFitPolicy(FitPolicy.WIDTH)
                    .load();

        }
        else if (fnc.equals("jpg") || fnc.equals("png") || fnc.equals("bmp") || fnc.equals("gif"))
        {
            setContentView(R.layout.activity_file_view_img);

            Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
            imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageBitmap(bitmap);
        }
        else
        {
            Toast.makeText(this, "File format currently not supported.", Toast.LENGTH_SHORT).show();
            finish();

//            setContentView(R.layout.activity_file_view_other);
//            Encryption encryption = new Encryption();
//            String idEnc, typeEnc;
//            idEnc = encryption.encrypt(id);
//            typeEnc = encryption.encrypt(fileType);
//
////            Uri uri = Uri.parse(getString(R.string.global_url) + "id=" + idEnc + "&type=" + typeEnc);
////            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////            startActivity(intent);
//            webView = (WebView) findViewById(R.id.other);
//            webView.getSettings().setJavaScriptEnabled(true);
//            webView.loadUrl(getString(R.string.global_url) + "id=" + idEnc + "&type=" + typeEnc);

        }

    }
}
