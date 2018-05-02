package com.iicsdms.tris.iicsdms2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;

/**
 * Created by Tris on 03/03/2018.
 */

public class DocumentOnClickDialogFragment extends AppCompatDialogFragment{

    static final String TAG = "test";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String name = getArguments().getString("FilePojoTitle");
        CharSequence[] sequence = {"Read","Info"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(name)
                .setItems(sequence, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                    switch (which){

                        case 0:
                            Intent intentRead = new Intent(getContext(), ViewFileActivity.class);

                            String fileFileNameRead = getArguments().getString("FilePojoFileName");
                            String fileThreadRead = getArguments().getString("FilePojoThread");
                            String fileTypeRead = getArguments().getString("FilePojoType");
                            String fileDocIdRead = getArguments().getString("FilePojoDocId");
                            String table = getArguments().getString("table");
                            String logEmail = getArguments().getString("logEmail");

                            intentRead.putExtra("fileFileName", fileFileNameRead);
                            intentRead.putExtra("fileThread", fileThreadRead);
                            intentRead.putExtra("fileType", fileTypeRead);
                            intentRead.putExtra("fileDocId", fileDocIdRead);
                            intentRead.putExtra("table", table);
                            intentRead.putExtra("logEmail", logEmail);

                            startActivity(intentRead);
                            break;


                        case 1:
                            String fileType = getArguments().getString("FilePojoType");

                            String fileCreatedBy = getArguments().getString("FilePojoCreatedBy");

                            String fileTitle = getArguments().getString("FilePojoTitle");
                            String fileCategory = getArguments().getString("FilePojoCategory");
                            String fileTimeCreated = getArguments().getString("FilePojoTimeCreated");
                            String fileFileName = getArguments().getString("FilePojoFileName");
                            String fileId = getArguments().getString("FilePojoDocId");


                            logEmail = getArguments().getString("logEmail");

                            String fileThread = getArguments().getString("FilePojoThread");
                            if(fileType.equals("Personal"))
                            {
                                String fileDesc = getArguments().getString("FilePojoDescription");

                                Intent intentInfo = new Intent(getContext(), ViewFileInfoActivity.class);
                                intentInfo.putExtra("fileTitle", fileTitle);

                                intentInfo.putExtra("fileCreatedBy", fileCreatedBy);

                                intentInfo.putExtra("fileCategory", fileCategory);
                                intentInfo.putExtra("fileFileName", fileFileName);
                                intentInfo.putExtra("fileTimeCreated", fileTimeCreated);
                                intentInfo.putExtra("fileType", fileType);
                                intentInfo.putExtra("fileId", fileId);
                                intentInfo.putExtra("logEmail", logEmail);
                                intentInfo.putExtra("fileDescription", fileDesc);


                                startActivity(intentInfo);
                            }
                            else if(fileType.equals("Incoming"))
                            {

                                if(fileThread != null)
                                {
                                    String fileSourceRecipient = getArguments().getString("FilePojoSourceRecipient");
                                    String fileStatus = getArguments().getString("FilePojoStatus");
                                    String fileActionReq = getArguments().getString("FilePojoActionReq");
                                    String fileActionDue = getArguments().getString("FilePojoActionDue");
                                    String fileReferenceNum = getArguments().getString("FilePojoReferenceNumber");


                                    Intent intentInfo = new Intent(getContext(), ViewFileInfoActivity.class);
                                    intentInfo.putExtra("fileTitle", fileTitle);

//                                    intentInfo.putExtra("fileCreatedBy", fileCreatedBy);

                                    intentInfo.putExtra("fileCategory", fileCategory);
                                    intentInfo.putExtra("fileFileName", fileFileName);
                                    intentInfo.putExtra("fileTimeCreated", fileTimeCreated);
                                    intentInfo.putExtra("fileSourceRecipient", fileSourceRecipient);
                                    intentInfo.putExtra("fileActionReq", fileActionReq);
                                    intentInfo.putExtra("fileActionDue", fileActionDue);
                                    intentInfo.putExtra("fileStatus", fileStatus);
                                    intentInfo.putExtra("fileTimeCreated", fileTimeCreated);
                                    intentInfo.putExtra("fileType", fileType);
                                    intentInfo.putExtra("fileThread", fileThread);
                                    intentInfo.putExtra("fileId", fileId);
                                    intentInfo.putExtra("fileReferenceNum", fileReferenceNum);
                                    intentInfo.putExtra("logEmail", logEmail);

                                    startActivity(intentInfo);
                                }
                                else
                                {
//                                    String fileCreatedBy = getArguments().getString("FilePojoCreatedBy");
                                    String fileEmail = getArguments().getString("FilePojoEmail");
                                    String fileAcadYear = getArguments().getString("FilePojoAcadYear");
                                    String fileFolderId = getArguments().getString("FilePojoFolderId");



                                    Intent intentInfo = new Intent(getContext(), ViewFileInfoActivity.class);
                                    intentInfo.putExtra("fileTitle", fileTitle);
                                    intentInfo.putExtra("fileCategory", fileCategory);
                                    intentInfo.putExtra("fileCreatedBy", fileCreatedBy);
                                    intentInfo.putExtra("fileEmail", fileEmail);
                                    intentInfo.putExtra("fileTimeCreated", fileTimeCreated);
                                    intentInfo.putExtra("fileAcadYear", fileAcadYear);
                                    intentInfo.putExtra("fileFileName", fileFileName);
                                    intentInfo.putExtra("fileType", fileType);
                                    intentInfo.putExtra("fileFolderId", fileFolderId);
                                    intentInfo.putExtra("fileId", fileId);


                                    intentInfo.putExtra("logEmail", logEmail);
                                    startActivity(intentInfo);
                                }
                            }
                            else if(fileType.equals("Outgoing"))
                            {

                                if(fileThread != null)
                                {

                                    String fileSourceRecipient = getArguments().getString("FilePojoSourceRecipient");
                                    String fileDesc = getArguments().getString("FilePojoDescription");
                                    Intent intentInfo = new Intent(getContext(), ViewFileInfoActivity.class);
                                    intentInfo.putExtra("fileTitle", fileTitle);

                                    intentInfo.putExtra("fileCreatedBy", fileCreatedBy);

                                    intentInfo.putExtra("fileCategory", fileCategory);
                                    intentInfo.putExtra("fileSourceRecipient", fileSourceRecipient);
                                    intentInfo.putExtra("fileTimeCreated", fileTimeCreated);
                                    intentInfo.putExtra("fileFileName", fileFileName);
                                    intentInfo.putExtra("fileThread", fileThread);
                                    intentInfo.putExtra("fileType", fileType);
                                    intentInfo.putExtra("fileId", fileId);
                                    intentInfo.putExtra("fileDescription", fileDesc);

                                    intentInfo.putExtra("logEmail", logEmail);
                                    startActivity(intentInfo);

                                }
                                else
                                {
//                                    String fileCreatedBy = getArguments().getString("FilePojoCreatedBy");
                                    String fileEmail = getArguments().getString("FilePojoEmail");
                                    String fileAcadYear = getArguments().getString("FilePojoAcadYear");
                                    String fileFolderId = getArguments().getString("FilePojoFolderId");


                                    Intent intentInfo = new Intent(getContext(), ViewFileInfoActivity.class);
                                    intentInfo.putExtra("fileTitle", fileTitle);
                                    intentInfo.putExtra("fileCategory", fileCategory);
                                    intentInfo.putExtra("fileCreatedBy", fileCreatedBy);
                                    intentInfo.putExtra("fileEmail", fileEmail);
                                    intentInfo.putExtra("fileTimeCreated", fileTimeCreated);
                                    intentInfo.putExtra("fileAcadYear", fileAcadYear);
                                    intentInfo.putExtra("fileFileName", fileFileName);
                                    intentInfo.putExtra("fileType", fileType);
                                    intentInfo.putExtra("fileFolderId", fileFolderId);
                                    intentInfo.putExtra("fileId", fileId);

                                    intentInfo.putExtra("logEmail", logEmail);
                                    startActivity(intentInfo);
                                }
                            }
                            break;
                    }
                    }
                })
                .setCancelable(false);
        return builder.create();
    }
}
