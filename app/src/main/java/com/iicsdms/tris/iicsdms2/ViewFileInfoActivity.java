package com.iicsdms.tris.iicsdms2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

import static java.security.AccessController.getContext;

/**
 * Created by Tris on 03/03/2018.
 */

public class ViewFileInfoActivity extends AppCompatActivity {

    static final String TAG = "TAG";
    TextView fileTitle, fileCreatedBy, fileFileName, fileTimeCreated, fileType, fileFromTo, fileTimeRecTimeSent, fileDescStatus,
                fileActionDue , fileActionRequired, fileReferenceNo, fileDesc, fileStatus, fileRefNoUploadBy, fileSrcRecipient,
                fileActionDueHolder, fileActionRequiredHolder, fileCategory;

    Toolbar toolbar;
    FilePojo filePojo;
    RetrieveData retrieveData;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_file_info);

        String title = getIntent().getStringExtra("fileTitle");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        fileRefNoUploadBy = (TextView) findViewById(R.id.refnouploadby);
        fileReferenceNo = (TextView) findViewById(R.id.reference);
        fileSrcRecipient = (TextView) findViewById(R.id.source_recipient);
        fileFromTo = (TextView) findViewById(R.id.fromto);
        fileCreatedBy = (TextView) findViewById(R.id.created_by);
        fileFileName = (TextView) findViewById(R.id.file_name);
        fileTimeRecTimeSent = (TextView) findViewById(R.id.timerectimesent);
        fileTimeCreated = (TextView) findViewById(R.id.time_stamp);
        fileType = (TextView) findViewById(R.id.type);
        fileCategory = (TextView) findViewById(R.id.category);
        fileDescStatus = (TextView) findViewById(R.id.descstatus);
        fileDesc = (TextView) findViewById(R.id.desc);
        fileStatus = (TextView) findViewById(R.id.status);
        fileActionDueHolder = (TextView) findViewById(R.id.action_due_holder);
        fileActionRequiredHolder = (TextView) findViewById(R.id.action_required_holder);
        fileActionDue = (TextView) findViewById(R.id.action_due);
        fileActionRequired = (TextView) findViewById(R.id.action_required);
        sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        String logEmail = sharedPreferences.getString("logEmail", TAG);

        String link = getString(R.string.doc_info_url);

        String fileThread = this.getIntent().getStringExtra("fileThread");
        String fileId = getIntent().getStringExtra("fileId");
        String fileFolderId = getIntent().getStringExtra("fileFolderId");

        String fileref = this.getIntent().getStringExtra("fileReferenceNum");
        String filesourceRecipient = this.getIntent().getStringExtra("fileSourceRecipient");
        String filecreatedBy = this.getIntent().getStringExtra("fileCreatedBy");
        String filefileName = this.getIntent().getStringExtra("fileFileName");
        String filetimeCreated = this.getIntent().getStringExtra("fileTimeCreated");
        String filetype = this.getIntent().getStringExtra("fileType");
        String fileactionDue = this.getIntent().getStringExtra("fileActionDue");
        String fileactionReq = this.getIntent().getStringExtra("fileActionReq");
        String filestatus= this.getIntent().getStringExtra("fileStatus");
        String filecategory = this.getIntent().getStringExtra("fileCategory");
        String filedesc = this.getIntent().getStringExtra("fileDescription");




        if(filetype.equals("Personal"))
        {
            retrieveData = new RetrieveData(getApplicationContext());
            filePojo = retrieveData.getDocumentInfo(link, logEmail, filetype, fileId, fileThread, fileFolderId);

            Log.e(TAG, filePojo.getDescription());
            Log.e(TAG, filePojo.getCreatedBy());
        }
        else if(filetype.equals("Incoming"))
        {
            if(fileThread != null)
            {
                retrieveData = new RetrieveData(getApplicationContext());
                filePojo = retrieveData.getDocumentInfo(link, logEmail, filetype, fileId, fileThread, fileFolderId);
                Log.e(TAG, filePojo.getDescription());
                Log.e(TAG, filePojo.getDepartment());
                Log.e(TAG, filePojo.getNote());
            }
            else
            {
                retrieveData = new RetrieveData(getApplicationContext());
                filePojo = retrieveData.getDocumentInfo(link, logEmail, filetype, fileId, fileThread, fileFolderId);

                Log.e(TAG, filePojo.getDescription());
                Log.e(TAG, filePojo.getDepartment());
            }
        }
        else if(filetype.equals("Outgoing"))
        {
            if(fileThread != null)
            {
                retrieveData = new RetrieveData(getApplicationContext());
                filePojo = retrieveData.getDocumentInfo(link, logEmail, filetype, fileId, fileThread, fileFolderId);

                Log.e(TAG, filePojo.getDescription());
                Log.e(TAG, filePojo.getDepartment());
            }
            else
            {
                retrieveData = new RetrieveData(getApplicationContext());
                filePojo = retrieveData.getDocumentInfo(link, logEmail, filetype, fileId, fileThread, fileFolderId);

                Log.e(TAG, filePojo.getDescription());
                Log.e(TAG, filePojo.getDepartment());
            }
        }



        fileReferenceNo.setText(fileref);
        fileSrcRecipient.setText(filesourceRecipient);
        fileCreatedBy.setText(filecreatedBy);
        fileDesc.setText(filedesc);
        fileFileName.setText(filefileName);
        fileTimeCreated.setText(filetimeCreated);
        fileType.setText(filetype);
        fileCategory.setText(filecategory);
        fileStatus.setText(filestatus);
        fileActionRequired.setText(fileactionReq);

        if(fileactionDue == null || fileactionDue.equals("null") || fileactionDue.equals("NULL") || fileactionDue.isEmpty())
        {
            fileActionDue.setText("None");
        }
        else
        {
            fileActionDue.setText(fileactionDue);
        }


        if(filetype.equals("Incoming")){
            fileRefNoUploadBy.setText("Reference Number");
            fileFromTo.setText("From");
            fileDescStatus.setText("Status");
            fileTimeRecTimeSent.setText("Time received");
        } else if(filetype.equals("Outgoing")){
            fileRefNoUploadBy.setText("Upload by");
            fileFromTo.setText("To");
            fileDescStatus.setText("Description");
            fileTimeRecTimeSent.setText("Time sent");
            fileActionDueHolder.setText("");
            fileActionRequiredHolder.setText("");
        } else if(filetype.equals("Personal")){
            fileRefNoUploadBy.setText("Upload by");
            fileFromTo.setText("By");
            fileCreatedBy.setText(filecreatedBy);
            fileDescStatus.setText("Description");
            fileTimeRecTimeSent.setText("Time uploaded");
            fileActionDueHolder.setText("");
            fileActionRequiredHolder.setText("");
        }







    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
