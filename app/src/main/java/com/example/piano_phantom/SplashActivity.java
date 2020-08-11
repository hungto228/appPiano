package com.example.piano_phantom;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SplashActivity extends AppCompatActivity {
    //variables

    private static final int PREMISSION_CONSTANT = 100;
    private static final int REQUETS_PERMISSION_SETTING = 101;

    //array petmission
    String[] permissionRequired = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO};

    private SharedPreferences permissionStatus;

    //setting in screen
    private boolean sentTosetting = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        permissionStatus = getSharedPreferences("permissionstatus", MODE_PRIVATE);
        //  check for the self permission whether is pre granted or not
        if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionRequired[0]) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(SplashActivity.this, permissionRequired[1]) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this, permissionRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this, permissionRequired[1])) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //Need Multiple Permissions
                builder.setTitle("Can nhieu quyn de truy cap");
                //This app needs Storage and Record Audio Permissions.
                builder.setMessage("Ung dung caan truy cap bo nho va quay man hinh");
                //grant
                builder.setPositiveButton("Cho phep", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SplashActivity.this, permissionRequired, PREMISSION_CONSTANT);
                    }
                });
                //cancel
                builder.setNegativeButton("Tro lai", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            } else if (permissionStatus.getBoolean(permissionRequired[0], false)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //Need Multiple Permissions
                builder.setTitle("Can nhieu quyn de truy cap");
                //This app needs Storage and Record Audio Permissions.
                builder.setMessage("Ung dung caan truy cap bo nho va quay man hinh");

                builder.setPositiveButton("Cho phep", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        sentTosetting = true;
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        //using uri start activity  for result  by activityforresuilt
                        Uri uri = Uri.fromParts("packet", getPackageName(), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUETS_PERMISSION_SETTING);
                        Toast.makeText(SplashActivity.this, "Di den quyen dung dung, cho phep truy cap bo nho va quay man hinh", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            } else {
                ActivityCompat.requestPermissions(SplashActivity.this, permissionRequired, PREMISSION_CONSTANT);
            }
            SharedPreferences.Editor editor = permissionStatus.edit();
            editor.putBoolean(permissionRequired[0], true);
            editor.commit();


        } else {
            // already have the permission, just go ahead.
            proceedApterpremission();
        }
    }

    //TODO: onRequestPermission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PREMISSION_CONSTANT) {
            //check if all permission  are grant
            boolean allgrant = false;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    allgrant = true;
                } else {
                    allgrant = false;
                    break;
                }
            }
            if (allgrant) {
                //
                proceedApterpremission();
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this, permissionRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this, permissionRequired[1])) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //Need Multiple Permissions
                builder.setTitle("Can nhieu quyn de truy cap");
                //This app needs Storage and Record Audio Permissions.
                builder.setMessage("Ung dung caan truy cap bo nho va quay man hinh");
                builder.setPositiveButton("cho phep", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ActivityCompat.requestPermissions(SplashActivity.this, permissionRequired, PREMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("tro lai", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            } else {
//                Unable to get Permission
//                You Need to give the permission manually by going into the Settings
//                Now closing the Application
                Toast.makeText(getBaseContext(), "Khong the nhan duoc quyen", Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "ban can vao phan cai dai de chap nhan quyen", Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), "Hien dang dong ung dung", Toast.LENGTH_SHORT).show();

            }
        }
    }
//TOdo: onActivitiressult

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUETS_PERMISSION_SETTING) {
            if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                proceedApterpremission();
            }
        }

    }

    private void proceedApterpremission() {
        Toast.makeText(getBaseContext(), "quyen duoc chap nhan ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
